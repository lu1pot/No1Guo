package JUCLearn;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class JUCLearn {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        new Thread(futureTask,"thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(futureTask.isDone()){
                        try {
                            System.out.println(Thread.currentThread().getName()+ ": 麻痹,你终于买好了");
                            System.out.println("invoke futureTask.get()  and Result: " + futureTask.get());
                            break;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() +": 怎么还不买好哦");
                }

            }
        },"Thread2").start();

    }



}
class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": in to the MyCallable.call()  我去买水等下哦");
        Thread.sleep(1);
        return "hello";
    }
}