package desktop5;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation2 extends JFrame {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new Animation2();
	}
	
	
	private Animation2() {
		super("画像を表示");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(new MyPanel());
		setSize(800, 400);
		setVisible(true);
		
	}
	
	
	private class MyPanel extends JPanel {
		Image image;
		int x, y;
		
		MyPanel() {
			image = new ImageIcon("helicopter.png").getImage();
			x = y = 100;
			addMouseMotionListener(new MouseMotion());
			addMouseListener(new MouseClick());
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.drawImage(image, x, y, this);
			
		}
		
		
		private class MouseMotion implements MouseMotionListener{
			@Override
			
			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				repaint();
				
			}
			
			@Override
			public void mouseMoved(MouseEvent e) {}		
		}
		
		
		
		private class MouseClick implements MouseListener{
			
			@Override
			
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				repaint();
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseReleased(MouseEvent e) {}
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
