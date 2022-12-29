package Product.Serv;

import Product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        logger.info("Список товаров ");

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
//        double sum =ThreadLocalRandom.current().nextDouble(2000);
        for (int i = 0; i < 10; i++) {

            Product product = new Product(i +1,"Продукт",ThreadLocalRandom.current().nextDouble(2000));

            resp.getWriter().printf("<h1>" + product + "</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
        logger.info("Список товаров ");
    }

    @Override
    public void init() throws SecurityException {
        logger.debug("Init");
    }
}