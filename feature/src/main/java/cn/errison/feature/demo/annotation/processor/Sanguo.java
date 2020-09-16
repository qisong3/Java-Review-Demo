package cn.errison.feature.demo.annotation.processor;

@BookFactory(author = "Luo guan zhong", sn = "111111")
public class Sanguo implements Book {
    
    @Override
    public void read() {
        System.out.println("San Guo");
    }
}
