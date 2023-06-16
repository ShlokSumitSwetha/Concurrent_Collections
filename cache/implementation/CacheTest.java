package Complete_Concurrent_Collections.cache.implementation;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class CacheTest<K,V>
{
    ReferenceQueue<V> queue = null;
    Map<K,WeakReference<V>> values = null;
    Map<WeakReference<V>,K> keys = null;
    Thread cleanup = null;

    CacheTest ()
    {
        queue  = new ReferenceQueue<V>(); 
        keys   = Collections.synchronizedMap (new HashMap<WeakReference<V>,K>());
        values = Collections.synchronizedMap (new HashMap<K,WeakReference<V>>());
        
        /***** Daemon thread  start**********/
          cleanup = new Thread() {
         
                public void run() {
                    try {
                        while(true){ //infinite loop
                            @SuppressWarnings("unchecked")
                            WeakReference<V> ref = (WeakReference<V>)queue.remove();
                            K key = keys.get(ref);
                            keys.remove(ref);
                            values.remove(key);
                        }
                    }
                    catch (InterruptedException e) {}
                }
            };
        cleanup.setDaemon (true);
        cleanup.start();
        /***** Daemon thread  end **********/
    }

    void stop () {
        cleanup.interrupt();
    }

    V get (K key) {
        return values.get(key).get();
    }

    void put (K key, V value) {
        WeakReference<V> ref = new WeakReference<V>(value, queue);
        keys.put (ref, key);
        values.put (key, ref);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append ("{");
        boolean first = true;
        for (Map.Entry<K,WeakReference<V>> entry : values.entrySet()) {
            if (first)
                first = false;
            else
                str.append (", ");
            str.append (entry.getKey());
            str.append (": ");
            str.append (entry.getValue().get());
        }
        str.append ("}");
        return str.toString();
    }

    static void gc (int loop, int delay) throws Exception
    {
        for (int n = loop; n > 0; n--) {
            Thread.sleep(delay);
            System.gc(); // <- obstinate donkey
        }
    }

    public static void main (String[] args) throws Exception
    {
        // Create the cache
        CacheTest<Employee,EmployeeVal> c = new CacheTest<Employee,EmployeeVal>();
        
        Employee employee=new Employee();
        EmployeeVal empvalue=new EmployeeVal();
        
        Employee employee1=new Employee();
        EmployeeVal empvalue1=new EmployeeVal();
        
        Employee employee2=new Employee("Sumit");
        EmployeeVal empvalue2=new EmployeeVal("TL");


        // Save them in the cache
        c.put (employee, null);
        c.put (employee1 ,empvalue1);
        c.put (employee2, empvalue2);
       

        // Display the cache contents
        System.out.println (c);

        // Erase one value;
        empvalue2 = null;
       // empvalue1=null;

        // Force garbage collection
        gc (10, 10);

        // Display the cache again
        System.out.println (c);

        // Stop cleanup thread
        c.stop();
    }
}