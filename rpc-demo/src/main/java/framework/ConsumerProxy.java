package framework;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author sailfish
 * @create 2017-12-30-下午8:24
 */
public class ConsumerProxy {


    public static <T> T consume(final Class<T> interfaceClass, final String host, final int port) throws Exception {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(host, port);

                try {
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    try {

                        output.writeUTF(method.getName());
                        output.writeObject(args);

                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        try {

                            Object result = input.readObject();
                            if (result instanceof Throwable) {
                                return (Throwable) result;
                            }
                            return result;
                        } finally {

                            input.close();

                        }
                    } finally {
                        output.close();
                    }
                } finally {
                    socket.close();
                }

            }
        });

    }
}
