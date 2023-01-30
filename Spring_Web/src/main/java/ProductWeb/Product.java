package ProductWeb;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "All_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private int price;

    @ManyToMany
    @JoinTable (
            name = "consumers_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "consumer_id")
    )
    private List<Consumer> consumers;

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", title='" + title + ", price=" + price + '}';
    }
}