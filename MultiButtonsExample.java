package desktop3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiButtonsExample extends JFrame implements ActionListener {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new MultiButtonsExample();
	}
	
	
	JButton button1;
	JButton button2;
	
	
	MultiButtonsExample() {
		button1 = new JButton("ボタン1");
		button1.addActionListener(this);
		
		getContentPane().add(BorderLayout.WEST, button1);
		
		
		button2 = new JButton("ボタン2");
		button2.addActionListener(this);
		getContentPane().add(BorderLayout.EAST, button2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == button1) {
			System.out.println("ボタン１が押されました。");
		}else if((ae.getSource() == button2)){
			System.out.println("ボタン2が押されました。");
		}	
		
	}
	
	
	
	
	
	
	
	
}
