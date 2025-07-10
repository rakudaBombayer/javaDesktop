package desktop4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBoxExample extends JFrame implements ActionListener {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		new ComboBoxExample();
	}
	
	JComboBox<String> comboBox = new JComboBox<String>();
	
	
	ComboBoxExample() {
		
		JButton button = new JButton("OK");
		button.addActionListener(this);
		
		getContentPane().setLayout(new FlowLayout());
		
		comboBox.addItem("選択肢1");
		comboBox.addItem("選択肢2");
		comboBox.addItem("選択肢3");
		
		getContentPane().add(comboBox);
		getContentPane().add(button);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 80);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(comboBox.getSelectedItem() + ""
				+ "が選択されています。");
	}
	
	
	
	
	
}
