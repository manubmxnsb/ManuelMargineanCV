package ex1;

import javax.swing.*;

class CounterX extends Thread{
    int size;
    JProgressBar pBar;

    CounterX(int s, int priority){
        this.size = s;
        pBar = new JProgressBar(0,size);
        pBar.setStringPainted(true);
        this.setPriority(priority);

    }

    JComponent getProgressBar(){return pBar;}

    public void run(){
        for(int i=0;i<=size;i++){
            try {Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pBar.setValue(i);
        }
    }
}