package Complete_Concurrent_Collections.concurrentcollectionmap;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentHashMapTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
    	ConcurrentMap map=new ConcurrentHashMap();
    	for(int i=0;i<10;i++){
            map.put(i,"static"+i);
    	}
        // two threads are created one for reading and one for  writing        
    	//User Views the list
        for(int i=0;i<10;i++){
     	   new Thread(new Viewer(map,"thread"+i)).start();
        }
   
  
    	new Thread(new Adder(map)).start();
        
        
        
       
    }

    static class Adder implements Runnable{

        private ConcurrentMap map;
        public  Adder(ConcurrentMap map) {
            this.map = map;
        }
        @Override
        public void run() {
        	
            for(int i=0;i<20;i++){
               
            	if(map.get(i)==null){
            		map.putIfAbsent(i,"Updated"+i);
            	}
            }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

    }

    static class Viewer implements Runnable{

        private ConcurrentMap map;
        private String threadName;
        public  Viewer(ConcurrentMap map,String threadName) {
            this.map = map;
            this.threadName=threadName;
        }
        @Override
        public void run() {
        	 for(int i=0;i<20;i++){
        		 System.out.println("reading"+threadName+"="+map.get(i));
        	 }

        }

    }
}