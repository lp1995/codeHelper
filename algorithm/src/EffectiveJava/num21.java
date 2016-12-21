package EffectiveJava;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by lenovo on 2016/12/21.
 *  如果一个类要被声明为static的，只有一种情况，就是静态内部类
 *  静态内部类跟静态方法一样，只能访问静态的成员变量和方法，不能访问非静态的方法和属性，但是普通内部类可以访问任意外部类的成员变量和方法
 *  静态内部类可以声明普通成员变量和方法，而普通内部类不能声明static成员变量和方法。
 *  静态内部类可以单独初始化:
 *  Inner i = new Outer.Inner();
 *  普通内部类初始化：
 *  Outer o = new Outer();
 *  Inner i = o.new Inner();
 *
 *  只有类才存在静态的变量 方法只能对静态变量的操作
 *
 */

//类中的成员函数有static函数，调用函数的时候可以不用实例化类
class  A{
    static void say(){
        System.out.println("go");
    }
}

class Host{
    private static class StrLenCmp implements Comparator<String>,Serializable {
        public StrLenCmp() {
        }

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }
        public static final Comparator<String> STRING_COMPARATOR = new StrLenCmp();
        public static Host a = new Host();

}

public class num21 {
    public static void main(String arg[]){
        String a = "111";
        String b = "222";
         Host.STRING_COMPARATOR.compare(a,b);
        A.say();
    }
}

