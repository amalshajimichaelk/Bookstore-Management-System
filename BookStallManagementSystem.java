import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookStallManagementSystem extends JFrame {
    
    private final JPanel mainPanel;
    private final CardLayout cardLayout;
    
    public BookStallManagementSystem() {
        setTitle("Book Stall Management System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        mainPanel.add(createHomePanel(), "HOME");
        mainPanel.add(createSearchBookPanelWithFilters(), "SEARCH");
        mainPanel.add(createCheckoutBookPanel(), "CHECKOUT");
        mainPanel.add(createUpdateBookPanel(), "UPDATE");
        mainPanel.add(createCustomerInfoPanel(), "CUSTOMER");
        mainPanel.add(createSupplierInfoPanel(), "SUPPLIER");
        mainPanel.add(createTransactionHistoryPanel(), "TRANSACTION");
        
        add(mainPanel);
        cardLayout.show(mainPanel, "HOME");
    }
    

    private JPanel createHomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 255, 255));
        
        JLabel titleLabel = new JLabel("Welcome to Book Stall Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 34));
        titleLabel.setForeground(new Color(0, 0, 0));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        panel.add(titleLabel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        buttonPanel.setBackground(new Color(243, 250, 255));
        
        JButton searchBtn = createStyledButton("Search Book");
        searchBtn.addActionListener(e -> cardLayout.show(mainPanel, "SEARCH"));
        searchBtn.setBackground(new Color(74, 114, 226));
        searchBtn.setForeground(new Color(255, 255, 255));
        
        JButton checkoutBtn = createStyledButton("Checkout Book");
        checkoutBtn.addActionListener(e -> cardLayout.show(mainPanel, "CHECKOUT"));
        checkoutBtn.setBackground(new Color(255, 107, 107));
        checkoutBtn.setForeground(new Color(255, 255, 255));
        
        JButton updateBtn = createStyledButton("Update Book");
        updateBtn.addActionListener(e -> cardLayout.show(mainPanel, "UPDATE"));
        updateBtn.setBackground(new Color(78, 205, 196));
        updateBtn.setForeground(new Color(255, 255, 255));
        
        JButton customerBtn = createStyledButton("Customer Info");                                          
        customerBtn.addActionListener(e -> cardLayout.show(mainPanel, "CUSTOMER"));
        customerBtn.setBackground(new Color(162, 155, 254));
        customerBtn.setForeground(new Color(255, 255, 255));
        
        JButton supplierBtn = createStyledButton("Supplier Info");
        supplierBtn.addActionListener(e -> cardLayout.show(mainPanel, "SUPPLIER"));
        supplierBtn.setBackground(new Color(255, 204, 203));
        supplierBtn.setForeground(new Color(255, 255, 255));
        
        JButton transactionBtn = createStyledButton("Transaction History");
        transactionBtn.addActionListener(e -> cardLayout.show(mainPanel, "TRANSACTION"));
        transactionBtn.setBackground(new Color(128, 128, 128));
        transactionBtn.setForeground(new Color(255, 255, 255));
        
        buttonPanel.add(searchBtn);
        buttonPanel.add(checkoutBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(customerBtn);
        buttonPanel.add(supplierBtn);
        buttonPanel.add(transactionBtn);
        
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
  
private JPanel createSearchBookPanelWithFilters() {
    JPanel panel = new JPanel(new BorderLayout(10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
    // Top search panel
    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
    topPanel.add(new JLabel("Search by:"));
    
    JComboBox<String> searchTypeCombo = new JComboBox<>(
        new String[]{"Book ID", "Title", "Author", "ISBN", "Publisher", "Release year"});
    topPanel.add(searchTypeCombo);
    
    JTextField searchField = new JTextField(20);
    topPanel.add(searchField);
    
    JButton searchBtn = new JButton("Search");
    JButton showAllBtn = new JButton("Show All Books");
    JButton filterBtn = new JButton("Open Filters");
    
    topPanel.add(searchBtn);
    topPanel.add(showAllBtn);
    topPanel.add(filterBtn);
    
    JButton backBtn = new JButton("Back to Home");
    backBtn.addActionListener(e -> cardLayout.show(mainPanel, "HOME"));
    topPanel.add(backBtn);
    
    panel.add(topPanel, BorderLayout.NORTH);
    
    JPanel filterPanel = createFilterPanel();
    filterPanel.setVisible(false);
    panel.add(filterPanel, BorderLayout.WEST);
    
    filterBtn.addActionListener(e -> {
        filterPanel.setVisible(!filterPanel.isVisible());
        filterBtn.setText(filterPanel.isVisible() ? "Close Filters" : "Open Filters");
        panel.revalidate();
        panel.repaint();
    });
    
    String[] columns = {"Book ID", "Title", "Author", "ISBN", "Price", 
                      "Quantity", "Category", "Language", "Publisher", "Release Year"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    panel.add(scrollPane, BorderLayout.CENTER);
    
    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton applyFiltersBtn = new JButton("Apply Filters");
    JButton clearFiltersBtn = new JButton("Clear Filters");
    
    bottomPanel.add(applyFiltersBtn);
    bottomPanel.add(clearFiltersBtn);
    panel.add(bottomPanel, BorderLayout.SOUTH);
    
   
    applyFiltersBtn.addActionListener(e -> {
        Map<String, List<String>> selectedFilters = getSelectedFilters(filterPanel);
        applyFiltersToBackend(selectedFilters, model);
    });
    
    
    clearFiltersBtn.addActionListener(e -> {
        clearAllFilters(filterPanel);
    
    });
    
    return panel;
}

private JPanel createFilterPanel() {
    JPanel filterPanel = new JPanel();
    filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.Y_AXIS));
    filterPanel.setBorder(BorderFactory.createTitledBorder("Filters"));
    filterPanel.setPreferredSize(new Dimension(250, 600));
    

    JPanel languagePanel = createFilterSection(
        "Language",
        new String[]{"English", "Spanish", "French", "German", "Malayalam", 
                    "Hindi", "Tamil", "Telugu", "Chinese", "Japanese"}
    );
    
    JPanel categoryPanel = createFilterSection(
        "Category",
        new String[]{"Rom-Com", "Action & Adventure", "Mystery", "Thriller", 
                    "Science Fiction", "Fantasy", "Horror", "Biography", 
                    "Self-Help", "History", "Poetry", "Drama", "Children's Books"}
    );
    
    JPanel pricePanel = new JPanel();
    pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.Y_AXIS));
    pricePanel.setBorder(BorderFactory.createTitledBorder("Price Range"));
    pricePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    JPanel priceInputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    priceInputPanel.add(new JLabel("Min:"));
    JTextField minPriceField = new JTextField(8);
    minPriceField.setName("minPrice");
    priceInputPanel.add(minPriceField);
    
    priceInputPanel.add(new JLabel("Max:"));
    JTextField maxPriceField = new JTextField(8);
    maxPriceField.setName("maxPrice");
    priceInputPanel.add(maxPriceField);
    
    pricePanel.add(priceInputPanel);
    
    JPanel availabilityPanel = new JPanel();
    availabilityPanel.setLayout(new BoxLayout(availabilityPanel, BoxLayout.Y_AXIS));
    availabilityPanel.setBorder(BorderFactory.createTitledBorder("Availability"));
    availabilityPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    JCheckBox inStockCheckBox = new JCheckBox("In Stock Only");
    inStockCheckBox.setName("inStock");
    availabilityPanel.add(inStockCheckBox);

    JPanel yearPanel = new JPanel();
    yearPanel.setLayout(new BoxLayout(yearPanel, BoxLayout.Y_AXIS));
    yearPanel.setBorder(BorderFactory.createTitledBorder("Release Year"));
    yearPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    JPanel yearInputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    yearInputPanel.add(new JLabel("From:"));
    JTextField fromYearField = new JTextField(8);
    fromYearField.setName("fromYear");
    yearInputPanel.add(fromYearField);
    
    yearInputPanel.add(new JLabel("To:"));
    JTextField toYearField = new JTextField(8);
    toYearField.setName("toYear");
    yearInputPanel.add(toYearField);
    
    yearPanel.add(yearInputPanel);
    

    JPanel filterContent = new JPanel();
    filterContent.setLayout(new BoxLayout(filterContent, BoxLayout.Y_AXIS));
    filterContent.add(languagePanel);
    filterContent.add(Box.createRigidArea(new Dimension(0, 10)));
    filterContent.add(categoryPanel);
    filterContent.add(Box.createRigidArea(new Dimension(0, 10)));
    filterContent.add(pricePanel);
    filterContent.add(Box.createRigidArea(new Dimension(0, 10)));
    filterContent.add(availabilityPanel);
    filterContent.add(Box.createRigidArea(new Dimension(0, 10)));
    filterContent.add(yearPanel);
    
    JScrollPane scrollPane = new JScrollPane(filterContent);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    filterPanel.add(scrollPane);
    
    return filterPanel;
}

private JPanel createFilterSection(String title, String[] options) {
    JPanel section = new JPanel();
    section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
    section.setBorder(BorderFactory.createTitledBorder(title));
    section.setAlignmentX(Component.LEFT_ALIGNMENT);
    
    for (String option : options) {
        JCheckBox checkBox = new JCheckBox(option);
        checkBox.setName(title.toLowerCase() + "_" + option.replaceAll("[^a-zA-Z0-9]", ""));
        section.add(checkBox);
    }
    
    return section;
}

private Map<String, List<String>> getSelectedFilters(JPanel filterPanel) {
    Map<String, List<String>> filters = new HashMap<>();
    
    
    filters.put("languages", new ArrayList<>());
    filters.put("categories", new ArrayList<>());
    filters.put("priceRange", new ArrayList<>());
    filters.put("yearRange", new ArrayList<>());
    filters.put("availability", new ArrayList<>());
    
    collectSelectedCheckBoxes(filterPanel, filters);
    
    return filters;
}

private void collectSelectedCheckBoxes(Container container, Map<String, List<String>> filters) {
    for (Component comp : container.getComponents()) {
        if (comp instanceof JCheckBox) {
            JCheckBox checkBox = (JCheckBox) comp;
            if (checkBox.isSelected()) {
                String name = checkBox.getName();
                if (name != null) {
                    if (name.startsWith("language_")) {
                        filters.get("languages").add(checkBox.getText());
                    } else if (name.startsWith("category_")) {
                        filters.get("categories").add(checkBox.getText());
                    } else if (name.equals("inStock")) {
                        filters.get("availability").add("inStock");
                    }
                }
            }
        } else if (comp instanceof JTextField) {
            JTextField textField = (JTextField) comp;
            String name = textField.getName();
            String value = textField.getText().trim();
            
            if (name != null && !value.isEmpty()) {
                if (name.equals("minPrice") || name.equals("maxPrice")) {
                    filters.get("priceRange").add(name + ":" + value);
                } else if (name.equals("fromYear") || name.equals("toYear")) {
                    filters.get("yearRange").add(name + ":" + value);
                }
            }
        } else if (comp instanceof Container) {
            collectSelectedCheckBoxes((Container) comp, filters);
        }
    }
}
private void clearAllFilters(Container container) {
    for (Component comp : container.getComponents()) {
        if (comp instanceof JCheckBox) {
            ((JCheckBox) comp).setSelected(false);
        } else if (comp instanceof JTextField) {
            ((JTextField) comp).setText("");
        } else if (comp instanceof Container) {
            clearAllFilters((Container) comp);
        }
    }
}

private void applyFiltersToBackend(Map<String, List<String>> filters, DefaultTableModel model) {
    System.out.println("=== Selected Filters ===");
    System.out.println("Languages: " + filters.get("languages"));
    System.out.println("Categories: " + filters.get("categories"));
    System.out.println("Price Range: " + filters.get("priceRange"));
    System.out.println("Year Range: " + filters.get("yearRange"));
    System.out.println("Availability: " + filters.get("availability"));
    
    model.setRowCount(0);
   
    
    JOptionPane.showMessageDialog(null, 
        "Filters applied!\nLanguages: " + filters.get("languages").size() + 
        "\nCategories: " + filters.get("categories").size(),
        "Filter Status", JOptionPane.INFORMATION_MESSAGE);
}


    private JPanel createCheckoutBookPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JTextField bookIdField = new JTextField(15);
        JTextField customerIdField = new JTextField(15);
        JTextField quantityField = new JTextField(15);
        
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Book ID:"), gbc);
        gbc.gridx = 1;
        formPanel.add(bookIdField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Customer ID:"), gbc);
        gbc.gridx = 1;
        formPanel.add(customerIdField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1;
        formPanel.add(quantityField, gbc);
        
        JButton checkoutBtn = new JButton("Process Checkout");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        formPanel.add(checkoutBtn, gbc);
        
        JButton backBtn = new JButton("Back to Home");
        gbc.gridy = 4;
        formPanel.add(backBtn, gbc);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "HOME"));
        
        panel.add(formPanel, BorderLayout.NORTH);
        
        JTextArea detailsArea = new JTextArea(15, 50);
        detailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createUpdateBookPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JTextField bookIdField = new JTextField(15);
        JTextField titleField = new JTextField(15);
        JTextField authorField = new JTextField(15);
        JTextField isbnField = new JTextField(15);
        JTextField priceField = new JTextField(15);
        JTextField quantityField = new JTextField(15);
        JTextField categoryField = new JTextField(15);
        
        String[] labels = {"Book ID:", "Title:", "Author:", "ISBN:", "Price:", "Quantity:", "Category:"};
        JTextField[] fields = {bookIdField, titleField, authorField, isbnField, priceField, quantityField, categoryField};
        
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; gbc.gridy = i;
            formPanel.add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1;
            formPanel.add(fields[i], gbc);
        }
        
        JButton loadBtn = new JButton("Load Book");
        JButton updateBtn = new JButton("Update Book");
        JButton addBtn = new JButton("Add New Book");
        JButton deleteBtn = new JButton("Delete Book");
        
        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 1;
        formPanel.add(loadBtn, gbc);
        gbc.gridx = 1;
        formPanel.add(updateBtn, gbc);
        
        gbc.gridx = 0; gbc.gridy = 8;
        formPanel.add(addBtn, gbc);
        gbc.gridx = 1;
        formPanel.add(deleteBtn, gbc);
        
        JButton backBtn = new JButton("Back to Home");
        gbc.gridx = 0; gbc.gridy = 9; gbc.gridwidth = 2;
        formPanel.add(backBtn, gbc);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "HOME"));
        
        panel.add(formPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createCustomerInfoPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton showAllBtn = new JButton("Show All Customers");
        JButton backBtn = new JButton("Back to Home");
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "HOME"));
        topPanel.add(showAllBtn);
        topPanel.add(backBtn);
        panel.add(topPanel, BorderLayout.NORTH);
        
        String[] columns = {"Customer ID", "Name", "Email", "Phone", "Address"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createSupplierInfoPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton showAllBtn = new JButton("Show All Suppliers");
        JButton backBtn = new JButton("Back to Home");
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "HOME"));
        topPanel.add(showAllBtn);
        topPanel.add(backBtn);
        panel.add(topPanel, BorderLayout.NORTH);
        
        String[] columns = {"Supplier ID", "Name", "Contact Person", "Email", "Phone", "Address"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createTransactionHistoryPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton showAllBtn = new JButton("Show All Transactions");
        JButton backBtn = new JButton("Back to Home");
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "HOME"));
        topPanel.add(showAllBtn);
        topPanel.add(backBtn);
        panel.add(topPanel, BorderLayout.NORTH);
        
        String[] columns = {"Transaction ID", "Book ID", "Customer ID", "Quantity", "Total Amount", "Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return btn;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookStallManagementSystem frame = new BookStallManagementSystem();
            frame.setVisible(true);
        });
    }
}
