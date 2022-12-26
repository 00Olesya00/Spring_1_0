package Product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class Apping_ {
        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext("Product");
            Card card = context.getBean(Card.class);
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Добавьте товар в корзину при помощи команды 'add' указав его id или удалите при помощи команды 'remove' так же указав его id");
                String in = sc.nextLine();
                String[] token = in.split(" ");
                if (token[0].equals("add")) {
                    card.addProductCardById(Integer.parseInt(token[1].trim()));
                    System.out.println(card);
                }
                if (token[0].equals("remove")) {
                    card.removeProductCardById(Integer.parseInt(token[1].trim()));
                    System.out.println(card);
                }
                if (token[0].equals("exit")) break;
            }
        }
    }

