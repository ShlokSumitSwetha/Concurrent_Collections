package Complete_Concurrent_Collections.executos;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.*;


//Java program to schedule a service which periodically beeps every 1seconds for 20.

class BeeperControl {
private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
static volatile int count=1;
public static void main(String[] args){
beepForAnHour();
}

public static void beepForAnHour() {
	
		final Runnable beeper = new Runnable() {
		public void run() {
			System.out.println("beep"+count);
			count++;
		}
		};
	final ScheduledFuture beeperHandle = scheduler.scheduleAtFixedRate(beeper, 11, 2, TimeUnit.SECONDS);

	scheduler.schedule(new Runnable() {
		public void run() {
		beeperHandle.cancel(true);
		}
	}, 20, TimeUnit.SECONDS);
 }
}