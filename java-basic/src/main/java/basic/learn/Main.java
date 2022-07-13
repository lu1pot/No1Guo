package basic.learn;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
  public static volatile int vi;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger  ai = new AtomicInteger(0);

//        Object o = new Object();
//        int h = o.hashCode();
//        System.out.println( Integer.toBinaryString(h));
//        System.out.println( Integer.toBinaryString(h >>> 16));
//        System.out.println( Integer.toBinaryString((h) ^ (h >>> 16)));
//
//        System.out.println(  ((h) ^ (h >>> 16)));
//        ReentrantLock reentrantLock = new ReentrantLock(false);
//
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 3000, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10));

        for (int i = 0; i < 10; i++) {
            pool.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    for (int i = 0; i < 100; i++) {
                        vi++;
                    }

                    return false;
                }
            });
        }
        pool.shutdown();
        while (true){
            if(pool.isTerminated()){
                System.out.println(vi);
                break;
            }
        }
    }

}
