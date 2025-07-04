package desktop2;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanellLayoutExample extends JFrame { // 修正: クラス名を一致させる

    public static void main(String[] args) {
        new PanellLayoutExample(); // 修正: クラス名を正しく呼び出す
    }

    PanellLayoutExample() { // 修正: コンストラクタ名をクラス名と一致させる
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new GridLayout(2, 2));

        getContentPane().add(new JButton("1 January"));
        getContentPane().add(new JButton("2 February"));
        getContentPane().add(new JButton("3 March"));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JButton("4 April"));
        panel.add(new JButton("5 May"));
        panel.add(new JButton("6 June"));
        
//        getContentPane().add(panel);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 2));
        panel2.add(new JButton("4 April"));
        panel2.add(new JButton("5 May"));
        panel2.add(new JButton("6 June"));
        panel.add(panel2);
        
        getContentPane().add(panel);
        
        setSize(300, 200);
        setVisible(true);
    }
}
