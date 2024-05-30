package ui;

import javax.swing.JPanel;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ConnectPane extends JPanel {
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
	public ConnectPane() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 113, 64, 231, 117, 0 };
		gridBagLayout.rowHeights = new int[] { 83, 38, 36, 28, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblNewLabel_2 = new JLabel("WELCOME TO CARO GAME");
		lblNewLabel_2.setForeground(new Color(220, 20, 60));
		lblNewLabel_2.setFont(new Font("Segoe Script", Font.BOLD, 23));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		lblNewLabel = new JLabel("IP:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		textFieldIp = new JTextField();
		textFieldIp.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textFieldIp.setText("127.0.0.1");
		textFieldIp.setColumns(10);
		GridBagConstraints gbc_textFieldIp = new GridBagConstraints();
		gbc_textFieldIp.fill = GridBagConstraints.BOTH;
		gbc_textFieldIp.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIp.gridx = 2;
		gbc_textFieldIp.gridy = 1;
		add(textFieldIp, gbc_textFieldIp);

		lblNewLabel_1 = new JLabel("PORT:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		textFieldPort = new JTextField();
		textFieldPort.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textFieldPort.setText("8888");
		textFieldPort.setColumns(10);
		GridBagConstraints gbc_textFieldPort = new GridBagConstraints();
		gbc_textFieldPort.fill = GridBagConstraints.BOTH;
		gbc_textFieldPort.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPort.gridx = 2;
		gbc_textFieldPort.gridy = 2;
		add(textFieldPort, gbc_textFieldPort);

		btnNewButton = new JButton("Kết nối");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ip = textFieldIp.getText();
					int port = Integer.parseInt(textFieldPort.getText());
					if (!CaroClient.conn.connected) {
						CaroClient.conn.connect(ip, port);
						JOptionPane.showMessageDialog(null, "Kết nối thành công");
						CaroClient.window.setContentPane(CaroClient.loginUI);
					} else {
						JOptionPane.showMessageDialog(null, "Bạn đã kết nối rồi");
						CaroClient.window.setContentPane(CaroClient.loginUI);
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Không thể kết nối đến máy chủ, vui lòng thử lại sau");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		add(btnNewButton, gbc_btnNewButton);

	}
}
