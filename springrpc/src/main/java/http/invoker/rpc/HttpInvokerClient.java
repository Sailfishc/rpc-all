package http.invoker.rpc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rpc.common.User;
import rpc.common.UserService;

/**
 * @author sailfish
 * @create 2017-12-31-下午12:05
 */
public class HttpInvokerClient {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("httpinvoker-rpc-client.xml");
        UserService userService = (UserService) context.getBean("userServiceProxy");

        User user = userService.findByName("liyebing");
        System.out.println(user.getName() + "   " + user.getEmail());
    }
}
