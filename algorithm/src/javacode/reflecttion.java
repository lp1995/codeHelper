package javacode;

import java.lang.reflect.Method;

/**
 * Created by lenovo on 2016/12/13.
 * 匈牙利算法 最大匹配 不包含优先级 不是稳定匹配
 */

 interface Person{
    public void say();
}

class  Man  implements Person{
    public void methon1(){
        System.out.println("man public");
    }
    protected void method2(){
        System.out.println("man protected");
    }
    private  void method3(){
        System.out.println("man private");
    }
    @Override
    public void say() {
        System.out.println("man");
    }
}

class StrongMan extends Man {
    public void m1(){
        System.out.println("public");
    }
    protected void m2(){
        System.out.println("protected");
    }
    private  void m3(){
        System.out.println("private");
    }
}
class Woman implements Person{
    @Override
    public void say() {
        System.out.println("Woman");
    }
}

public class reflecttion {

    public static void  test01(){
        try {
            //woman 换成man 就可以很方便的创建man的实例。省去了
            /**
             * Woman woman1 = new Woman();避免修改了大量的代码。为每个类单独编写创建实例的过程。
             * 但是类的实现还是要用的。
             * 相比单独创建 反射实现需要依赖实现同一个接口
             */
            Class class1 =  Class.forName("Woman");
            Person person = (Person)class1.newInstance();

            person.say();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test02(){

        Class p = StrongMan.class;
        /**
         * getMethods只能过去接口、继承、本身的公有变量
         */
        //Method[] methods = p.getMethods();
        /**
         * getDeclaredMethods只能获取方法本身的所有公有私有保护的方法,不能输出接口 继承的方法 输出 m1 m2 m3
         */
        Method[] methods = p.getDeclaredMethods();
        for(int i=0;i<methods.length;i++){
            String methodName = methods[i].getName();
            System.out.println(methodName);

        }
    }
    public static void  main(String arg[]){
        /**
         * method 和 declaredMethod的区别是
         * decalred 只能获取本身的公有私有保护的变量或函数
         * 没有decalred 只能获取公有变量方法，但可以使继承 接口中的
         */
        try {
            Class p = StrongMan.class;
            //say m1 can, m1 m2  method1 method2 method3 cannot
           // String methodName = p.getMethod("method3").getName();
            //m1 m2 m3 can , say method1 2 3 cannot
            String methodName = p.getDeclaredMethod("method2").getName();
            System.out.println(methodName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
