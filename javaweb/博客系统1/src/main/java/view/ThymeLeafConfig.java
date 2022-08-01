package view;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

@WebListener
public class ThymeLeafConfig implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        //1.创建模板引擎对象
        TemplateEngine engine = new TemplateEngine();
        //2.创建解析器对象
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(context);
        resolver.setPrefix("/WEB-INF/template/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("utf-8");
        //3.将二者关联
        engine.setTemplateResolver(resolver);
        //4.将engine放入context
        context.setAttribute("engine",engine);
        System.out.println("初始化成功");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}
