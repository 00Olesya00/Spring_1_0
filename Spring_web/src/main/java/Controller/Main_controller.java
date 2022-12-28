package Controller;

import com.example.Spring_web.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Main_controller {
    private Product_Repository product_Repository;

    @Autowired
    public void MainController(Product_Repository product_Repository) {
        this.product_Repository = product_Repository;
    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", product_Repository.getAllProducts());
        return "products_page";
    }

    @GetMapping("/add-form")
    public String addProductsPage() {
        return "add_product";
    }


    @PostMapping(value = "/add", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String addProduct(Product product){
        product_Repository.addProduct(product);
        return "redirect:/products";
    }
}