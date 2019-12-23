import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        //起一个端口
        ServerSocket serverSocket = new ServerSocket (8888);
        while(true){
            //等待客户端连接
            Socket socket = serverSocket.accept ();//可能会有阻塞
            //有客户端建立了连接
            InputStream is = socket.getInputStream ();
            OutputStream os = socket.getOutputStream ();

            Reader reader = new InputStreamReader (is,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader (reader);

            Writer writer = new OutputStreamWriter (os,"UTF-8");
            PrintWriter printWriter = new PrintWriter (writer,false);

            String message;
            //等待客户端发送消息
            while((message = bufferedReader.readLine ()) != null){//可能会有阻塞
                //接收到了客户端发来的消息
                System.out.println ("收到消息：" + message);

                //回复给客户端
                printWriter.println ("ok" );
                printWriter.flush ();
            }
            socket.close ();
        }
    }
}
