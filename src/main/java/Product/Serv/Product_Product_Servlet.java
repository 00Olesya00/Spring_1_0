package Product.Serv;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Random;

 @WebServlet("/start")
public class Product_Product_Servlet extends HttpServlet {
    public static Logger logger = LoggerFactory.getLogger(Product.Serv.ProductServlet_User.class);

    @Override
    protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws SecurityException, IOException {
        HttpSession session = reg.getSession();
    }
 }