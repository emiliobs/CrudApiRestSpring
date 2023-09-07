package Emisoft.Crud.Controllers;

import Emisoft.Crud.Product.Product;
import Emisoft.Crud.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<Object> NewProduct(@RequestBody Product product)
    {
        return productService.NewProduct(product);
    }
}
