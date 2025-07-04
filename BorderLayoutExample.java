package desktop2;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExample extends JFrame { // JFrame を継承

    public static void main(String[] args) {
        new BorderLayoutExample(); // インスタンスを生成
    }

    BorderLayoutExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // フレームの閉じる動作
        setLayout(new BorderLayout()); // レイアウトマネージャの設定

        // ボタンを各位置に追加
        getContentPane().add(BorderLayout.CENTER, new JButton("CENTER"));
        getContentPane().add(BorderLayout.SOUTH, new JButton("SOUTH")); // 修正: South -> SOUTH
        getContentPane().add(BorderLayout.WEST, new JButton("WEST"));
        getContentPane().add(BorderLayout.EAST, new JButton("EAST"));
        getContentPane().add(BorderLayout.NORTH, new JButton("NORTH"));

        setSize(300, 200); // 修正: setSIze -> setSize
        setVisible(true); // フレームを表示
    }
}
