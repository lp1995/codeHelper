package EffectiveJava;

/**
 * Created by lenovo on 2016/12/15.
 * 避免调用终结方法
 *
 * 终结方法：
 * 当一个对象不被引用，并被垃圾回收装置回收的时候，就会调用对象的finalize方法。
 * 缺点：不稳定，你不清楚系统什么时候会调用finalize
 *
 */
//TODO
class  num7_person{
    public int data;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalized");
    }
}

public class num7 {
    public static void main(String arg[]){
        num7_person p = new num7_person();
        p=null;
        System.gc();//调用java垃圾回收装置

    }

}
