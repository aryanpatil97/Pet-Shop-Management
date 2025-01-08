package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class SelectType {

	JFrame frame1;
	protected Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectType window = new SelectType();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectType() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setResizable(false);
		frame1.setIconImage(Toolkit.getDefaultToolkit().getImage(SelectType.class.getResource("/images/paws.png")));
		frame1.setTitle("Select Menu");
		frame1.setSize(900,600);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 247, 250));
		frame1.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(102, 97, 696, 23);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("Happy Paws Paradise");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Baloo Thambi 2", Font.BOLD, 51));
		lblNewLabel.setBounds(125, 21, 649, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Category");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Baloo Thambi 2", Font.BOLD, 36));
		lblNewLabel_1.setBounds(306, 133, 287, 47);
		panel.add(lblNewLabel_1);
		
		JButton btnDog = new JButton("DOG");
		btnDog.setIcon(null);
		btnDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DogMenu.main(null);
			}
		});
		btnDog.setFont(new Font("Baloo Thambi 2", Font.BOLD, 53));
		btnDog.setBounds(125, 192, 316, 214);
		panel.add(btnDog);
		
		JButton btnNewButton_2 = new JButton("Coming soon!");
		btnNewButton_2.setFont(new Font("Baloo Thambi 2", Font.PLAIN, 13));
		btnNewButton_2.setBounds(320, 420, 273, 29);
		panel.add(btnNewButton_2);
		
		JButton btnCat = new JButton("CAT");
		btnCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CatMenu.main(null);
			}
		});
		btnCat.setFont(new Font("Baloo Thambi 2", Font.BOLD, 53));
		btnCat.setBounds(482, 192, 316, 214);
		panel.add(btnCat);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
			}
			
		});
		btnBack.setFont(new Font("Baloo Thambi 2", Font.BOLD, 39));
		btnBack.setBounds(69, 496, 176, 58);
		panel.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Baloo Thambi 2", Font.BOLD, 39));
		btnExit.setBounds(658, 496, 176, 58);
		panel.add(btnExit);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(102, 461, 696, 23);
		panel.add(separator_1);
	}
}
