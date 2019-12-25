import java.util.HashMap;
import java.util.Map;

public class ParseURL {

    //解析URL
    //schema :// user:password@host:port / path ? query_string # segement

    //权威端口
    private static Map<String,Integer> knownPorts = new HashMap<> ();
    static {
        knownPorts.put ("http",80);
        knownPorts.put ("https",443);
        knownPorts.put ("jdbc:mysql",3306);
    }

    public static void main(String[] args) {
        int index;
        String url = "https://www.baidu.com/s?wd=c%2B%2B&rsv_spt=1&rsv_iqid=0xa8575675000721cc&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=tb&rsv_sug3=4&rsv_sug1=4&rsv_sug7=101&rsv_sug2=0&inputT=2400&rsv_sug4=3237";
        index = url.indexOf ("://");
        String schema = url.substring (0,index);//协议名
        System.out.println ("协议：" + schema);

        url = url.substring (index + 3);
        index = url.indexOf ("/");
        String hostAndPort = url.substring (0,index);//主机名
        String host;
        int port;
        if(hostAndPort.contains (":")){
            String[] group = hostAndPort.split (":");
            host = group[0];
            port = Integer.valueOf (group[1]);
        }else{
            host = hostAndPort;
            port = knownPorts.get (schema);
        }
        System.out.println ("主机：" + host);
        System.out.println ("端口：" + port);

        url = url.substring (index + 1);
        index = url.indexOf ("?");
        String path = url.substring (0,index);//路径
        System.out.println ("路径：" + path);

        url = url.substring (index + 1);
        String queryString;
        String segment;
        index = url.indexOf ("#");
        if(index != -1) {
            queryString = url.substring (0, index);
            segment = url.substring (index + 1);
            System.out.println ("片段标识符：" + segment);
        }else{
            queryString = url;
        }
        System.out.println ("查询字符串：" + queryString);

        String[] kv = queryString.split ("&");
        for(String s:kv){
            System.out.println ("各查询字符串：" + s);
        }

    }
}
