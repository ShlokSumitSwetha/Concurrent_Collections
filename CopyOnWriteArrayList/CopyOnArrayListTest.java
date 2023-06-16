package Complete_Concurrent_Collections.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnArrayListTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list=new CopyOnWriteArrayList<>();
        
        // two threads are created one for reading and one for  writing        
        
     // User Adds to the sList
        Adder adder=new Adder();
        adder.setList(list);
        Thread t=new Thread(adder);
        
        //User Views the list
        Viewer viewer=new Viewer();
        viewer.setList(list);       
        Thread t1=new Thread(viewer);
        
        t.start();
        t1.start();

    }

    static class Adder implements Runnable{

        private List<Integer> list;
        public void setList(List<Integer> list) {
            this.list = list;
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                list.add(i);
                System.out.println("Added="+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    static class Viewer implements Runnable{

        private List<Integer> list;
        public void setList(List<Integer> list) {
            this.list = list;
        }
        @Override
        public void run() {
            while (true) {
                System.out.println("Length of list->"+list.size());
                for (Integer i : list) {
                    System.out.println("Reading="+i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}