import java.io.*;
import java.net.Socket;

public class IODemo12 {

    /*

    1.从文件中读取
    2.从网络中读取（网卡、TCP连接）
    3.从内存中读取
    4.从标准输入读

     */

    private static InputStream 从文件中读字节流() throws IOException {
        //从文件中读
        InputStream inputStream;
        inputStream = new FileInputStream ("本地文件.txt");
        return inputStream;

    }

    /*
    1.直接通过字节方式读，然后程序进行字符编码（buffer大小  <  数据长度）
    2.把Stream转化为Reader，进行字符形式读取
        2.1 直接读
        2.2 BufferedReader  readLine
    3.Scanner也可以
     */
    private static String 从字节流中最终获取字符数据(InputStream is) throws IOException{

        //把Stream转化为Reader，进行字符形式读取

        /*
        直接读
        Reader reader = new InputStreamReader (is,"UTF-8");
        char[] buffer = new char[1024];
        int len = reader.read (buffer);
        String message = new String (buffer,0,len);
        return message;
        */

        /*
        StringBuilder进行读
        StringBuilder sb = new StringBuilder ();
        Reader reader = new InputStreamReader (is,"UTF-8");
        char[] buffer = new char[1024];
        int len;
        while((len= reader.read (buffer)) != -1){
            sb.append(buffer,0,len);

        }
        String message  = sb.toString ();
        return message;
        */


        //BufferedReader进行readLine
        Reader reader = new InputStreamReader (is,"UTF-8");
        BufferedReader bufferedReader = new BufferedReader (reader);
        String line;
        StringBuilder sb = new StringBuilder ();

        while((line = bufferedReader.readLine ())!= null){
            sb.append (line + "\r\n");
        }

        String message = sb.toString ();
        return message;

    }


    public static void main(String[] args) throws IOException {
        InputStream inputStream = 从文件中读字节流 ();
        String message = 从字节流中最终获取字符数据 (inputStream);
        System.out.println (message);
    }
}
