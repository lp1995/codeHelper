package EffectiveJava;

/**
 * Created by lenovo on 2016/12/21.
 * 可以使用静态导入来省区创建实例
 * import static ...
 *
 */
class num19_constant{
    public num19_constant() {
    }
    public static final double X_VALUE = 1.0;
}

public class num19 {
    public static void main(String arg[]){
        System.out.println(new num19_constant().X_VALUE);
    }
}
