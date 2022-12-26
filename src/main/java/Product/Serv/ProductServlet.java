package Product.Serv;


import Product.User.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/start")
public class ProductServlet extends HttpServlet {
    public static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws SecurityException, IOException {
        HttpSession session = reg.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");// создаем проверку, зарегистрирован ли пользователь

        if (userInfo == null) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().printf("<html><body>");
            resp.getWriter().println("<h3> Новый пользователь</h3>");
            resp.getWriter().printf("<form method=\"POST\" action=\"\">");
            resp.getWriter().printf("<input name=\"shoutDelete\" value=\"false\"hidden>");
            resp.getWriter().printf("Логин:<input name=\"login\">");
            resp.getWriter().printf("Имя:<input name=\"name\"> ");
            resp.getWriter().printf("<input type=\"submit\" value=\"СОЗДАТЬ\">");
            resp.getWriter().printf("</body></html>");
        } else { // приветствуем пользователя если он уже создан
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().printf("<html><body>");
            resp.getWriter().printf("<h3>Здравствуйте!" + userInfo.getName() + "</h3>");
            resp.getWriter().printf("Логин:  " + userInfo.getLogin() + " <br>");
            resp.getWriter().printf("Имя:  " + userInfo.getName());
             // Создаем возможность удаления пользователя
            resp.getWriter().printf("<hr>");
            resp.getWriter().printf("<form method=\"POST\" action=\"\">");
            resp.getWriter().printf("<input name=\"shoutDelete\" value=\"true\"hidden>");
            resp.getWriter().printf("<input type=\"submit\" value=\"Удалить\">");
            resp.getWriter().printf("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest reg, HttpServletResponse resp) throws SecurityException, IOException {

        boolean shoutDeelete = Boolean.parseBoolean(reg.getParameter("shoutDelete"));
        if (!shoutDeelete) {

            String login = reg.getParameter("login");
            String name = reg.getParameter("name");
            UserInfo info = new UserInfo(login, name); //получем логин и имя

//             resp.addCookie(new Cookie("userInfo"));
            HttpSession session = reg.getSession();
            session.setAttribute("userInfo", info);
            resp.getWriter().printf("<html><body>OK</body></html>");

        } else {
            resp.setContentType("text/html;charset=UTF-8");
            HttpSession session = reg.getSession();
            session.removeAttribute("userInfo");
            resp.getWriter().printf("<html><body>УДАЛЕНО</body></html>");

        }
    }

    @Override
    public void init() throws SecurityException {
        logger.debug("Inet");
    }
}
//
//    @Override
//    protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws SecurityException, IOException {
//        PrintWriter writer =resp.getWriter();
//        writer.write("html");
//        writer.write("body");
//        writer.write("<h1>  Я запустился!" + new Date()+ "< /h1>");
//        writer.write("/html");
//        writer.write("/body");
//    }




