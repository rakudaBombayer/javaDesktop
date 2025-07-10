package desktop4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

    public MyPanel() {
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.WHITE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(new Color(
                (int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256)));
        g.fillRect(e.getX(), e.getY(), 10, 10); // 修正
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(e.getX() - 2, e.getY() - 2, 5, 5); // 修正
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // 修正済み
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // 修正済み
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 修正済み
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // 修正済み
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // 修正済み
    }
}