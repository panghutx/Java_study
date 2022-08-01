import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/thymeleafUrl.html")
public class ThymeleafUrlServlet extends HttpServlet {
    //1.创建核心类,用于完成页面渲染
    public TemplateEngine engine = new TemplateEngine();
    //2.初始化模板引擎,创建解析器，加载文件，关联
    public void init(){
        ServletContext context = getServletContext();
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(context);
        resolver.setCharacterEncoding("utf-8");
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        engine.setTemplateResolver(resolver);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        resp.setContentType("text/html;charset=utf-8");
        //3.实例化WebContext，关联变量
        WebContext webContext = new WebContext(req,resp,context);
        webContext.setVariable("url1","https://youngsay.cn");
        webContext.setVariable("url2","http://blog.youngsay.cn");
        //4.渲染
        engine.process("thymeleafUrl",webContext,resp.getWriter());
    }
}
