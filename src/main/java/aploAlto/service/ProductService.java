package aploAlto.service;



import aploAlto.Model.Product;
import aploAlto.repository.ProductRepository;
import aploAlto.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create a new product
    public Product createProduct(Product product) {
        try{
            return productRepository.save(product);
        }catch (Exception e){
            throw new ProductNotFoundException("Product could not empty");
        }
    }

    // Get all products
    public Optional<List<Product>> getAllProducts() {
        return Optional.of(productRepository.findAll());
    }

    // Get product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

    // Update product
    public Product updateProduct(Long id, Product product) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
        product.setId(id);
        return productRepository.save(product);
    }

    // Delete product
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
        productRepository.deleteById(id);
    }
}