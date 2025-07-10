package desktop5;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation4 extends JFrame {
	int width = 800, height = 400;
	
	
	public static void main(String[] args) {
		new Animation4();
	}
	
	
	private Animation4() {
		super("指定方向に画像を動作");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	     getContentPane().add(new MyPanel());
	      setSize(width, height);
	      setVisible(true);
		
	}
	
	
	private class MyPanel extends JPanel {
        Image image;
        int imWidth, imHeight;
        int x, y;
        
        JButton stop, up, down, left, right;
        int move = 0;
        int speed = 20;
        Timer timer;
        
        

        private MyPanel() {
            image = new ImageIcon("helicopter.png").getImage();
            
            imWidth = image.getWidth(this);
            imHeight = image.getHeight(this);
            
            x = width / 2 - imWidth;
            y = height / 2 - imHeight;
            
            setLayout(null);
            stop = new JButton("■");
            stop.setBounds(30, 30, 30, 30);
            stop.setMargin(new Insets(0, 0, 0, 0));
            stop.addActionListener(new ButtonAction());
            
            up = new JButton("⋀");
            up.setBounds(30, 0, 30, 30);
            up.setMargin(new Insets(0, 0, 0, 0));
            up.addActionListener(new ButtonAction());
            
            
            down = new JButton("↓");
            down.setBounds(30, 60, 30, 30);
            down.setMargin(new Insets(0, 0, 0, 0));
            down.addActionListener(new ButtonAction());
            
            left = new JButton("←");
            left.setBounds(0, 30, 30, 30);
            left.setMargin(new Insets(0, 0, 0, 0));
            left.addActionListener(new ButtonAction());
            
            
            right = new JButton("→");
            right.setBounds(60, 30, 30, 30);
            right.setMargin(new Insets(0, 0, 0, 0));
            right.addActionListener(new ButtonAction());
            
            add(stop);
            add(up);
            add(down);
            
            add(right);
            add(left);
            
            timer = new Timer(100, new TimerAction());
            setButton(0);
        }

        @Override
        protected void paintComponent(Graphics g) {
        	
        	switch(move) {
        	case 1:
        		y -= speed;
        		if(y < -imHeight) y = height;
        		break;
        		
        	case 2:
        		y += speed;
        		if(y > height) y =-imHeight;
        		break;	
        		
        	case 3:
        		x -= speed;
        		if(x < -imWidth) y = width;
        		break;
        		
        		
        	case 4:
        		x += speed;
        		if(x > width) y =-imWidth;
        		break;
        	}
  	
            super.paintComponent(g);
            g.drawImage(image, x, y, this); // 画像を描画 
            
        }

        
        private void setButton(int move) {
        	this.move = move;
        	if(move == 0) {
        		
        		stop.setEnabled(false);
        		up.setEnabled(true);
        		down.setEnabled(true);
        		left.setEnabled(true);
        		right.setEnabled(true);
        		timer.stop();
        		
        	} else {
        		
        		stop.setEnabled(true);
        		up.setEnabled(true);
        		down.setEnabled(true);
        		left.setEnabled(true);
        		right.setEnabled(true);
        		timer.start();		
        		
        	}        	
        	
        }
        
        private class ButtonAction implements ActionListener{
        	@Override
        	public void actionPerformed(ActionEvent ae) {
        		
        		if(ae.getSource().equals(stop)) {
        			setButton(0);
        		}
        		if(ae.getSource().equals(up)) {
        			setButton(1);
        		}
        		if(ae.getSource().equals(down)) {
        			setButton(2);
        		}
        		if(ae.getSource().equals(left)) {
        			setButton(3);
        		}
        		if(ae.getSource().equals(right)) {
        			setButton(4);
        		}  		
        		
        	}     	
        	
        }
        
        private class TimerAction implements ActionListener{
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		repaint();
        	}
        	
        	
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        private class MouseClick implements MouseListener {
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
