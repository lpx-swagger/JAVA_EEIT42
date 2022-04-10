package myClass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.DebugGraphics;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class MyDrawer extends JPanel{  // MyDrawer 的物件實體 is-a JPanel
	//private LinkedList<HashMap<String, Integer>> line ;  // 板上只出現一條線，LinkedList<點> => 有順序的「點」
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycleBin; // 多條線，點：LinkedList<HashMap<String, Integer>>
	private Color defaultColor;
	
	
	public MyDrawer() {
		setBackground(Color.WHITE);
		
		MyListener mylistener = new MyListener();
		addMouseListener(mylistener); // => mouse click, release
		addMouseMotionListener(mylistener);
		
		lines = new LinkedList<>(); // 初始化，平常用不到，需要用再拿出來
		lines.size();
		recycleBin = new LinkedList<>();
		
		defaultColor = Color.BLACK;
	}
	
	
	@Override // 沒有要使用 paintComponent 只是要把這個方法帶到而已。
	protected void paintComponent(Graphics g) { /* 如何做「渲染」 => 只要 repaint()後，這個方法會重新呼叫處理這
	整段 paintComponent()。 => 程式時間生命週期 => 走到某時間點(老年人) 就會被呼叫 或 手機home鍵 
		=> 此程式是Framework觸發來的，不是自己寫的 => 查 Graphics g 的g 是什麼型別？如果是Graphics2D	就可以
			強制轉型回原型，用更多的功能出來實現更多的動作 */
		super.paintComponent(g);  // => 爸爸的方法先做一做
		
//		// 如何用 instanof 找出 g 是 Graphics2D?
//		if(g instanceof DebugGraphics) System.out.println("Debug1");
//		if(g instanceof Graphics2D) System.out.println("Debug2");
		Graphics2D g2d = (Graphics2D) g;
		
//		g2d.setColor(defaultColor);
//		g2d.drawLine(0, 0, 200, 500);
		g2d.setStroke(new BasicStroke(4));
		
//		// 畫所有在lines中的每一個 	line
//		for(LinkedList<HashMap<String, Integer>> ll : lines) { // => 若有#5點，可以畫4條線
//			// 畫一條line
//			for(int i = 1; i < ll.size(); i++) { // 0->1 => 算1; 1->2 => 算2; 2->3 => 算3; 3->4 => 算4，前一點到當前點，所以從 1 開始巡防
//				HashMap<String, Integer> p1 = ll.get(i-1); // 2點1線
//				HashMap<String, Integer> p2 = ll.get(i);
//				g2d.drawLine(p1.get("x"), p1.get("y"), p2.get("x"), p2.get("y"));
//			}
//		}
		
		
		// 畫所有在lines中的每一個 	line
		for(LinkedList<HashMap<String, Integer>> ll : lines) { // => 若有#5點，可以畫4條線

			// 每一條線的第一點都帶有顏色資訊，畫第一條之前先設定顏色
			g2d.setColor( new Color(ll.get(0).get("color")	) );

			// 畫一條line
			for(int i = 1; i < ll.size(); i++) { // 0->1 => 算1; 1->2 => 算2; 2->3 => 算3; 3->4 => 算4，前一點到當前點，所以從 1 開始巡防
				HashMap<String, Integer> p1 = ll.get(i-1); // 2點1線
				HashMap<String, Integer> p2 = ll.get(i);
				g2d.drawLine(p1.get("x"), p1.get("y"), p2.get("x"), p2.get("y"));
			}
		}
	}
	
	
	private class MyListener extends MouseAdapter { // MouseAdapter 為了整合
		
		@Override
		public void mousePressed(MouseEvent e) { /* 內部類別，這裡的存取修飾字(private)也可以是protected, public 等等，
		一般類別(無內部類別)使用public class 或 class */
			//super.mousePressed(e); => 為了串接parents而已，本身無作用
			//System.out.println("Press: " + e.getX() + e.getY());
			//HashMap<String, Integer> => Key: 在這段收集資料，因為滑鼠一點到，資料就有了，「點」收集來的資料
			HashMap<String, Integer> point = new HashMap<String, Integer>(); // 用收集來的「點」進行繪製
			point.put("x", e.getX()); point.put("y", e.getY());
			
			point.put("color", defaultColor.getRGB());
			
			// 抓了一點也同時創立一條新線 => 新線新點
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
			line.add(point);
			
			lines.add(line);
			//repaint(); => 一個點沒什麼好畫的，可以省略 => 幾何裡面的一點是看不到的
			
			recycleBin.clear(); // => 若要開始畫新的一筆，垃圾桶的東西要先全部倒掉
		}
		
		
		@Override
		public void mouseDragged(MouseEvent e) {
			//super.mouseDragged(e);
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", e.getX()); point.put("y", e.getY());
			
			
			// 滑動時，收集到的新點(point)要放在lines中，最後的那一條線
			lines.getLast().add(point);
			repaint();  // 我一提起筆 就要換下一筆畫，所以要重畫
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
			lines.add(recycleBin.removeLast());  // recycleBin => lines的最後一條丟回去
			repaint();
		}  
	}
	
	public void saveLines(File saveFile) throws Exception{  //拋出例外,不寫try-catch
		ObjectOutputStream oout = 
				new ObjectOutputStream(
						new FileOutputStream(saveFile));
		oout.writeObject(lines); // 序列化
		oout.flush();
		oout.close();
	}
	
	public void loadLines(File loadFile) throws Exception {  //拋出例外
		ObjectInputStream oin = 
				new ObjectInputStream(
						new FileInputStream(loadFile));
		Object obj = oin.readObject(); // 解序列化
		oin.close();
		
		lines = (LinkedList<LinkedList<HashMap<String, Integer>>>)obj;
		repaint();
		
	}
	
	public Color getDefaultColor() {
		return defaultColor;
	}
	
	public void setDefaultColor(Color c) {
		defaultColor = c;
	}
	
}
