package com.raja.mvc.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.raja.mvc.model.ProductModel;
import com.raja.mvc.project.ProductEntity;
import com.raja.mvc.service.ProductService;

import jakarta.validation.Valid;
@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
    
	
	

	@GetMapping("/productform")
	public String getProductForm(Model model)
	{
		ProductModel productModel=new ProductModel();
		model.addAttribute("productModel", productModel);
		model.addAttribute("page","productform");
		return"index";
		}
	
	
	@PostMapping("/submitProduct")
    public String saveProduct(@Valid @ModelAttribute("productModel") ProductModel productModel, 
                             BindingResult bindingResult, Model model) {
        // Check for validation errors
        if (bindingResult.hasErrors()) {
            // If there are validation errors, return to the product form with errors
            model.addAttribute("page", "productform");
            
            return "index";  // return to the form page (assuming "productForm.html" is your Thymeleaf template)
        }

      

        // Redirect to a success page or product list page after successful validation
        model.addAttribute("page", "submitProduct");
        productService.saveProductData(productModel);
        return "index";  // assuming there is a page that lists products
    }
	
	
	
	
	@GetMapping("/getProducts")
	public String getAllProducts(Model model)
	{
		List<ProductEntity> products=productService.getAllProducts();
		model.addAttribute("products", products);
		model.addAttribute("page","getProducts");
		return"index";
		
	
	}
	
	@GetMapping("/delete/{proId}")
	public String deleteProduct(@PathVariable long proId) {
		
		productService.deleteProductById(proId);
	    return "redirect:/getProducts"; // Redirect back to the product list
	}
	
	@GetMapping("/edit/{id}")                                                                   
	 public String editProductForm(@PathVariable Long id, Model model) {                         
	     Optional<ProductEntity> product = productService.findProductById(id);                   
	                                                                                             
	     if (product.isPresent()) {                                                              
	         model.addAttribute("productModel", product.get());
	         model.addAttribute("page","edit");
	         return "index"; // View for editing product                                  
	     } else {                                                                                
	         model.addAttribute("errorMessage", "Product not found");                            
	         return "error"; // Redirect to an error page if not found                           
	     }                                                                                       
	 }
	
	@PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id,  ProductModel productModel) 
	{
        productService.updateProductData(id, productModel); // Call service to update product
        return "redirect:/getProducts";
	
	

		
	}
	
	
       @GetMapping("/postid")
       public String getWeb1(Model model) {
    	   model.addAttribute("page","postid");
           return "index"; // Returns the id.html template
       }
       
  
       
       // Handling POST request for fetching product by ID
       @PostMapping("/get-product-by-id")
       public String getProductById(@RequestParam("id") Long id, Model model) {
           Optional<ProductEntity> product = productService.findProductById1(id);
           if (product.isPresent()) {
               model.addAttribute("product", product.get());
           } else {
               model.addAttribute("error", "Product not found");
           }
           model.addAttribute("page","get-product-by-id");
           return "index"; // Returns the single.html template for product details
       }
         
	
	@GetMapping("/contact")
    public String contactUs(Model model) 
	{
		model.addAttribute("page","contact");
        return "index"; // Returns the name of the HTML file
    }

    @GetMapping("/about")
    public String aboutUs(Model model) {
    	model.addAttribute("page","about");
        return "index"; // Returns the name of the HTML file 
    }
    
    @GetMapping("/")
    public String getHomePage()
    {
    	return"index";
    	
    }
}


