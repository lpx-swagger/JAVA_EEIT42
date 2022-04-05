package Generator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyEditor extends JFrame {
	private JButton openBtn, saveBtn, saveAsBtn;
	private JTextArea textArea;
	private File openFile;
	public MyEditor() {
		super("PEI-XUAN LU's Editor");
		openBtn = new JButton("Open");
		saveBtn = new JButton("Save");
		saveAsBtn = new JButton("Save as");

		textArea = new JTextArea();

		layoutView();
		setEvent();
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void layoutView() {
		setLayout(new BorderLayout());

		JPanel top = new JPanel(new FlowLayout());

		top.add(openBtn); top.add(saveBtn); top.add(saveAsBtn);

		add(top, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
	}

	private void setEvent() {
		openBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});

		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});

		saveAsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveAsFile();
			}
		});
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

	public static void main(String[] args) {
		new MyEditor();
	}

}