package EffectiveJava;

/**
 * Created by lenovo on 2016/12/21.
 * 当类实现接口时，接口就可以充当引用这个类的实例
 */
abstract class num18_abstract{
    public abstract  void say();
}

class num18_comcrete extends num18_abstract{
    @Override
    public void say() {
        System.out.println("hello");
    }
}

public class num18 {
    public static num18_abstract initAbstract(){
        return new num18_comcrete() {
            @Override
            public void say() {
                System.out.println("hello 1");
            }
        };
    }
    public static void main(String arg[]){
        initAbstract().say();
    }
}
