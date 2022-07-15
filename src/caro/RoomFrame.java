package caro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import client.GlobalService;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class RoomFrame extends JFrame {
	private static final long serialVersionUID = 1544825937269298757L;
	public JList<Room> jlistRoom;
	private JPanel contentPane;

	public RoomFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 387, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 48, 348, 285);
		contentPane.add(scrollPane);

		jlistRoom = new JList<Room>();
		jlistRoom.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "List Room", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setViewportView(jlistRoom);

		JButton btnCreateRoom = new JButton("Create room");
		btnCreateRoom.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCreateRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalService.gI().CreateRoom();
			}
		});
		btnCreateRoom.setBounds(15, 349, 119, 23);
		contentPane.add(btnCreateRoom);

		JButton btnJoinRoom = new JButton("Join room");
		btnJoinRoom.setFont(new Font("Dialog", Font.BOLD, 12));
		btnJoinRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GlobalService.gI().JoinRoom(jlistRoom.getSelectedValue().getNumber());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please select room");
				}
			}
		});
		btnJoinRoom.setBounds(252, 349, 111, 23);
		contentPane.add(btnJoinRoom);

		JButton btnUpdateLRoom = new JButton("Update list room");
		btnUpdateLRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalService.gI().UpdateListRoom();
			}
		});
		btnUpdateLRoom.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUpdateLRoom.setBounds(15, 14, 149, 23);
		contentPane.add(btnUpdateLRoom);
	}
}
