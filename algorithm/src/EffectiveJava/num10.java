package EffectiveJava;

/**
 * Created by lenovo on 2016/12/16.
 * 始终要覆盖toString
 */
class num10_person{
    private String name;

    public num10_person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "it is "+name;
    }
}
public class num10 {
    public static void main(String arg[]){
        num10_person p = new num10_person("liupeng");
        System.out.println(p);
        //assert的用法，assert boolean ; assert boolean:表达式; assert true 继续执行，assert false 不会执行后续
        //运行是要加参数 -ea开启
        System.out.println("start");
        assert false;
        System.out.println("end");
    }
}
