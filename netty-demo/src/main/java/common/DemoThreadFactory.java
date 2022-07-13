package common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoThreadFactory implements ThreadFactory {
    AtomicInteger ai = new AtomicInteger(0);
    String prefix = "";

    public void MyThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(prefix + ai.getAndIncrement());
        return thread;
    }
}
