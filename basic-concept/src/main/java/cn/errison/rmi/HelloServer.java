package cn.errison.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 服务端启动类
 * 
 *
 *
 */
public class HelloServer {

    public static void main(String args[]) {
        try {
            // 本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少
            LocateRegistry.createRegistry(8888);
            IHello remoteHello = new HelloImpl();
            // 把远程对象注册到RMI注册服务器上，并命名为RHello
            // 绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的）
            Naming.bind("rmi://localhost:8888/RHello", remoteHello);
            // Naming.bind("//localhost:8888/RHello",rhello);
            System.out.println("------------远程对象IHello注册成功，等待客户端调用...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}