package desktop5;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation1 extends JFrame{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new Animation1();
	}
	
	private Animation1() {
		super("画像を表示");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(new MyPanel());
		setSize(800, 400);
		setVisible(true);
		
		
	}
	
	
	private class MyPanel extends JPanel {
		
		@Override
		protected void paintComponent (Graphics g) {
			Image image = new ImageIcon("helicopter.png").getImage();
			g.drawImage(image, 100, 100, this);
		}
		
		
	}
	
	
	
	
	
	
	
}
