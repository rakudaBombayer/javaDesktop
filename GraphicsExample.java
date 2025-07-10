package desktop4;

import javax.swing.JFrame;

public class GraphicsExample extends JFrame {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new GraphicsExample();
	}
	
	GraphicsExample() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new MyPanel());
		
		setSize(500, 500);
		setVisible(true);
		
	}
	
	
	
	
}
