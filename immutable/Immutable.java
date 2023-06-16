package Complete_Concurrent_Collections.immutable;

public final class Immutable {
	private int immutable_int=0;
	private String immutable_string;
	
	public Immutable(int intValue,String string){
		this.immutable_int=intValue;
		this.immutable_string=string;
	}
	public int getInt(){
		return immutable_int;
	}
	public String getString(){
		return immutable_string;
	}
}
