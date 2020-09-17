package cn.errison.feature.demo.executorservice;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Demo1 {

    private static void createForkJoin(){
        //Create ForkJoinPool using the default constructor.
        ForkJoinPool pool = new ForkJoinPool();
        //Create three FolderProcessor tasks. Initialize each one with a different folder path.
        FolderProcessor system = new FolderProcessor("C:\\Windows", "log");
        FolderProcessor apps = new FolderProcessor("C:\\Program Files", "log");
        FolderProcessor documents = new FolderProcessor("C:\\Documents And Settings", "log");
        //Execute the three tasks in the pool using the execute() method.
        pool.execute(system);
        pool.execute(apps);
        pool.execute(documents);
        //Write to the console information about the status of the pool every second
        //until the three tasks have finished their execution.
        do
        {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");
            try
            {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        } while ((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));
        //Shut down ForkJoinPool using the shutdown() method.
        pool.shutdown();
        //Write the number of results generated by each task to the console.
        List<String> results;
        results = system.join();
        System.out.printf("System: %d files found.\n", results.size());
        results = apps.join();
        System.out.printf("Apps: %d files found.\n", results.size());
        results = documents.join();
        System.out.printf("Documents: %d files found.\n", results.size());
    }



    public static void main(String[] args) {
        createForkJoin();
    }
}
