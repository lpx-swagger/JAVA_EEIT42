package Generator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import MyClass.MyPanel;
import MyClass.myDigitalClock;

public class MyKeyBoard extends JFrame{
	private JButton newGame;
	private MyPanel mp;
	private myDigitalClock mdc;
	
	public MyKeyBoard() {
		super("My Greedy Snake Game");
		newGame = new JButton("New Game");
		mp = new MyPanel();
		mdc = new myDigitalClock();
		
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		// 版面配置
		layoutView();
		
		setEvent();
	}
	

	public void layoutView() {
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		add(top, BorderLayout.NORTH);
		
		top.add(newGame);
		add(mp, BorderLayout.CENTER);
	}
	
	
	public void setEvent() {
		
	}
	
	public static void main(String[] args) {
		new MyKeyBoard();

	}
}
