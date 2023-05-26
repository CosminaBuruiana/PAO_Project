package ro.pao.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;


public class ThreadExecuter implements Runnable {
    private final static int queueSize = 20;
    private final static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(queueSize);
    private final static AtomicBoolean stop = new AtomicBoolean(false);
    private final static ThreadExecuter singleton = new ThreadExecuter();
    private final static Thread executer = new Thread(getInstance());

    public static ThreadExecuter getInstance()
    {
        return singleton;
    }
    
    public void start()
    {
        executer.start();
    }

    public void join()
    {
        try {
            executer.join();
        } catch (InterruptedException e) {
            // can't be async
            e.printStackTrace();
        }
    }

    public void stop()
    {
        // In main thread:
        stop.set(true);
        add(() -> {});
    }

    @Override
    public void run() {
        // In executer thread:
        while (!stop.get()) {
            try {
                queue.take().run();
            } catch (InterruptedException e) {
                // can't be async
                 e.printStackTrace();
            }
        }
    }
    public void add(Runnable task)
    {
        queue.add(task);
    }
}
