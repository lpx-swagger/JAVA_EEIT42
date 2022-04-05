package myClass;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class myDigitalClock extends JLabel{
	private Timer timer;
	public myDigitalClock() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Calendar now = Calendar.getInstance();
				int hh = now.get(Calendar.HOUR_OF_DAY);
				int mm = now.get(Calendar.MINUTE);;
				int ss = now.get(Calendar.SECOND);;
				setText(String.format("%2d:%2d:%2d", hh, mm, ss));
			}
		}, 0, 1*1000); // 馬上執行，隔一秒做一次
		// GregorianCalendar => 曆法
	}
	
	private class myTask extends TimerTask {
		@Override
		public void run() {
			
		}
		
	}
	
}
