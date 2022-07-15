package caro;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;

public class Board {
	int row = 20;
	int col = 20;
	int height;
	int width;
	int cellSize;
	public int[][] matrix = new int[20][20];
	Image imgX;
	Image imgO;
	public Point flagPiece = new Point(-1, -1);

	public Board(int w, int h) {
		width = w;
		height = h;
		cellSize = w / row;
		try {
			imgX = ImageIO.read(getClass().getResourceAsStream("/image/X.png"));
			imgX = imgX.getScaledInstance(cellSize, cellSize, Image.SCALE_SMOOTH);
			imgO = ImageIO.read(getClass().getResourceAsStream("/image/O.png"));
			imgO = imgO.getScaledInstance(cellSize, cellSize, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		for (int i = 0; i <= row; i++) {
			g.drawLine(i * cellSize, 0, i * cellSize, height);
			g.drawLine(0, i * cellSize, width, i * cellSize);
		}
		paintFlagPiece(g);
		paintPiece(g);
	}

	private void paintPiece(Graphics g) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					g.drawImage(imgX, i * cellSize, j * cellSize, null);
				} else if (matrix[i][j] == 2) {
					g.drawImage(imgO, i * cellSize, j * cellSize, null);
				}
			}
		}
	}

	private void paintFlagPiece(Graphics g) {
		if (flagPiece.x != -1 || flagPiece.y != -1) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(flagPiece.x * cellSize, flagPiece.y * cellSize, cellSize, cellSize);
		}
	}
}
