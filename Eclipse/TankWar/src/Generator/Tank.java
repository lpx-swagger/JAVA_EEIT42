package Generator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterators.AbstractLongSpliterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioPermission;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Tank extends JFrame {
	private PlayGroundPanel PlayGround;
	private int scoreCount;
	private scoreBoard sB;
	private JButton save,load,sound,restart,effect;
	private Thread t, t1;
	private boolean soundFlag = false;
	private boolean sEffectFlag = false;
	
	public Tank() {
		super("戰場");
		
		setLayout(new BorderLayout());
		
		JPanel top = new JPanel(new FlowLayout());
		
		save = new JButton("存檔");
		load = new JButton("載入");
		sound = new JButton("聲音:關");
		effect = new JButton("音效:關");
		restart = new JButton("重來");
		sB = new scoreBoard();
		
		top.add(sB);
		top.add(sound);
		top.add(effect);
		top.add(save);
		top.add(load);
		top.add(restart);
		
		save.setFocusable(false);
		load.setFocusable(false);
		effect.setFocusable(false);
		sound.setFocusable(false);
		restart.setFocusable(false);
		
		add(top,BorderLayout.NORTH);
		
		PlayGround = new PlayGroundPanel();
		PlayGround.setFocusable(true);
		add(PlayGround, BorderLayout.CENTER);
		
		setListener();
		t = new myThread();
		t1 = new myThread1();
		setSize(1200,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class myThread extends Thread implements Serializable {
		@Override
		public void run() {
			music();
		}
	}
	
	private class myThread1 extends Thread implements Serializable {
		@Override
		public void run() {
			musicEffect();//bull music
		}
	}
	
	public static void musicEffect() {
		//bull music
		try {
			Player play = new Player(new FileInputStream("dir1/bullmusic.mp3"));
			play.play();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	public static void music() {
		try {
			Player play = new Player(new FileInputStream("dir1/music.mp3"));
			while(true) {
				play.play();
				play = new Player(new FileInputStream("dir1/music.mp3"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setListener() {
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveobj();
			}
		});
		
		load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadobj();
			}
		});
		
		sound.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				soundFlag = !soundFlag;
				if(soundFlag) {
					t.start();
					sound.setText("聲音:開");
				}
				else {
					t.stop();
					t = new myThread();
					sound.setText("聲音:關");
				}
			}
		});
		
		effect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sEffectFlag = !sEffectFlag;
				if(sEffectFlag) {
					effect.setText("音效:開");
				}
				else {
					effect.setText("音效:關");
				}
			}
		});
		
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayGround.normalobjs.clear();
				PlayGround.bullobjs.clear();
				PlayGround.setTank();
				PlayGround.gameFlag = false;
				scoreCount = 0;
				PlayGround.repaint();
			}
		});
	}
	
	private void saveobj() {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			try {
				ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
				int[] tankCoor = PlayGround.getTankCoordinate();
				oout.writeObject(new objForSave(scoreCount,tankCoor[0],tankCoor[1], PlayGround.getBullList(), PlayGround.getRockList()));
				oout.flush();
				oout.close();
				JOptionPane.showMessageDialog(null, "存檔成功");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "存檔失敗");
			}
		}
	}
	
	private void loadobj() {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			try {
				ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
				Object obj = oin.readObject();
				oin.close();
				PlayGround.bullobjs = (LinkedList<PlayGroundPanel.ImgObj>) ((objForSave)obj).bullobjs;
				PlayGround.normalobjs = (LinkedList<PlayGroundPanel.ImgObj>) ((objForSave)obj).normalobjs;
				PlayGround.tankX = ((objForSave)obj).tankX;
				PlayGround.tankY = ((objForSave)obj).tankY;
				scoreCount = ((objForSave)obj).score;
				repaint();
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"載入失敗");
			}
		}
	}
	
	private class objForSave implements Serializable {   // 存成檔案，下次開啟時，再從這裡開始玩
	// 通常存成 transeit 的是希望不要存 Timer 或是 背景音樂 或是你不想重覆存物件 或是 final???
		private int tankX, tankY, score;
		private LinkedList<PlayGroundPanel.ImgObj> bullobjs, normalobjs;
		public objForSave(int c, int x, int y, LinkedList<PlayGroundPanel.ImgObj> bullobjs, LinkedList<PlayGroundPanel.ImgObj> normalobjs) {
			this.tankX = x;
			this.tankY = y;
			this.bullobjs = bullobjs;
			this.normalobjs = normalobjs;
			this.score = c;
		}
	}
	
	private class scoreBoard extends JLabel {
		private transient Timer t;
		public scoreBoard(){
			t = new Timer();
			try{
				t.schedule(new score(), 0, 10);
			} catch(IllegalStateException e) {
				System.out.println("錯在這裡1");
				e.getStackTrace();
			}
		}
		
		private class score extends TimerTask {
			@Override
			public void run() {
				setText("得分: " + scoreCount);
			}
		}
	}
	
	private class PlayGroundPanel extends JPanel implements Serializable {
		private int viewW = 0, viewH = 0, tankW, tankH, tankX, tankY, dx, dy;
		private transient Timer timer;
		private transient BufferedImage tankImg, bullImg, rockImg, backGround;
		private LinkedList<ImgObj> bullobjs, normalobjs;
		private transient ImgObj temp1, temp2;
		private int backGroundH, backGroundW;
		private boolean gameFlag = false;
		private transient Action UP, DOWN, LEFT, RIGHT, ATT;
		private transient rockGenerator rockG;
		private transient RefreshTask refresh;
		private char[] ch = {'撞','石','頭','你','輸','啦','!'};
		
		public PlayGroundPanel() {
			setBackground(Color.cyan);
			try {
				tankImg = ImageIO.read(new File("dir1/TANK.png"));
				bullImg = ImageIO.read(new File("dir1/bull.PNG"));
				rockImg = ImageIO.read(new File("dir1/rock.png"));
				backGround = ImageIO.read(new File("dir1/back.png"));
				tankW = tankImg.getWidth(); tankH = tankImg.getHeight();
				dx = 5; dy = 5;
				UP = new UpAction(); DOWN = new DownAction(); LEFT = new LeftAction(); RIGHT = new RightAction();
				ATT = new attackAction();
				this.getInputMap().put(KeyStroke.getKeyStroke('w'), "upAction");
				this.getActionMap().put("upAction", UP);
				this.getInputMap().put(KeyStroke.getKeyStroke('s'), "downAction");
				this.getActionMap().put("downAction", DOWN);
				this.getInputMap().put(KeyStroke.getKeyStroke('a'), "leftAction");
				this.getActionMap().put("leftAction", LEFT);
				this.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightAction");
				this.getActionMap().put("rightAction", RIGHT);
				this.getInputMap().put(KeyStroke.getKeyStroke('j'), "attack");
				this.getActionMap().put("attack", ATT);
				bullobjs = new LinkedList<ImgObj>();
				normalobjs = new LinkedList<ImgObj>();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			setTank();
			
			ImagePanel(backGround);
			timer = new Timer();
			rockG = new rockGenerator();
			refresh = new RefreshTask();
			
			try{
				timer.schedule(refresh, 0, 30);
			} catch(IllegalStateException e) {
					System.out.println("錯在這裡2");
					e.getStackTrace();
			}
			
			try{
				timer.schedule(rockG, 1000,1000*1);
			} catch(IllegalStateException e) {
					System.out.println("錯在這裡3");
					e.getStackTrace();
			}
		}
		
		public PlayGroundPanel(objForSave o) {
			setBackground(Color.cyan);
			try {
				tankImg = ImageIO.read(new File("dir1/TANK.png"));
				bullImg = ImageIO.read(new File("dir1/bull.PNG"));
				rockImg = ImageIO.read(new File("dir1/rock.png"));
				backGround = ImageIO.read(new File("dir1/back.png"));
				tankW = tankImg.getWidth(); tankH = tankImg.getHeight();
				dx = 5; dy = 5;
				UP = new UpAction(); DOWN = new DownAction(); LEFT = new LeftAction(); RIGHT = new RightAction();
				ATT = new attackAction();
				
				this.getInputMap().put(KeyStroke.getKeyStroke('w'), "upAction");
				this.getActionMap().put("upAction", UP);
				this.getInputMap().put(KeyStroke.getKeyStroke('s'), "downAction");
				this.getActionMap().put("downAction", DOWN);
				this.getInputMap().put(KeyStroke.getKeyStroke('a'), "leftAction");
				this.getActionMap().put("leftAction", LEFT);
				this.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightAction");
				this.getActionMap().put("rightAction", RIGHT);
				this.getInputMap().put(KeyStroke.getKeyStroke('j'), "attack");
				this.getActionMap().put("attack", ATT);
				bullobjs = new LinkedList<ImgObj>();
				normalobjs = new LinkedList<ImgObj>();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			tankX = o.tankX; tankY = o.tankY;
			
			bullobjs = o.bullobjs;
			normalobjs = o.normalobjs;
			scoreCount = o.score;
			ImagePanel(backGround);
			timer = new Timer();
			rockG = new rockGenerator();
			refresh = new RefreshTask();
			
			timer.schedule(rockG, 1000,1000*1);
			timer.schedule(refresh, 0, 30);
		}
		
		public int[] getTankCoordinate(){
			int[] c = {tankX, tankY};
			return c;
		}
		
		public LinkedList<ImgObj> getBullList(){
			LinkedList<ImgObj> list = bullobjs;
			return list;
		}
		
		public LinkedList<ImgObj> getRockList(){
			LinkedList<ImgObj> list = normalobjs;
			return list;
		}
		
		public class UpAction extends AbstractAction {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tankY > 0) {
					tankY -= dy;
				}
			}		
		}
		
		public class DownAction extends AbstractAction implements Serializable {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tankY < viewH - tankImg.getHeight()) {
					tankY += dy;
				}
			}		
		}
		
		public class LeftAction extends AbstractAction implements Serializable {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tankX > 0) {
					tankX -= dx;
				}
			}		
		}
		
		public class RightAction extends AbstractAction implements Serializable {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tankX < viewW - tankImg.getWidth()) {
					tankX += dx;
				}
			}		
		}
		
		public class attackAction extends AbstractAction implements Serializable {
			@Override
			public void actionPerformed(ActionEvent e) {
				createBull(0, 30);
				if(sEffectFlag) {
					t1.start();
					t1 = new myThread1();
				}
				
				try {
					Thread.sleep(35);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		
		private void ImagePanel(BufferedImage f) {
			backGroundH = f.getHeight()/2;
			backGroundW = f.getWidth()/2;
		}
		
		private void createBull(int dx, int dy) {
			new ImgObj(tankX, tankY, dx, dy, true);
		}
		
		private void createBarrier(int x, int y, int dx, int dy) {
			int[] coll = {x,y};
			int[] temp = {(int)(Math.random()*viewW), (int)(Math.random()*viewH)};
			
			if(x == -1 && y == -1) {
				coll = temp;
			}
			
			int RockmaxX = coll[0] + rockImg.getWidth()/2;
			int RockminX = coll[0] - rockImg.getWidth()/2;
			int RockmaxY = coll[1] + rockImg.getHeight()/2;
			int RockminY = coll[1] - rockImg.getHeight()/2;
			int tankmaxX = tankX + tankImg.getWidth()/2;
			int tankminX = tankX - tankImg.getWidth()/2;
			int tankmaxY = tankY + tankImg.getHeight()/2;
			int tankminY = tankY - tankImg.getHeight()/2;
			
			if((RockmaxY > tankminY && tankminY > RockminY && RockmaxX > tankminX && tankminX > RockminX)
					|| (tankmaxY > RockminY && RockminY > tankminY && tankmaxX > RockmaxX && RockmaxX > tankminX)
					|| (tankmaxY > RockminY && RockminY > tankminY && RockmaxX > tankmaxX && tankmaxX > RockminX)
					|| (tankmaxY > RockmaxY && RockmaxY > tankminY && RockmaxX > tankmaxX && tankmaxX > RockminX)) {
					return;
			}
			
			new ImgObj(coll[0], coll[1], dx, dy, false);
		}
		
		public class ImgObj implements Serializable {
			private int objX, objY;
			boolean bull;
			int dx, dy;
			public ImgObj(int x, int y, int dx, int dy, boolean bull) {
				objX = x;
				objY = y;
				this.dx = dx;
				this.dy = dy;
				if(bull){
					bullobjs.add(this);
				}
				else {
					normalobjs.add(this);
				}
			}
		}
		
		void setTank() {
			tankX = 550;
			tankY = 300;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			viewW = getWidth(); viewH = getHeight();
			if(!gameFlag) {
				g2d.drawImage(backGround, viewW/2 - backGroundW, viewH/2 - backGroundH, null);
				g2d.drawImage(tankImg, tankX, tankY, null);
				
				for(ImgObj obj : bullobjs) {
					g2d.drawImage(bullImg, obj.objX, obj.objY, null);
				}
				
				for(ImgObj obj : normalobjs) {
					g2d.drawImage(rockImg, obj.objX, obj.objY, null);
				}
			}
			else {
				g2d.drawChars(ch, 0, ch.length, viewW/2, viewH/2);
			}
		}
		
		private class rockGenerator extends TimerTask implements Serializable {
			@Override
			public void run() {
				createBarrier(-1, -1, 0, 0);
			}
		}
		
		private class RefreshTask extends TimerTask implements Serializable {
			@Override
			public void run() {
				boolean flag = false, flag2 = false, flag3 = false;
				int X = 0, Y = 0;
				
				for(Iterator<ImgObj> it = bullobjs.iterator(); it.hasNext();) {
					if(it.next().objY < 0) {
						it.remove();
					}
				}
				
				for(Iterator<ImgObj> it = normalobjs.iterator(); it.hasNext();) {
					temp1 = it.next();
					if(temp1.objX < 0 || temp1.objY < 0 || temp1.objX > viewW || temp1.objY > viewH) {
						it.remove();
					}
				}
				for(Iterator<ImgObj> it = bullobjs.iterator(); it.hasNext();) {
					
					temp1 = it.next();
					for(Iterator<ImgObj> itRock = normalobjs.iterator(); itRock.hasNext();) {
						temp2 = itRock.next();
						if((temp2.objY + (rockImg.getHeight()/2) > temp1.objY - (bullImg.getHeight()/2)
								&& temp2.objX + (rockImg.getWidth()/2) > temp1.objX - (bullImg.getWidth()/2)
								&& temp1.objX - (bullImg.getWidth()/2) > temp2.objX - (rockImg.getWidth()/2))
							||(temp2.objY + (rockImg.getHeight()/2) > temp1.objY - (bullImg.getHeight()/2)
								&& temp2.objX - (rockImg.getWidth()/2) < temp1.objX + (bullImg.getWidth()/2)
								&& temp1.objX + (bullImg.getWidth()/2) < temp2.objX + (rockImg.getWidth()/2))) {
							flag = true;
							if((int)(Math.random()*100) < 50) {
								flag2 = true;
								X = temp2.objX; Y = temp2.objY;
							}
							if((int)(Math.random()*100) < 20) {
								flag3 = true;
								X = temp2.objX; Y = temp2.objY;
							}
							itRock.remove();
							scoreCount++;
						}
					}
					
					if(flag) {
						it.remove();
					}
					
					if(flag2) {
						flag2 = false;
						for(int i = 1; i < 3; i++) {
							for(int j = 1; j < 3; j++) {
								createBarrier(X, Y, (int)Math.pow(-1, i) * 2, (int)Math.pow(-1, j) * 2);
							}
						}
					}
					
					if(flag3) {
						createBarrier(X, Y, (X - tankX)/50, (Y - tankY)/50);
					}
				}
				
				for(ImgObj obj : bullobjs) {
					obj.objY -= obj.dy;
				}
				
				for(ImgObj obj : normalobjs) {
					obj.objX -= obj.dx;
					obj.objY -= obj.dy;
				}
				
				for(ImgObj obj : normalobjs) {
					int RockmaxX = obj.objX + rockImg.getWidth()/2;
					int RockminX = obj.objX - rockImg.getWidth()/2;
					int RockmaxY = obj.objY + rockImg.getHeight()/2;
					int RockminY = obj.objY - rockImg.getHeight()/2;
					int tankmaxX = tankX + tankImg.getWidth()/2;
					int tankminX = tankX - tankImg.getWidth()/2;
					int tankmaxY = tankY + tankImg.getHeight()/2;
					int tankminY = tankY - tankImg.getHeight()/2;
					
					if((RockmaxY > tankminY && tankminY > RockminY && RockmaxX > tankminX && tankminX > RockminX)
						|| (tankmaxY > RockminY && RockminY > tankminY && tankmaxX > RockmaxX&&RockmaxX > tankminX)
						|| (tankmaxY > RockminY && RockminY > tankminY && RockmaxX > tankmaxX&&tankmaxX > RockminX)
						|| (tankmaxY > RockmaxY && RockmaxY > tankminY && RockmaxX > tankmaxX&&tankmaxX > RockminX)) {
						gameFlag=true;
					}
				}
				
				repaint();
			}
		}
	}
	
	public static void main(String[] args) {
		new Tank();
	}
}



