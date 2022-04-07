package Generator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.imageio.plugins.bmp.BMPImageWriteParam;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import MyClass.MyPanel;
import MyClass.myDigitalClock;
import MyClass.myKeyboardListener;


public class myMotion extends JFrame {
	public final int B_WIDTH = 840;
    public final int B_HEIGHT = 840;
	private JButton newGame;
	private MyPanel mp;
	private myDigitalClock mdc;
	
	
	public myMotion() {
		super("My Greedy Snake Game");
		newGame = new JButton("New Game");
		
		myKeyboardListener mkl = new myKeyboardListener();
		this.addKeyListener(mkl);
		
		mp = new MyPanel();
		mdc = new myDigitalClock();
		
		layoutView();
		setEvent();
	}

	public void layoutView() {
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		add(top, BorderLayout.NORTH);
		
		top.add(newGame); top.add(mdc); add(mp);
		add(mp, BorderLayout.CENTER);
		
		setResizable(false);
		//pack();
		
		setSize(B_WIDTH, B_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setEvent() {
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewGame();
				
			}
		});
	}

	
	private void NewGame() {
		mp.newGame();
		
	}
	
	public static void main(String[] args) {
		new myMotion();
	}
}
