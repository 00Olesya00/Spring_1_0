
package ProductWeb;
import java.util.List;

public class MainAPP {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new productDAoImP(sessionFactoryUtils);
            List<Product> productList = productDao.findAll();
            System.out.println(productList);
            Product milk = new Product("Молоко", 20);
            Product meat = new Product("Мясо", 400);
            System.out.println(productDao.saveOrUpdate(milk)); //молоко уже есть, обновится цена
            System.out.println(productDao.saveOrUpdate(meat)); // Мяса - добавится
            Product pancake = productDao.findById(4L);
            System.out.println(pancake);
            productDao.deleteById(4L);
            List<Product> All_products = productDao.findAll();
            System.out.println(All_products);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}