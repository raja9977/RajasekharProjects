package com.raja.mvc.service;



/*import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.raja.mvc.model.ProductModel;
import com.raja.mvc.project.ProductEntity;
import com.raja.mvc.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public void saveProductData(ProductModel productModel) {
        double price = productModel.getProPrice();
        String category = productModel.getProCategory();
        double dprice = 0.0;

        switch (category) {
            case "Mobile":
                dprice = price * 0.1;
                break;
            case "Laptop":
                dprice = price * 0.15;
                break;
            case "Printer":
                dprice = price * 0.2;
                break;
            case "Camera":
                dprice = price * 0.25;
                break;
        }

        // Map data from ProductModel to ProductEntity
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProName(productModel.getProName());
        productEntity.setProPrice(productModel.getProPrice());
        productEntity.setProCategory(productModel.getProCategory());
        productEntity.setProDescription(productModel.getProDescription());
        productEntity.setProBrand(productModel.getProBrand());
        productEntity.setDprice(dprice);
       
        productEntity.setCreatedAt(LocalDate.now());
        productEntity.setCreatedBy(System.getProperty("user.name"));

        // Save the entity to the database
        productRepository.save(productEntity);
       
        
        }
     

        public  List<ProductEntity>getAllProducts(){
	List<ProductEntity> products=productRepository.findAll();
	return products;
        

      
        }
     
     // Delete the product from the repository
        // Delete product by ID
        public void deleteProductById(long id) 
        {
            productRepository.deleteById(id);
        }
        
        
     // Method to update product data
        public void updateProductData(Long id, ProductModel productModel) {
            Optional<ProductEntity> existingProductOpt = productRepository.findById(id);
            
            if (existingProductOpt.isPresent()) {
                ProductEntity existingProduct = existingProductOpt.get();
                
                // Update fields
                existingProduct.setProName(productModel.getProName());
                existingProduct.setProBrand(productModel.getProBrand());
                existingProduct.setProPrice(productModel.getProPrice());
                existingProduct.setProDescription(productModel.getProDescription());
                existingProduct.setProCategory(productModel.getProCategory());
                existingProduct.setDprice(calculateDiscountedPrice(productModel.getProPrice(), productModel.getProCategory()));
                existingProduct.setCreatedAt(LocalDate.now()); // You might want to keep the original creation date instead
                existingProduct.setCreatedBy(System.getProperty("user.name"));
                
                // Save the updated entity
                productRepository.save(existingProduct);
            }
        }

        // Calculate discounted price based on category
        private double calculateDiscountedPrice(double price, String category) {
            double dprice = 0.0;
            switch (category) {
                case "Mobile":
                    dprice = price * 0.1;
                    break;
                case "Laptop":
                    dprice = price * 0.15;
                    break;
                case "Printer":
                    dprice = price * 0.2;
                    break;
                case "Camera":
                    dprice = price * 0.25;
                    break;
            }
            return dprice;
        }


    // Find product by ID
        public Optional<ProductEntity> findProductById(Long id) {
            return productRepository.findById(id);
        }
      
    // Find product by ID
        public Optional<ProductEntity> findProductById1(Long id) {
            return productRepository.findById(id);
        }
        public Optional<ProductModel> findProductById11(Long id) {
            Optional<ProductEntity> productEntity = productRepository.findById(id);

            if (productEntity.isPresent()) {
                ProductModel productModel = convertEntityToModel(productEntity.get());
                return Optional.of(productModel);
            } else {
                return Optional.empty(); // If product not found
            }
        }

        // Update Product
        public void updateProduct(Long id, ProductModel productModel) {
            Optional<ProductEntity> existingProduct = productRepository.findById(id);

            if (existingProduct.isPresent()) {
                ProductEntity productEntity = existingProduct.get();
                
                // Update fields
                productEntity.setProName(productModel.getProName());
                productEntity.setProPrice(productModel.getProPrice());
                productEntity.setProBrand(productModel.getProBrand());
                productEntity.setProDescription(productModel.getProDescription());
                productEntity.setProCategory(productModel.getProCategory());
                
                productRepository.save(productEntity); // Save updated product
            }
        }

        // Helper method to convert Entity to Model
        private ProductModel convertEntityToModel(ProductEntity productEntity) {
            ProductModel productModel = new ProductModel();
            productModel.setProName(productEntity.getProName());
            productModel.setProPrice(productEntity.getProPrice());
            productModel.setProBrand(productEntity.getProBrand());
            productModel.setProDescription(productEntity.getProDescription());
            productModel.setProCategory(productEntity.getProCategory());
            return productModel;
        }
        
        
        
        // Fetch product by ID
        public Optional<ProductEntity> findProductById111(Long id)
        {
            return productRepository.findById(id);
        }
}*/








