package myClass;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * When the 1st horse arrived, stop the game. Marked it as the WINNER! */

public class RacingV2 extends JFrame {
	private JButton goButton;
	private JLabel[] lanes = new JLabel[8];
	private Car[] cars = new Car[8]; 

	
	public RacingV2() {
		super("PEI-XUAN LU's Horse Racing V2");
		layoutView();
		
	} 
	
	// lane, car 分開工作，讓lane 固定在畫面

	public void layoutView() {
		setLayout(new GridLayout(9, 1));
		
		goButton = new JButton("Go!");
		add(goButton);
		
		goButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
		
		
		// 顯示跑道在畫面上
		for(int i = 0; i < lanes.length; i++) {
			lanes[i] = new JLabel(" Horse " + (i+1) + ". ");
			add(lanes[i]);
		}
		
		setSize(1122, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private void go() {
		for(int i = 0; i < 8; i++) {
			cars[i] = new Car(i);
			cars[i].start();
			
		}
	}
	
	private class Car extends Thread { // 執行序 => 跑完這個跑道
		private int lane; // 你跑在第幾跑道 => field
		private StringBuffer sb;
		
		Car(int lane) {
			this.lane = lane;
			sb = new StringBuffer(" Horse " + (lane + 1) + ". ");
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				/* StringBuff, JLable 無append，可以這樣做append
				   lanes[lane].setText(lanes[lane].getText() + ">");  */
				if(i == 99) {
					sb.append("> WINNER" );
				} else {
					sb.append(">");
				}
				lanes[lane].setText(sb.toString());
				if(i==99) stopGame();
				
				try {
					Thread.sleep(10 + (int)(Math.random()*200));
				} catch (InterruptedException e) {
					break;
				} 
			}
		}
		
	}
	
	// 第一名到達後，通知其他人停止跑，自己也不跑了
	private void stopGame() {
		for(int i = 0; i < 8; i++) {
			cars[i].interrupt();;
		}
	}
	
	public static void main(String[] args) {
		new RacingV2();
	}

}
