package javacode;

/**
 * Created by lenovo on 2016/12/15.
 * static变量的初始化
 *
 */

class static1{
    static {
        //data=5;
        init();
    }
    public static int data=4 ;

    private static void init(){
        data = 6;
    }

}

public class staticTest01 {
    public static void main(String arg[]){
        System.out.println(static1.data);
    }
}
