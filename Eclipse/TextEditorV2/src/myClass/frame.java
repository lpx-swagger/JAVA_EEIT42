package myClass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;


public class frame extends JFrame {
	private JButton backgroundColorPicker, fontColorPicker, insertPic;
	private JTextArea textArea;
	private File openFile;
	private JMenu fileMenu;
	private JMenuBar menuBar;
	private JMenuItem addSheet, save, saveAs, export, loadText;
	private JComboBox<String> fontComboBox, sizeComboBox, styleComboBox;
	private JToolBar toolPanel;

	
	public frame() {
		super("Text Editor");
		//openBtn = new JButton("Open");
		
		layoutView();
		
		setEvent();
		
		setSize(840, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void layoutView() {
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		// menu bar 
		menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		// text area
		textArea = new JTextArea();
		add(textArea, BorderLayout.CENTER);
		
		// place tool panel on top of the text area
		toolPanel = new JToolBar();
		toolPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		textArea.add(toolPanel, BorderLayout.NORTH);
	}

	// 設定打字區域的字型
	private void setTextAreaFont() {
		fontComboBox = new Jco;
	}
	
	// 設定打字區域的字體大小
	private void setTextAreaFontSize() {
		
	}
	
	// 設定打字區域的字體粗細斜
	private void setTextAreaFontStyle() {
		
	}
	
	// 設定打字區域的背景顏色
	private void setTextAreaBackgroundColor() {
		
	}
	
	// add picture
	private void addPic() {
		
	}
	
	// add tab
	private void addSheet() {
		
	}
	
	// save file
	private void saveFile() {
		try {
			if(openFile != null) {
				FileOutputStream fout = new FileOutputStream(openFile);
				fout.write(textArea.getText().getBytes());
				fout.flush();
				fout.close();
				JOptionPane.showMessageDialog(null, "Save OK!");
			} else {
				saveAsFile();
			}
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	// export data
	private void exportData() {
		
	}
	
	// load data => 
	private void loadData() {
		
	}
	
	// load text
	private void loadText()) {
		
	}
	
	private void setEvent() {
//		openBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				openFile();
//			}
//		});
	}

	private void openFile() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			openFile = jfc.getSelectedFile();
			try { 
				FileInputStream fin = new FileInputStream(openFile);
				byte[] buf = new byte[(int)openFile.length()];  // (int) => the max storge of string editor is 2G
				fin.read(buf);
				fin.close();

				textArea.setText(new String(buf));

			} catch(Exception e) {
				System.out.println(e.toString());
			}

		}
	}

	

	private void saveAsFile() {
		JFileChooser jfc;
		String openDir;

		if(openFile != null) {
			openDir = openFile.getParent();
		} else {
			openDir = ".";  // current path
		}

		jfc = new JFileChooser(openDir);
		if(jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			openFile = jfc.getSelectedFile();
			saveFile();
		}
	}

	private void loadObj() {
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
	
	private void showColorDialog() {
		//Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.GREEN);
		Color newColor = JColorChooser.showDialog(null, "Choose a color", md.getDefaultColor());
		if (newColor != null) {
			md.setDefaultColor(newColor);
		}
	}
}