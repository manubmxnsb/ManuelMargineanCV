package ex1;

public class numberException extends Exception{
    int num;
    public numberException(int number,String msg) {
        super(msg);
        this.num = number;
    }

    int getNum(){
        return num;
    }
}
