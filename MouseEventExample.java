package desktop4;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventExample extends JFrame {

    public MouseEventExample() {
        // JFrameの設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new MyPanel());
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventExample();
    }

    // 内部クラスとしてJPanelを定義し、リスナーを実装
    class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
        MyPanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("マウスがクリックされました: (" + e.getX() + ", " + e.getY() + ")");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("マウスがパネルに入りました。");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("マウスがパネルから出ました。");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("マウスのボタンが押されました。");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("マウスのボタンが離されました。");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println("マウスがドラッグされました: (" + e.getX() + ", " + e.getY() + ")");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            System.out.println("マウスが移動しました: (" + e.getX() + ", " + e.getY() + ")");
        }
    }
}
