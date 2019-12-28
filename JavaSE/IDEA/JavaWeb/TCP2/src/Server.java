import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket tcpServerSocket = new ServerSocket (8080);//起一个端口号
        Scanner scanner = new Scanner (System.in);

        while(true){
            //如果没有客户端连接上来，将阻塞
            Socket clientSocket = tcpServerSocket.accept ();//接收客户端
            InetAddress clientAddress = clientSocket.getInetAddress ();//获取到客户端的ip地址
            int clientPort = clientSocket.getPort ();//获取到客户端的端口号

            System.out.printf ("有客户端连接上来 %s ：%d%n",clientAddress.getHostAddress (),clientPort);

            //获取输入字节流(即客户发送来的字节流)
            InputStream is = clientSocket.getInputStream ();
            //字节流转换为字符流
            InputStreamReader isReader = new InputStreamReader (is,"UTF-8");
            //字符流转换为缓冲字符流
            BufferedReader reader = new BufferedReader (isReader);

            //获取输出字符流（即回复给客户端的消息）
            OutputStream os = clientSocket.getOutputStream ();
            PrintStream out = new PrintStream (os,true,"UTF-8");

            String line;
            while((line = reader.readLine ()) != null ) {
                System.out.println ("收到消息：" + line);
                System.out.print ("请回复：");
                String response = scanner.nextLine ();
                out.println (response);
            }

        }

    }
}
