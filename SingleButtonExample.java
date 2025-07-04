package desktop3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SingleButtonExample extends JFrame implements ActionListener {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		new SingleButtonExample();
	}
	
	
	SingleButtonExample() {
		JButton button = new JButton("ボタン");
		button.addActionListener(this);
		
		getContentPane().add(button);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(button);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		System.out.println("ボタンが押されました");
	}
	
	
	
	
}
