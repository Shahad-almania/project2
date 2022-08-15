package controller;

import lombok.RequiredArgsConstructor;
import model.ApiResponse;
import model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.Category_Service;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
public class Category_Controller {

    private final Category_Service categoryService;

    public Category_Controller(Category_Service categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity getCategory(){
        ArrayList<Category> category=categoryService.getCategory();
        return ResponseEntity.status(200).body(category);
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse("Errors..",400));
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(201).body( new ApiResponse("New category added !",201));
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateCategory(@RequestBody @Valid Category category,@PathVariable int index,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse("Errors..", 400));
        }
        categoryService.updateCategory(index, category);
        return ResponseEntity.status(201).body(new ApiResponse("Category updated !", 201));
    }
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteCategory(@PathVariable int index){
        categoryService.deleteCategory(index);
        return ResponseEntity.status(200).body(new ApiResponse("Category deleted !",200));
    }
}
