package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class LoginPage {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(224, 247, 250));
		frame.setForeground(new Color(0, 0, 0));
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		frame.setSize(((int)dim.width)/2, ((int)dim.height)/2);
		frame.setLocationRelativeTo(null);
		
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/aryanpatil/Desktop/doge_meme.png"));
		frame.setBackground(new Color(0, 0, 0));
		frame.setTitle("Login Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter UserName : ");
		lblNewLabel.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblNewLabel.setBounds(97, 172, 258, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Happy Paws Paradise");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Baloo Thambi 2", Font.BOLD, 51));
		lblNewLabel_1.setBounds(174, 28, 506, 77);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(97, 120, 660, 12);
		frame.getContentPane().add(separator);
		
		JLabel lblEnterPassword = new JLabel("Enter Password :");
		lblEnterPassword.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblEnterPassword.setBounds(97, 252, 271, 49);
		frame.getContentPane().add(lblEnterPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Baloo Thambi 2", Font.BOLD, 21));
		textField.setBounds(422, 179, 258, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Baloo Thambi 2", Font.BOLD, 21));
		passwordField.setBounds(422, 256, 258, 46);
		frame.getContentPane().add(passwordField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(101, 362, 656, 12);
		frame.getContentPane().add(separator_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				 if (username.equals("Aryan") && password.equals("1234")) {
					 SelectType.main(null);
		            } else {
		                JOptionPane.showMessageDialog(null,"Invalid Credentials");
		            }
			}
		});
		btnLogin.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnLogin.setBounds(350, 403, 159, 53);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnReset.setBounds(97, 403, 159, 53);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnExit.setBounds(598, 403, 159, 53);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_2 = new JLabel("by PAWtil Aryan");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(350, 94, 151, 16);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
