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

@Service public class ProductService
{
    private final ProductRepository productRepository;

    @Autowired public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public List<Product> GetProducts()
    {
        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> NewProduct(Product product)
    {
        Optional<Product> resultProduct = this.productRepository.findProductByName(product.getName());
        HashMap<String, Object> datas = new HashMap<>();

        if (resultProduct.isPresent())
        {
            datas.put("Error", true);
            datas.put("Mensaje", "There is a Product with the same Name.");

            return new ResponseEntity<>(datas, HttpStatus.CONFLICT);
        }
        else
        {
            productRepository.save(product);
            datas.put("data", product);
            datas.put("message", "The product was insert in the Db.");

            return new ResponseEntity<>(datas, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> EditProduct(Product product)
    {
        Optional<Product> prodcutResul = this.productRepository.findProductByName(product.getName());
        HashMap<String, Object> datas = new HashMap<>();

        if (prodcutResul.isPresent() && product.getId() == null)
        {
            datas.put("Error", true);
            datas.put("message", "There is a product with the same Name.");

            return new ResponseEntity<>(datas, HttpStatus.CONFLICT);
        }

        datas.put("message", "The product was insert in the Db.");

        if (product.getId() != null)
        {

            datas.put("message", "Tha Porduct was Edit Secceful in the Db!");


        }

        productRepository.save(product);
        datas.put("dat", product);
        return new ResponseEntity<>(datas, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> DeleteProduct(Long id)
    {
        var productExist = this.productRepository.existsById(id);
        HashMap<String, Object> datas = new HashMap<>();

        if (!productExist)
        {
            datas.put("Error", true);
            datas.put("message", "There isn't a Porduct with this Id!.");
            return  new ResponseEntity<>(datas, HttpStatus.CONFLICT);
        }

        this.productRepository.deleteById(id);
           datas.put("message", "Porduct was Delete from the DB!.");
        return  new ResponseEntity<>(datas, HttpStatus.ACCEPTED);
    }
}
