package controller;

import model.ApiResponse;
import model.Merchant;
import model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.Merchant_Service;


import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/merchant")
public class Merchant_Controller {
    private final Merchant_Service merchantService ;

    public Merchant_Controller(Merchant_Service merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping
    public ResponseEntity getMerchant(){
        return ResponseEntity.status(200).body(merchantService.getMerchant());
    }

    @PostMapping
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(201).body( new ApiResponse("New merchant added..",201));
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateMerchant(@RequestBody @Valid Merchant merchant,@PathVariable int index,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        merchantService.updateMerchant(index, merchant);
        return ResponseEntity.status(201).body(new ApiResponse("Merchant updated..", 201));
    }
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteMerchant(@PathVariable int index){
        merchantService.deleteMerchant(index);
        return ResponseEntity.status(200).body(new ApiResponse("Product deleted..",200));
    }
}

