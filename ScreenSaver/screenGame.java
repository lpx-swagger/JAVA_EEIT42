
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class screenGame extends JFrame{
		JLabel lab;
		//取得整個螢幕的長、寬
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//可點擊的次數 (歸0程式結束)
		int lifecount = 7;
		//圖片初始移動速度
		int speed = 1;
		//圖片
		Icon pic;
		//字形
		String text;
		
		//造圖片視窗
		public screenGame() {
			JPanel panel1 = new JPanel();
			
			//圖片導入
			pic = new ImageIcon("dir1/min.gif");
			//加載存放
			lab = new JLabel(text,pic,JLabel.CENTER);
			lab.setFont(new Font(null, Font.BOLD, 55));//剩餘次數大小
			lab.setHorizontalTextPosition(JLabel.CENTER);
			
			
			//滑鼠點擊的事件
			lab.addMouseListener(new MListener());
			
			panel1.add(lab);
			add(panel1);
			setSize(pic.getIconWidth(),pic.getIconHeight());
			setUndecorated(true);
			setVisible(true);
			try {
				run();
			} catch (Exception e) {
				
			}
		}
		
		//滑鼠點擊後
		public class MListener extends MouseAdapter {
			public void mousePressed(MouseEvent e) {
				//點擊後顯示 次數
				lab.setText("剩"+ lifecount-- + "次");
				speed +=1;
				System.out.println(speed);
			}
		}
		
		//圖片移動的軌跡
		public void run(){
			int y = 10;
			int x = 10;
			boolean yb = false;
			boolean xb = false;
			
			while(lifecount >= 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				setLocation(x,y);
				
				if(y >= dim.getHeight() - 100) {
					yb = true;
				}else if (y <= -100) {
					yb = false;
				}
				
				if(x >= dim.getWidth() - 100) {
					xb = true;
				}else if (x <= -100) {
					xb = false;
				}
				
				if (yb) {
					y -= speed;
				} else {
					y += speed;
				}
				
				if (xb) {
					x -= speed;
				}else {
					x += speed;
				}
			}
			
				//爆炸效果圖片載入
				lab.setText(" ");
				lab.setIcon(new ImageIcon("dir1/explosion.gif"));
				
				try {
					Thread.sleep(1900);
				} catch (Exception e) {
				}
				
				//爆炸後程式結束
				System.exit(0);
		}
	public static void main(String[] args) {
		new screenGame();
	}
}
