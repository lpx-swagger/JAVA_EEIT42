package Generator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// 目前都是寫 單一視窗，photoshop 有多視窗
public class chloe37 extends JFrame {
	private JTextField x, y;
//	private JButton equ;
	private JLabel result;
	
	public chloe37() {  
		setLayout(new FlowLayout());  /* 需按照順序來丟，java.awt.setLayout(LayoutManager)，
//		狗狗可以是JAVA 認證工程師，只要他他有考過證照，所以在 LayoutManager 裡面有 FlowLayout()，因為他也有考過LayoutManager 的證照 */
//		setLayout(new FlowLayout().LEFT100, 0));
		x = new JTextField(4); // 區域變數用完就丟； 屬性，物件在人就在
		y = new JTextField(4); // 區域變數用完就丟； 屬性，物件在人就在
		JLabel addSymbol = new JLabel("+");
		JButton equ = new JButton("=");
		result = new JLabel("");
		
		add(x);  // java.awt.Container 父繼承就已經有，可以直接寫
		add(addSymbol); add(y); add(equ); add(result);
		
		equ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {  // 匿名方法的實作
				doAdd();  // 不要在 method 寫太多 CODE
				
			}
		});   // ex. server 隨時都在傾聽，monitor；誰來聽
		
		
		setSize(480, 360); // java.awt.Window ，constructor 初始化， setSize(0,0) 初始值
		setLayout(new FlowLayout()); // 名字是啥不重要，但是要給值
		setVisible(true);  // 紅燈亮，記憶體不做移除，即使關掉也仍在記憶體內
		System.out.println(EXIT_ON_CLOSE);  // EXIT_ON_CLOSE 是一個 int，放任意的值 ex.4
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void doAdd() {  // do => 一個動作，Add => 那個動作
		String strX = x.getText(); // 使用者所輸入的是 string，需做轉換
		String strY = y.getText();
		int IntX = Integer.parseInt(strX);
		int IntY = Integer.parseInt(strY);
		int intResult = IntX + IntY;
		result.setText(" " + intResult);
	}
	
	public static void main(String[] args) {
		new chloe36();		// 名字是供人用來呼叫的；修電工來修理不需知道他的名字
	}
}
