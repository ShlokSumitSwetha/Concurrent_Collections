package Complete_Concurrent_Collections.delay_queue;
import java.util.concurrent.*;

public class DelayObject implements Delayed{
	private String data;
	private long startTime;
	
	DelayObject(String s, long l){
		this.data=s;
		this.startTime=l;
	}
	

	@Override
	public int compareTo(Delayed o) {
		if(this.startTime<((DelayObject) o).startTime){
			return -1;
		}
		if(this.startTime>((DelayObject) o).startTime){
			return 1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff=startTime-System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	@Override

	public String toString() {

		return "{" +

				"data='" + data + '\'' +

				", startTime=" + startTime +

				'}';

	}


}
