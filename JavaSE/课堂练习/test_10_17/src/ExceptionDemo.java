public class ExceptionDemo {

    public static void main(String[] args) {
        try{
            throwException(true);
        }catch(NullPointerException exc){
            System.out.println ("逮到了逮到了" );
        }finally {
            System.out.println ("总得来一趟吧");
        }
    }

    private static void throwException(boolean b) {
        System.out.println ("之前");
        if(b){
            throw new NullPointerException();
        }
        System.out.println ("之后");
    }
}
