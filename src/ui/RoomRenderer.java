package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import caro.Room;
import javax.swing.border.EmptyBorder;

public class RoomRenderer extends JPanel implements ListCellRenderer<Room> {
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
	public Component getListCellRendererComponent(JList<? extends Room> list, Room value, int index, boolean isSelected,
			boolean cellHasFocus) {
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
