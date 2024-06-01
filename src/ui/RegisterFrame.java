package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import network.logic.SendMessage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class RegisterFrame extends JFrame {
	private static final long serialVersionUID = -4275849317194116690L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldReEnter;

	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 556, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{105, 130, 113, 0};
		gbl_contentPane.rowHeights = new int[]{20, 32, 20, 20, 20, 34, 23, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
						
								JLabel lblNewLabel = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
								lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
								GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
								gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
								gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel.gridx = 1;
								gbc_lblNewLabel.gridy = 0;
								contentPane.add(lblNewLabel, gbc_lblNewLabel);
				
						JLabel lblNewLabel_1 = new JLabel("Tên tài khoản:");
						lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
						GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
						gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
						gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
						gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_1.gridx = 0;
						gbc_lblNewLabel_1.gridy = 2;
						contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
				textFieldUsername = new JTextField();
				textFieldUsername.setFont(new Font("Segoe UI", Font.PLAIN, 18));
				GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
				gbc_textFieldUsername.gridwidth = 2;
				gbc_textFieldUsername.fill = GridBagConstraints.BOTH;
				gbc_textFieldUsername.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldUsername.gridx = 1;
				gbc_textFieldUsername.gridy = 2;
				contentPane.add(textFieldUsername, gbc_textFieldUsername);
				textFieldUsername.setColumns(10);
						
								JLabel lblNewLabel_2 = new JLabel("Mật khẩu:");
								lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
								GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
								gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
								gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
								gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
								gbc_lblNewLabel_2.gridx = 0;
								gbc_lblNewLabel_2.gridy = 3;
								contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
				
						passwordField = new JPasswordField();
						passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
						GridBagConstraints gbc_passwordField = new GridBagConstraints();
						gbc_passwordField.gridwidth = 2;
						gbc_passwordField.fill = GridBagConstraints.BOTH;
						gbc_passwordField.insets = new Insets(0, 0, 5, 5);
						gbc_passwordField.gridx = 1;
						gbc_passwordField.gridy = 3;
						contentPane.add(passwordField, gbc_passwordField);
		
				JLabel lblNewLabel_3 = new JLabel("Nhập lại mật khẩu:");
				lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
				GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
				gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3.gridx = 0;
				gbc_lblNewLabel_3.gridy = 4;
				contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
				JButton btnNewButton = new JButton("Đăng kí");
				btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name = textFieldUsername.getText();
						String pass = String.valueOf(passwordField.getPassword());
						String repass = String.valueOf(passwordFieldReEnter.getPassword());
						if (name.equals("") || pass.equals("") || repass.equals("")) {
							JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin đăng ký");
							return;
						}
						SendMessage.gI().register(name, pass, repass);
					}
				});
				
						passwordFieldReEnter = new JPasswordField();
						passwordFieldReEnter.setFont(new Font("Segoe UI", Font.PLAIN, 18));
						GridBagConstraints gbc_passwordFieldReEnter = new GridBagConstraints();
						gbc_passwordFieldReEnter.gridwidth = 2;
						gbc_passwordFieldReEnter.fill = GridBagConstraints.BOTH;
						gbc_passwordFieldReEnter.insets = new Insets(0, 0, 5, 5);
						gbc_passwordFieldReEnter.gridx = 1;
						gbc_passwordFieldReEnter.gridy = 4;
						contentPane.add(passwordFieldReEnter, gbc_passwordFieldReEnter);
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
				gbc_btnNewButton.gridx = 1;
				gbc_btnNewButton.gridy = 6;
				contentPane.add(btnNewButton, gbc_btnNewButton);
	}
}
