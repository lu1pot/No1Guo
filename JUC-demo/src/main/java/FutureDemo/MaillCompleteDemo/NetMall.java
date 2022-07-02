package FutureDemo.MaillCompleteDemo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class NetMall {


    private String netMallName;

    public String getNetMallName() {
        return netMallName;
    }

    public void setNetMallName(String netMallName) {
        this.netMallName = netMallName;
    }

    public NetMall(String netMallName){
        this.netMallName = netMallName;
    }

    public double handlePrice(String productName){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0); /*模拟书的价格*/
    }
}
