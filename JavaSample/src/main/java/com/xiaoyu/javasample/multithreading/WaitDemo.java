package com.xiaoyu.javasample.multithreading;

public class WaitDemo {
    //wait() notify() notifyAll()等都是Object的方法
    //默认调用都是this.wait()...
    //如果Object monitor = new Object();当做monitor
    //需要monitor.wait() monitor.notify()...
    //不然会报错IllegalMonitorStateException
    private final Object monitor = new Object();

    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("print=====>" + i);
        }

    }

    public synchronized void fly() {
        for (int i = 0; i < 100; i++) {
            System.out.println("println=====>" + i);
        }
        notifyAll();
    }

    public void sleep() {
        synchronized (monitor) {
            for (int i = 0; i < 100; i++) {
                if (i == 50) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("printlnln=====>" + i);
            }
        }

    }

    public static void main(String[] args) {
        final WaitDemo waitDemo = new WaitDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                waitDemo.run();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                waitDemo.fly();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                waitDemo.sleep();
            }
        }).start();
    }
}
