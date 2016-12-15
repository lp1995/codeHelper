package EffectiveJava;

/**
 * Created by lenovo on 2016/12/15.
 * 避免创建不必要的对象
 */


class num5_person{
    public static final int oper;
    static {
        //新建实例只创建一次，提高效率
        oper =1;
    }

}

public class num5 {
    public static void main(String arg[]){
        //重复创建一个string实例
        String s = new String("11111");
        //正确
        String s1 = "1111";

        Long sum = 0l;//最好改成long，速度大大提升
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum +=i;//Long MAX_VALUE次调用 Long.valueOf() new 了一个Long对象
        }
        System.out.println(sum);
    }
}
