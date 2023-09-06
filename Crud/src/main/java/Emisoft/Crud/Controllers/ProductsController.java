package Emisoft.Crud.Controllers;

import Emisoft.Crud.Product.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductsController
{
    @GetMapping(value = "/")
    public List<Product> GetProducts()
    {
        return List.of(
                new Product(
                        55555l,
                        "Emilio",
                        5500,
                        LocalDate.of(2023, Month.AUGUST, 6),
                        5));
    }
}
