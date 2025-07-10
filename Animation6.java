package desktop5;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation6 extends JFrame {
    int width = 800, height = 400;

    public static void main(String[] args) {
        new Animation6();
    }

    private Animation6() {
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

        JButton stop, up, down, left, right, attack;
        int move = 0;
        int speed = 20;
        Timer timer;

        List<Bullet> bullets = new ArrayList<>(); // 弾丸を管理するリスト

        public MyPanel() {
            // 画像の読み込み
            image = new ImageIcon("helicopter.png").getImage();
            imWidth = image.getWidth(this);
            imHeight = image.getHeight(this);

            x = width / 2 - imWidth / 2;
            y = height / 2 - imHeight / 2;

            setLayout(null);

            // ボタンの設定
            stop = new JButton("■");
            stop.setBounds(30, 30, 30, 30);
            stop.addActionListener(new ButtonAction());

            up = new JButton("⋀");
            up.setBounds(30, 0, 30, 30);
            up.addActionListener(new ButtonAction());

            down = new JButton("↓");
            down.setBounds(30, 60, 30, 30);
            down.addActionListener(new ButtonAction());

            left = new JButton("←");
            left.setBounds(0, 30, 30, 30);
            left.addActionListener(new ButtonAction());

            right = new JButton("→");
            right.setBounds(60, 30, 30, 30);
            right.addActionListener(new ButtonAction());

            attack = new JButton("攻撃");
            attack.setBounds(100, 30, 60, 30);
            attack.addActionListener(new AttackAction());

            add(stop);
            add(up);
            add(down);
            add(left);
            add(right);
            add(attack);

            timer = new Timer(100, new TimerAction());
            setButton(0);
        }

        @Override
        protected void paintComponent(Graphics g) {
            // 画像の移動ロジック
            switch (move) {
                case 1: // 上
                    y -= speed;
                    if (y < -imHeight) y = height;
                    break;
                case 2: // 下
                    y += speed;
                    if (y > height) y = -imHeight;
                    break;
                case 3: // 左
                    x -= speed;
                    if (x < -imWidth) x = width;
                    break;
                case 4: // 右
                    x += speed;
                    if (x > width) x = -imWidth;
                    break;
            }

            super.paintComponent(g);
            g.drawImage(image, x, y, this);

            // 弾丸を描画＆位置を更新
            Iterator<Bullet> iterator = bullets.iterator();
            while (iterator.hasNext()) {
                Bullet bullet = iterator.next();
                bullet.move(); // 弾丸の位置を更新
                g.fillOval(bullet.getX(), bullet.getY(), 10, 10);

                // 画面外に出た弾丸を削除
                if (bullet.getX() > width || bullet.getY() < 0 || bullet.getY() > height) {
                    iterator.remove();
                }
            }
        }

        private void setButton(int move) {
            this.move = move;
            if (move == 0) {
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

        private class ButtonAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(stop)) {
                    setButton(0);
                }
                if (e.getSource().equals(up)) {
                    setButton(1);
                }
                if (e.getSource().equals(down)) {
                    setButton(2);
                }
                if (e.getSource().equals(left)) {
                    setButton(3);
                }
                if (e.getSource().equals(right)) {
                    setButton(4);
                }
            }
        }

        private class AttackAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 新しい弾丸を生成してリストに追加
                bullets.add(new Bullet(x + imWidth / 2, y + imHeight / 2));
                repaint();
            }
        }

        private class TimerAction implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }

        // 弾丸クラス
        private class Bullet {
            private int x, y;
            private int speed = 10;

            public Bullet(int startX, int startY) {
                this.x = startX;
                this.y = startY;
            }

            public void move() {
                x += speed; // 弾丸を右方向に移動
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }
        }
    }
}
