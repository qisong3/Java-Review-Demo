package cn.errison.feature.demo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * 定义一个远程接口，必须继承Remote接口，其中需要远程调用的方法必须抛出RemoteException异常
 * 
 * @author andy
 *
 */
public interface IHello extends Remote {

    /**
     * 更新user信息
     * @param user
     * @return
     * @throws RemoteException
     */
    UserBean updateUser(UserBean user) throws RemoteException;
}