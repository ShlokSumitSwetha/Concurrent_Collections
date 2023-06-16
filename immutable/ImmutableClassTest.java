package Complete_Concurrent_Collections.immutable;

import java.util.Date;

public class ImmutableClassTest {
public static void main(String[] args) {
	Immutable i=new Immutable(1,"Sumit");
	System.out.println(i.getInt());
	
	Immutable2_problem i2=new Immutable2_problem(1,"Sumit",new Date());
	//Fri Aug 07 14:45:40 IST 2015
	//System.out.println(i2.getDate());
	
	i2.getDate().setDate(28);
	//System.out.println(i2.getDate());// Fri Aug 28 14:45:40 IST 2015
	
	
	Immutable2_solution i3=Immutable2_solution.getInstance(1,"Sumit",new Date());
	//Fri Aug 07 14:45:40 IST 2015
	System.out.println(i3.getDate());
	
	i3.getDate().setDate(22);
	System.out.println(i3.getDate());// Fri Aug 28 14:45:40 IST 2015
	
	Mutable m=new Mutable();
	m.setI(100);
	
	Immutable3 immutable=Immutable3.getInstance(1,"Sumit",new Date(),m);
	
	System.out.println(immutable.getMutable().i);
	
	immutable.getMutable().setI(200);
	
	System.out.println(immutable.getMutable().i);
	
	
}
}
