package cn.errison.feature.demo.annotation.processor;

@BookFactory(author = "施耐庵", sn = "2222222")
public class Shuihu implements Book {


    @Override
    public void read() {
        System.out.println("水浒传");
    }
}
