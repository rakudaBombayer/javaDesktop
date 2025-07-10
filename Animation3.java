package desktop5;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation3 extends JFrame {

    public static void main(String[] args) {
        new Animation3();
    }

    private Animation3() {
        super("画像を動作");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(new MyPanel());
        setSize(800, 400);
        setVisible(true);
    }

    private class MyPanel extends JPanel {
        Image image;
        int x = 100;
        int y = 200;
        Timer timer;

        private MyPanel() {
            image = new ImageIcon("helicopter.png").getImage();
            addMouseListener(new MouseClick());

            // タイマーを設定
            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    x += 5; // x座標を増加
                    y -= 0; // y座標を減少
                    repaint(); // 再描画
                }
            });
            timer.start(); // タイマーを開始
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, x, y, this); // 画像を描画
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
