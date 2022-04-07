package MyClass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import Generator.myMotion;


public class MyPanel extends JPanel implements ActionListener {
    private final int RAND_POS = 11;
    private final int DELAY = 500;
    private final int DOT_SIZE = 70;
    private final int TOTAL_DOTS = 144;  // 840*840 div 70*70 => the maximum number of possible dots on the board
    public final int B_WIDTH = 840;
    public final int B_HEIGHT = 840;
    
    private int x[] = new int[TOTAL_DOTS];
    private int y[] = new int[TOTAL_DOTS];
    
    private int dots; private int eX; private int eY;
    
	private boolean leftDir = false; private boolean rightDir = true;
	private boolean upDir = false; private boolean downDir = false;
	private boolean inGame = true;
	
	private Image elephant; private Image head; private Image unitBody;

	private Timer timer;
	
	public MyPanel() {
		setBackground(Color.BLACK);
		setFocusable(true);
		requestFocus();
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		//newGame();
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void newGame() {
		loadObj();
		initGame();
		setInGame();
	}
	
	private void loadObj() {
		try {
			elephant = ImageIO.read(new File("/Volumes/disk0s3/Users/chloe-lu/lesson_learned_disks03/JAVA_course/Eclipse/20220316_DS/dir1/ball2.png"));
			head = ImageIO.read(new File("/Volumes/disk0s3/Users/chloe-lu/lesson_learned_disks03/JAVA_course/Eclipse/20220316_DS/dir1/ball0.png"));
			unitBody = ImageIO.read(new File("/Volumes/disk0s3/Users/chloe-lu/lesson_learned_disks03/JAVA_course/Eclipse/20220316_DS/dir1/ball1.png"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private void initGame() {
		dots = 3;
		for(int i = 0; i < dots; i++) {
			x[i] = 350 - i * 10;
			y[i] = 350;
		}
		
		locElephant();
		
	}
	
	public void setInGame() {
		this.inGame = true;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//System.out.println(viewW + " " +viewW);
		
		Graphics2D g2d = (Graphics2D) g;
		
		if(inGame) {
			g2d.drawImage(elephant, eX, eY, this);
			
			for(int i = 0; i < dots; i++) {
				if(i == 0) {
					g2d.drawImage(head, x[i], y[i], this);
				} else {
					g2d.drawImage(unitBody, x[i], y[i], this);
				}
			}
//			timer = new Timer(250, e -> update(g2d));
//			timer.start();
			
		} else {
			gameOver(g2d);
		}
		//repaint();
	}
	
	
//	//int x; int y;
    public void start(){
//        JFrame frame = new JFrame();
//
//        frame.add(panel);
//        frame.setSize(640, 480);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//
//        KeyStroke us = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false);
//        KeyStroke ds = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false);
//        KeyStroke ls = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false);
//        KeyStroke rs = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false);
//
//        panel.getInputMap().put(us, "UP");
//        panel.getInputMap().put(ds, "DOWN");
//        panel.getInputMap().put(ls, "LEFT");
//        panel.getInputMap().put(rs, "RIGHT");
//
//
//        panel.getActionMap().put("UP", new AbstractAction(){
//            @Override
//            public void actionPerformed(ActionEvent evt){
//                Up();
//            }
//        });
//
//        panel.getActionMap().put("DOWN", new AbstractAction(){
//            @Override
//            public void actionPerformed(ActionEvent evt){
//                Down();
//            }
//        });
//        panel.getActionMap().put("LEFT", new AbstractAction(){
//            @Override
//            public void actionPerformed(ActionEvent evt){
//                Left();
//            }
//        });
//        panel.getActionMap().put("RIGHT", new AbstractAction(){
//            @Override
//            public void actionPerformed(ActionEvent evt){
//                Right();
//            }
//        });
//    }
//    
//    private void Up() {
//    	y[0] -= DOT_SIZE;
//	}
//	
//	private void Down() {
//		y[0] += DOT_SIZE;
//	}
//	
//	private void Right() {
//		x[0] += DOT_SIZE;
//	} 
//	
//	private void Left() {
//		x[0] -= DOT_SIZE;
	}

	private void gameOver(Graphics g) {
		String msg = "Game Over!!!";
		Font ft = new Font("", Font.ITALIC, 12);
		FontMetrics metr = getFontMetrics(ft);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(ft);
		g2d.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 ); // TODO int x, y
	}

	
	

	private void locElephant() {
		int ran1 = (int)(Math.random() * RAND_POS);
		int ran2 = (int)(Math.random() * RAND_POS);
		eX = (ran1 * DOT_SIZE);
		eY = (ran2 * DOT_SIZE);
		System.out.println("X: " + eX + " " + "Y: " + eY);
	}
	
	private void checkElephant() {
		if((x[0] == eX) && (y[0] == eY)) {
			dots++;
			locElephant();
		}
	}

	private void move() {
		for(int i = dots; i > 0; i--) {
			x[i] = x[(i - 1)];
			y[i] = y[(i - 1)];
		}
		
		if(leftDir) {
			x[0] -= DOT_SIZE;
		}
		
		if(rightDir) {
			x[0] += DOT_SIZE;
		}
		
		if(upDir) {
			y[0] -= DOT_SIZE;
		}
		
		if(downDir) {
			y[0] += DOT_SIZE;
		}
		
		
	}

	private void checkCollision() {
		// snake hit itself
		for(int i = dots; i > 0; i--) {
			if( (i > 4) && (x[0] == x[i]) && (y[0] == y[i]) ) {
				inGame = false;
			}
		}
		
		// snake hit one of the walls
		if(x[0] >= B_WIDTH) {
			inGame = false;
		}
		
		if(y[0] >= B_HEIGHT) {
			inGame = false;
		}
		
		if(x[0] < 0) {
			inGame = false;
		}
		
		if(y[0] < 0) {
			inGame = false;
		}
		
	
	}
		
//	// update score
	private void updatescore(){
//        try {            
//           Connection c=ClassDB.getkoneksi();
//          Statement s=(Statement)c.createStatement();
//       String cektinggi="Select * from score where nama = '" + Nama.toString() +"'";
//           ResultSet r=s.executeQuery(cektinggi);
//           if (r.next()){
//            scoretinggi = Integer.parseInt(r.getString("score"));
//            if (scorenya &lt;= scoretinggi){
//                 return;  
//            }
//            else{
//                 String sqel = "UPDATE score Set score ='" + scorenya +"' where nama = '" + Nama.toString()+ "'";     
//           s.executeUpdate(sqel); 
//            }
//                     
//           }            
//       }catch(Exception e) {
//           System.out.println(e);
//       }
   }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(inGame) {
			checkElephant();
			checkCollision();
			move();
		}
		repaint();
	}
	

}
