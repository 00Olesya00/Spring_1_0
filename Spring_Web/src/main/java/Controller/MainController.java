package Controller;

import com.example.Products.Product;
import com.example.Products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
 public class MainController {
    private ProductRepository productRepository;

    @Autowired
    public void MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "products_page";
    }

    @GetMapping("/add-form")
    public String addProductsPage() {
        return "addProduct";
    }


    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String addProduct(Product product){
        productRepository.addProduct(product);
        return "redirect:/products";
    }
}