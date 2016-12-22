package 高级算法;
import java.util.Scanner;

/**
 * Created by liupeng on 2016/12/22.
 * 01背包问题
 * https://hihocoder.com/problemset/problem/1038
 */
public class hiho1038 {
    public static int MAX_COUNT = 100000;
    public static int[] best = new int[MAX_COUNT];

    public static int f1(int value[],int need[],int n,int ticketNum){
        for(int w=0;w<=ticketNum;w++){
            best[w] = 0;
        }
        for(int i=0;i<n;i++){
            for(int wj=ticketNum;wj>=need[i];wj--){
                int a = best[wj];
                int b = best[wj-need[i]]+value[i];
                best[wj] = a>b?a:b;
            }
        }
        return best[ticketNum];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =6000;
        int ticketNum =0;
        int value[] = new int[510];
        int need[] = new int[510];
        int i=-1;
        while(i!=n&&sc.hasNext()){
            String line = sc.nextLine();
            String[] nums = line.split(" ");
            if(i!=-1) {
                need[i] = Integer.valueOf(nums[0]);
                value[i] = Integer.valueOf(nums[1]);
            }else {
                n = Integer.valueOf(nums[0]);
                ticketNum = Integer.valueOf(nums[1]);
            }
            i+=1;
         }
        int result = f1(value,need,n,ticketNum);
        System.out.println(result);


    }

}
