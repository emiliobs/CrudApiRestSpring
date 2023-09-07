package Emisoft.Crud.Controllers;

import Emisoft.Crud.Product.Product;
import Emisoft.Crud.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductsController
{
    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> GetProducts()
    {
        return  productService.GetProducts();
    }

    @PostMapping
    public void NewProduct(@RequestBody Product product)
    {
        this.productService.NewProduct(product);
    }
}
