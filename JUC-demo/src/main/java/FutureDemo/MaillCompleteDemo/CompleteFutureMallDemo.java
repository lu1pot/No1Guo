package FutureDemo.MaillCompleteDemo;

import FutureDemo.CompletableDemo.NamedThreadFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompleteFutureMallDemo {
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dd"),
            new NetMall("tb"),
            new NetMall("pdd"),
            new NetMall("tm")
    );

    public static List<String> getPrice(List<NetMall> list, String productName){
      return list.stream().map(new Function<NetMall, String>() {
            @Override
            public String apply(NetMall netMall) {
                String name = netMall.getNetMallName();
                double price = netMall.handlePrice(productName);
                return String.format(productName + " in %s price is %.2f",name,price);
            }
        }).collect(Collectors.toList());
    }

    public static List<String> getPriceByFuture(List<NetMall> list, String productName, Executor executor){
       return list.stream().map(
                netMall ->
                        CompletableFuture.supplyAsync(()-> String.format(productName + " in %s price is %.2f",
                                netMall.getNetMallName(),
                                netMall.handlePrice(productName)),executor)
        ).collect(Collectors.toList())
                .stream()
                .map(s-> s.join())
                .collect(Collectors.toList());
    }

    public static List<String> getPriceLamda(List<NetMall> list, String productName){
        return list.stream().map(netMall ->
                String.format(
                        productName + " in %s price is %.2f",
                        netMall.getNetMallName(),netMall.handlePrice(productName)
                )
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ThreadPoolExecutor xxxPool = new ThreadPoolExecutor(5, 6, 1000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                new NamedThreadFactory("xxx"));

        long startTime = System.currentTimeMillis();
        List<String> list1 = getPriceByFuture(list,"mysql",xxxPool);
        for(String s : list1){
            System.out.println(s);
        }
        long dur = System.currentTimeMillis() - startTime;

        System.out.println("-------- dur " + dur + " mills --------");

        xxxPool.shutdown();
    }
}
