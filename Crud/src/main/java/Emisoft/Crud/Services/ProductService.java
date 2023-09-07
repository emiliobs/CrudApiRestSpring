package Emisoft.Crud.Services;

import Emisoft.Crud.Product.Product;
import Emisoft.Crud.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    private final ProductRepository productRepository;

   @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public List<Product> GetProducts()
    {
      return   this.productRepository.findAll();
    }

    public void NewProduct(Product product)
    {
        Optional<Product> resultProduct = this.productRepository.findProductByName(product.getName());

        if (resultProduct.isPresent())
        {
            throw  new IllegalStateException("There is a Prodcut in DB.");
        }
        else
        {
            productRepository.save(product);
        }
    }
}
