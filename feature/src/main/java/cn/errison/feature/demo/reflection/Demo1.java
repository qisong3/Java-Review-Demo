package cn.errison.feature.demo.reflection;

import java.lang.reflect.*;

public class Demo1 {

    public static final String PARENT_CLASS_NAME = "cn.errison.feature.demo.reflection.Person";

    public static final String CHILD_CLASS_NAME = "cn.errison.feature.demo.reflection.Child";

    public static void main(String[] args) throws Exception {
        demo1();
        demo2();
        demo3();
    }

    /**
     * demo1：通过Java反射机制得到类的包名和类名，并构造新的包
     */
    public static void demo1() throws Exception {
        // 1 获得包名和类名
        Person person = new Person();
        System.out.println("写法1，包名：" + person.getClass().getPackage().getName());
        System.out.println("完整类名：" + person.getClass().getName());

        Class<?> class1 = Person.class;
        System.out.println("写法2，包名：" + class1.getPackage().getName() + " , 完整类名：" + class1.getName());

        String name = class1.getClassLoader().getClass().getName();
        System.out.println("类加载器类名：" + name);

        // 构造新的对象
        Class<?> class2 = Class.forName(PARENT_CLASS_NAME);
        Person reflectPerson = (Person) class2.newInstance();
        reflectPerson.setName("Errison");
        reflectPerson.setAge(18);
        System.out.println(reflectPerson.toString());

        // 用构造器构造
        Class<?> class3 = Class.forName(PARENT_CLASS_NAME);
        Constructor<?>[] constructors = class3.getConstructors();
        Person reflectPerson1 = (Person) constructors[0].newInstance();
        reflectPerson1.setName("Tom");
        reflectPerson1.setAge(20);
        System.out.println(reflectPerson1.toString());

        Person reflectPerson2 = (Person) constructors[0].newInstance();
        reflectPerson2.setName("Tom Errison");
        reflectPerson2.setAge(30);
        System.out.println(reflectPerson2.toString());

    }



    /**
     * demo2：通过Java反射机制得到类的一些属性：继承的接口、父类、函数信息、成员信息、类型等
     */
    public static void demo2() throws Exception {
        Class<?> class1 = Class.forName(CHILD_CLASS_NAME);

        //取得父类名称
        Class<?> superclass = class1.getSuperclass();
        System.out.println("Child类的父类名：" + superclass.getName());

        Field[] fields = class1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("类中的成员" + i + "： " + fields[i]);
        }

        //取得类方法
        Method[] methods = class1.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("取得Child类的方法" + i + "：");
            System.out.println("函数名：" + methods[i].getName());
            System.out.println("函数返回类型：" + methods[i].getReturnType());
            System.out.println("函数访问修饰符：" + Modifier.toString(methods[i].getModifiers()));
            System.out.println("函数代码写法： " + methods[i]);
        }

        //取得类实现的接口，因为接口类也属于Class，所以得到接口中的方法也是一样的方法得到哈
        Class<?> interfaces[] = class1.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("实现的接口类名： " + interfaces[i].getName());
        }

        System.out.println("调用无参方法fly()：");
        Method method = class1.getMethod("fly");
        method.invoke(class1.newInstance());

        System.out.println("调用有参方法walk(int m)：");
        method = class1.getMethod("walk", int.class);
        method.invoke(class1.newInstance(), 100);
    }

    /**
     * demo3：通过Java反射机制，通过Java反射机制操作成员变量, set 和 get
     */
    public static void demo3() throws Exception {
        Class<?> class1 = Class.forName(PARENT_CLASS_NAME);
        Object obj = class1.newInstance();
        Field personNameField = class1.getDeclaredField("name");
        personNameField.setAccessible(true); //取消访问检查
        personNameField.set(obj, "OutSide");
        System.out.println("修改属性之后得到属性变量的值：" + personNameField.get(obj));
    }


}

