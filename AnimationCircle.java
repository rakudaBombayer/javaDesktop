package desktop5;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationCircle extends JFrame {

    public static void main(String[] args) {
        new AnimationCircle();
    }

    private AnimationCircle() {
        super("円軌道を描く画像");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new MyPanel());
        setSize(800, 600);
        setVisible(true);
    }

    private class MyPanel extends JPanel {
        Image image;
        int centerX, centerY, radius;
        double angle; // 現在の角度（ラジアン）
        Timer timer;

        private MyPanel() {
            image = new ImageIcon("helicopter.png").getImage();
            centerX = 300; // 円の中心X座標
            centerY = 400; // 円の中心Y座標
            radius = 100;  // 円の半径
            angle = 0;     // 初期角度

            // タイマーの設定
            timer = new Timer(30, new ActionListener() { // 30msごとに更新
                @Override
                public void actionPerformed(ActionEvent e) {
                    angle += 0.05; // 角度を少しずつ増加
                    repaint();     // 再描画
                }
            });
            timer.start(); // タイマー開始
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 円軌道上の座標を計算
            int x = centerX + (int) (radius * Math.cos(angle));
            int y = centerY + (int) (radius * Math.sin(angle));

            // 画像を描画
            g.drawImage(image, x - image.getWidth(this) / 2, y - image.getHeight(this) / 2, this);
        }
    }
}
