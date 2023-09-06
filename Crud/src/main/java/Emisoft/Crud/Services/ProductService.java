package Emisoft.Crud.Services;

import Emisoft.Crud.Product.Product;
import Emisoft.Crud.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ProductService
{
    private final ProductRepository productReposito;

   @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productReposito = productRepository;
    }

    public List<Product> GetProducts()
    {
      return   this.productReposito.findAll();
    }
}
