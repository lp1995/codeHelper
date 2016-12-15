package EffectiveJava;

import java.util.Objects;

/**
 * Created by lenovo on 2016/12/15.
 * 消除过期的对象引用
 *
 * 举例：内存泄漏
 */

class num6_stack{
    private Objects element[];
    private int size;

    public num6_stack() {
        this.element = new Objects[10];
        this.size = 0;
    }

    /**
     * 先push然后pop，size之后的元素不会清空，占用空间，最好消除引用
     *
     */

    public void push(Objects e){
        element[size] = e;
        size +=1;
    }
    //错误
    public Objects popWrong(){
        size-=1;
        return element[size];
    }

    //正确
    public Objects pop(){
        size -=1;
        Objects o=element[size];
        element[size] = null;
        return o;

    }
}

public class num6 {
    public static void main(String arg[]){
        System.out.println();
    }
}
