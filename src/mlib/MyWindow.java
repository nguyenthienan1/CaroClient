package mlib;

import java.awt.Container;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyWindow extends JFrame {
	private static final long serialVersionUID = 8560587936628025228L;

	public MyWindow() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setTitle("Cờ Caro");
		try {
			setIconImage(ImageIO.read(MyWindow.class.getResource("/image/caro.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int exit = JOptionPane.showConfirmDialog(null, "Exit game?", "Warning", JOptionPane.YES_NO_OPTION);
				if (exit == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	@Override
	public void setContentPane(Container contentPane) {
		super.setContentPane(contentPane);
		revalidate();
	}
}
