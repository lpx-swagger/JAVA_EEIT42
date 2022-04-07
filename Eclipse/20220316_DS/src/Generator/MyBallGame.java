package Generator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyBallGame extends JFrame{
	private MyPanel myPanel;
	
	public MyBallGame() {
		layoutView();
	}
	
	public void layoutView() {
		setLayout(new BorderLayout());
		
		myPanel = new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public class MyPanel extends JPanel {
		private Timer timer;
		private BufferedImage ballImg;
//		private int ballX, ballY, viewW, viewH;  
		private int viewW, viewH, ballW, ballH;
		private LinkedList<BallTask> balls;
		
		
		public MyPanel() {
			setBackground(Color.YELLOW);
			
			// TODO 如何知道是BufferedImage? => read() 
				// => 老師經驗也知道g2d那邊也是要用BufferedImage, 所以在這裡先叫出來
			try {
//				ImageIO.read(new File("dir1/ball.png"));
				ballImg = ImageIO.read(new File("dir1/ball.png"));
				ballW = ballImg.getWidth();
				ballH = ballImg.getHeight();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			addMouseListener(new MouseAdapter() {
				@Override 
				public void mousePressed(MouseEvent e) {
					createBall(e.getX(), e.getY());
				}
			});
			
			balls = new LinkedList<>();
			
//			TODO 此方法只適合"一顆"球，不精確
//			dx = dy = 4;  // 單位時間移動距離 => 速度
//			timer = new Timer();
//			timer.schedule(new BallTask(), 1*1000, 30);  // 從 1sec 出發，0.03ps
			
			timer = new Timer();
			timer.schedule(new RefreshTask(), 0, 30);
		}
		
		
		private void createBall(int clickX, int clickY) {
			BallTask bt = new BallTask(clickX, clickY,
					(int)Math.random()*9-4, (int)Math.random()*9-4);  // 取random 0～8 - 4 => 讓速度keep在接近4
			balls.add(bt);
			timer.schedule(bt, 1*1000, 20);  // TODO why bt not RefreshTask()?
		}
		
		
		
		private class BallTask extends TimerTask {
			// Ball field，不是全部人都該擁有的
			private int ballX, ballY, dx, dy;
			BallTask(int ballX, int ballY, int dx, int dy) {
				this.ballX = ballX - ballW/2;  // finetune
				this.ballY = ballY - ballH/2;
				this.dx = dx;
				this.dy = dy;
			}
			
			@Override
			public void run() {
//				TODO 此方法只適合"一顆"球，不精確 => 所以 repaint() 另外寫，球他動他的，不要一直叫別人看
//				if(ballX < 0 || ballX + ballImg.getWidth() > viewW) {
//					dx *= -1;
//				}
//			
//				if(ballY < 0 || ballY + ballImg.getHeight() > viewH) {
//					dy *= -1;
//				}
//				
//				ballX += dx;
//				ballY += dy;
//				repaint();
				
				// speed
				if(ballX < 0 || ballX + ballImg.getWidth() > viewW) {
					dx *= -1;  // 負*負 = 正
				}
				
				if(ballY < 0 || ballY + ballImg.getHeight() > viewH) {
					dy *= -1;
				}
				
				ballX += dx;
				ballY += dy;
			}
		}
		
		
		private class RefreshTask extends TimerTask {
			@Override
			public void run() {
				repaint();
			}
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			viewW = getWidth(); viewH = getHeight();
			Graphics2D g2d = (Graphics2D)g;  // 不轉型(直接Graphics)也沒關係, 看你想怎麼運用，不管是 g 或 g2d 都可
			
			// foreach
			for(BallTask ball: balls) {
				g2d.drawImage(ballImg, ball.ballX, ball.ballY, null);
			}
		}
	} 
	
	
	public static void main(String[] args) {
		new MyBallGame();
	}

}
