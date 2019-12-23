import java.io.*;
import java.net.Socket;

public class IODemo11 {

    /*

    1.从文件中读取
    2.从网络中读取（网卡、TCP连接）
    3.从内存中读取
    4.从标准输入读

     */

    //获取输入流
    private static InputStream 从文件中读字节流() throws IOException {

        //从文件中读
        InputStream inputStream;
        inputStream = new FileInputStream ("本地文件.txt");
        return inputStream;

    }

    /*如何输入
    1.直接通过字节方式读，然后程序进行字符编码（buffer大小  <  数据长度）
    2.把Stream转化为Reader，进行字符形式读取
        2.1 直接读
        2.2 BufferedReader  readLine
    3.Scanner也可以
     */
    private static String 从字节流中最终获取字符数据(InputStream is) throws IOException{

        //1.字节方式读
        //如果内容大于buffer长度的话，可能会导致一个字符只读了一半
        byte[] buffer = new byte[1024];
        int len = is.read (buffer);//读buffer个大小

        //数据放在buffer【0，len）
        String message  = new String(buffer,0,len,"UTF-8");

        return message;

    }
    public static void main(String[] args) throws IOException {
        InputStream inputStream = 从文件中读字节流 ();
        String message = 从字节流中最终获取字符数据 (inputStream);
        System.out.println (message);
    }
}
