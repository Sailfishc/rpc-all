package invoke;

import framework.ConsumerProxy;
import service.HelloService;

/**
 * @author sailfish
 * @create 2017-12-30-下午8:41
 */
public class RpcConsumerMain {

    public static void main(String[] args) throws Exception {
        HelloService consume = ConsumerProxy.consume(HelloService.class, "127.0.0.1", 8083);

        for (int i = 0; i < 5; i++) {
            String s = consume.sayHello("hello, sailfish:" + i);
            System.out.println(s);
            Thread.sleep(1000);
        }
    }
}


//hello,hello, sailfish:0
//hello,hello, sailfish:1
//hello,hello, sailfish:2
//hello,hello, sailfish:3
//hello,hello, sailfish:4