import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// JFrame 比 Frame 還強大

public class JFRAME01 extends JFrame {

    public static void main(String[] args) {
        new JFRAME01(); // 只要看到 new 之後的就是 object
    }

    public JFRAME01() {
        super("My first Frame");
        this.getContentPane().setLayout(new FlowLayout());
        JLabel label = new JLabel("Chloe's sooooo pretty!!!");
        label.setOpaque(true);
        label.setBackground(Color.YELLOW);
        add(label);
        setVisible(true);


        // display window
        //Frame jf01 = new Frame();
        setSize(380, 480);
        setBackground(Color.BLUE);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setType()
        //System.exit(0);        
    }
}





