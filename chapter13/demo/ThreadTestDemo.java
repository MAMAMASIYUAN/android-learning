import java.lang.*;

public class ThreadTestDemo {

    public static void main(String args[]) {
        RunnableDemo R1 = new RunnableDemo( "Runnable-Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo( "Runnable-Thread-2");
        R2.start();

        ThreadDemo T1 = new ThreadDemo( "Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo( "Thread-2");
        T2.start();
    }
}

class RunnableDemo extends SomeClass implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo( String name) {
        threadName = name;
        System.out.println("创建了线程 " +  threadName );
    }

    public void run() {
        Methods.DoSomething(threadName);
    }

    public void start () {
        System.out.println("线程启动了 " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

class ThreadDemo extends Thread implements SomeInterface {
    private Thread t;
    private String threadName;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("创建了线程 " +  threadName );
    }

    public void run() {
        Methods.DoSomething(threadName);
    }

    public void start () {
        System.out.println("线程启动了 " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

class Methods {
    public static void DoSomething(String threadName) {
        System.out.println("线程正在运行 " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("线程： " + threadName + ", " + i);
                // 让线程睡醒一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("线程： " +  threadName + " 被中断了");
        }
        System.out.println("线程： " +  threadName + " 退出");
    }
}