package com.jiangbo.user.mashibing.classloader;

import com.jiangbo.user.mashibing.jvm.Hello;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 类加载的加密模拟
 * description:
 *  一般class是一个二进制的流，然后自己编译，同时自己加密，这里采用一个笨方法异或；解密时，使用异或解密。 
 *
 * @author chengjiangbo@shandiantech.com
 * @version 1.0.0
 * @date 2020/11/22
 */
public class T007_MSBClassLoaderWithEncryption extends ClassLoader{

  //异或种子值
  private static int seed = 0B101101110;

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    File file = new File("D:\\projects\\personal\\study\\user\\build\\classes\\java\\test\\", name.replace(".", "/").concat(".msbclass"));

    try {
      FileInputStream fis = new FileInputStream(file);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      int b = 0;

      while((b = fis.read()) !=  0){
        baos.write(b ^ seed);
      }

      byte[] bytes = baos.toByteArray();
      baos.close();
      fis.close();

      return defineClass(name, bytes, 0, bytes.length);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return super.findClass(name);
  }


  private static void encFile(String name){

    File file = new File("D:\\projects\\personal\\study\\user\\build\\classes\\java\\test\\", name.replace(".", "/").concat(".class"));

    try {
      FileInputStream fis = new FileInputStream(file);
      FileOutputStream fos = new FileOutputStream(new File("D:\\projects\\personal\\study\\user\\build\\classes\\java\\test\\", name.replace(".", "/").concat(".msbclass")));

      int b= 0;
      while((b = fis.read()) != 0){
        fos.write(b ^ seed);
      }

      fis.close();
      fos.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    encFile("com.jiangbo.user.mashibing.jvm.Hello");

    ClassLoader classLoader = new T007_MSBClassLoaderWithEncryption();
    Class clazz = classLoader.loadClass("com.jiangbo.user.mashibing.jvm.Hello");
    Hello hello = (Hello) clazz.newInstance();
    String result = hello.say("cjb");
    System.out.println(result);

    System.out.println(classLoader.getClass().getClassLoader());
    System.out.println(classLoader.getParent());
  }
}
