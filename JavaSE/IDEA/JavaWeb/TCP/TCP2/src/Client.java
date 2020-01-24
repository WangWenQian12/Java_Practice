import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    //客户端

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner (System.in);

        Socket tcpClientSocket = new Socket ();//起一个客户端端口
        byte[] ipv4 = {127,0,0,1};//跟本机交互
        InetAddress serverAdress = InetAddress.getByAddress (ipv4);//获取服务器的ip地址

        //连接服务器
        SocketAddress serverSocketAddress = new InetSocketAddress (serverAdress,8080);//服务器ip+端口
        tcpClientSocket.connect (serverSocketAddress);//tcp是面向连接的

        while(true){
            System.out.print ("请输入：");
            String request = scanner.nextLine ();
            //当用户输入 quit 时，退出程序
            if (request.equalsIgnoreCase ("quit")) {
                break;
            }
            //通过字节流直接写入信息
            OutputStream os = tcpClientSocket.getOutputStream ();
            PrintStream out = new PrintStream (os,true,"UTF-8");//自动刷新信息

            out.println (request);

            //通过字节流，直接读取数据
            InputStream is = tcpClientSocket.getInputStream ();//获取此端口的输入流，即服务器回复的消息
            BufferedReader reader = new BufferedReader (new InputStreamReader (is,"UTF-8"));
            String response = reader.readLine ();
            System.out.println ("收到回复：" + response);

        }

        tcpClientSocket.close ();
    }

}
