package cn.errison.feature.demo.annotation;

import java.lang.reflect.Method;

public class Demo1 {

    @CopyRight(author = "Errison")
    public void methodWithAnnotation() {
        System.out.println("this is a annotation tag method");
    }

    public String getAnnotation() throws Exception {
        Method method = this.getClass().getMethod("methodWithAnnotation");
        CopyRight copyRight = method.getAnnotation(CopyRight.class);
        return copyRight.author();
    }


    public static void main(String[] args) throws Exception {
        System.out.println("author of this method is " + new Demo1().getAnnotation());
    }


}
