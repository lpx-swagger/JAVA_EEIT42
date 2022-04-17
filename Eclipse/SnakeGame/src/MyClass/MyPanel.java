package MyClass;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import Generator.myMotion;


import Generator.myMotion;

public class MyPanel extends JPanel implements ActionListener {
    private final int RAND_POS = 11;
    private final int DELAY = 300;
    private final int DOT_SIZE = 70;
    private final int TOTAL_DOTS = 144;  // 840*840 div 70*70 => the maximum number of possible dots on the board
    public final int B_WIDTH = 840;
    public final int B_HEIGHT = 840;
    
    private int x[] = new int[TOTAL_DOTS];
    private int y[] = new int[TOTAL_DOTS];
    
    private int dots; private int eX; private int eY; private int score;
    private int id;
    
	private boolean leftDir = false; private boolean rightDir = true;
	private boolean upDir = false; private boolean downDir = false;
	private boolean inGame = true;

	private Image elephant; private Image head; private Image unitBody;

	private Timer timer;
	
	public MyPanel(){
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		
		timer = new Timer(DELAY, this);
		this.id =0;
	}
	
	private int sqlQuery() {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String sql = "SELECT COUNT(*) AS count FROM SnakeGame";
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/iii", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("count");
				System.out.println(id);
				return id;
			}
			conn.close();
			
			return 0;
			//System.out.println("Max: " + id);
			
		} catch(Exception e) {
			System.out.println(e.toString());
			//JOptionPane.showMessageDialog(null, e.getMessage());
			return 0;
		}
	}
	
	private void sqlUpdate()  {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		String sqll = "UPDATE SnakeGame SET score = ? WHERE id = ?";
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/iii", prop);
			PreparedStatement pstmt = conn.prepareStatement(sqll);
			
			pstmt.setInt(1, getScore());
			pstmt.setInt(2, this.id);
            
			int n = pstmt.executeUpdate();
			if(n > 0) {
            	JOptionPane.showMessageDialog(null, "Updated Score!");
            } else {
            	JOptionPane.showMessageDialog(null, "Failed!");
            }
			
			conn.close();	
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void newGame() {
		addKeyListener(new KAdapter());
		setFocusable(true);
		requestFocus();
		
		this.id = sqlQuery();
		System.out.println(this.id);
		
		/* If you're just listening for a few keys and your component doing the listening 
		 * may not have the focus, you're far better of using key bindings than a KeyListener.*/
		
		loadObj();
		setInGame();
		initGame();
		timer.start();
		
	}
	
	private void loadObj() {
		try {
			elephant = ImageIO.read(new File("dir1/ball2.png"));
			head = ImageIO.read(new File("dir1/ball0.png"));
			unitBody = ImageIO.read(new File("dir1/ball1.png"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private void initGame() {
		dots = 3;  // 1head + 2unitbody
		score = 0;
		for(int i = 0; i < dots; i++) {  // default Snake location
			x[i] = 350 - i * 10;
			y[i] = 350;
		}
		locElephant();
	}
	
	private void locElephant() {
		int ran1 = (int)(Math.random() * RAND_POS);
		int ran2 = (int)(Math.random() * RAND_POS);
		eX = (ran1 * DOT_SIZE);
		eY = (ran2 * DOT_SIZE);
		System.out.println("Elephant location: " + "X: " + eX + " " + "Y: " + eY);
	}
	
	public void setInGame() {
		this.inGame = true;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		if(inGame) {
//			System.out.println("aaa");
			g2d.drawImage(elephant, eX, eY, this);
			
			for(int i = 0; i < dots; i++) {
				if(i == 0) {
					g2d.drawImage(head, x[i], y[i], this);
				} else {
					g2d.drawImage(unitBody, x[i], y[i], this);
				}
			}
			Toolkit.getDefaultToolkit().sync();
		}
		else {
//			System.out.println("bbb");
			gameOver(g2d);
		}
	}
	
	
	public int getScore() {
		return dots-3;
	}
	
	private void gameOver(Graphics g) {
		String msg = "Game Over!!!";
		Font ft = new Font("", Font.ITALIC, 12);
		FontMetrics metr = getFontMetrics(ft);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(ft);
		g2d.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 );
		g2d.drawString("Score: " + getScore(), B_WIDTH/3, B_HEIGHT/3);
		
		timer.stop();
		System.out.println(this.id + " " + getScore());
		sqlUpdate();
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
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(inGame) {
			checkElephant();
			checkCollision();
			move();
		}			
		repaint();
	}

	private class KAdapter extends KeyAdapter {
		
		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if((key == KeyEvent.VK_LEFT) && (!rightDir)) {
				leftDir = true;
				upDir = false;
				downDir = false;
				System.out.println("Modifiers: " + e.getModifiersEx());
				System.out.println("head go left");

			}

			if((key == KeyEvent.VK_UP) && (!downDir)) {
				upDir = true;
				leftDir = false;
				rightDir = false;
				System.out.println("Modifiers: " + e.getModifiersEx());
				System.out.println("head go up");
			}

			if((key == KeyEvent.VK_DOWN) && (!upDir)) {
				downDir = true;
				leftDir = false;
				rightDir = false;
				System.out.println("Modifiers: " + e.getModifiersEx());
				System.out.println("head go down");
			}

			if((key == KeyEvent.VK_RIGHT) && (!leftDir)) {
				rightDir = true;
				upDir = false;
				downDir = false;
				System.out.println("Modifiers: " + e.getModifiersEx());
				System.out.println("head go right");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}
	}

}


