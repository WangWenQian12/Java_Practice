import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer1 {

    //线程池

    private static class ServiceTask implements Runnable{
        private final Socket socket;

        private ServiceTask(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    InputStream is = socket.getInputStream ();
                    OutputStream os = socket.getOutputStream ();

                    Reader reader = new InputStreamReader (is, "UTF-8");
                    BufferedReader bufferedReader = new BufferedReader (reader);

                    Writer writer = new OutputStreamWriter (os, "UTF-8");
                    PrintWriter printWriter = new PrintWriter (writer, false);

                    String message;
                    //等待客户端发送消息
                    while ((message = bufferedReader.readLine ()) != null) {//可能会有阻塞
                        //接收到了客户端发来的消息
                        System.out.println ("收到消息：" + message);

                        //回复给客户端
                        printWriter.println ("ok");
                        printWriter.flush ();
                    }
                    socket.close ();
                }
            }catch(IOException e){ }
            }
        }

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool (10);//线程池
        ServerSocket serverSocket = new ServerSocket (8888);
        while(true){
            Socket socket = serverSocket.accept ();
            pool.execute (new ServiceTask (socket));
        }

    }
}

