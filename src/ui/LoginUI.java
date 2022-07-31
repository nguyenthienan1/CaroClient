package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import client.SendMessage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LoginUI extends JPanel {
	private static final long serialVersionUID = 2542937514118548359L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfUserName;
	private JButton btnSignIn;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField;
	private JLabel lblSignUp;

	/**
	 * Create the panel.
	 */
	public LoginUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 76, 82, 251, 55, 67, 0 };
		gridBagLayout.rowHeights = new int[] { 75, 42, 42, 31, 29, 20, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(new Color(199, 21, 133));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblNewLabel = new JLabel("Username:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		tfUserName = new JTextField();
		tfUserName.setText("admin");
		tfUserName.setColumns(10);
		GridBagConstraints gbc_tfUserName = new GridBagConstraints();
		gbc_tfUserName.fill = GridBagConstraints.BOTH;
		gbc_tfUserName.insets = new Insets(0, 0, 5, 5);
		gbc_tfUserName.gridx = 2;
		gbc_tfUserName.gridy = 1;
		add(tfUserName, gbc_tfUserName);

		lblNewLabel_2 = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setText("admin");
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		add(passwordField, gbc_passwordField);

		btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUserName.getText();
				String password = String.valueOf(passwordField.getPassword());
				username = username.trim();
				password = password.trim();
				if (username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please input user name and password");
				} else {
					SendMessage.gI().login(username, password);
				}
			}
		});
		btnSignIn.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnSignIn = new GridBagConstraints();
		gbc_btnSignIn.insets = new Insets(0, 0, 5, 5);
		gbc_btnSignIn.gridx = 2;
		gbc_btnSignIn.gridy = 3;
		add(btnSignIn, gbc_btnSignIn);

		lblSignUp = new JLabel("Sign up?");
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
		lblSignUp.setForeground(Color.RED);
		lblSignUp.setFont(new Font("Tahoma", Font.ITALIC, 13));
		GridBagConstraints gbc_lblSignUp = new GridBagConstraints();
		gbc_lblSignUp.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSignUp.insets = new Insets(0, 0, 5, 5);
		gbc_lblSignUp.gridx = 3;
		gbc_lblSignUp.gridy = 4;
		add(lblSignUp, gbc_lblSignUp);

	}
}
