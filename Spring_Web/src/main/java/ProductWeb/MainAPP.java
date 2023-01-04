
package ProductWeb;

import ProductWeb.repository.ConsumerDao;
import ProductWeb.repository.ConsumerDaoImpl;
import ProductWeb.repository.ProductDaOImP;
import ProductWeb.repository.ProductDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class MainAPP {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ProductWeb");
        ProductDao productDao = context.getBean(ProductDaOImP.class);
        ConsumerDao consumerDao = context.getBean(ConsumerDaoImpl.class);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("введите команду");
            String in = sc.nextLine();
            String[] token = in.split(" ");
            if (token[0].equals("getProduct")) {
                Product product = productDao.findById((long) Integer.parseInt(token[1].trim()));
                System.out.println(product);
            }
            if (token[0].equals("getConsumer")) {
                Consumer consumer = consumerDao.findConsumerById((long) Integer.parseInt(token[1].trim()));
                System.out.println(consumer);
            }
            if (token[0].equals("getProductsByConsumerId")) {
                List<Product> products = consumerDao.getProductsByConsumerId((long) Integer.parseInt(token[1].trim()));
                System.out.println(products);
            }
            if (token[0].equals("getConsumersByProductsId")) {
                List<Consumer> consumers = productDao.getConsumersByProductsId((long) Integer.parseInt(token[1].trim()));
                System.out.println(consumers);
            }
            if (token[0].equals("exit")) break;
        }
    }
}
