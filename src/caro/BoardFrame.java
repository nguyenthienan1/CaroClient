package caro;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.GlobalService;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class BoardFrame extends JFrame {
	private static final long serialVersionUID = -8413011714717794876L;
	public Board board = new Board(500, 500);
	public JPanel panelBoard;
	public JPanel contentPane;
	public JTextArea txtFieldChat;

	public BoardFrame() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to out this room?", "Close room",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					GlobalService.gI().LeaveRoom();
				}
			}
		});
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelBoard = new JPanel() {
			private static final long serialVersionUID = -6877477921746367220L;
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				board.paint(g);
			}
		};
		panelBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Point p = e.getPoint();
				int x = p.x / board.cellSize;
				int y = p.y / board.cellSize;
				GlobalService.gI().Piece(x, y);
				// System.out.println("X: " + x + " Y: " + y);
			}
		});
		panelBoard.setBackground(UIManager.getColor("info"));
		panelBoard.setBounds(10, 10, 501, 501);
		contentPane.add(panelBoard);

		JTextField textChat = new JTextField();
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
		textChat.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		textChat.setBounds(541, 445, 144, 26);
		contentPane.add(textChat);
		textChat.setColumns(10);

		JLabel lblNewLabel = new JLabel("Chat:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel.setBounds(541, 154, 55, 16);
		contentPane.add(lblNewLabel);

		JButton btnSendChat = new JButton("Send");
		btnSendChat.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnSendChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = textChat.getText();
				textChat.setText("");
				if (!content.equals("")) {
					GlobalService.gI().ChatRoom(content);
				}
			}
		});
		btnSendChat.setBounds(541, 483, 98, 26);
		contentPane.add(btnSendChat);

		JButton btnReady = new JButton("Ready");
		btnReady.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalService.gI().Ready();
			}
		});
		btnReady.setBounds(541, 10, 98, 26);
		contentPane.add(btnReady);

		JScrollPane scrollPaneChat = new JScrollPane();
		scrollPaneChat.setBounds(541, 181, 221, 253);
		contentPane.add(scrollPaneChat);

		txtFieldChat = new JTextArea();
		txtFieldChat.setBackground(new Color(224, 255, 255));
		txtFieldChat.setForeground(new Color(30, 144, 255));
		txtFieldChat.setEditable(false);
		txtFieldChat.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtFieldChat.setLineWrap(true);
		scrollPaneChat.setViewportView(txtFieldChat);
	}
}
