package EffectiveJava;

import javax.lang.model.element.NestingKind;

/**
 * Created by lenovo on 2016/12/15.
 * 简介：方便构造多参数的对象
 *
 * 作用：
 * 不用创建不同参数的构造函数
 * 也不同使用多个set，来初始化变量
 */

interface build<T>{
    public T build();
}

class Person{
    private String name;
    private String age;
    private String gender;
    private String param1;
    private String param2;
    private String param3;
    public static class builder implements build<Person> {
        private String name;
        private String age;
        private String gender;
        private String param1="";
        private String param2="";
        private String param3="";
        public builder(String name, String age, String gender){
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public builder setParam1(String param1){
            this.param1 = param1;
            return this;
        }
        public builder setParam2(String param2){
            this.param2 = param2;
            return this;
        }
        public builder setParam3(String param3){
            this.param3 = param3;
            return  this;
        }

        @Override
        public Person build() {
            return  new Person(this);
        }
    }
    public Person(builder b){
        this.age = b.age;
        this.gender = b.gender;
        this.name = b.name;
        this.param1 = b.param1;
        this.param2 = b.param2;
        this.param3 = b.param3;
    }
    public void print(){
        System.out.println(name +"/"+ age +"/"+gender+"/"+param1+"/"+param2+"/"+param3 );
    }
}

public class num2 {
    public static void main(String arg[]){
        //Person p = new Person.builder("liuepng","age","gender").setParam1("11").setParam2("22").setParam3("33").build();
        //Person p = new Person.builder("liuepng","age","gender").setParam2("22").setParam3("33").build();
        Person p = new Person.builder("liuepng","age","gender").setParam3("33").build();
        p.print();
    }

}
