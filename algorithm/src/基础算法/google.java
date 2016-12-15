package 基础算法;
/**
 * 穷举算法算 计算  wwwdot - google = dotcom
 */

/**
 * char_value 存的是使用的数字表
 * used 用来判断是否使用过
 * value 表示该字符对应的值
 */
class char_value{
    public boolean used;
    public char value;

    public char_value(boolean used, char value) {
        this.used = used;
        this.value = value;
    }
}
/**
 * char_item 是用来存储未知数
 * c表示未知数的字符表示
 * value表示字符的值，从char_value中获取
 * leading 判断是否是数首
 */
class char_item{
    public char c;
    public char value;
    public boolean leading;

    public char_item(char c, char value, boolean leading) {
        this.c = c;
        this.value = value;
        this.leading = leading;
    }
}

public class google {
    public static int max_number = 9;
    public static void checkAnswer( char_item item[] ){
        String a = "wwwdot";
        String b = "google";
        String c = "dotcom";
        String one = replaceToInt(a,item);
        String two = replaceToInt(b,item);
        String three = replaceToInt(c,item);
        if((Integer.valueOf(one)-Integer.valueOf(two)) == Integer.valueOf(three)){
            System.out.println(one+" - " + two + " = "+three);
        }
    }
    public static String replaceToInt(String str, char_item item[]){
        for(int i=0;i<item.length;i++){
            str = str.replace(item[i].c , item[i].value);
        }
        return str;
    }

    public static boolean isValueValid(char_item aItem,char_value aValue){
        if(aItem.leading==true){
            if(aValue.value=='0'){
                return false;
            }
        }
        if(aValue.used==true){
            return false;
        }
        return true;
    }

    public static void SearchingResult(char_item item[], char_value value[],int index ){
        //检查结果
        if(index == max_number ){
            checkAnswer(item);
            return;
        }
        for(int i=0; i < value.length ; i++){
            if(isValueValid(item[index],value[i])){
                value[i].used = true;
                item[index].value = value[i].value;
                SearchingResult(item,value,index+1);
                value[i].used = false;
            }
        }
    }
     public static void  main(String arg[]) {
        char_item item[] = new char_item[9];
         item[0] = new char_item('w','x',true);
         item[1] = new char_item('d','x',true);
         item[2] = new char_item('o','x',false);

         item[3] = new char_item('t','x',false);
         item[4] = new char_item('g','x',true);
         item[5] = new char_item('l','x',false);

         item[6] = new char_item('e','x',false);
         item[7] = new char_item('c','x',false);
         item[8] = new char_item('m','x',false);

         char_value value[]= new char_value[10];
         value[0] = new char_value(false,'0');
         value[1] = new char_value(false,'1');
         value[2] = new char_value(false,'2');

         value[3] = new char_value(false,'3');
         value[4] = new char_value(false,'4');
         value[5] = new char_value(false,'5');

         value[6] = new char_value(false,'6');
         value[7] = new char_value(false,'7');
         value[8] = new char_value(false,'8');
         value[9] = new char_value(false,'9');
         SearchingResult(item,value,0);

    }
}