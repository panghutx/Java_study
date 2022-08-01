import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Image {
    public String name;
    public String url;
}
@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Image> images = getImage();
        resp.setContentType("text/html;charset=utf-8");
        ServletContext context = getServletContext();
        WebContext webContext = new WebContext(req,resp,context);
        webContext.setVariable("images",images);
        TemplateEngine engine = (TemplateEngine) context.getAttribute("engine");
        engine.process("index",webContext, resp.getWriter());
    }
    //从指定目录下获取图片
    public List<Image> getImage(){
        List<Image> images = new ArrayList<>();
        //得到图片路径
        ServletContext context = getServletContext();
        String path = context.getRealPath("/image");
        //查看图片
        File imageRoot = new File(path);
        File[] files = imageRoot.listFiles();
        for(File file:files){
            Image image = new Image();
            image.name = file.getName();
            image.url = "/image/"+file.getName();
            images.add(image);
        }

        return images;
    }
}
