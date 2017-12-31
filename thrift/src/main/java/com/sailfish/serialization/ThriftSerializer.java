package com.sailfish.serialization;

import com.sailfish.thrift.service.User;

import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

/**
 * @author sailfish
 * @create 2017-12-29-上午7:58
 */
public class ThriftSerializer {

    private ThriftSerializer() {
    }

    public static void main(String[] args) throws TException {
        User user = new User();
        user.setEmail("kongxuan@163.com");
        user.setName("kongxuan");

        //序列化
        byte[] data = ThriftSerializer.serialize(user);
        //反序列化
        User newUser = ThriftSerializer.deserialize(data, User.class);
        System.out.println("email:" + newUser.getEmail() + " name:" + newUser.getName());
    }


    public static byte[] serialize(TBase obj) {
        try {
            TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
            return serializer.serialize(obj);
        } catch (TException e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> T deserialize(byte[] data, Class<?> cls) {
        try {
            TBase o = (TBase) cls.newInstance();
            TDeserializer tDeserializer = new TDeserializer();
            tDeserializer.deserialize(o, data);
            return (T) o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
