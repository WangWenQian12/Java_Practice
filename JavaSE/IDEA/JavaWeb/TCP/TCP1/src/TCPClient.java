import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket ("127.0.0.1",8888);

        InputStream is = socket.getInputStream ();
        OutputStream os = socket.getOutputStream ();

        Reader reader = new InputStreamReader (is,"UTF-8");
        BufferedReader bufferedReader = new BufferedReader (reader);
        Writer writer = new OutputStreamWriter (os,"UTF-8");
        PrintWriter printWriter = new PrintWriter (writer,false);

        String[] messages = {"在嘛","在干嘛","想我吗","多喝烫水"};
        for(String message : messages){
            printWriter.println (message);
            printWriter.flush ();

            //回复的消息
            String echoMessage = bufferedReader.readLine ();
            System.out.println ("对方回复：" + echoMessage);
        }
        socket.close ();


    }
}
