package v2;

import v2.bussiness.User;

import java.io.*;
import java.util.UUID;

public class SessionServer {

    private static String dir = "会话";//将信息保存至会话目录下

    public static String put(User user) throws IOException {
        String sessionId = UUID.randomUUID ().toString ();//根据当前时间，当前机器随机给出一个全球都不会重复的随机码，作为我们的sessionId
        String filename = dir + "\\" + sessionId;
        OutputStream os = new FileOutputStream (filename);
        ObjectOutputStream oos = new ObjectOutputStream (os);

        oos.writeObject (user);

        os.close ();

        return sessionId;

    }

    public static User get(String sessionId) throws IOException, ClassNotFoundException {
        String filename = dir + "\\" + sessionId;

        InputStream is = new FileInputStream (filename);
        ObjectInputStream ois = new ObjectInputStream (is);

        User user = (User)ois.readObject ();

        is.close ();

        return user;
    }
}
