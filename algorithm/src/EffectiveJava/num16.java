package EffectiveJava;

/**
 * Created by lenovo on 2016/12/16.
 * 复合关系
 * 不包含实例，是继承实例
 *
 */

interface human{
    public void say();
}

class people implements human{
    @Override
    public void say() {
        System.out.println("hello");
    }
}

class man extends people{
    private int count=0;
    @Override
    public void say() {
        count+=1;
        super.say();
    }
    public int getCount(){
        return count;
    }
}


public class num16 {
    public static void main(String arg[]){
        man m = new man();
        m.say();
        m.say();
        m.say();
        m.say();
        System.out.println(m.getCount());
    }
}
