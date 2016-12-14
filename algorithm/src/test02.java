/**
 * Created by lenovo on 2016/12/11.
 */
public class test02 {

    public static String replaceToInt(String str, char_item item[]){
        for(int i=0;i<item.length;i++){
            str.replace(item[i].c,item[i].value);
        }
        return str;
    }

    public static  void main(String arg[]){
        String str="wwwdot";
        System.out.println(str.replace('w','1'));
    }
}
