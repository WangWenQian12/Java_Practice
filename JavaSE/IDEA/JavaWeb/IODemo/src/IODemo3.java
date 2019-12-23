import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class IODemo3 {

    /*

    1.从文件中读取
    2.从网络中读取（网卡、TCP连接）
    3.从内存中读取
    4.从标准输入读

     */

    private static InputStream 从内存中读字节流() throws IOException {

        //从标准输入读（输入ctrl+D标识结束）
        InputStream inputStream;
        inputStream = System.in;
        return inputStream;

    }

    /*
    * 1.直接通过字节方式读，然后程序进行字符编码（buffer大小  <  数据长度）
    * 2.把Stream转化为Reader，进行字符形式读取
        2.1 直接读
        2.2 BufferedReader  readLine
    * 3.Scanner也可以
     */
    private static String 从字节流中最终获取字符数据(InputStream is) throws IOException{
        //Scanner读入
        Scanner scanner = new Scanner (is,"UTF-8");
        String str = "";
        while(scanner.hasNext ()) {
            str = str + scanner.nextLine () + "\r\n";
        }
        return str;
    }


    public static void main(String[] args) throws IOException {
        InputStream inputStream = 从内存中读字节流 ();
        String message = 从字节流中最终获取字符数据 (inputStream);
        System.out.println (message);


    }
}
