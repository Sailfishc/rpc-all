package framework;

import org.apache.commons.lang3.reflect.MethodUtils;

import sun.reflect.misc.MethodUtil;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sailfish
 * @create 2017-12-30-下午8:31
 */
public class ProvideReflect {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();


    public static void provider(final Object service, final int port) throws Exception {

        if (service == null || port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Illegal param.");
        }

        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            final Socket socket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        try {

                            try {

                                //method name
                                String methodName = input.readUTF();
                                //method arguments
                                Object[] arguments = (Object[]) input.readObject();

                                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                                try {
                                    //method invoke
                                    Object result = MethodUtils.invokeExactMethod(service, methodName, arguments);
                                    output.writeObject(result);
                                } catch (Throwable throwable) {
                                    output.writeObject(throwable);
                                } finally {
                                    output.close();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                input.close();
                            }

                        } finally {
                            socket.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
