package myClass;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// TODO
public class Racing extends JFrame {
	private JButton goButton;
	private JLabel[] lanes = new JLabel[8];
	private int rank;
	
	public Racing() {
		layoutView();
		
		
	} 
	
	// lane, car 分開工作，讓lane 固定在畫面
	
	public void layoutView() {
		setLayout(new GridLayout(9, 1));
		
		goButton = new JButton("Go!");
		add(goButton);
		
		// 顯示跑道在畫面上
		for(int i = 0; i < lanes.length; i++) {
			lanes[i] = new JLabel((i+1) + ". ");
			add(lanes[i]);
		}
		
		setSize(1024, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	private class Car extends Thread { // 執行序 => 跑完這個跑道
		private int lane; // 你跑在第幾跑道 => 屬性field
		private StringBuffer sb;
		Car(int lane) {
			this.lane = lane;
			sb = new StringBuffer(" " + (lane + 1) + ". ");
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				/* StringBuff, JLable 無append，可以這樣做append
				   lanes[lane].setText(lanes[lane].getText() + ">");  */
				if(i == 99) {
					sb.append("> " + rank++);
				} else {
					sb.append(">");
				}
				
				lanes[lane].setText(sb.toString());
				try {
					Thread.sleep(100);  // 0.1sec
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
	}

}
