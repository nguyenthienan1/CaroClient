package ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

import client.SendMessage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

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

		lblNewLabel = new JLabel("Username:");

		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(new Color(199, 21, 133));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));

		tfUserName = new JTextField();
		tfUserName.setText("admin");
		tfUserName.setColumns(10);

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

		lblNewLabel_2 = new JLabel("Password:");

		passwordField = new JPasswordField();
		passwordField.setText("admin");

		lblSignUp = new JLabel("Sign up");
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
		lblSignUp.setFont(new Font("Tahoma", Font.ITALIC, 12));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(tfUserName, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
					.addGap(76))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(301, Short.MAX_VALUE)
					.addComponent(lblSignUp, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addGap(160))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(143)
					.addComponent(btnSignIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(153))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tfUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnSignIn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(lblSignUp)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
