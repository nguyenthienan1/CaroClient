package ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import caro.Room;
import client.SendMessage;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Vector;
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
	private JList<Room> jlistRoom;
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
				SendMessage.gI().CreateRoom();
			}
		});
		btnCreateRoom.setFont(new Font("Dialog", Font.BOLD, 12));

		btnJoinRoom = new JButton("Join room");
		btnJoinRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SendMessage.gI().JoinRoom(jlistRoom.getSelectedValue().getNumber());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Please select room");
				}
			}
		});
		btnJoinRoom.setFont(new Font("Dialog", Font.BOLD, 12));

		btnUpdateLRoom = new JButton("Update list room");
		btnUpdateLRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.gI().UpdateListRoom();
			}
		});
		btnUpdateLRoom.setFont(new Font("Dialog", Font.BOLD, 12));

		panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(26)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUpdateLRoom, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnCreateRoom, GroupLayout.PREFERRED_SIZE, 119,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
										.addComponent(btnJoinRoom, GroupLayout.PREFERRED_SIZE, 111,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 348,
										Short.MAX_VALUE)))
				.addGap(44)).addComponent(panel, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnUpdateLRoom)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnCreateRoom).addComponent(btnJoinRoom))
										.addContainerGap()));
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		menuBar = new JMenuBar();
		panel.add(menuBar);

		imenuLogOut = new JMenu("Menu");
		menuBar.add(imenuLogOut);

		mntmNewMenuItem = new JMenuItem("Log out");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.gI().LogOut();
			}
		});
		imenuLogOut.add(mntmNewMenuItem);

		jlistRoom = new JList<>();
		jlistRoom.setCellRenderer(new RoomRenderer());
		scrollPane.setViewportView(jlistRoom);
		setLayout(groupLayout);

	}

	public void setListRoom(Vector<Room> vRooms) {
		jlistRoom.setListData(vRooms);
	}

	class RoomRenderer extends JPanel implements ListCellRenderer<Room> {
		private static final long serialVersionUID = -5301381214439291954L;
		private JLabel lbNumRoom;
		private JLabel lbNumPlayer;
		private JLabel lbStatus;

		public RoomRenderer() {
			setLayout(new BorderLayout(5, 5));
			lbNumPlayer = new JLabel();
			lbNumPlayer.setFont(new Font("Dialog", Font.BOLD, 16));
			lbNumPlayer.setBackground(new Color(98, 224, 255));
			lbNumRoom = new JLabel();
			lbNumRoom.setFont(new Font("Segoe Script", Font.BOLD, 20));
			lbStatus = new JLabel();
			lbStatus.setFont(new Font("Dialog", Font.BOLD, 16));

			JPanel panelNumroom = new JPanel(new BorderLayout(5, 5));
			panelNumroom.setBorder(new EmptyBorder(5, 5, 5, 5));
			panelNumroom.setBackground(Color.black);
			panelNumroom.add(lbNumRoom, BorderLayout.CENTER);
			add(panelNumroom, BorderLayout.WEST);

			JPanel panelText = new JPanel(new GridLayout(0, 1));
			panelText.add(lbNumPlayer);
			panelText.add(lbStatus);
			add(panelText, BorderLayout.CENTER);
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends Room> list, Room value, int index,
				boolean isSelected, boolean cellHasFocus) {
			lbNumRoom.setText("Room " + value.getNumber());
			lbNumPlayer.setText("Players: " + value.getNumOfPlayer());
			lbStatus.setText("Status: " + value.getStatus());

			// set Opaque to change background color of JLabel
			lbNumRoom.setOpaque(true);
			lbNumPlayer.setOpaque(true);
			lbStatus.setOpaque(true);

			// when select item
			if (isSelected) {
				lbNumRoom.setBackground(list.getSelectionBackground());
				lbNumPlayer.setBackground(list.getSelectionBackground());
				lbStatus.setBackground(list.getSelectionBackground());
				setBackground(list.getSelectionBackground());
			} else {
				lbNumRoom.setBackground(new Color(98, 224, 255));
				lbNumPlayer.setBackground(list.getBackground());
				lbStatus.setBackground(list.getBackground());
				setBackground(list.getBackground());
			}
			return this;
		}
	}
}
