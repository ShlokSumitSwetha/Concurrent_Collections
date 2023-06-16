package Complete_Concurrent_Collections.immutable;

import java.util.Date;

public class Immutable2_solution {
	private  int immutable_int=0;
	private final String immutable_string;
	private  Date mutable_date;
	
	private Immutable2_solution(int intValue,String string,Date date){
		this.immutable_int=intValue;
		this.immutable_string=string;
		// copy the values to original
		this.mutable_date = new Date(date.getTime());
		
	}
	
	public static Immutable2_solution getInstance(int intValue,String string,Date date){
		return new Immutable2_solution(intValue,string,date);
	}
	public int getInt(){
		return immutable_int;
	}
	public String getString(){
		return immutable_string;
	}
	// create new instance and give so that it does not changes the value of originals
	public Date getDate(){
		return new Date(mutable_date.getTime());
	}
}
