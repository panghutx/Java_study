import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Part part = req.getPart("MyImage");
        //得到文件名
        String name = part.getSubmittedFileName();
        ServletContext context = getServletContext();
        //得到要存放的路径
        String realPath = context.getRealPath("/image")+"/"+name;
        part.write(realPath);
        resp.sendRedirect("image");
    }
}
