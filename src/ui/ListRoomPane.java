package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;

import caro.Room;
import client.SendMessage;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

public class ListRoomPane extends JPanel {
	private static final long serialVersionUID = 2449280938065755409L;
	private JScrollPane scrollPane;
	private JButton btnCreateRoom;
	private JButton btnJoinRoom;
	private JButton btnUpdateLRoom;
	private JList<Room> jlistRoom;
	private JMenu imenuMn;
	private JMenuItem mntmLogOut;
	private JMenuBar menuBar_1;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public ListRoomPane() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Danh sách phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setEnabled(true);

		jlistRoom = new JList<>();
		jlistRoom.setCellRenderer(new RoomRenderer());
		scrollPane.setViewportView(jlistRoom);
		add(scrollPane, BorderLayout.CENTER);

		menuBar_1 = new JMenuBar();
		add(menuBar_1, BorderLayout.NORTH);

		imenuMn = new JMenu("Menu");
		menuBar_1.add(imenuMn);

		mntmLogOut = new JMenuItem("Đăng xuất");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.gI().logOut();
			}
		});
		imenuMn.add(mntmLogOut);

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		add(panel, BorderLayout.SOUTH);

		btnCreateRoom = new JButton("Tạo phòng");
		panel.add(btnCreateRoom);
		btnCreateRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.gI().createRoom();
			}
		});
		btnCreateRoom.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		btnJoinRoom = new JButton("Vào phòng");
		panel.add(btnJoinRoom);
		btnJoinRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SendMessage.gI().joinRoom(jlistRoom.getSelectedValue().getNumber());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng muốn vào");
				}
			}
		});
		btnJoinRoom.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		btnUpdateLRoom = new JButton("Cập nhật");
		panel.add(btnUpdateLRoom);
		btnUpdateLRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage.gI().updateListRoom();
			}
		});
		btnUpdateLRoom.setFont(new Font("Segoe UI", Font.PLAIN, 18));

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
			lbNumRoom.setText("Phòng " + value.getNumber());
			lbNumPlayer.setText("Số người trong phòng: " + value.getNumOfPlayer());
			lbStatus.setText("Trạng thái: " + value.getStatus());

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
