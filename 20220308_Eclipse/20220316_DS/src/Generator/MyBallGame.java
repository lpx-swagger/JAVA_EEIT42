package Generator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyBallGame extends JFrame{
	public MyBallGame() {
		layoutView();
	}
	
	public void layoutView() {
		setLayout(new BorderLayout());
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public class MyPanel extends JPanel {
		
		// 全部的人都擁有的
		private Timer timer;
		private BufferedImage ballImg;
//		private int ballX, ballY, viewW, viewH;  
		private int ballW, ballH;
		
		
		public MyPanel() {
			setBackground(Color.YELLOW);
			
			// TODO 如何知道是BufferedImage? => read() => 老師經驗也知道g2d那邊也是要用BufferedImage,所以在這裡先叫出來
			try {
				ImageIO.read(new File("dir1/pokemonGo.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			dx = dy = 4;  // 單位時間移動距離 => 速度
			timer = new Timer();
//			timer.schedule(new BallTask(), 1*1000, 30);  // 從 1sec 出發，0.03ps
		}
		
		
		private void createBall(int clickX, int clickY) {
			(int)Math.random()*9-4  // 取random 0～8 - 4 => 讓速度keep在接近4
		}
		
		
		
		private class BallTask extends TimerTask {
			
			// Ball 該有的field，不是全部人該擁有的
			private int ballX, ballY, dx, dy;
			
			
			
			@Override
			public void run() {
				// 此方法只適合"一顆"球，不精確
//				if(ballX < 0 || ballX + ballImg.getWidth() > viewW) {
				if(ballX < 0 || ballX + ballImg.getWidth() > viewW) {
					dx *= -1;  // 負*負 = 正
				}
				if(ballY < 0 || ballY + ballImg.getHeight() > viewH) {
					dy *= -1;
				}
				ballX += dx;
				ballY += dy;
				
				repaint();
			}
		}
		
		
		private class RefreshTask extends TimerTask {

			@Override
			public void run() {
				
			}
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			viewW = getWidth(); viewH = getHeight();
			Graphics2D g2d = (Graphics2D)g;  // 不轉型也沒關係
			
		}
	} 
	
	
	public static void main(String[] args) {
		new MyBallGame();
	}

}
