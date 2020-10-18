package week01;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author guanyushen
 * @date 2020/10/18 19:08
 */

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) {

        try {
            Class<?> cla = new HelloClassLoader().loadClass("Hello");
            Object obj = cla.newInstance();
            Method method = cla.getMethod("hello");
            method.invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] helloBytes = getReallyBytes(name);
        return defineClass(name,helloBytes,0,helloBytes.length);
    }



    private byte[] getReallyBytes(String name) {


        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("src/main/resources/Hello.xlass"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);

        try {
            System.out.println("Available bytes:" + in.available());
            byte[] temp = new byte[1024];
            int size = 0;
            while ((size = in.read(temp)) != -1) {
                out.write(temp, 0, size);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = out.toByteArray();
        for (int i=0;i<bytes.length;i++) {
            int temp = 255 - bytes[i] & 0xff;
            bytes[i] = (byte)temp;
        }
        return bytes;
    }
}
