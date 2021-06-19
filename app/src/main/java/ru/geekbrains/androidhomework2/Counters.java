package ru.geekbrains.androidhomework2;

public class Counters {
    private int counter_1;
    private int counter_2;
    private int counter_3;
    private int counter_4;

    public Counters() {
        this.counter_1 = 0;
        this.counter_2 = 0;
        this.counter_3 = 0;
        this.counter_4 = 0;
    }

    public int getCounter_2() {
        return counter_2;
    }

    public int getCounter_3() {
        return counter_3;
    }

    public int getCounter_4() {
        return counter_4;
    }

    public int getCounter_1() {
        return counter_1;
    }

    public void setCounter_1(int counter_1) {
        this.counter_1 = counter_1;
    }
    public void increaseCounter1(){
        counter_1++;
    }
    public void increaseCounter2(){
        counter_2++;
    }
    public void increaseCounter3(){
        counter_3++;
    }
    public void increaseCounter4(){
        counter_4++;
    }
}
