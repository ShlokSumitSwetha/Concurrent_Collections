package Complete_Concurrent_Collections.immutable;

import java.util.Date;

public class Immutable3 {
	private  int immutable_int=0;
	private final String immutable_string;
	private  Date mutable_date;
	private Mutable mutable;
	
	private Immutable3(int intValue,String string,Date date,Mutable m){
		this.immutable_int=intValue;
		this.immutable_string=string;
		// copy the values to original
		this.mutable_date = new Date(date.getTime());
		this.mutable=new Mutable(m.i);
		
	}
	
	public static Immutable3 getInstance(int intValue,String string,Date date,Mutable m){
		return new Immutable3(intValue,string,date,m);
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
	public Mutable getMutable(){
		return new Mutable(mutable.i);
	}
}
