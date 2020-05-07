import java.io.*;
import java.net.Socket;

public class IODemo {

    /*

    1.从文件中读取
    2.从网络中读取（网卡、TCP连接）
    3.从内存中读取
    4.从标准输入读

     */

    private static InputStream 从文件中读字节流() throws IOException {

        InputStream inputStream;

        //从文件中读
        //inputStream = new FileInputStream ("本地文件.txt");

        //从内存中读取
        //byte[] bytes = "内存中的一段空间\r\nhh\r\n".getBytes ();
        //inputStream = new ByteArrayInputStream (bytes);

        Socket socket = new Socket ("www.baidu.com",80);
        OutputStream os = socket.getOutputStream ();
        Writer writer = new OutputStreamWriter (os,"UTF-8");
        PrintWriter printWriter = new PrintWriter (writer,false);
        printWriter.printf ("GET / HTTP/1.0\r\n\r\n" );
        printWriter.flush ();
        inputStream = socket.getInputStream ();

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

        //1.字节方式读
        //如果内容大于buffer长度的话，可能会导致一个字符只读了一半
        /*byte[] buffer = new byte[1024];
        int len = is.read (buffer);//读buffer个大小
        //数据放在buffer【0，len）

        String message  = new String(buffer,0,len,"UTF-8");

        return message;*/



        /*
        //直接读为字符，保证读到的是完整字符
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

        //一行一行读
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

    private static OutputStream 获取一个输出流() throws IOException {
        OutputStream os = new FileOutputStream("本地输出文件.txt");
        //Socket socket = new Socket("www.baidu.com", 80);
        //OutputStream os = socket.getOutputStream();
        //OutputStream os = new ByteArrayOutputStream();

        return os;
    }

    private static void 输出一段字符(OutputStream os, String message) throws IOException {
        /*
        byte[] buffer = message.getBytes("UTF-8");
        os.write(buffer);
         */

        Writer writer = new OutputStreamWriter(os, "UTF-8");
        //writer.append(message);
        //writer.flush();

        PrintWriter printWriter = new PrintWriter(writer, false);
        printWriter.printf("%s", message);
        printWriter.flush();
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = 从文件中读字节流 ();
        String message = 从字节流中最终获取字符数据 (inputStream);
        System.out.println (message);

        OutputStream os = 获取一个输出流();
        输出一段字符(os, "我是中国人，最喜欢过年了\r\n");
    }
}
