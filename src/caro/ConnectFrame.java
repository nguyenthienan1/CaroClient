package caro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.CaroClient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConnectFrame extends JFrame {
	private static final long serialVersionUID = 6885875859847925924L;
	private JPanel contentPane;
	private JTextField textFieldIp;
	private JTextField textFieldPort;
	public ConnectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 232);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("IP:");
		lblNewLabel_2.setBounds(108, 63, 22, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldIp = new JTextField();
		textFieldIp.setText("127.0.0.1");
		textFieldIp.setColumns(10);
		textFieldIp.setBounds(140, 60, 118, 20);
		contentPane.add(textFieldIp);
		
		JLabel lblNewLabel_3 = new JLabel("PORT:");
		lblNewLabel_3.setBounds(112, 110, 36, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldPort = new JTextField();
		textFieldPort.setText("8888");
		textFieldPort.setColumns(10);
		textFieldPort.setBounds(158, 107, 86, 20);
		contentPane.add(textFieldPort);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO CARO GAME");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 16));
		lblNewLabel.setBounds(81, 11, 247, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ip = textFieldIp.getText();
					int port = Integer.parseInt(textFieldPort.getText());
					if (!CaroClient.conn.connected) {
						CaroClient.conn.Connect(ip, port);
						JOptionPane.showMessageDialog(null, "Connect success");
						setVisible(false);
						CaroClient.loginFrame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "You are already connected");
						setVisible(false);
						CaroClient.loginFrame.setVisible(true);
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Can't connect to server, check ip and port then try again");
				}
			}
		});
		btnNewButton.setBounds(155, 148, 89, 23);
		contentPane.add(btnNewButton);
	}
}
