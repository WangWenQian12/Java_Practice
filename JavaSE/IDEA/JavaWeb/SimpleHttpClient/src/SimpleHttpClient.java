import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleHttpClient {

    //HTTP的请求和响应内容

    public static void main(String[] args) throws IOException {
        String request = "GET / HTTP/1.0\r\nHost:www.baidu.com\r\n\r\n";

        Socket socket = new Socket ("www.baidu.com",80);
        socket.getOutputStream ().write (request.getBytes ("UTF-8"));
        //版本  状态码  状态描述
        //响应头打印
        //把响应正文保存下来
        byte[] bytes = new byte[4096];
        int len = socket.getInputStream ().read (bytes);
        String response = new String(bytes,0,len,"UTF-8");
        //假设 4096 字节已经包含 响应行 + 所有响应头 + 一部分正文
        int index = -1;
        for(int i = 0;i < len - 3;i++){
            if(bytes[i] == '\r' && bytes[i+1] == '\n' && bytes[i+2] == '\r' && bytes[i+3] == '\n'){
                index = i;//0 ~ i是响应正文之前的内容，之后为响应正文
                break;
            }
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream (bytes,0,index + 4);
        Scanner scanner = new Scanner (byteArrayInputStream,"UTF-8");
        String statusLine = scanner.nextLine ();
        String[] k = statusLine.split (" ");
        System.out.println ("版本：" + k[0]);
        System.out.println ("状态码：" + k[1]);
        System.out.println ("状态描述：" + k[2]);

        //System.out.println ("状态行：" + statusLine);
        String line;
        int 正文总长度 = -1;
        while(!(line = scanner.nextLine ()).isEmpty ()){
            String[] kv = line.split (":");
            String key = kv[0].trim ();
            String value = kv[1].trim ();
            System.out.println ("响应头：" + key + " === " + value);
            if(key.equalsIgnoreCase ("Content-Length")){
                正文总长度 = Integer.valueOf (value);
            }
        }
        int 已经读了 = len - index - 4;
        int 还应该读 = 正文总长度 - 已经读了;

        byte[] body = new byte[正文总长度];
        System.arraycopy (bytes,index + 4,body,0,已经读了);//从bytes里拷0-已经读了个数的字节，拷到body中
        int 实际读 = socket.getInputStream ().read (body,已经读了,还应该读);

        System.out.println (已经读了);
        System.out.println (还应该读);
        System.out.println (实际读);

        //System.out.println (new String(body,0,body.length,"UTF-8"));
        FileOutputStream fileOutputStream = new FileOutputStream ("百度.html");
        fileOutputStream.write (body);





    }
}
