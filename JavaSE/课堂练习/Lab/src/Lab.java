//排序方法的抽象
interface SortMethod{
    //返回排序的方法名称
    String getName();
    //进行各类排序
    void sort(int[] a);
}

//构造原始数组的方法
interface BuildSort{
    //返回构造方法的名称
    String getName();
    //构造数组
    int[] build(int[] a);
}


public class Lab {




    public static void main(String[] args) {
        for(int i = 1;i <= 4;i++){
            int n = 50000 * i;//每次循环都是不一样的元素数量，分别为5w，10w，15w，20w
            for(BuildMethod method : methods){

            }
        }
    }
}
