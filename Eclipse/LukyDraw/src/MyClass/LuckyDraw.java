package MyClass;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Generator.MainChloe;


public class LuckyDraw extends JFrame {
	
	private JButton b1;
	private JTextField x1, x2, x3, x4, x5, x6;
	private JTextArea log;
	private JLabel result;
	
	public LuckyDraw() {
		super("My Lucky Drawing");
		x1 = new JTextField(3);
		x2 = new JTextField(3);
		x3 = new JTextField(3);
		x4 = new JTextField(3);
		x5 = new JTextField(3);
		x6 = new JTextField(3);
		b1 = new JButton("Enter");
		result = new JLabel("");
		
		//setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		setLayout(new FlowLayout());
		add(x1); add(x2); add(x3); 
		add(x4); add(x5); add(x6); add(b1); add(result);
		log = new JTextArea();
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("OK");
				getValue();
				
			}});
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void getValue() {
		int gx1 = Integer.parseInt(x1.getText());
		int gx2 = Integer.parseInt(x2.getText());
		int gx3 = Integer.parseInt(x3.getText());
		int gx4 = Integer.parseInt(x4.getText());
		int gx5 = Integer.parseInt(x5.getText());
		int gx6 = Integer.parseInt(x6.getText());
		
		//result.setText("" + );
	}
	
	
	public static void main(String[] args) {
		new LuckyDraw();
	}
}
