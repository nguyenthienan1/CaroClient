package ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

import client.CaroClient;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ConnectUI extends JPanel {
	private static final long serialVersionUID = -8529188793389411079L;
	private JLabel lblNewLabel;
	private JTextField textFieldIp;
	private JLabel lblNewLabel_1;
	private JTextField textFieldPort;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public ConnectUI() {

		lblNewLabel = new JLabel("IP:");

		textFieldIp = new JTextField();
		textFieldIp.setText("127.0.0.1");
		textFieldIp.setColumns(10);

		lblNewLabel_1 = new JLabel("PORT:");

		textFieldPort = new JTextField();
		textFieldPort.setText("8888");
		textFieldPort.setColumns(10);

		lblNewLabel_2 = new JLabel("WELCOME TO CARO GAME");
		lblNewLabel_2.setForeground(new Color(220, 20, 60));
		lblNewLabel_2.setFont(new Font("Segoe Script", Font.BOLD, 16));

		btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ip = textFieldIp.getText();
					int port = Integer.parseInt(textFieldPort.getText());
					if (!CaroClient.conn.connected) {
						CaroClient.conn.Connect(ip, port);
						JOptionPane.showMessageDialog(null, "Connect success");
						CaroClient.window.setContentPane(CaroClient.loginUI);
					} else {
						JOptionPane.showMessageDialog(null, "You are already connected");
						CaroClient.window.setContentPane(CaroClient.loginUI);
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Can't connect to server, check ip and port then try again");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(47)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(52)
									.addComponent(textFieldPort, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
									.addGap(5)))
							.addGap(83))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(textFieldIp, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addGap(48)))
					.addGap(33))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldIp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(27)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
