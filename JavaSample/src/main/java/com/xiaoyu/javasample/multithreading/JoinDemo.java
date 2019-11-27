package com.xiaoyu.javasample.multithreading;

public class JoinDemo {

    /**
     * join是thread的方法.
     * 在本例子中.在thread2中  加入  thread1.join().
     * 造成的结果就是 thread2 等待thread1 执行完毕后,thread2才会继续执行.
     */
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            System.out.println("print=====>" + i);
        }
    }

    public void fly() {
        for (int i = 0; i < 10_000; i++) {
            System.out.println("println=====>" + i);
        }

    }

    public static void main(String[] args) {
        final JoinDemo waitDemo = new JoinDemo();
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitDemo.run();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitDemo.fly();
            }
        });
        thread1.start();
        thread2.start();
    }
}
