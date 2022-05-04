import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/showRequest")
public class ShowRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        StringBuilder respBody = new StringBuilder();
        respBody.append(req.getProtocol()); //请求的协议名称和版本
        respBody.append("<br>");
        respBody.append(req.getMethod()); //请求的方法
        respBody.append("<br>");
        respBody.append(req.getRequestURI());//url的一部分
        respBody.append("<br>");
        respBody.append(req.getContextPath());
        respBody.append("<br>");
        respBody.append(req.getQueryString());
        respBody.append("<br>");

        respBody.append("<h3>headers:</h3>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            respBody.append(headerName + " ");
            respBody.append(req.getHeader(headerName));
            respBody.append("<br>");
        }

        resp.getWriter().write(respBody.toString());


    }
}
