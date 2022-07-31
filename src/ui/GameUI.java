package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.SendMessage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import caro.Board;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

public class GameUI extends JPanel {
	private static final long serialVersionUID = -9076187580180368445L;
	private Board board;
	private JButton btnReady;
	private JTextField textChat;
	private JButton btnSendChat;
	private JMenu iMenuLeaveRoom;
	private JMenuItem mntmNewMenuItem;
	private JScrollPane scrollPane;
	private JTextArea textShowChat;
	private JPanel panel_1;
	private JMenuBar menuBar;

	/**
	 * Create the panel.
	 */
	public GameUI() {

		board = new Board();
		board.setBackground(new Color(238, 238, 238));

		panel_1 = new JPanel();
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 200, 0 };
		gbl_panel_1.rowHeights = new int[] { 26, 452, 20, 26, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		btnReady = new JButton("Ready");
		GridBagConstraints gbc_btnReady = new GridBagConstraints();
		gbc_btnReady.anchor = GridBagConstraints.WEST;
		gbc_btnReady.insets = new Insets(0, 0, 5, 0);
		gbc_btnReady.gridx = 0;
		gbc_btnReady.gridy = 0;
		panel_1.add(btnReady, gbc_btnReady);
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.gI().ready();
			}
		});
		setLayout(new BorderLayout(10, 10));
		add(board, BorderLayout.CENTER);
		board.setLayout(null);
		add(panel_1, BorderLayout.EAST);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		scrollPane.setBorder(new TitledBorder(null, "Chat", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		textShowChat = new JTextArea();
		textShowChat.setColumns(10);
		textShowChat.setEditable(false);
		textShowChat.setWrapStyleWord(true);
		textShowChat.setFont(new Font("Dialog", Font.PLAIN, 16));
		textShowChat.setLineWrap(true);
		scrollPane.setViewportView(textShowChat);

		textChat = new JTextField();
		GridBagConstraints gbc_textChat = new GridBagConstraints();
		gbc_textChat.fill = GridBagConstraints.HORIZONTAL;
		gbc_textChat.insets = new Insets(0, 0, 5, 0);
		gbc_textChat.gridx = 0;
		gbc_textChat.gridy = 2;
		panel_1.add(textChat, gbc_textChat);
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
		GridBagConstraints gbc_btnSendChat = new GridBagConstraints();
		gbc_btnSendChat.anchor = GridBagConstraints.WEST;
		gbc_btnSendChat.gridx = 0;
		gbc_btnSendChat.gridy = 3;
		panel_1.add(btnSendChat, gbc_btnSendChat);

		menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);

		iMenuLeaveRoom = new JMenu("Menu");
		menuBar.add(iMenuLeaveRoom);

		mntmNewMenuItem = new JMenuItem("Leave room");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int out = JOptionPane.showConfirmDialog(null, "Do you want out this room?", "Leave room",
						JOptionPane.YES_NO_OPTION);
				if (out == JOptionPane.YES_OPTION) {
					SendMessage.gI().leaveRoom();
				}
			}
		});
		iMenuLeaveRoom.add(mntmNewMenuItem);
		btnSendChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventSendChat();
			}
		});
	}

	private void eventSendChat() {
		String content = textChat.getText();
		textChat.setText("");
		if (!content.equals("")) {
			SendMessage.gI().chatRoom(content);
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

	public void resetBoard() {
		board.matrix = new int[20][20];
		board.flagPiece.setLocation(-1, -1);
		board.repaint();
	}
}
