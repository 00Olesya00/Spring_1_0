package Product.Serv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


@WebServlet("/products")
public class Product_Servlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(Product_Servlet.class);
    private float sum =ThreadLocalRandom.current().nextInt(2000);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        logger.info("Список товаров: ");

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 1; i < 11; i++) {
            Product product = new Product(i,"Продукт",sum);

            resp.getWriter().printf("<h1>" + product + "</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
        logger.info("Список товаров: ");
    }

    @Override
    public void init() throws SecurityException {
        logger.debug("Init");
    }
}