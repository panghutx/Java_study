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
import java.util.Random;

@WebServlet("/GuessNum")
public class GuessNumTemplateEngine extends HttpServlet {
    //核心，用于完成页面的渲染
    public TemplateEngine engine = new TemplateEngine();
    public int randomNum;
    public int count;

    public void init() {
        //对模板引擎初始化
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(this.getServletContext());
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("utf-8");
        engine.setTemplateResolver(resolver);
        System.out.println("初始化完成");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random random = new Random();
        randomNum = random.nextInt(100)+1;
        WebContext webContext = new WebContext(req,resp,getServletContext());
        webContext.setVariable("first",true);
        resp.setContentType("text/html;charset=utf-8");
        engine.process("guessNum",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.获取用户输入的数字
        int num = Integer.parseInt(req.getParameter("guessNum"));
        String result = "";
        // 2. 和 随机数 进行比较
        if (num < randomNum) {
            result = "猜低了";
        } else if (num > randomNum) {
            result = "猜高了";
        } else {
            result = "猜对了";
        }
        // 3. 自增猜的次数
        count++;
        //4.返回响应界面
        WebContext context = new WebContext(req,resp,getServletContext());
        context.setVariable("first",false);
        context.setVariable("result",result);
        context.setVariable("count",count);
        engine.process("guessNum",context,resp.getWriter());
    }
}
