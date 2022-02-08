package ex3;

import ex1.Counter;

public class Counter1 extends Thread {
    private int startInt;
    private int endInt;
    private Counter1 c;
    Counter1(String name, int startInt, int endInt){
        super(name);
        this.startInt = startInt;
        this.endInt = endInt;
    }
    Counter1(String name, int startInt, int endInt, Counter1 counter){
        super(name);
        this.startInt = startInt;
        this.endInt = endInt;
        this.c = counter;
    }
    @Override
    public void run(){
        System.out.println(getName() + "Starting process : ");
        if(c != null) {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=startInt;i<endInt;i++){
            System.out.println(getName() + " i = "+i);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " job finalised.");
    }

    public static void main(String[] args) {
        Counter1 c1 = new Counter1("counter1",0,11);
        Counter1 c2 = new Counter1("counter2",11,21,c1);
        c1.start();
        c2.start();
    }

}
