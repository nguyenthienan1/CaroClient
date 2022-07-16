package caro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.GlobalService;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;

public class BoardFrame extends JFrame {
	private static final long serialVersionUID = -8413011714717794876L;
	public JPanel contentPane;
	private JTextField textChat;
	public JTextArea textShowChat;
	public BoardPanel boardPanel;

	public BoardFrame() {
		setBounds(0, 0, 1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		boardPanel = new BoardPanel();
		boardPanel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) boardPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		JButton btnReady = new JButton("Ready");
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalService.gI().Ready();
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		textChat = new JTextField();
		textChat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String content = textChat.getText();
					textChat.setText("");
					if (!content.equals("")) {
						GlobalService.gI().ChatRoom(content);
					}
				}
			}
		});
		textChat.setColumns(10);

		JButton btnSendChat = new JButton("Send");
		btnSendChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = textChat.getText();
				textChat.setText("");
				if (!content.equals("")) {
					GlobalService.gI().ChatRoom(content);
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(boardPanel, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReady)
						.addComponent(textChat, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSendChat))
					.addGap(8))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnReady)
					.addPreferredGap(ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(textChat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSendChat)
					.addGap(34))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(boardPanel, GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		textShowChat = new JTextArea();
		textShowChat.setFont(new Font("Arial", Font.PLAIN, 16));
		textShowChat.setWrapStyleWord(true);
		textShowChat.setLineWrap(true);
		scrollPane.setViewportView(textShowChat);
		contentPane.setLayout(gl_contentPane);
	}
}
