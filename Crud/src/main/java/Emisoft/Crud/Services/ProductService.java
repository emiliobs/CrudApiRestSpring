package Emisoft.Crud.Services;

import Emisoft.Crud.Product.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ProductService
{
    public List<Product> GetProducts()
    {
        return List.of(
                new Product(
                        55555l,
                        "Emilio Barrera",
                        5500,
                        LocalDate.of(2023, Month.AUGUST, 6),
                        5)
        );
    }
}
