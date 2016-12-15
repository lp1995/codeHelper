package 基础算法;

/**
 * 阿拉伯数字和中文数字
 */


public class numberToChinese {
    public static String chnNumChar[]=new String[]{"零","一","二","三","四","五","六","七","八","九"};
    public static String chnUnitSection[] = new String[]{"","万","亿","万亿"};
    public static String chnUnitChar[] = new String[]{"","十","百","千"};

    public static String NumberToChinese(int num,String chnstr){
        int unitPos = 0;
        String strIns="";
        boolean needZero = false;
        while(num>0){
            int section = num % 10000;
            if(needZero){
                chnstr = chnNumChar[0] + strIns;
            }
            strIns = SectionTochinese(section);

            strIns = (section!=0) ?chnUnitSection[unitPos]:chnUnitSection[0]+strIns;

            needZero = (section<1000)&&(section>0);
            num = num / 10000;
            unitPos +=1;
        }
        return chnstr;
    }

    public static String SectionTochinese(int section){
        String strChn="";
        String strIns="";
        int unitPos=0;
        boolean zero = true;
        while (section>0){
            int v = section%10;
            if(v==0){
                if(!zero){
                    zero = true;
                    strChn=chnNumChar[0]+strChn;
                }
            }else{
                zero = false;
                strIns = chnNumChar[v]+ chnUnitChar[unitPos]+strIns;
                strChn = strIns + strChn;
            }
            unitPos += 1;
            section = section / 10;
        }
        return strChn;
    }

    public static void main(String arg[]){

    }
}
