package tcp.http;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    //tcp是面向连接的，是需要客户连接的
    public static void main(String[] args) throws IOException {

        ServerSocket tcpServerSocket = new ServerSocket(8080);//起一个端口

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Socket clientSocket = tcpServerSocket.accept();//等待客户连接
            InetAddress clientAddress = clientSocket.getInetAddress();//对方的ip地址
            int clientPort = clientSocket.getPort();//地方的端口号

            //System.out.printf("有客户端连接上来 %s:%d%n",clientAddress.getHostAddress(), clientPort);

            // tcp是字节流的形式发送数据的，并不是像udp管道式发送数据

            // 获取 字节流
            InputStream is = clientSocket.getInputStream();
            // 字节流转换为字符流
            InputStreamReader isReader = new InputStreamReader(is, "UTF-8");
            // 字符流转换缓冲字符流
            BufferedReader reader = new BufferedReader(isReader);

            // 输出字节流（输出回复的内容）
            OutputStream os = clientSocket.getOutputStream();
            PrintStream out = new PrintStream(os, true, "UTF-8");

            //确保字符流中所有数据都读到了
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("好友说: " + line);
                System.out.print("请回复> ");
                String response = scanner.nextLine();
                out.println(response);
            }
        }
    }
}
