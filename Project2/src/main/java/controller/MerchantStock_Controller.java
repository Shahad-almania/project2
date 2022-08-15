package controller;

import model.ApiResponse;
import model.MerchantStock;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.MerchantStock_Service;


import javax.validation.Valid;



@RestController
@RequestMapping("/api/v1/merchantStock")
public class MerchantStock_Controller {
    private final MerchantStock_Service merchantStockService;

    public MerchantStock_Controller(MerchantStock_Service merchantStockService) {
        this.merchantStockService = merchantStockService;
    }

    @GetMapping
    public ResponseEntity getMerchantStock() {
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStocks());
    }

    @PostMapping
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStocks, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        merchantStockService.addMerchantStocks(merchantStocks);
        return ResponseEntity.status(201).body(new ApiResponse("New merchantStock added..", 201));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStock merchantStock, @PathVariable int index, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        merchantStockService.updateMerchantStocks(index, merchantStock);
        return ResponseEntity.status(201).body(new ApiResponse("MerchantStock updated ..", 201));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteMerchantStock(@PathVariable int index) {
        merchantStockService.deleteMerchantStocks(index);
        return ResponseEntity.status(200).body(new ApiResponse("MerchantStock deleted..", 200));
    }


    @PostMapping("/NewProduct") ////////////////////////////////////////////////////////////////////3
    public ResponseEntity addNewProduct(@RequestParam String productID,@RequestParam int merchantID,@RequestParam int stock) {
        int isValid = MerchantStock_Service.addNewProduct(productID, merchantID, stock);
        if (isValid == 1) {
            return ResponseEntity.status(201).body(new ApiResponse("add new product..", 201));
        } else if (isValid == 2){
            return ResponseEntity.status(400).body(new ApiResponse("Error", 400));
    }       return null;

   }


}