import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.raja.mvc.project.ProductEntity;
import com.raja.mvc.model.ProductModel;
import com.raja.mvc.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public void saveProductData(ProductModel productModel) {
        double price = productModel.getProPrice();
        String category = productModel.getProCategory();
        double dprice = 0.0;

        switch (category) {
            case "Mobile":
                dprice = price * 0.1;
                break;
            case "Laptop":
                dprice = price * 0.15;
                break;
            case "Printer":
                dprice = price * 0.2;
                break;
            case "Camera":
                dprice = price * 0.25;
                break;
        }

        // Map data from ProductModel to ProductEntity
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProName(productModel.getProName());
        productEntity.setProPrice(productModel.getProPrice());
        productEntity.setProCategory(productModel.getProCategory());
        productEntity.setProDescription(productModel.getProDescription());
        productEntity.setProBrand(productModel.getProBrand());
        productEntity.setDprice(dprice);
        productEntity.setCreatedAt(LocalDate.now());
        productEntity.setCreatedBy(System.getProperty("user.name"));

        // Save the entity to the database
        productRepository.save(productEntity);
       
        
        }
     

        public  List<ProductEntity>getAllProducts(){
	List<ProductEntity> products=productRepository.findAll();
	return products;
        }
  
        

        
        
     // Delete the product from the repository
        // Delete product by ID
        public void deleteProductById(long id) {
            productRepository.deleteById(id);	
        }
        

        // Fetch product by ID
           public Optional<ProductEntity> findProductById1(Long id) {
               return productRepository.findById(id);
           }
           
        
        
	        
	        // Method to update product data
	        public void updateProductData(Long id, ProductModel productModel) {
	            Optional<ProductEntity> existingProductOpt = productRepository.findById(id);
	            
	            if (existingProductOpt.isPresent()) {
	                ProductEntity existingProduct = existingProductOpt.get();
	                
	                // Update fields
	                existingProduct.setProName(productModel.getProName());
	                existingProduct.setProBrand(productModel.getProBrand());
	                existingProduct.setProPrice(productModel.getProPrice());
	                existingProduct.setProDescription(productModel.getProDescription());
	                existingProduct.setProCategory(productModel.getProCategory());
	               existingProduct.setDprice(calculateDiscountedPrice(productModel.getProPrice(), productModel.getProCategory()));
	                existingProduct.setCreatedAt(LocalDate.now()); // You might want to keep the original creation date instead
	                existingProduct.setCreatedBy(System.getProperty("user.name"));
	                
	                // Save the updated entity
	                productRepository.save(existingProduct);
	            }
	        }

	        // Calculate discounted price based on category
	        private double calculateDiscountedPrice(double price, String category) {
	            double dprice = 0.0;
	            switch (category) {
	                case "Mobile":
	                    dprice = price * 0.1;
	                    break;
	                case "Laptop":
	                    dprice = price * 0.15;
	                    break;
	                case "Printer":
	                    dprice = price * 0.2;
	                    break;
	                case "Camera":
	                    dprice = price * 0.25;
	                    break;
	            }
	            return dprice;
	        }

	
	

     // Find product by ID
        public Optional<ProductEntity> findProductById(Long id) {
        	
        
            return productRepository.findById(id);
            
        }
        
         
        


}
    
    
   




	  
	  





