package ProductWeb.repository;

import ProductWeb.Consumer;
import ProductWeb.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConsumerDao {
    Consumer findConsumerById(Long id);

    List<Product> getProductsByConsumerId(Long id);

    List<Consumer> findAll();

    void deleteById(Long id);

    Consumer saveOrUpdate(Consumer product);
}