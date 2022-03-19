package ThreadS多线程;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
验证ConcurrentHashMap
* */
public class VerifyConcurrentHashMap {
    public static final Map<String,Integer> map = new ConcurrentHashMap<>();
    public static void main(String [] args ) throws InterruptedException {
        for (int i = 1; i <= 1000; i++) {
            new Thread(()->{
                while(true){
                    Integer test = map.get("test");
                    if (test == null){
                        if (map.putIfAbsent("test",1) == null)
                            break;
                    }
                    else{
                        if (map.replace("test",test,test+1))
                            break;
                    }
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(map.get("test"));
    }

}
