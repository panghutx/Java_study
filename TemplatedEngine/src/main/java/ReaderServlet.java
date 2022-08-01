import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reader")
public class ReaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.读取ServletContext中的message值
        ServletContext context = getServletContext();
        String message = (String) context.getAttribute("message");
        resp.setContentType("text/html;charset=utf-8");
        //2.返回读到的值
        resp.getWriter().write(message);
    }
}
