package cn.errison.feature.demo.executorservice;

import java.util.concurrent.*;

public class Demo {

    private static void execute() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(getRunnable());
        Future<String> stringFuture = service.submit(getCallable());
        System.out.println(stringFuture.get());
    }

    private static Runnable getRunnable(){
        Runnable runnable = () ->{
            System.out.println("I am a job");
        };
        return runnable;
    }

    private static Callable<String> getCallable(){
        Callable callable = new Callable() {
            @Override
            public String call() throws Exception {
                return "return null";
            }
        };
        return callable;

    }

    public static void main(String[] args) throws Exception{
        execute();
    }
}
