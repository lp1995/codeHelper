package EffectiveJava;

/**
 * Created by lenovo on 2016/12/15.
 * 通过私构造器强化不可实例化的能力
 * 用途：
 * 一些类包含静态变量和静态成员函数，不需要被实例化
 *
 */

class PersonUtils{
    public static void print(){
        System.out.println("i am a person !");
    }
    //申明为私有防止被实例化
    private PersonUtils(){
        //防止在类的内部错误调用
        throw new AssertionError();
    }
}

public class num4 {

    public static void main(String arg[]){
        PersonUtils.print();
    }
}
