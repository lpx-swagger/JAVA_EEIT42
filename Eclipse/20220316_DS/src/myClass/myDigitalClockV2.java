package myClass;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class myDigitalClockV2 extends JLabel {

	private Timer timer;
	private ClockTask clockTask;
	int hh, mm, ss;
	
	
	public myDigitalClockV2() {
		timer = new Timer();
		clockTask = new ClockTask();
		timer.schedule(clockTask, 0, 1*1000);
	}
	
	private class ClockTask extends TimerTask {
		@Override
		public void run() {
			Calendar now = Calendar.getInstance();
			int hh = now.get(Calendar.HOUR_OF_DAY);
			int mm = now.get(Calendar.MINUTE);
			int ss = now.get(Calendar.SECOND);
			setText(String.format("%02d:%02d:%02d", hh, mm, ss));
		}
	}

}
