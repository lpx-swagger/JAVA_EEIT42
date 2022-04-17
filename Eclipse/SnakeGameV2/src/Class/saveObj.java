package Class;

import java.io.File;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class saveObj() {
	JFileChooser jfc = new JFileChooser();
	if(jfc.showDialog(jfc, null)==JFileChooser.APPROVE_OPTION) {
		File file = jfc.getSelectedFile();
		ObjectOutputStream oout = new ObjectOutputStream();
		JOptionPane.showMessageDialog(null, "Save success!!!");
	}
}

class int[] getSnakeCoori() {
	int[] coo = {snakeX, snakeY};
	return coo;
}