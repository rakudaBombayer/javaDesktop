package desktop4;

import javax.swing.JFrame;



public class SimpleDraw extends JFrame {

    public static void main(String[] args) {
        new SimpleDraw();
    }

    SimpleDraw() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 修正済み
        getContentPane().add(new MyPanel());
        setSize(600, 400); // サイズ変更
        setVisible(true);
    }
}
