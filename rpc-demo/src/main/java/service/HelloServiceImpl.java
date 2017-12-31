package service;

/**
 * @author sailfish
 * @create 2017-12-30-下午8:21
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String content) {
        return "hello," + content;
    }
}