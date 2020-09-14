package cn.errison.feature.demo.annotation.processor;

@BookFactory(author = "罗贯中", sn = "111111")
public class Sanguo implements Book {
    
    @Override
    public void read() {
        System.out.println("三国演义");
    }
}
