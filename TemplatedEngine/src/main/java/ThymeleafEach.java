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
import java.util.ArrayList;
import java.util.List;

class Person {
    public String name;
    public int kill;
    public int dead;
    public int score;

    public Person(String name, int kill, int dead, int score) {
        this.name = name;
        this.kill = kill;
        this.dead = dead;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getKill() {
        return kill;
    }

    public int getDead() {
        return dead;
    }

    public int getScore() {
        return score;
    }

}

@WebServlet("/each")
public class ThymeleafEach extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("損友比过狗友i",12,2,80));
        persons.add(new Person("马棚管理员",21,8,130));
        persons.add(new Person("小气",16,5,110));
        ServletContext context = getServletContext();
        WebContext webContext = new WebContext(req,resp,context);
        webContext.setVariable("persons",persons);
        resp.setContentType("text/html;charset=utf-8");
        TemplateEngine engine = (TemplateEngine) context.getAttribute("engine");
        engine.process("ThymeleafEach",webContext, resp.getWriter());
    }

}
