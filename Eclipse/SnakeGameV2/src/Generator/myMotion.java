package Generator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Class.myDigitalClock;


public class myMotion extends JFrame {
	public final int B_WIDTH = 840;
    public final int B_HEIGHT = 840;
	private JButton newGame, updateScore;
	private MyPanel mp;
	private myDigitalClock mdc;
	private JTextField name, age, gender, country;
	
	
	public myMotion() {
		super("My Greedy Snake Game");
		newGame = new JButton("NewGame");
		//updateScore = new JButton("ScoreSQL");
		
		mp = new MyPanel();
		mdc = new myDigitalClock();
		
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		add(top, BorderLayout.NORTH);
		
		setResizable(false);
		//pack();
		
		setSize(B_WIDTH, B_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		name = new JTextField(6);
		age = new JTextField(3);
		gender = new JTextField(3);
		country = new JTextField(6);
		
		JLabel n = new JLabel("Name: ");
		JLabel a = new JLabel(", Age: ");
		JLabel g = new JLabel(", Gender(F/M/X): ");
		JLabel c = new JLabel(", Country: ");
		
		
		top.add(n); top.add(name); top.add(a); top.add(age); 
		top.add(g); top.add(gender); top.add(c); top.add(country);
		
		top.add(newGame); top.add(mdc); 
		//top.add(updateScore); 
		add(mp, BorderLayout.CENTER);
		
		setEvent();
		//this.id = sqlQuery();
	}
	

	private void sqlinsertInto() {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		String sql = "INSERT INTO SnakeGame" + " (name, age, gender, country)" + " VALUES(?,?,?,?)";
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/iii", prop);
			PreparedStatement pstmt = conn.prepareStatement(
					sql,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, name.getText());
			pstmt.setString(2, age.getText());
			pstmt.setString(3, gender.getText());
			pstmt.setString(4, country.getText());
			int n = pstmt.executeUpdate();
            if(n > 0) {
            	JOptionPane.showMessageDialog(null, "Successfully Save!");
            } else {
            	JOptionPane.showMessageDialog(null, "Failed!");
            }
            conn.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void setEvent() {
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sqlinsertInto();
				NewGame();
			}
		});
	}
	
	private void NewGame() {
		mp.newGame();
		
		//this.id++;
		//System.out.println(this.id);
	}
	
	
	public static void main(String[] args){
		new myMotion();
	}
}

