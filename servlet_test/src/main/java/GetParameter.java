import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取 GET 请求中的参数
 */

@WebServlet("/getParameter")
public class GetParameter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String userId = req.getParameter("userId"); //获取queryString中的userId
        String userName = req.getParameter("userName");
        resp.getWriter().write("userId:"+userId+"<br>"+"userName:"+userName);
    }
}
