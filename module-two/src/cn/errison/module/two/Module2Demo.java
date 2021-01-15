package cn.errison.module.two;


import cn.errison.module.one.Module1Demo;

public class Module2Demo {

    public static void printModule1Static(){

        Module1Demo module1Demo = new Module1Demo();
        System.out.println(module1Demo.getInstanceString());
        System.out.println(Module1Demo.getStaticInt());
    }


    public static void main(String[] args) {
        printModule1Static();
    }
}
