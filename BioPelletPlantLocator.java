package Backend;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class BioPelletPlantLocator extends JFrame {
    private ArrayList<BioPelletPlant> plants;
    private JTable table;
    private JTextField searchField;
    private DefaultTableModel tableModel;

    public BioPelletPlantLocator() {
        plants = new ArrayList<>();
        initializePlants(); // Initialize with pre-added plants

        setTitle("Bio Pellet Plant Locator");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // Tool bar
        JToolBar toolBar = new JToolBar();
        JButton searchButton = new JButton("Search by Pincode");
        toolBar.add(searchButton);
        add(toolBar, BorderLayout.NORTH);

        // Plant List Panel
        JPanel plantListPanel = new JPanel(new BorderLayout());
        String[] columns = {"Plant Name", "Location", "Capacity", "Contact", "Pincode"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        plantListPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchPanel.add(new JLabel("Enter Pincode:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        plantListPanel.add(searchPanel, BorderLayout.NORTH);

        add(plantListPanel, BorderLayout.CENTER);

        // Footer label
        JLabel footerLabel = new JLabel("- Bio Pellet Plant Locator");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        footerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(footerLabel, BorderLayout.SOUTH);

        // Event handling
        searchButton.addActionListener(e -> searchPlantByPincode());

        setVisible(true);
    }

    private void initializePlants() {

            // Pre-added plants (example data)
            plants.add(new BioPelletPlant("Chennai Biofuel Plant", "Chennai, Tamil Nadu", "120", "044-1234-5678", "600001"));
            plants.add(new BioPelletPlant("Eco Friendly Biomass Plant", "Chennai, Tamil Nadu", "110", "044-2345-6789", "600001"));
            plants.add(new BioPelletPlant("Eco Green Energy", "Chennai, Tamil Nadu", "150", "044-3456-7890", "600018"));
            plants.add(new BioPelletPlant("Renewable Bioenergy Corp", "Chennai, Tamil Nadu", "220", "044-4567-8901", "600018"));
            plants.add(new BioPelletPlant("Bioenergy Solutions", "Chennai, Tamil Nadu", "190", "044-5678-9012", "600018"));
            plants.add(new BioPelletPlant("Sustainable Energy Works", "Chennai, Tamil Nadu", "130", "044-6789-0123", "600028"));
            plants.add(new BioPelletPlant("Chennai Biomass Power", "Chennai, Tamil Nadu", "140", "044-8901-2345", "600028"));
            plants.add(new BioPelletPlant("Renewable Energy Solutions", "Chennai, Tamil Nadu", "100", "044-9012-3456", "600042"));
            plants.add(new BioPelletPlant("Chennai EcoPellet Plant", "Chennai, Tamil Nadu", "125", "044-0123-4567", "600042"));
            plants.add(new BioPelletPlant("Green Fuel Industries", "Chennai, Tamil Nadu", "250", "044-1234-5678", "600060"));
            plants.add(new BioPelletPlant("Biofuels India", "Chennai, Tamil Nadu", "160", "044-2345-6789", "600060"));
            plants.add(new BioPelletPlant("Green Biomass Technologies", "Chennai, Tamil Nadu", "170", "044-3456-7890", "600060"));
            plants.add(new BioPelletPlant("Tamil Nadu Bio Pellets", "Chennai, Tamil Nadu", "200", "044-4567-8901", "600100"));
            plants.add(new BioPelletPlant("Chennai Green Energy Solutions", "Chennai, Tamil Nadu", "180", "044-5678-9012", "600100"));
            plants.add(new BioPelletPlant("Renewable Resources Chennai", "Chennai, Tamil Nadu", "155", "044-6789-0123", "600100"));
            plants.add(new BioPelletPlant("Renewable Energy Systems", "Chennai, Tamil Nadu", "135", "044-7890-1234", "600036"));
            plants.add(new BioPelletPlant("Chennai Sustainable Fuels", "Chennai, Tamil Nadu", "145", "044-8901-2345", "600036"));
            plants.add(new BioPelletPlant("Green Energy Solutions", "Chennai, Tamil Nadu", "175", "044-9012-3456", "600049"));
            plants.add(new BioPelletPlant("Chennai Bioenergy Plant", "Chennai, Tamil Nadu", "165", "044-0123-4567", "600049"));
            plants.add(new BioPelletPlant("Renewable Resources Chennai", "Chennai, Tamil Nadu", "155", "044-5678-9012", "600055"));
        plants.add(new BioPelletPlant("Sustainable Biomass Energy", "Chennai, Tamil Nadu", "140", "044-9876-5432", "603203"));
    }

    private void searchPlantByPincode() {
        String searchPincode = searchField.getText().trim();
        tableModel.setRowCount(0); // Clear the table

        boolean found = false; // Track if any plants are found
        for (BioPelletPlant plant : plants) {
            if (plant.getPincode().equals(searchPincode)) {
                tableModel.addRow(new Object[]{
                        plant.getName(),
                        plant.getLocation(),
                        plant.getCapacity(),
                        plant.getContact(),
                        plant.getPincode()
                });
                found = true; // A match was found
            }
        }

        if (!found) {
            showErrorDialog("No plants found for the given pincode.");
        }
    }

    private void showErrorDialog(String message) {
        JDialog dialog = new JDialog(this, "Error", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new JLabel(message));
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> dialog.dispose());
        dialog.add(okButton);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this); // Center the dialog
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BioPelletPlantLocator::new);
    }

    class BioPelletPlant {
        private String name, location, capacity, contact, pincode;

        public BioPelletPlant(String name, String location, String capacity, String contact, String pincode) {
            this.name = name;
            this.location = location;
            this.capacity = capacity;
            this.contact = contact;
            this.pincode = pincode;
        }

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public String getCapacity() {
            return capacity;
        }

        public String getContact() {
            return contact;
        }

        public String getPincode() {
            return pincode;
        }
    }
}