package 基础算法;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lenovo on 2016/12/15.
 * 拓扑排序
 * 每个顶点在序列中只出现一次
 * 每一个顶点有次序
 *
 * 有向图无法从某个定点出发经过若干条边回到该定点，这个图叫做有向五环图
 * aoe
 * aov
 *
 * 对于aov网 邻接表是定义有向图的一个好的方式
 *
 * 关键路径延期将导致活动延期
 * 一个活动的时间余量是0，该活动就是关键路径，时间余量是最晚时间 - 最早时间
 */
//aov 网表示的结构
class tagVertexNode implements Comparable<tagVertexNode>{
    public String name;

    @Override
    public int compareTo(tagVertexNode o) {
        return  o.sTime - sTime;
    }

    public int day;
    public int sTime;
    public int inCount;
    public int adjacent;
    public int adjacentNode[];

    public tagVertexNode(String name, int day, int sTime, int inCount, int adjacent, int[] adjacentNode) {
        this.name = name;
        this.day = day;
        this.sTime = sTime;
        this.inCount = inCount;
        this.adjacent = adjacent;
        this.adjacentNode = adjacentNode;

    }
}

class tagGraph{
    public int count=0;
    public tagVertexNode vertex[];
}

public class TopologicalSorting {

    public static int MAX_VERTEX = 9;

    //拓扑排序算法
    public static boolean topoLogicalSorting(tagGraph g) {
        ArrayList<tagVertexNode> queue = new ArrayList<tagVertexNode>();
        //找到入度为0的所有点
        for (int i = 0; i < MAX_VERTEX; i++) {
            if (g.vertex[i].inCount == 0) {
                queue.add(g.vertex[i]);
            }
        }
        while (!queue.isEmpty()) {
            //排序按照从大到小排序
            Collections.sort(queue);
            //取最后一个stime小的节点，然后remove 因为这样，复杂度低,相比从小到大排序。
            tagVertexNode node = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);

            //记录
            g.count += 1;
            System.out.println(node.name);
            for (int j = 0; j < node.adjacent; j++) {
                tagVertexNode ajacentNode = g.vertex[node.adjacentNode[j]];
                ajacentNode.inCount -= 1;

                //巧妙的一个方法，在这判断你是否有入度为0的节点，不用重新查询
                if (ajacentNode.inCount == 0) {
                    queue.add(ajacentNode);
                }
            }
        }

        if (g.count == MAX_VERTEX) {
            return true;
        }else{
            return false;
        }
    }

    public  static  void  main(String arg[]){
        tagGraph g = new tagGraph();
        tagVertexNode node[] = new tagVertexNode[10];
        node[0] = new tagVertexNode("n0",8,0,0,2,new int[]{6,2});
        node[1] = new tagVertexNode("n1",5,0,0,2,new int[]{4,2});
        node[2] = new tagVertexNode("n2",6,8,2,1,new int[]{3});
        node[3] = new tagVertexNode("n3",4,14,1,2,new int[]{5,8});
        node[4] = new tagVertexNode("n4",7,5,1,1,new int[]{5});
        node[5] = new tagVertexNode("n5",7,18,2,0,new int[]{});
        node[6] = new tagVertexNode("n6",4,8,1,1,new int[]{7});
        node[7] = new tagVertexNode("n7",3,12,1,1,new int[]{8});
        node[8] = new tagVertexNode("n8",4,18,2,0,new int[]{});
        g.vertex = node;
        topoLogicalSorting(g);
        System.out.println(g.count);

    }
}
