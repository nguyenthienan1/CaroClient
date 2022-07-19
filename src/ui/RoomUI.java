package ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import caro.Room;
import client.GlobalService;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class RoomUI extends JPanel {
	private static final long serialVersionUID = 2449280938065755409L;
	private JScrollPane scrollPane;
	private JButton btnCreateRoom;
	private JButton btnJoinRoom;
	private JButton btnUpdateLRoom;
	public JList<Room> jlistRoom;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu imenuLogOut;
	private JMenuItem mntmNewMenuItem;

	/**
	 * Create the panel.
	 */
	public RoomUI() {
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(true);
		
		btnCreateRoom = new JButton("Create room");
		btnCreateRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalService.gI().CreateRoom();
			}
		});
		btnCreateRoom.setFont(new Font("Dialog", Font.BOLD, 12));
		
		btnJoinRoom = new JButton("Join room");
		btnJoinRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GlobalService.gI().JoinRoom(jlistRoom.getSelectedValue().getNumber());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please select room");
				}
			}
		});
		btnJoinRoom.setFont(new Font("Dialog", Font.BOLD, 12));
		
		btnUpdateLRoom = new JButton("Update list room");
		btnUpdateLRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalService.gI().UpdateListRoom();
			}
		});
		btnUpdateLRoom.setFont(new Font("Dialog", Font.BOLD, 12));
		
		panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUpdateLRoom, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnCreateRoom, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
								.addComponent(btnJoinRoom, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)))
					.addGap(44))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUpdateLRoom)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateRoom)
						.addComponent(btnJoinRoom))
					.addContainerGap())
		);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		menuBar = new JMenuBar();
		panel.add(menuBar);
		
		imenuLogOut = new JMenu("Menu");
		menuBar.add(imenuLogOut);
		
		mntmNewMenuItem = new JMenuItem("Log out");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GlobalService.gI().LogOut();
			}
		});
		imenuLogOut.add(mntmNewMenuItem);
		
		jlistRoom = new JList<>();
		jlistRoom.setCellRenderer(new RoomRenderer());
		scrollPane.setViewportView(jlistRoom);
		setLayout(groupLayout);

	}
}
