package desktop4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuExample extends JFrame implements ActionListener{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new MenuExample();
	}
	
	JMenuBar menuBar = new JMenuBar();
	JMenu menuFile = new JMenu("ファイル");
	JMenuItem menuOpen = new JMenuItem("開く");
	
	JMenuItem menuExit = new JMenuItem("終了");
	
	
	MenuExample() {
		menuFile.add(menuOpen);
		menuFile.add(menuExit);
		menuBar.add(menuFile);
		
		setJMenuBar(menuBar);
		
		menuOpen.addActionListener(this);
		menuExit.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuOpen) {
			System.out.println("開くが選択されました。");
		} else if(e.getSource() == menuExit) {
			System.out.println(0);
		}
	}
	
	
}
