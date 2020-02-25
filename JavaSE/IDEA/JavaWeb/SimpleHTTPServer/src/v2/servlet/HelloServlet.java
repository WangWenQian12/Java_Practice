package v2.servlet;

import v2.Request;
import v2.Response;

import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String target = req.parameters.get ("target");

        if(target == null){
            resp.setStatus("401 Unauthorized");
            resp.println ("<h1>请求失败</h1>");
            return;
        }

        resp.setHeader ("Content-Type","text/plain;charset=UTF-8");
        resp.setHeader ("X-Teacher","陈沛鑫");
        resp.setHeader ("X-Room","201");

        resp.println ("你好 " + target );

        String user = "未登录";
        String cookie = req.headers.get ("Cookie");
        if(cookie != null){
            String[] group = cookie.split ("=");
            user = group[1];
            resp.println ("当前用户为 " + user);
        }
    }
}
