package EffectiveJava;

/**
 * Created by lenovo on 2016/12/15.
 * 覆盖equals方法
 * 这一节讲的东西很多我理解的不是很透彻，主要注意几点
 * 自反性 对称性 传递性 一致性 非空性
 */
class num8_person{
    public int data;
    @Override
    public boolean equals(Object obj) {//不能声明为 num8_person obj
        if(!(obj instanceof  num8_person)){
            return  false;
        }
        return this.data==((num8_person) obj).data;
    }
}
public class num8 {

}
