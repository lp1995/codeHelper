package EffectiveJava;

import java.util.Objects;

/**
 * Created by lenovo on 2016/12/16.
 * 这个部分将clone()函数，没怎么看懂
 * 只简单的举几个例子
 */
class num11_clone1 {
    public int data;
    public Objects obj[];

    @Override
    protected Object clone() {
        try{
            //可以基础对象数组可以拷贝，obj{] data拷贝
            num11_clone1 result = (num11_clone1)super.clone();
            result.obj = obj.clone();
            return  result;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}

class num11_clone2 implements Cloneable{
    private Entry[] buckets;
    private static class  Entry{
        final Object key;
        Object value;
        Entry next;
        Entry(Object key,Object value,Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy(){
            return new Entry(key,value,next == null?null:next.deepCopy());
        }

        //非递归写法
        Entry deepCopy2(){
            Entry result = new Entry(key,value,next);
            for (Entry p=result;p!=null;p=p.next){
                result.next = new Entry(p.next.key,p.next.value,p.next.next);
            }
            return  result;
        }


    }
    @Override
    public num11_clone2 clone(){
        try{
            num11_clone2 result = (num11_clone2)super.clone();
            result.buckets = new Entry[buckets.length];
            for(int i=0;i<buckets.length;i++){
                if(buckets[i]!=null){
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }
            return  result;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }



}

public class num11
{
    public static void main(){

    }
}
