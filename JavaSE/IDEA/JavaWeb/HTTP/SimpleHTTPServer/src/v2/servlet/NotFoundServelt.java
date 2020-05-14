package v2.servlet;

import v2.Request;
import v2.Response;
import v2.servlet.HttpServlet;

import java.io.IOException;

public class NotFoundServelt extends HttpServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        resp.setStatus("404 Not Found");
        resp.println ("<h1>资源不存在</h1>");
        return;
    }
}
