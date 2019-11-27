package com.xiaoyu.javasample;

class Person {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class MyClass {
    public static void main(String[] args) {
        int[] arr = new int[20];
        arr[10] = 10;
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
//        for (int i : arr) {
//            if (arr[i] == 10) return;
//            //System.out.println(i);
//        }
        int i = 0;
        for (int value = arr[i]; value < 10; value = arr[++i]) {
            System.out.println(value);

        }
    }


}
