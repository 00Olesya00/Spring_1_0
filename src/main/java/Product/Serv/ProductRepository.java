package Product.Serv;

import Product.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(); //Arrays.asList());
        products.add(new Product(1, "Сахар", 90.04));
        products.add(new Product(2, "Картофель", 28.55));
        products.add(new Product(3, "Гречневая мука", 67.78));
        products.add(new Product(4, "Рис длиннозерновой", 119.40));
        products.add(new Product(5, "Капуста", 18.25));

    }

    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Продукт не найден"));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}