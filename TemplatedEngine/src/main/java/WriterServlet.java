import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/writer")
public class WriterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取message参数
        String message = req.getParameter("message");
        ServletContext context = getServletContext();
        //2.将message设置到ServletContext
        context.setAttribute("message",message);
        resp.setContentType("text/html;charset=utf-8");
        //3.返回结果
        resp.getWriter().write("设置成功");
    }
}
