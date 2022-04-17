package Generator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import myClass.MyDrawer;
import myClass.myDigitalClock;

public class MyPainter extends JFrame {
	
	// Field
	private JButton clear, redo, undo, saveImg, saveObj, loadObj, color;
	private MyDrawer md;
	private myDigitalClock mdc;
	
	// constructor 
	public MyPainter() {
		super("My Painter");
		
		mdc = new myDigitalClock();
		clear = new JButton("Clear");
		redo = new JButton("Redo");
		undo = new JButton("Undo");
		saveImg = new JButton("saveToImg");
		saveObj = new JButton("save Object");
		loadObj = new JButton("load Object");
		color = new JButton("Color");
		md = new MyDrawer();
		
		setSize(840, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		layoutView();
		
		setEvent();
	}
	
	
	public void layoutView() {
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		add(top, BorderLayout.NORTH);
		
		top.add(clear);	top.add(redo); top.add(undo); 
		top.add(saveImg); top.add(saveObj); top.add(loadObj); top.add(color); top.add(mdc);
		
		add(md, BorderLayout.CENTER);
	}
	
	
	public void setEvent() {
//		clear.addActionListener(this);
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
		
		saveImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveImg();
			}
		});
		
		saveObj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObj();
			}
		});
		
		loadObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObj();
				
			}
		});
		
		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showColorDialog();
			}
		});
	} 
	
	private void clear() {
		md.clear();
	}
	private void undo() {
		md.undo();
	}
	private void redo() {
		md.redo();
	}
	
	private void saveImg() {
		BufferedImage img = new BufferedImage( 
				md.getWidth(), md.getHeight(), 
				BufferedImage.TYPE_INT_RGB);
		Graphics g = img.createGraphics();
		md.paint(g);
		
		try {
			ImageIO.write(img, "jpg", new File("./io/chloe.jpg")); // 上面先寫渲染的動作，這行再用 ImageIO 把他灌出去 
			
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	
	public void saveObj() {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			try {
				md.saveLines(file);
				JOptionPane.showMessageDialog(null, "Save OK!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Load Failed");
			}
		}
	}
	
	public void loadObj() {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			try {
				md.loadLines(file);
				JOptionPane.showMessageDialog(null, "Load Successfully");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Load Failed");
			}
		}
	}
	
	public void showColorDialog() {
		//Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.GREEN);
		Color newColor = JColorChooser.showDialog(null, "Choose a color", md.getDefaultColor());
		if (newColor != null) {
			md.setDefaultColor(newColor);
		}
	}
	
	public static void main(String[] args) {
		new MyPainter();
		
		/* Method1: 3個人都叫你聽，如何區分？
		   System.out.println(e.getActionCommand());
		   全部誰聽？ 我本人 setListener() 聽 */ 
	}

}
