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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteCat {

	private JFrame frmDeleteCat;
	private JTextField txtName;
	private JTextField txtBreed;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCat window = new DeleteCat();
					window.frmDeleteCat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteCat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeleteCat = new JFrame();
		frmDeleteCat.setResizable(false);
		frmDeleteCat.setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteCat.class.getResource("/images/doge_meme.png")));
		frmDeleteCat.getContentPane().setBackground(new Color(224,247,250));
		frmDeleteCat.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete via Cat ID");
		lblNewLabel.setFont(new Font("Baloo Thambi 2", Font.BOLD, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(142, 45, 366, 46);
		frmDeleteCat.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(142, 103, 615, 12);
		frmDeleteCat.getContentPane().add(separator);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblName.setBounds(142, 176, 211, 46);
		frmDeleteCat.getContentPane().add(lblName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Breed");
		lblNewLabel_1_1.setFont(new Font("Baloo Thambi 2", Font.BOLD, 32));
		lblNewLabel_1_1.setBounds(142, 248, 211, 46);
		frmDeleteCat.getContentPane().add(lblNewLabel_1_1);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Baloo Thambi 2", Font.BOLD, 20));
		txtName.setBounds(304, 182, 291, 40);
		frmDeleteCat.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtBreed = new JTextField();
		txtBreed.setFont(new Font("Baloo Thambi 2", Font.BOLD, 20));
		txtBreed.setColumns(10);
		txtBreed.setBounds(304, 254, 291, 40);
		frmDeleteCat.getContentPane().add(txtBreed);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(142, 399, 615, 12);
		frmDeleteCat.getContentPane().add(separator_1);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Id = Integer.parseInt(txtId.getText());
				
				JDBCHandling jh = new JDBCHandling();
				int status = jh.DeleteCat(Id);
				if(status==1) {
					JOptionPane.showMessageDialog(null,"Data Deleted!");
				}else {
					JOptionPane.showMessageDialog(null,"Not Deleted:(");
				}
				txtName.setText(null);
				txtBreed.setText(null);
				txtId.setText(null);
			}
		});
		btnNewButton.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnNewButton.setBounds(375, 328, 150, 59);
		frmDeleteCat.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeleteCat.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnBack.setBounds(142, 448, 150, 59);
		frmDeleteCat.getContentPane().add(btnBack);
	
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtBreed.setText(null);
			}
		});
		btnReset.setFont(new Font("Baloo Thambi 2", Font.BOLD, 30));
		btnReset.setBounds(607, 448, 150, 59);
		frmDeleteCat.getContentPane().add(btnReset);
		
		txtId = new JTextField();
		txtId.setBounds(509, 45, 97, 46);
		frmDeleteCat.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnGetData = new JButton("Get Data");
		btnGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Id = Integer.parseInt(txtId.getText());
				try (ResultSet rs = JDBCHandling.getCatData(Id)) {
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
		frmDeleteCat.getContentPane().add(btnGetData);
		
		frmDeleteCat.setForeground(new Color(224,247,250));
		frmDeleteCat.setBackground(new Color(224,247,250));
		frmDeleteCat.setTitle("Delete Cat");
		frmDeleteCat.setSize(900, 600);
		frmDeleteCat.setLocationRelativeTo(null);
		frmDeleteCat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
