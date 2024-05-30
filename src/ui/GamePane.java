package ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.SendMessage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import caro.Board;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class GamePane extends JPanel {
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
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JList<String> listPlayer;
	private JScrollPane scrollPane_2;
	private JList<String> listSpecPlayer;

	/**
	 * Create the panel.
	 */
	public GamePane() {

		board = new Board();

		panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		btnReady = new JButton("Sẵn sàng");
		btnReady.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		panel_1.add(btnReady);
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
		panel_1.add(scrollPane);
		scrollPane.setBorder(new TitledBorder(null, "Chat", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		textShowChat = new JTextArea();
		textShowChat.setRows(10);
		textShowChat.setColumns(10);
		textShowChat.setEditable(false);
		textShowChat.setWrapStyleWord(true);
		textShowChat.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textShowChat.setLineWrap(true);
		scrollPane.setViewportView(textShowChat);

		textChat = new JTextField();
		textChat.setMaximumSize(new Dimension(2147483647, 100));
		textChat.setHorizontalAlignment(SwingConstants.LEFT);
		textChat.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		panel_1.add(textChat);
		textChat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					eventSendChat();
				}
			}
		});
		textChat.setColumns(10);

		btnSendChat = new JButton("Gửi");
		btnSendChat.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		panel_1.add(btnSendChat);

		menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);

		iMenuLeaveRoom = new JMenu("Menu");
		menuBar.add(iMenuLeaveRoom);

		mntmNewMenuItem = new JMenuItem("Rời phòng");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int out = JOptionPane.showConfirmDialog(null, "Bạn có muốn rời phòng?", "Thông tin",
						JOptionPane.YES_NO_OPTION);
				if (out == JOptionPane.YES_OPTION) {
					SendMessage.gI().leaveRoom();
				}
			}
		});
		iMenuLeaveRoom.add(mntmNewMenuItem);
		
		panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "Người chơi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(scrollPane_1);
		
		listPlayer = new JList<String>();
		scrollPane_1.setViewportView(listPlayer);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new TitledBorder(null, "Người xem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(scrollPane_2);
		
		listSpecPlayer = new JList<String>();
		scrollPane_2.setViewportView(listSpecPlayer);
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
	
	public void updatePlayerRoom(Vector<String> players) {
		listPlayer.setListData(players);
	}
	
	public void updateSpectatingPlayer(Vector<String> players) {
		listSpecPlayer.setListData(players);
	}
}
