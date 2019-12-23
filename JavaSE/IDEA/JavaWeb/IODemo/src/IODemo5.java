import java.io.*;

public class IODemo5 {

    //获取输出流
    public static OutputStream 获取一个输出流() throws IOException {
        //1.本地文件输出
        OutputStream os = new FileOutputStream ("本地输出文件.txt");

        //2.在网络中获取输出流
        //Socket socket = new Socket ("www.baidu.com",80);
        //OutputStream os = socket.getOutputStream ();

        //3.在内存中获取输出流
        //OutputStream os = new ByteArrayOutputStream ();

        return os;
    }

    //如何输出
    private static void 输出一段字符(OutputStream os, String message) throws IOException {
        /*
        byte[] buffer = message.getBytes ("UTF-8");
        os.write (buffer);
        */


        Writer writer = new OutputStreamWriter (os,"UTF-8");
        /*
        writer.append (message);
        writer.flush ();
        */

        PrintWriter printWriter = new PrintWriter (writer,false);
        printWriter.printf ("%s",message);
        printWriter.flush ();

    }


    public static void main(String[] args) throws IOException {
        OutputStream os = 获取一个输出流 ();
        输出一段字符 (os, "在吗？\r\n在干嘛？\r\n想我吗？\r\n多喝烫水\r\n");//输出到了“本地输出文件.txt”

    }
}
