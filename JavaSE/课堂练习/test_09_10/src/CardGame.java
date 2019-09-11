import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardGame {

    private static final String[] color = {"♥","♠","♦","♣"};

    //买牌
    private static List<Card> buyDeck() {
        ArrayList<Card> deck = new ArrayList<>(52);

        for(int i = 0; i<4; i++){
            for(int j=1;j<=13;j++){
                String a = color[i];
                int value = j;
                Card b = new Card(a,value);
                deck.add(b);
            }
        }
        return deck;
    }

    //洗牌
    private static void washDeck(List<Card> deck) {
        Random random = new Random(20190910);
        for(int i=deck.size()-1;i>0;i--){
            int r = random.nextInt(i);
            swap(deck,i,r);
        }
    }

    private static void swap(List<Card> deck,int i, int r) {
        Card tmp = deck.get(i);
        deck.set(i,deck.get(r));
        deck.set(r,tmp);

    }

    //发牌
    private static void sendDeck(List<List<Card>> hands,List<Card> deck,int numPerson,int numCard) {
        //在给每个人发牌时，要确保他有足够的空间来拿这些牌
        for(int k=0;k<numCard;k++){
            hands.add(new ArrayList<>(numCard));
        }

        for(int i=0;i<numCard;i++){//抓五张牌
            for(int j=0;j<numPerson;j++){//三个人一人抓一次
                Card card = deck.remove(0);//从牌堆里抓第一张，抓完后属于自己，不再属于牌堆
                hands.get(j).add(card);//抓牌人获得这张牌
            }
        }

    }

    //捉黑A,谁拿谁输
    private static void play(List<List<Card>> hands) {
        Card card = new Card("♥",1);
        for(int i = 0;i<hands.size();i++){
            for(int j= 0;j<hands.get(i).size();j++) {
                if (hands.get (i).get (j).equals (card)) {//遍历所有牌，找到♥1，并输出是哪位玩家
                    System.out.println ((i+1)+"号玩家输了");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Card> deck = buyDeck();//买牌
        System.out.println (deck);
        washDeck(deck);//洗牌
        System.out.println (deck);
        List<List<Card>> hands = new ArrayList<>();
        sendDeck(hands,deck,3,5);
        System.out.println (hands.get(0));//第一个人抓到的牌
        System.out.println (hands.get(1));//第二个人抓到的牌
        System.out.println (hands.get(2));//第三个人抓到的牌
        play(hands);//捉黑A,谁拿谁输


    }



}
