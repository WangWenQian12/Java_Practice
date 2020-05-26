public class Main {

    //富翁与普通人换钱
    //富翁每天给普通人10w，普通人第一天给富翁1分钱，第二天2分钱，第三天4分钱……
    //问30天后分别给了对方多少钱

    public static void main(String[] args) {
        int money1 = 10*30;
        int money2 = 1;
        for(int i = 1; i < 30;i++){
            money2 = money2 * 2;
        }
        System.out.println (money1);
        System.out.println (money2-1);
    }
}
