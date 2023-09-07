package Emisoft.Crud.Services;

import Emisoft.Crud.Product.Product;
import Emisoft.Crud.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

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

    public ResponseEntity<Object> NewProduct(Product product)
    {
        Optional<Product> resultProduct = this.productRepository.findProductByName(product.getName());
        HashMap<String, Object> datas = new HashMap<>();

        if (resultProduct.isPresent())
        {
            datas.put("Error", true);
            datas.put("Mensaje", "There is a Product with the same Name.");

           return new ResponseEntity<>(datas,HttpStatus.CONFLICT);
        }
        else
        {
            productRepository.save(product);
            datas.put("data", product);
            datas.put("message", "The product was insert in the Db.");

            return new ResponseEntity<>(datas,HttpStatus.CREATED);
        }
    }
}
