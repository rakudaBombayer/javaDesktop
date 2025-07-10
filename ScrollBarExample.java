package desktop4;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class ScrollBarExample extends JFrame implements AdjustmentListener {

	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new ScrollBarExample();
	}
	JTextField textField = new JTextField(20);
	JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 50, 5, 0, 105);
	JLabel label = new JLabel("50", JLabel.CENTER);
	
	
	ScrollBarExample() {
		scrollBar.addAdjustmentListener(this);
		getContentPane().add(BorderLayout.NORTH, scrollBar);
		getContentPane().add(BorderLayout.CENTER, label);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(200, 80);
		setVisible(true);
		
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		label.setText("" + scrollBar.getValue());
		
	}
	
}
