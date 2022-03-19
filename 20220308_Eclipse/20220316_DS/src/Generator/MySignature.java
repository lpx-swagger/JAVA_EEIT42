package Generator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import myClass.MyDrawer;

public class MySignature extends JFrame implements ActionListener{
	private JButton clear, redo, undo;
	private MyDrawer md;
	
	public MySignature() {
		super("Painter Programming");
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		//sign = new;
		
		clear = new JButton("Clear");
		redo = new JButton("Redo");
		undo = new JButton("Undo");
		top.add(clear);	top.add(redo); top.add(undo);
		
		add(top, BorderLayout.NORTH);
		md = new MyDrawer();
		add(md, BorderLayout.CENTER);
		
		
		setSize(640, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setListener();
	}
	
	public void setListener() {
		clear.addActionListener(this);
		redo.addActionListener(this);
		undo.addActionListener(this);
	} 
	
	
	public static void main(String[] args) {
		new MySignature();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Method1: 3個人都叫你聽，如何區分？
		   System.out.println(e.getActionCommand());
		   全部誰聽？ 我本人( setListener() )聽 */ 
		
	}
}
