package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import client.CaroClient;
import network.logic.SendMessage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;

public class LoginPane extends JPanel {
	private static final long serialVersionUID = 2542937514118548359L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfUserName;
	private JButton btnSignIn;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField;
	private JLabel lblSignUp;
	private Component verticalStrut;
	private Component verticalStrut_1;

	/**
	 * Create the panel.
	 */
	public LoginPane() {
		setBackground(new Color(146, 168, 209));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 76, 82, 251, 55, 67, 0 };
		gridBagLayout.rowHeights = new int[] { 27, 0, 42, 18, 42, 0, 29, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(199, 21, 133));
		lblNewLabel_1.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 26));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblNewLabel = new JLabel("Tên tài khoản:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		tfUserName = new JTextField();
		tfUserName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		tfUserName.setText("admin");
		tfUserName.setColumns(10);
		GridBagConstraints gbc_tfUserName = new GridBagConstraints();
		gbc_tfUserName.fill = GridBagConstraints.BOTH;
		gbc_tfUserName.insets = new Insets(0, 0, 5, 5);
		gbc_tfUserName.gridx = 2;
		gbc_tfUserName.gridy = 2;
		add(tfUserName, gbc_tfUserName);

		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 3;
		add(verticalStrut, gbc_verticalStrut);

		lblNewLabel_2 = new JLabel("Mật khẩu:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		passwordField.setText("admin");
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);

		lblSignUp = new JLabel("Đăng ký?");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new RegisterFrame().setVisible(true);
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

		btnSignIn = new JButton("Đăng nhập");
		btnSignIn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!CaroClient.conn.connected) {
						CaroClient.conn.connect("localhost", 8888);
					}
					String username = tfUserName.getText();
					String password = String.valueOf(passwordField.getPassword());
					username = username.trim();
					password = password.trim();
					if (username.equals("") || password.equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập vào tên tài khoản");
					} else {
						SendMessage.gI().login(username, password);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Không thể kết nối đến máy chủ, vui lòng thử lại sau");
				}
			}
		});

		verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 2;
		gbc_verticalStrut_1.gridy = 5;
		add(verticalStrut_1, gbc_verticalStrut_1);
		btnSignIn.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnSignIn = new GridBagConstraints();
		gbc_btnSignIn.insets = new Insets(0, 0, 0, 5);
		gbc_btnSignIn.gridx = 2;
		gbc_btnSignIn.gridy = 6;
		add(btnSignIn, gbc_btnSignIn);
		lblSignUp.setForeground(Color.RED);
		lblSignUp.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		GridBagConstraints gbc_lblSignUp = new GridBagConstraints();
		gbc_lblSignUp.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSignUp.insets = new Insets(0, 0, 0, 5);
		gbc_lblSignUp.gridx = 3;
		gbc_lblSignUp.gridy = 6;
		add(lblSignUp, gbc_lblSignUp);

	}
}
