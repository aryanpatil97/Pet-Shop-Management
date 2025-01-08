package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
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
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class AddCat {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtBreed;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCat window = new AddCat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddCat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(AddCat.class.getResource("/images/doge_meme.png")));
		frame.getContentPane().setBackground(new Color(224,247,250));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Cat");
		lblNewLabel.setFont(new Font("Baloo Thambi 2", Font.BOLD, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(304, 45, 291, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(142, 103, 615, 12);
		frame.getContentPane().add(separator);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblName.setBounds(142, 149, 211, 46);
		frame.getContentPane().add(lblName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Breed");
		lblNewLabel_1_1.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblNewLabel_1_1.setBounds(142, 207, 211, 46);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblNewLabel_1_2.setBounds(142, 265, 118, 46);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender");
		lblNewLabel_1_3.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblNewLabel_1_3.setBounds(142, 323, 118, 46);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Vaccinated");
		lblNewLabel_1_4.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblNewLabel_1_4.setBounds(449, 265, 211, 46);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Baloo Thambi 2", Font.BOLD, 20));
		txtName.setBounds(304, 149, 291, 40);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtBreed = new JTextField();
		txtBreed.setFont(new Font("Baloo Thambi 2", Font.BOLD, 20));
		txtBreed.setColumns(10);
		txtBreed.setBounds(304, 207, 291, 40);
		frame.getContentPane().add(txtBreed);
		
		JSpinner spnAge = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
		spnAge.setBounds(304, 265, 72, 40);
		frame.getContentPane().add(spnAge);
		
		JComboBox Vaccinated = new JComboBox();
		Vaccinated.setFont(new Font("Baloo Thambi 2", Font.PLAIN, 15));
		Vaccinated.setMaximumRowCount(3);
		Vaccinated.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No", "Partially"}));
		Vaccinated.setBounds(647, 265, 110, 46);
		frame.getContentPane().add(Vaccinated);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(142, 399, 615, 12);
		frame.getContentPane().add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224,247,250));
		panel.setBounds(304, 323, 165, 46);
		frame.getContentPane().add(panel);
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
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				int status = jd.insertCat(Name, Breed, Age, Gender, Vaccination);
				if(status==1) {
					JOptionPane.showMessageDialog(null,"Data Updated!");
				}else {
					JOptionPane.showMessageDialog(null,"Not Updated:(");
				}
			}
		});
		btnNewButton.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnNewButton.setBounds(375, 448, 150, 59);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnBack.setBounds(142, 448, 150, 59);
		frame.getContentPane().add(btnBack);
	
		
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
		frame.getContentPane().add(btnReset);
		
		frame.setForeground(new Color(224,247,250));
		frame.setBackground(new Color(224,247,250));
		frame.setTitle("Add Dog");
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
