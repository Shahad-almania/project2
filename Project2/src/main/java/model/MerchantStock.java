package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class MerchantStock {

    @NotEmpty(message = "Id: can't be null")
    @Size(min=3,message = "Id: have to be 3 character long")
    private String id;

    @NotEmpty(message = "ProductID: can't be null")
    @Size(min=3,message = "productID: have to be 3 character long")
    private String productID;


    @NotNull(message = "MerchantID: can't be null")
    @Range(min=3,max=3,message = "merchantID: have to be 3 character long")
    private int merchantID;

    @NotNull(message = "Stock: can't be null")
    @Range(min=10,message = "Stock: have to be more than 10 at start ")
    private int stock;

}

