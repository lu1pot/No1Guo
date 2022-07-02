package FutureDemo.CompletableDemo;

import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor xxxPool = new ThreadPoolExecutor(2, 4, 1000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                new NamedThreadFactory("xxx"));
/*
        corePoolSize:指定了线程池中的线程数量，它的数量决定了添加的任务是开辟新的线程去执行，还是放到workQueue任务队列中去；
        maximumPoolSize:指定了线程池中的最大线程数量，这个参数会根据你使用的workQueue任务队列的类型，决定线程池会开辟的最大线程数量；
        keepAliveTime:当线程池中空闲线程数量超过corePoolSize时，多余的线程会在多长时间内被销毁；
        unit:keepAliveTime的单位
        workQueue:任务队列，被添加到线程池中，但尚未被执行的任务；它一般分为直接提交队列、有界任务队列、无界任务队列、优先任务队列几种；
        threadFactory:线程工厂，用于创建线程，一般用默认即可；
        handler:拒绝策略；当任务太多来不及处理时，如何拒绝任务；
        */
/*        CompletableFuture<Void> cf = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },xxxPool);*/

        CompletableFuture<Integer> cf =  CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println(Thread.currentThread().getName() + " 开始处理任务");

                Integer res = ThreadLocalRandom.current().nextInt(50);
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
                return res;
            }
        },xxxPool).whenComplete(new BiConsumer<Integer, Throwable>() {
            @Override
            public void accept(Integer v, Throwable e) {
                if(e==null){
                    System.out.println("计算完成，更新系统updateValue: " + v.intValue());
                }
            }
        }).exceptionally(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable e) {
                e.printStackTrace();
                System.out.println("发生异常: " + e.getCause() + "\t" + e.getMessage());
                return -1;
            }
        });

        System.out.println("Main : 我去忙别的");
        xxxPool.shutdown();
    }
}
