package Generator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.StyleConstants;

//TODO

public class guessNumV2 extends JFrame{
	private JTextField input;
	private JButton guess;
	private JTextArea log;
	private int count = 0;
	private int countA = 0;
	private int countB = 0;
	private final int NUM = 4;
	private String newAns;
	
	public guessNumV2() {
		super("My Bulls and Cows Game"); // 祖宗8代都會做initialize
		setLayout(new BorderLayout());
		
		input = new JTextField();
		guess = new JButton("Guess");
		log = new JTextArea();
		log.setEditable(false);
		//StyleConstants.setFontSize(null, 14);
		
		add(log, BorderLayout.CENTER);
		JPanel north = new JPanel(new BorderLayout());
		add(north, BorderLayout.NORTH);
		
		north.add(guess, BorderLayout.EAST);
		north.add(input, BorderLayout.CENTER);
		
		newGame();

        // guess.addActionListener(new MyListener()); //另外定義=>搭配最後class MyListener
        // guess.addActionListener(this); //自己實作=>搭配開頭class GuessNumber後implements ActionListener及下方@Override
        // guess.addActionListener(new MyListenerV2()); //寫成內部類別=>搭配下方class MyListenerV2
        guess.addActionListener(new ActionListener(){ //寫成內部類別(直接定義)=>點選按鈕後(事件)執行doGuess()
            @Override
            public void actionPerformed(ActionEvent e){
                //System.out.println(createAnswer(4));
                doGuess();
            }
        });
		
		setSize(640, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 關了就關了不要再多問一次 要不要關掉
	}
	
	//TODO open file 再去 try-catch 做check
	
	private void doGuess() {
		boolean isDigitValid = true;
		boolean isRepeat = false;
		
		// get input String
		String usrInput = input.getText();
		String digit = "[0-9]{" + usrInput.length() + "}";
		
		
		
		// TODO must be digits
		JOptionPane.showMessageDialog(null, 
				"Must be an integer", "ERROR", JOptionPane.ERROR_MESSAGE);
		
		
		// checkAB()
		if(usrInput.matches(digit)) {
			// checkAB()
			String chdab = checkAB(usrInput);
			
			// display => log
			log.append(count + ". " + usrInput + " => " + chdab + "\n");
			
			// if(?A?B .equals("3A0B“)) => showResult(true)
			if(chdab.equals(usrInput.length() + "A0B")) {
				showResult(true);
				newGame();
			}
			
			// guess greater than 10 times => showResult(false) => loser
			if(count == 10) {
				showResult(false);
				newGame();
			}
		} else {
			
			
		}
		
		//TODO guessing number cannot same as previous guessing number
		
		JOptionPane.showMessageDialog(null, "You must enter an interger with "
				+ "no duplicates digits and with 4-digits", "ERROR", JOptionPane.ERROR_MESSAGE);
		
		if(isDigitValid == true && isRepeat == false) {
			count++;
		}
		
	}
	
	
	
	
	private String createAnswer() {
		return createAnswer(3);
	}
	
	public static String createAnswer(int dig) {  // 猜3碼以外的數字，ex. #6
		int[] poker = new int[10];
		boolean isRepeat;
		int temp;
		for (int i=0; i<poker.length; i++){
			do {
				temp = (int)(Math.random()*10);

				// 檢查機制 
				isRepeat = false;
				for (int j=0; j<i; j++){
					if (temp == poker[j]){
						isRepeat = true;
						break;
					}
				}
			}while(isRepeat);

			poker[i] = temp;
		}
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<dig; i++) {
			sb.append(poker[i]);
		}
		return sb.toString();
	}
   
	// Method1 for checking ?A?B
	private String checkAB(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if(i == j && s.charAt(i) == s.charAt(j)) {
					countA++;
				} else if(s.charAt(j) == s.charAt(i)){
					countB++;
				}
			}
			
		}
		return String.valueOf(countA) + "A" + String.valueOf(countB) + "B";
		//return String.format("%dA%dB", countA, countB);
	}
	
	// Method2 for checking ?A?B	
	private String checkAB(String s, String g) {
		int[] count1 = new int[10];
		int[] count2 = new int[10];
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == g.charAt(i)) {
				countA++;
			} else {
				count1[s.charAt(i) - '0']++;
				count2[g.charAt(i) - '0']++;
			}
			
		}
		
		for(int i = 0; i < 10; i++) {
			countB = countB + Math.min(count1[i], count2[i]);
		}
		
		return String.valueOf(countA) + "A" + String.valueOf(countB) + "B";	
	}
		
	// show result
	private void showResult(boolean isWin) {
		JOptionPane.showMessageDialog(this, isWin?"You're a Winner":"Hey, Loser ~~~");
	}
	
	// create new game
	private void newGame() {
		// counter = 0
		count = 0;
		
		// input, log => clear
		String empty = "";
		input.setText(empty);
		log.setText(empty);
		
		// createAnswer
		newAns = createAnswer(NUM);
		
		// print out answer in Terminal
		System.out.println(newAns);
		
		log.append("請猜4個數字 => ");
		
	}
	
	// main function
	public static void main(String[] args) {
		new guessNumV2();
		
	}
		
}


class MyListenerV3 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println(guessNumV2.createAnswer(4));
	}
}


