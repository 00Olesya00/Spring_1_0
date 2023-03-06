package ProductWeb.repository;

import ProductWeb.Consumer;
import ProductWeb.Product;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
    List<Consumer> getConsumersByProductsId(Long id);
}