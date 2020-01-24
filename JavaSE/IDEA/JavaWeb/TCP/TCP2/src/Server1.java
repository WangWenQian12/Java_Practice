import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server1 {

    //线程池版本

    private static class ServerTask implements Runnable{
        private Socket socket;

        ServerTask(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InetAddress clientAddress = socket.getInetAddress ();
                int clientPort = socket.getPort();

                System.out.printf ("有客户端连接上来：%s：%d%n",clientAddress,clientPort);

                //获取输入字节流（即客户端发送来的消息）
                InputStream is = socket.getInputStream ();
                //字节流转换为字符流
                InputStreamReader isReader = new InputStreamReader (is);
                //字符流转换为缓冲字符流
                BufferedReader reader = new BufferedReader (isReader);

                //输出字符流
                OutputStream os = socket.getOutputStream ();
                PrintStream out = new PrintStream (os,true,"UTF-8");


                while(true){
                    String line;
                    while(!(line = reader.readLine ()).isEmpty ()){
                        System.out.println ("收到消息：" + line);
                        Scanner sc = new Scanner (System.in);
                        System.out.print ("请回复：");
                        String response = sc.nextLine ();
                        out.println (response);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace ();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        //创建线程池，大小为10
        ExecutorService pool = Executors.newFixedThreadPool (10);
        //服务器起一个端口
        ServerSocket serverSocket = new ServerSocket (8080);
        while(true){
            Socket socket = serverSocket.accept ();//接收客户端请求，返回一个socket供通信
            pool.execute (new ServerTask(socket));
        }

    }
}
