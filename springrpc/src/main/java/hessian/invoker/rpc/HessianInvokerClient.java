package hessian.invoker.rpc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rpc.common.User;
import rpc.common.UserService;

/**
 * @author sailfish
 * @create 2017-12-31-下午12:02
 */
public class HessianInvokerClient {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("hessian-rpc-client.xml");
        UserService userServiceHessianProxy = (UserService) context.getBean("userServiceHessianProxy");
        User user = userServiceHessianProxy.findByName("kongxuan");
        System.out.println("name:" + user.getName() + ",email:" + user.getEmail());   //name:kongxuan,email:kongxuan@163.com

    }
}
