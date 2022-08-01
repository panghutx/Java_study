import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1.通过方法的参数可以获取到ServletContext
        ServletContext context = sce.getServletContext();
        //2.创建TemplateEngine类对象engine
        TemplateEngine engine = new TemplateEngine();
        //3.创建解析器
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(context);
        //4.加载文件
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("utf-8");
        //5.关联engine和解析器
        engine.setTemplateResolver(resolver);
        //6.将engine放到ServletContext中
        context.setAttribute("engine",engine);
    }

}
