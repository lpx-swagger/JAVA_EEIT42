package MyClass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private Color defaultColor;
	private LinkedList<HashMap<String, Integer>> line;
	
	
	public MyPanel() {
		setBackground(Color.WHITE);
		MyListener mylistener = new MyListener();
		addKeyListener(mylistener);
		defaultColor = Color.BLACK;
	}
	
	/* TODO 
	 * 
	 * 蛇身0.5secs 自動 動一格 */
	
	private class MyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO if..else if...else if
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("OK");
		Graphics2D g2d = (Graphics2D) g;
		
		int point1 = (int)(java.lang.Math.random()*600+1);
		int point2 = (int)(java.lang.Math.random()*600+1);
		if((point1 < 285 && point1 > 300) || point2 != 300) {  // 避免與蛇頭重疊
			g2d.drawOval(point1, point2, 5, 5);
			g2d.fillOval(point1, point2, 5, 5);
		}
		
		// TODO 蛇身共5+5+5 = 15，一點長寬是5，loc(285~300, 300)
		
		
	}
	
}
