package cn.errison.concurrency.lock;


public class SyncDemo {

    private Integer integer = 0;

    private static Object lock = new Object();

    private Integer lock1 = new Integer(0);
    private Integer lock2 = new Integer(1);

    private  void add() {
        synchronized (lock){
            integer++;
        }
    }

    private void minus() {
        synchronized (lock) {
            integer--;
        }
    }

    private void balance() {
        Thread addThread;
        Thread minusThread;
        for (int i = 0; i < 10000; i++) {
            addThread = new Thread(() -> add());
            addThread.start();
        }
        for (int i = 0; i < 10000; i++) {
            minusThread = new Thread(() -> minus());
            minusThread.start();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        SyncDemo syncDemo = new SyncDemo();
        syncDemo.balance();
        Thread.sleep(5000);
        System.out.println(syncDemo.integer);
    }
}
