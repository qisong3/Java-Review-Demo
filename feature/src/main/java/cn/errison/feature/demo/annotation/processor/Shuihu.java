package cn.errison.feature.demo.annotation.processor;

@BookFactory(author = "Shi nai an", sn = "2222222")
public class Shuihu implements Book {


    @Override
    public void read() {
        System.out.println("Shui Hu Zhuan");
    }
}
