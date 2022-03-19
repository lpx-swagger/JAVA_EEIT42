package myClass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;
//TODO
public class MyDrawer extends JPanel{
	//private LinkedList<HashMap<String, Integer>> line ;  // 一條線，LinkedList<點> => 有順序的「點」
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycleBin; // 多條線，點：LinkedList<HashMap<String, Integer>>
	
	
	public MyDrawer() {
		setBackground(Color.yellow);
		MyListener mylistener = new MyListener();
		addMouseListener(mylistener);
		addMouseMotionListener(mylistener);
		lines = new LinkedList<>(); // 平常用不到，需要用再拿出來
		recycleBin = new LinkedList<>();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) { /* 如何做「渲染」 => 這個方法重新呼叫；
	程式時間生命週期 => 走到某時間點(老年人) 就會被呼叫 或 手機home鍵 => 此程式是Framwork觸發來的，不是自己寫的 */
		super.paintComponent(g);
		System.out.println("OK"); // 未改寫，只是呼叫
		// TODO 如何用 instanof 找出 g 是 Graphics2D?
		Graphics2D g2d = (Graphics2D) g;
		
		
		// 畫出線條
		g2d.setColor(Color.DARK_GRAY);
		g2d.setStroke(new BasicStroke(4));
		
		for(LinkedList<HashMap<String, Integer>> ll : lines) {
			for(int i = 1; i < ll.size(); i++) { // 從 1 開始巡防
				HashMap<String, Integer> p1 = ll.get(i-1); // 2點1線
				HashMap<String, Integer> p2 = ll.get(i);
				g2d.drawLine(p1.get("x"), p1.get("y"), p2.get("x"), p2.get("y"));
				//g2d.drawLine(0, 0, 120, 120);
			}
		}
		
	}
	
	
	private class MyListener extends MouseAdapter { // MouseAdapter 為了整合
		@Override
		public void mousePressed(MouseEvent e) { /*TODO 內部類別，這裡的存取修飾字(private)也可以是protected, public 等等，
		一般類別(無內部類別)使用public class 或 class*/
			//super.mousePressed(e); => 為了串接parents而已，本身無作用
			//System.out.println("Press: " + e.getX() + e.getY());
			//HashMap<String, Integer> => Key: 「點」收集來的資料
			HashMap<String, Integer> point = new HashMap<String, Integer>(); // 用收集來的「點」進行繪製
			point.put("x", e.getX()); 
			point.put("y", e.getY());
			
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();// 新線新點
			line.add(point);
			
			lines.add(line);
			repaint();
			
		}
		
		
		// 其實寫 mouseDragged 就夠用了，但是如果只選mouseDragged, 下筆下去的點會無法顯示
		
		
		@Override
		public void mouseDragged(MouseEvent e) {
			//super.mouseDragged(e);
			//System.out.println("Drag: " + e.getX() + e.getY());
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			
		}
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if(lines.size() > 0) {
			//lines.removeLast();
			recycleBin.add(lines.removeLast());  // 你丟我撿起
			repaint();
		}
	}
	
	public void redo() {
		//chloe// recycleBin.add(lines.getLast());
		if(lines.size() > 0) {
			recycleBin.add(lines.removeLast());
			repaint();
		} // recycleBin 最後一條拿回去
	}
	
	public void saveFile(File s) throws Exception{  //拋出例外,不寫try-catch
		ObjectOutputStream oout = 
				new ObjectOutputStream(
						new FileOutputStream(s));
		oout.write();
		oout.flush();
		oout.close();
		
	}
	
	public void loadLines(File lf) throws Exception {  //拋出例外
		ObjectInputStream oin = 
				new ObjectInputStream(
						new FileInputStream(lf)); 
	}
	
	
}
