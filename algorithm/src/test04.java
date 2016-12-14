/**
 * Created by lenovo on 2016/12/13.
 */
class Person{
    public String type;
    public String data;
    public Person leftChild=null;
    public Person rightChild=null;

    public Person(String type, String data) {
        this.type = type;
        this.data = data;

    }
}

public class test04 {
    public static void printNode(Person p){
        if(p==null){
            return;
        }
        System.out.println(p.data);

        if(p.leftChild!=null) {
            printNode(p.leftChild);
        }
        if(p.rightChild!=null)
        {
            printNode(p.rightChild);
        }
    }
    public static void main(String arg[]){
        Person root = new Person("1","0");
        Person f1 = new Person("1","f1");
        Person f2 = new Person("1","f2");
        Person s11 = new Person("1","s11");
        Person s12 = new Person("1","s12");
        root.leftChild = f1;
        root.rightChild = f2;
        f2.leftChild = s11;
        f2.rightChild = s12;
        Person testP = null;
        printNode(root);

    }
}
