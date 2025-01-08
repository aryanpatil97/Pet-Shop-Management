package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

public class ViewCats {

	private JFrame frmViewCats;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCats window = new ViewCats();
					window.frmViewCats.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewCats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewCats = new JFrame();
		frmViewCats.setResizable(false);
		frmViewCats.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewCats.class.getResource("/images/doge_meme.png")));
		frmViewCats.getContentPane().setBackground(new Color(224,247,250));
		frmViewCats.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cat DataBase");
		lblNewLabel.setFont(new Font("Baloo Thambi 2", Font.BOLD, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(304, 45, 291, 46);
		frmViewCats.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(142, 103, 615, 12);
		frmViewCats.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(142, 446, 615, 12);
		frmViewCats.getContentPane().add(separator_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmViewCats.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnBack.setBounds(142, 470, 150, 59);
		frmViewCats.getContentPane().add(btnBack);
	
		
		JButton btnReset = new JButton("Exit");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnReset.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnReset.setBounds(607, 470, 150, 59);
		frmViewCats.getContentPane().add(btnReset);
		
		
		String[] columnNames = {"ID", "Name", "Breed", "Age", "Vaccinated"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(142, 127, 615, 305);
		frmViewCats.getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		table.setForeground(Color.BLACK);
		table.setBackground(new Color(224,247,250));
		table.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("Baloo Thambi 2", Font.BOLD, 15));
		fetchDataFromDatabase(tableModel);
		scrollPane.setViewportView(table);
		
		frmViewCats.setBackground(new Color(224,247,250));
		frmViewCats.setTitle("View Cats");
		frmViewCats.setSize(900, 600);
		frmViewCats.setLocationRelativeTo(null);
		frmViewCats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static void fetchDataFromDatabase(DefaultTableModel tableModel) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/PetShopManagement";  // Adjust database URL if needed
        String user = "root"; // Your MySQL username
        String password = "password"; // Your MySQL password

        // SQL query to fetch data from the Dogs table
        String query = "SELECT id, name, breed, age, vaccinated FROM Cats";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Iterate through the result set and populate the JTable
            while (rs.next()) {
                // Get data from the ResultSet
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String breed = rs.getString("breed");
                int age = rs.getInt("age");
                String vaccinated = rs.getString("vaccinated");

                // Add row to the table model
                Object[] row = {id, name, breed, age, vaccinated};
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching data from database.");
        }
    }
}


