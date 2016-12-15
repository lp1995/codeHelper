package EffectiveJava;

/**
 * Created by lenovo on 2016/12/15.
 * 用私有构造器或者枚举类型强化singleton属性
 */

class sington1{
    public static final sington1 INSTANCE = new sington1();
    private sington1(){};
    public void print(){
        System.out.println("sington1");
    }
}

class sington2{
    private static final sington2 INSTANCE = new sington2();
    private sington2(){};
    public static sington2 getInstance(){
        return INSTANCE;
    }
    public void print(){
        System.out.println("sington2");
    }
}

enum sington3{
    INSTANCE;
    public void print(){
        System.out.println("sington3");
    }
}

public class num3 {
    public static void main(String arg[]){
        sington1.INSTANCE.print();
        sington2.getInstance().print();
        sington3.INSTANCE.print();
    }
}
