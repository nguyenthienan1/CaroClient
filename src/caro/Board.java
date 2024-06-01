package caro;

import javax.swing.JPanel;

import client.SendMessage;
import mlib.MyImage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JPanel {
	private static final long serialVersionUID = 1440930565921598349L;
	private int edge = 20;
	public int[][] matrix = new int[20][20];
	public Point flagPiece = new Point(-1, -1);

	public Board() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				int cellSize = getCellSize();
				Point p = e.getPoint();
				int x = p.x / cellSize;
				int y = p.y / cellSize;
				if (x < 20 && y < 20) {
					SendMessage.gI().piece(x, y);
				}
			}
		});
	}

	private int getCellSize() {
		int cellSizeCol = getHeight() / edge;
		int cellSizeRow = getWidth() / edge;
		if (cellSizeCol < cellSizeRow) {
			return cellSizeCol;
		} else {
			return cellSizeRow;
		}
	}

	private void paintBackground(Graphics g) {
		int cellSize = getCellSize();
		g.setColor(new Color(255, 255, 217));
		g.fillRect(0, 0, edge * cellSize, edge * cellSize);
	}

	@Override
	protected void paintChildren(Graphics g) {
		paintBackground(g);
		int cellSize = getCellSize();
		g.setColor(Color.BLACK);
		for (int i = 0; i <= edge; i++) {
			g.drawLine(i * cellSize, 0, i * cellSize, cellSize * edge);
			g.drawLine(0, i * cellSize, cellSize * edge, i * cellSize);
		}
		paintFlagPiece(g);
		paintPiece(g);
		super.paintChildren(g);
	}

	private void paintPiece(Graphics g) {
		int cellSize = getCellSize();
		try {
			Image X = MyImage.imgX.getScaledInstance(cellSize - 10, cellSize - 10, Image.SCALE_SMOOTH);
			Image O = MyImage.imgO.getScaledInstance(cellSize - 10, cellSize - 10, Image.SCALE_SMOOTH);
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (matrix[i][j] == 1) {
						g.drawImage(X, i * cellSize + 5, j * cellSize + 5, null);
					} else if (matrix[i][j] == 2) {
						g.drawImage(O, i * cellSize + 5, j * cellSize + 5, null);
					}
				}
			}
		} catch (Exception e) {
		}
	}

	private void paintFlagPiece(Graphics g) {
		int cellSize = getCellSize();
		if (flagPiece.x != -1 && flagPiece.y != -1) {
			g.setColor(Color.ORANGE);
			g.fillRect(flagPiece.x * cellSize + 1, flagPiece.y * cellSize + 1, cellSize - 1, cellSize - 1);
		}
	}
}
