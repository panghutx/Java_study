import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

//加上这个注解之后才能读取文件内容
@MultipartConfig
@WebServlet("/file")
public class Upload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Part part = req.getPart("myFile");
        System.out.println(part.getContentType());
        System.out.println(part.getName());
        System.out.println(part.getSize());
        part.write("d:/myFile.png");
        resp.getWriter().write("上传成功");
    }
}
