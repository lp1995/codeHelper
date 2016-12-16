package EffectiveJava;

/**
 * Created by lenovo on 2016/12/16.
 * 覆盖equals时总要覆盖hashcode
 * 如果没有覆盖hashcode，会导致基于一系列散列操作失效，hashmap hashset hashtable
 *
 * 一个类的hashcode特性
 * 1、每次调用hashcode的值都一样
 * 2、equals 判断是true的话，那么hashcode返回必须产生同样的值
 * 3、如果equals不等，那么产的hashcode要尽可能不等，否则会降低性能
 */

class num9_PhoneNumber{
    private int areaCode;
    private int prefix;
    private int lineNumber;

    private volatile int hashCode;

    public num9_PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }


    /**
     * 如何编写hashcode
     * 1、确定equeal的域，equals函数中对那些变量进行相等比较
     * 2、对每个域进行hashcode计算，不同类型的域有不同的计算方法，具体可以查阅effectivejava或网上
     */
    @Override
    public int hashCode() {
        int result = hashCode;
        if(result==0){
            result = 17;
            result = result *31 + areaCode;
            result = result *31 + prefix;
            result = result *31 + lineNumber;
            hashCode = result;
        }
        return  result;

    }
}

public class num9 {

}
