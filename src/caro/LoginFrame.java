package caro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.CaroClient;
import client.GlobalService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1768487403015568735L;
	private JPanel contentPane;
	private JTextField tfUserName;
	private JPasswordField passwordField;

	public LoginFrame() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 291);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(65, 77, 61, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(new Color(199, 21, 133));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(175, 11, 49, 26);
		contentPane.add(lblNewLabel_1);

		tfUserName = new JTextField();
		tfUserName.setText("admin");
		tfUserName.setBounds(136, 77, 169, 20);
		contentPane.add(tfUserName);
		tfUserName.setColumns(10);

		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUserName.getText();
				String password = String.valueOf(passwordField.getPassword());
				username = username.trim();
				password = password.trim();
				if (username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(CaroClient.loginFrame, "Please input user name and password");
				} else {
					GlobalService.gI().Login(username, password);
				}
			}
		});
		btnSignIn.setBounds(158, 172, 89, 29);
		contentPane.add(btnSignIn);

		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setBounds(65, 131, 61, 14);
		contentPane.add(lblNewLabel_4);

		passwordField = new JPasswordField();
		passwordField.setText("admin");
		passwordField.setBounds(136, 128, 169, 20);
		contentPane.add(passwordField);

		JLabel lblSignUp = new JLabel("Sign up");
		lblSignUp.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Sign up");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSignUp.setForeground(Color.RED);
			}
		});
		lblSignUp.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblSignUp.setForeground(Color.BLUE);
			}
		});
		lblSignUp.setForeground(Color.RED);
		lblSignUp.setBounds(352, 231, 46, 14);
		contentPane.add(lblSignUp);
	}
}
