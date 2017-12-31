package invoke;

import framework.ProvideReflect;
import service.HelloService;
import service.HelloServiceImpl;

/**
 * @author sailfish
 * @create 2017-12-30-下午8:40
 */
public class ProviderMain {

    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        ProvideReflect.provider(helloService, 8083);

    }
}
