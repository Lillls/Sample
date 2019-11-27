package com.xiaoyu.javasample.multithreading;

public class YieldDemo {

    /**
     * yield()是Thread的静态方法.
     * 本例子中run,方法中执行Thread.yield();
     * 在执行到Thread.yield()这行代码时,会让出这一次的执行机会,让其他线程执行.
     * 到System.out.println("print=====>" + i);还是会继续抢夺代码执行权限.
     * 并不是暂停,只是让出这次的执行状态,下次还是会抢夺CPU的执行状态.
     * 只会让优先级或者高优先级的线程得到执行机会
     *
     * 所以造成的结果是打印了一大堆"
     * fly=====> 中穿插了
     * run=====>
     */
    public void run() {
        for (int i = 0; i < 10_000_000; i++) {
            Thread.yield();
            System.out.println("run=====>" + i);
        }
    }

    public void fly() {
        for (int i = 0; i < 10_000_000; i++) {
            System.out.println("fly=====>" + i);
        }

    }

    public static void main(String[] args) {
        final YieldDemo waitDemo = new YieldDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitDemo.run();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitDemo.fly();
            }
        });
        thread1.start();
        thread2.start();
    }
}
