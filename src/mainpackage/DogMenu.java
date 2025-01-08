package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DogMenu {

	private JFrame frmDogmenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DogMenu window = new DogMenu();
					window.frmDogmenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DogMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDogmenu = new JFrame();
		frmDogmenu.setResizable(false);
		frmDogmenu.setBackground(new Color(224,247,250));
		frmDogmenu.setTitle("Dog-Menu");
		frmDogmenu.setSize(900, 600);
		frmDogmenu.setLocationRelativeTo(null);
		
		frmDogmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224,247,250));
		frmDogmenu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DOG MENU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Baloo Thambi 2", Font.BOLD, 59));
		lblNewLabel.setBounds(153, 28, 595, 75);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewDogs vd = new ViewDogs();
				vd.main(null);
			}
		});
		btnNewButton.setFont(new Font("Baloo Thambi 2", Font.BOLD, 40));
		btnNewButton.setBounds(468, 141, 263, 141);
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(86, 121, 726, 12);
		panel.add(separator);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDog ad = new AddDog();
				ad.main(null);
			}
		});
		btnAdd.setFont(new Font("Baloo Thambi 2", Font.BOLD, 40));
		btnAdd.setBounds(194, 141, 262, 141);
		panel.add(btnAdd);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteDog dd =  new DeleteDog();
				dd.main(null);
			}
		});
		btnNewButton_1_1.setFont(new Font("Baloo Thambi 2", Font.BOLD, 40));
		btnNewButton_1_1.setBounds(194, 289, 262, 141);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Update");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateDog ud = new UpdateDog();
				ud.main(null);
			}
		});
		btnNewButton_1_2.setFont(new Font("Baloo Thambi 2", Font.BOLD, 40));
		btnNewButton_1_2.setBounds(468, 289, 262, 141);
		panel.add(btnNewButton_1_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDogmenu.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Baloo Thambi 2", Font.BOLD, 40));
		btnBack.setBounds(56, 488, 192, 60);
		panel.add(btnBack);
		
		JButton btnAdd_1_1 = new JButton("Exit");
		btnAdd_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnAdd_1_1.setFont(new Font("Baloo Thambi 2", Font.BOLD, 40));
		btnAdd_1_1.setBounds(663, 488, 192, 60);
		panel.add(btnAdd_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(86, 442, 726, 12);
		panel.add(separator_1);
	}
}
