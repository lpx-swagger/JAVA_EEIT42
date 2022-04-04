package Generator;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;


public class chloe76 {
	public static void main(String[] args) {  // 通常 一個 Timer 物件就足夠了
		Timer timer = new Timer();
		myTask mT = new myTask();
		myStop ms = new myStop(timer);
		
		timer.schedule(mT, 0, 3*1000);   // 3 secs
		timer.schedule(mT, 10*1000);// 無論如何10secs就結束
		System.out.println("Main");

	}

}

class myTask extends TimerTask {   // 因為是abstract => 繼承 就可以
	int i;
	@Override
	public void run() {
		System.out.println(i++);
//		cancel();  // 結束任務，非 Timer		
	}
}

class myStop extends TimerTask {  // TimerTask 本身不知到Timer 是誰
	private Timer timer;    // 讓TimerTask 知道Timer是誰，介紹互認識
	myStop(Timer timer) {
		this.timer = timer;
	}
	
	@Override
	public void run() {
		System.out.println("Finish");
		timer.cancel();  // 時間一到了 => 取消Timer
	}
	
}