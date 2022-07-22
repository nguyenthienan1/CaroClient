package ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.SendMessage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import caro.Board;

import java.awt.Font;

public class GameUI extends JPanel {
	private static final long serialVersionUID = -9076187580180368445L;
	private Board board;
	private JButton btnReady;
	private JTextField textChat;
	private JButton btnSendChat;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu iMenuLeaveRoom;
	private JMenuItem mntmNewMenuItem;
	private JScrollPane scrollPane;
	private JTextArea textShowChat;

	/**
	 * Create the panel.
	 */
	public GameUI() {

		board = new Board();
		board.setBackground(new Color(238, 238, 238));

		btnReady = new JButton("Ready");
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.gI().Ready();
			}
		});

		textChat = new JTextField();
		textChat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					eventSendChat();
				}
			}
		});
		textChat.setColumns(10);

		btnSendChat = new JButton("Send");
		btnSendChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventSendChat();
			}
		});

		panel = new JPanel();

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Chat", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(board, GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE).addGap(32)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textChat, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
								.addComponent(btnSendChat, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnReady, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
						.addContainerGap())
				.addGroup(Alignment.LEADING,
						groupLayout.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(449, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(btnReady).addGap(257)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
										.addGap(68)
										.addComponent(textChat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnSendChat))
								.addComponent(board, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE))
						.addContainerGap()));

		textShowChat = new JTextArea();
		textShowChat.setWrapStyleWord(true);
		textShowChat.setFont(new Font("Dialog", Font.PLAIN, 16));
		textShowChat.setBorder(null);
		textShowChat.setLineWrap(true);
		scrollPane.setViewportView(textShowChat);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		menuBar = new JMenuBar();
		panel.add(menuBar);

		iMenuLeaveRoom = new JMenu("Menu");
		menuBar.add(iMenuLeaveRoom);

		mntmNewMenuItem = new JMenuItem("Leave room");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int out = JOptionPane.showConfirmDialog(null, "Do you want out this room?", "Leave room",
						JOptionPane.YES_NO_OPTION);
				if (out == JOptionPane.YES_OPTION) {
					SendMessage.gI().LeaveRoom();
				}
			}
		});
		iMenuLeaveRoom.add(mntmNewMenuItem);
		setLayout(groupLayout);
	}

	private void eventSendChat() {
		String content = textChat.getText();
		textChat.setText("");
		if (!content.equals("")) {
			SendMessage.gI().ChatRoom(content);
		}
	}

	public void setPiece(int x, int y, int isX) {
		board.matrix[x][y] = isX;
	}

	public void setFlagPiece(int x, int y) {
		board.flagPiece.setLocation(x, y);
		board.repaint();
	}

	public void addTextChat(String text) {
		String content = textShowChat.getText() + text + "\n";
		textShowChat.setText(content);
	}
}
