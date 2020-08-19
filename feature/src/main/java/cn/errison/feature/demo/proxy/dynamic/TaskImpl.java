package cn.errison.feature.demo.proxy.dynamic;

public class TaskImpl implements Job,Task {

    @Override
    public void setData(String data) {
        System.out.println(data + " Data is saved");
    }

    @Override
    public int getCalData(int x) {
        return x * 10;
    }

    @Override
    public String getCalData(Integer x) {
        return Integer.toBinaryString(x);
    }
}
 