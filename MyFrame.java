package desktop2;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new MyFrame();
	}
	
	
	MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new JButton("ボタン"));
		setSize(300, 200);
		setVisible(true);
		
	}
	
	
	
	
}
