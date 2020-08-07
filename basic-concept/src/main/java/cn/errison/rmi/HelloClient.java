package cn.errison.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 客户端启动类
 * 
 * @author andy
 *
 */
public class HelloClient {


    public static void main(String args[]) {
        try {
            // 在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法
            IHello remoteHello = (IHello) Naming.lookup("rmi://localhost:8888/RHello");// 构造user对象，测试远程对象传输
            UserBean user = new UserBean();
            user.setAge(20);
            user.setName("andy");
            System.out.println("-------------- 服务端返回的的user为" + remoteHello.updateUser(user).toString());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}