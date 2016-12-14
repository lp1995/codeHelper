package algorithm;

/**
 * Created by lenovo on 2016/12/13.
 */
class TagMaxMatch{
    public int edge[][]; // 存储关系
    public boolean on_path[];
    public int path[];
    public int max_match;

    public TagMaxMatch(int[][] edge, boolean[] on_path, int[] path, int max_match) {
        this.edge = edge;
        this.on_path = on_path;
        this.path = path;
        this.max_match = max_match;
    }
}


public class hungray_match {
    public static int UNIT_COUNT = 4;

    public static void clearOnPathSign( TagMaxMatch match){
        for(int i=0;i<UNIT_COUNT;i++){
            match.on_path[i]=false;
        }
    }

    public static boolean findAugmentPath(TagMaxMatch match,int index){
        for(int i=0;i<UNIT_COUNT;i++){
            if((match.edge[index][i]==1)&&!match.on_path[i]){
                match.on_path[i] = true;
                if((match.path[i]== -1)||findAugmentPath(match,match.path[i])){
                    match.path[i] = index;
                    return true;
                }
            }
        }
        return  false;
    }

    public static void Hungray_Match(TagMaxMatch match){
        for(int i=0;i<UNIT_COUNT;i++) {
            if (findAugmentPath(match, i)) {
                match.max_match += 1;
            }
            clearOnPathSign(match);
        }
    }

    public static void main(String arg[]){
        /**
         * 测试用例
         */
        int edge[][]= {{1,0,1,0},{1,0,0,0},{1,1,0,0},{0,0,1,1}};
        boolean on_path[] = {false,false,false,false};
        int path[]={-1,-1,-1,-1};
        TagMaxMatch match = new TagMaxMatch(edge,on_path,path,0);
        Hungray_Match(match);
        for(int i = 0;i<4;i++){
            System.out.println("y"+i+":"+"x"+path[i]);
        }

    }

}
