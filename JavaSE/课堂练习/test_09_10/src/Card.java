import java.util.List;
import java.util.ArrayList;

public class Card {

    //扑克牌
    int value;
    String color;

    Card(String color,int value){
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]",color,value);
    }


    @Override//覆写eauals函数
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Card)){
            return false;
        }
        //this.val == obj.value;
        //需要向下转换
        Card o = (Card)obj;

        return value == o.value && color.equals(o.color);
    }

    public static void main(String[] args) {


    }
}
