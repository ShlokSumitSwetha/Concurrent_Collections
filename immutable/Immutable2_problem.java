package Complete_Concurrent_Collections.immutable;

import java.util.Date;

public class Immutable2_problem {
	private int immutable_int=0;
	private final String immutable_string;
	private Date mutable_date;
	
	public Immutable2_problem(int intValue,String string,Date date){
		this.immutable_int=intValue;
		this.immutable_string=string;
		this.mutable_date=date;
	}
	public int getInt(){
		return immutable_int;
	}
	public String getString(){
		return immutable_string;
	}
	public Date getDate(){
		return mutable_date;
	}
}
