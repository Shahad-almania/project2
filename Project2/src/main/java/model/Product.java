package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;


@AllArgsConstructor @Data
public class Product {

    @NotEmpty(message = "Id: can't be null")
    @Range(min=3,message = "Id: have to be 3 character long")
    private String id;

    @NotEmpty(message = "Name: can't be null")
    @Size(min = 3, message = "Name: have to be 3 length long")
    private String name;

    @NotNull(message = "Price: can't be null")
    @Positive(message = "Price: must be positive number")
    private int price;

    @NotEmpty(message = "CategoryID: can't be null")
    @Size(min=3,message = "CategoryID: have to be 3 character long")
    private String categoryID;
}
