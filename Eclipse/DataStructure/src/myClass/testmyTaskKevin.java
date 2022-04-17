package myClass;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class testmyTaskKevin extends JLabel{
    private Timer timer;
    private Calendar localTime;
    private MyTask myTask = new MyTask();;

    Calendar timeNow = Calendar.getInstance();
    int hh = timeNow.get(Calendar.HOUR);
    public testmyTaskKevin(){
        System.out.println("hh = "+hh);
        timer = new Timer();
        
        //hh=123;
        System.out.println("hh=123 = "+hh);
        myTask = new MyTask();
        System.out.println("myTask1 = "+getHH());
        
        timer.schedule(myTask, 0, 1*1000); 
        
        System.out.println("myTask2 = "+getHH());
        
        setText(hh+":");   
    }
    
    public class MyTask extends TimerTask{
        @Override
        public void run() {
//            mm = timeNow.get(Calendar.MINUTE);
//            ss = timeNow.get(Calendar.SECOND);
////            setText(hh+":"+mm+":"+ss);
//            System.out.println(getHH());
            
        }      
    }
    
    public int getHH(){
        return hh;
    }
//    public int getMM(){
//        return mm;
//    }
//    public int getSS(){
//        return ss;
//    }
    
    
    
    public static void main(String[] args) {
        JFrame testClock = new JFrame();
        
        testClock.setVisible(true);
        testClock.setSize(640,480);
        testClock.setDefaultCloseOperation(EXIT_ON_CLOSE);
        testClock.add(new testmyTaskKevin());   
    }
}
