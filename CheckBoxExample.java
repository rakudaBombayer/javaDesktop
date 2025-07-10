package desktop4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxExample extends JFrame implements ActionListener{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		new CheckBoxExample();
		
	}
	
	
	JCheckBox checkBox;
	
	CheckBoxExample(){
		getContentPane().setLayout(new FlowLayout());
		JButton button = new JButton("OK");
		
		button.addActionListener(this);
		checkBox = new JCheckBox("チェックボックス");
		
		
		getContentPane().add(checkBox);
		getContentPane().add(button);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 80);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (checkBox.isSelected()) {
			System.out.println("チェックボックスはONです。");
		}else {
			System.out.println("チェックボックスはOFFです。");
		}
		
		
	}
	
	
	
	

}
