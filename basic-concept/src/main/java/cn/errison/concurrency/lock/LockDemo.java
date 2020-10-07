package cn.errison.concurrency.lock;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {


    private Lock lock = new ReentrantLock(true);

    private Integer integer = new Integer(0);

    private void add() {
        try {
            lock.tryLock();
            integer++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void minus() {
        try {
            lock.tryLock();
            integer--;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void balance() {
        for (int i = 0; i < 100000; i++) {
           add();
           minus();
        }

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        LockDemo demo = new LockDemo();
//        demo.balance();
//        System.out.println(demo.integer);
        String string = "\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47";
        byte[] bytes = string.getBytes("utf-8");

        System.out.println(bytes.length);

    }
}
