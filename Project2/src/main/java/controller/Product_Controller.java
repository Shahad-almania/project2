package controller;

import model.ApiResponse;
import model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.Product_Service;
import javax.validation.Valid;



@RestController
@RequestMapping("/api/v1/product")
public class Product_Controller {

    private final Product_Service productService ;

    public Product_Controller(Product_Service productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(productService.getProduct(productId));
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        productService.addProduct(product);
        return ResponseEntity.status(201).body( new ApiResponse("New product added !",201));
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateProduct(@RequestBody @Valid Product product,@PathVariable int index,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        productService.updateProduct(index, product);
        return ResponseEntity.status(201).body(new ApiResponse("Product updated..", 201));
    }
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteProduct(@PathVariable int index){
        productService.deleteProduct(index);
        return ResponseEntity.status(200).body(new ApiResponse("Product deleted..",200));
    }

}
