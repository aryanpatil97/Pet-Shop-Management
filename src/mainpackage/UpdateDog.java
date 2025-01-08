package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.Resultset;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class UpdateDog {

	private JFrame frmUpdateDog;
	private JTextField txtName;
	private JTextField txtBreed;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDog window = new UpdateDog();
					window.frmUpdateDog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateDog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateDog = new JFrame();
		frmUpdateDog.setResizable(false);
		frmUpdateDog.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateDog.class.getResource("/images/doge_meme.png")));
		frmUpdateDog.getContentPane().setBackground(new Color(224,247,250));
		frmUpdateDog.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update via Dog ID");
		lblNewLabel.setFont(new Font("Baloo Thambi 2", Font.BOLD, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(142, 45, 366, 46);
		frmUpdateDog.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(142, 103, 615, 12);
		frmUpdateDog.getContentPane().add(separator);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblName.setBounds(142, 149, 211, 46);
		frmUpdateDog.getContentPane().add(lblName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Breed");
		lblNewLabel_1_1.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblNewLabel_1_1.setBounds(142, 207, 211, 46);
		frmUpdateDog.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblNewLabel_1_2.setBounds(142, 265, 118, 46);
		frmUpdateDog.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender");
		lblNewLabel_1_3.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblNewLabel_1_3.setBounds(142, 323, 118, 46);
		frmUpdateDog.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Vaccinated");
		lblNewLabel_1_4.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblNewLabel_1_4.setBounds(449, 265, 211, 46);
		frmUpdateDog.getContentPane().add(lblNewLabel_1_4);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Baloo Thambi 2", Font.BOLD, 20));
		txtName.setBounds(304, 149, 291, 40);
		frmUpdateDog.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtBreed = new JTextField();
		txtBreed.setFont(new Font("Baloo Thambi 2", Font.BOLD, 20));
		txtBreed.setColumns(10);
		txtBreed.setBounds(304, 207, 291, 40);
		frmUpdateDog.getContentPane().add(txtBreed);
		
		JSpinner spnAge = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
		spnAge.setBounds(304, 265, 72, 40);
		frmUpdateDog.getContentPane().add(spnAge);
		
		JComboBox Vaccinated = new JComboBox();
		Vaccinated.setFont(new Font("Baloo Thambi 2", Font.PLAIN, 15));
		Vaccinated.setMaximumRowCount(3);
		Vaccinated.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No", "Partially"}));
		Vaccinated.setBounds(647, 265, 110, 46);
		frmUpdateDog.getContentPane().add(Vaccinated);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(142, 399, 615, 12);
		frmUpdateDog.getContentPane().add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224,247,250));
		panel.setBounds(304, 323, 165, 46);
		frmUpdateDog.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton btnMale = new JRadioButton("Male");
		btnMale.setBounds(6, 0, 66, 40);
		panel.add(btnMale);
		buttonGroup.add(btnMale);
		btnMale.setFont(new Font("Baloo Thambi 2", Font.PLAIN, 17));
		
		JRadioButton btnFemale = new JRadioButton("Female");
		btnFemale.setBounds(74, -2, 85, 43);
		panel.add(btnFemale);
		buttonGroup.add(btnFemale);
		btnFemale.setFont(new Font("Baloo Thambi 2", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Id = Integer.parseInt(txtId.getText());
				String Name = txtName.getText();
				String Breed = txtBreed.getText();
				int Age = (Integer) spnAge.getValue();
				
				String Gender = null;
				if(btnMale.isSelected()) {
					Gender = "Male";
				}else if(btnFemale.isSelected()) {
					Gender = "Female";
				}
				String Vaccination = (String) Vaccinated.getSelectedItem();
				
				System.out.println(Name);
				System.out.println(Breed);
				System.out.println(Age);
				System.out.println(Gender);
				System.out.println(Vaccination);
				
				JDBCHandling jd = new JDBCHandling();
				
				int status = jd.insertUpdateDog(Id,Name, Breed, Age, Gender, Vaccination);
				if(status==1) {
					JOptionPane.showMessageDialog(null,"Data Updated!");
				}else {
					JOptionPane.showMessageDialog(null,"Not Updated:(");
				}
			}
		});
		btnNewButton.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnNewButton.setBounds(375, 448, 150, 59);
		frmUpdateDog.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUpdateDog.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnBack.setBounds(142, 448, 150, 59);
		frmUpdateDog.getContentPane().add(btnBack);
	
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtBreed.setText(null);
				btnMale.setSelected(false);
				btnFemale.setSelected(false);
				spnAge.setValue(0);
			}
		});
		btnReset.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnReset.setBounds(607, 448, 150, 59);
		frmUpdateDog.getContentPane().add(btnReset);
		
		txtId = new JTextField();
		txtId.setBounds(509, 45, 97, 46);
		frmUpdateDog.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnGetData = new JButton("Get Data");
		btnGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Id = Integer.parseInt(txtId.getText());
				try (ResultSet rs = JDBCHandling.getDogData(Id)) {
		            if (rs != null && rs.next()) {
		                // Populate the text fields with data
		                txtName.setText(rs.getString("name"));
		                txtBreed.setText(rs.getString("breed"));
		            } else {
		                JOptionPane.showMessageDialog(null, "No data found for the given ID: " + Id);
		            }
		        } catch (SQLException se) {
		            se.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error while fetching data from database.");
		        }
				
			}
		});
		btnGetData.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnGetData.setBounds(612, 45, 143, 46);
		frmUpdateDog.getContentPane().add(btnGetData);
		
		frmUpdateDog.setForeground(new Color(224,247,250));
		frmUpdateDog.setBackground(new Color(224,247,250));
		frmUpdateDog.setTitle("Update Dog");
		frmUpdateDog.setSize(900, 600);
		frmUpdateDog.setLocationRelativeTo(null);
		frmUpdateDog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
