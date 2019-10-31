import java.util.*;

public class MyString {

    private final char[] s;

    public MyString(char[] value){
        this.s = Arrays.copyOf (value,value.length);
    }



    //equals(数组的比较调用arrays equals)
   // public boolean


    //toUpperCase


    //equalsIgnoreCsae（忽略大小写去比较）
    public boolean equalsIgnoreCase(MyString o){
        if(o == null){
            return false;
        }
        //if(val.length != o.value.length){
          //  return false;
        //}




        return true;
    }




    //concat拼接字符串
    public MyString concat(MyString o){
return null;
    }



    //求访问各级域名的次数
    /*public List<String> subdomainVisits(String[] cpdomains) {
        String s = cpdomains.toString ();
        String[] a = s.split ("\\ ");

        String[] words = a[1].split("\\.");
    }*/


    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<> ();
        String[] domains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        for(String cpdomain : domains){
            //先将数字和字符串分割
            String[] a = cpdomain.split(" ");
            int n = Integer.valueOf (a[0]);
            String domain = a[1];

            //再将域名分为各级域名
            String[] words = domain.split ("\\.");
            for(int i = 0;i<words.length;i++){
                String[] c = Arrays.copyOfRange (words,i,words.length);
                //System.out.println (Arrays.toString (c));
                String subdomain = String.join(".",c);

                int oldCount = map.getOrDefault (subdomain,0);
                map.put(subdomain,oldCount + n);
            }

        }
        System.out.println (map);

        //用List形式输出
        List<String> ret = new ArrayList<> ();
        for(Map.Entry<String,Integer> e : map.entrySet ()){
            String domain = e.getKey ();
            int n = e.getValue ();
            String s = String.format ("%d %s",n,domain);
            ret.add(s);
        }

        System.out.println (ret);

    }


}
