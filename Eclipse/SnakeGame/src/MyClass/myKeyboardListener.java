package MyClass;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class myKeyboardListener extends KeyAdapter {
	private boolean leftDir = false;
	private boolean rightDir = true;
	private boolean upDir = false;
	private boolean downDir = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if((key == KeyEvent.VK_LEFT) && (!rightDir)) {
			leftDir = true;
			upDir = false;
			downDir = false;
			
		}
		
		if((key == KeyEvent.VK_UP) && (!downDir)) {
			upDir = true;
			leftDir = false;
			rightDir = false;
			//System.out.println(e.getModifiersEx());
			//System.out.println("OK");
		}
		
		if((key == KeyEvent.VK_DOWN) && (!upDir)) {
			downDir = true;
			leftDir = false;
			rightDir = false;
			System.out.println(e.getModifiersEx());
		}
		
		if((key == KeyEvent.VK_LEFT) && (!rightDir)) {
			leftDir = true;
			upDir = false;
			downDir = false;
			System.out.println(e.getModifiersEx());
		}
		
		
	}
}


