package Generator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import myClass.MyDrawer;
import myClass.myDigitalClock;
//TODO
public class MySignatureV2 extends JFrame {
	private JButton clear, redo, undo, saveImg;
	private MyDrawer md;
	private myDigitalClock mdc;
	
	public MySignatureV2() {
		super("Painter Programming");
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		
		mdc = new myDigitalClock();
		clear = new JButton("Clear");
		redo = new JButton("Redo");
		undo = new JButton("Undo");
		saveImg = new JButton("saveImg");
		top.add(clear);	top.add(redo); top.add(undo); 
		top.add(saveImg); top.add(mdc);
		
		add(top, BorderLayout.NORTH);
		md = new MyDrawer();
		add(md, BorderLayout.CENTER);
		
		
		setSize(640, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setListener();
	}
	
	public void setListener() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				redo();
			}
		});
	} 
	
	private void clear() {
		
	}
	private void undo() {
		
	}
	private void redo() {
		
	}
	private void saveJPG() {
		BufferedImage img = new BufferedImage( // 
				myDrawer.getWidth(), myDrawer.getHeight(), 
				BufferedImage.TYPE_INT_RGB);
		Graphics g = img.createGraphics();
		myDrawer.paint(g);
		
		try {
			ImageIO.write(img, "jpg", new File("dir1/brad.jpg")); 
			/*上面先寫渲染的動作，這行再用 ImageIO 把他灌出去*/
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void saveFile() {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			
		} else {
			try {
				JOptionPane.showMessageDialog(null, "OK");
			} catch (Exception e) {
				
			}
		}
	}
	
	public void loadFile() {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			try {
				MyDrawer.loadLines();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Load Failed");
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		new MySignatureV2();
	}

}
