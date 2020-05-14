package v2.bussiness;

import v2.Request;
import v2.Response;
import v2.SessionServer;
import v2.servlet.HttpServlet;

import java.io.IOException;

public class Hello extends HttpServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException, ClassNotFoundException {
        String target = req.parameters.get ("target");

        /*if(target == null){
            resp.setStatus("401 Unauthorized");
            resp.println ("<h1>请求失败</h1>");
            return;
        }*/

        String sessionId = null;
        String cookie = req.headers.get ("Cookie");
        if(cookie != null){
            String[] group = cookie.split ("=");
            sessionId = group[1];
        }

        User user = SessionServer.get (sessionId);

        resp.setHeader ("Content-Type","text/plain;charset=UTF-8");
        resp.setHeader ("X-Teacher","陈沛鑫");
        resp.setHeader ("X-Room","201");

        //resp.println ("你好 " + target );
        resp.println ("当前用户为 " + user.username);
        resp.println ("账户余额为：" + user.balance);
    }
}

