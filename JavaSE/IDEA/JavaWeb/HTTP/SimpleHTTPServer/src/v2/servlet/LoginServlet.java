package v2.servlet;

import v2.Request;
import v2.Response;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String username = req.parameters.get("username");
        if(username == null){
            resp.setStatus("401 Unauthorized");
            resp.println ("<h1>请登录</h1>");
            return;
        }

        //种一个cookie
        //resp.setHeader ("Set-Cookie","username = "+ username);
        resp.setHeader ("Set-Cookie","username = " + username + ";expires=Tue, 07-Apr-2020 08:46:16 GMT; Max-Age=8640000");

        resp.print ("<h2>欢迎 " + username + " </h2>");
    }


}
