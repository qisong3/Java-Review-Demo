package cn.errison.feature.demo.proxy.dynamic;

import java.lang.reflect.Proxy;

public class ProxyFactory {

	public static Object newInstance(Object ob) {
		return Proxy.newProxyInstance(ob.getClass().getClassLoader(),
				new Class<?>[] { Task.class, Job.class }, new MyInvocationHandler(ob));
	}


	public static void main(String[] args) {
		Task task = (Task)ProxyFactory.newInstance(new TaskImpl());
		task.setData("Test");
		System.out.println(task.getCalData(new Integer(50)));
	}

}