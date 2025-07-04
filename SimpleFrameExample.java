package desktop;

import javax.swing.JFrame;

public class SimpleFrameExample {

    public static void main(String[] args) {
        // フレームを作成
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 修正箇所
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}

