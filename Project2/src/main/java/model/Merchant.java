package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Merchant {

    @NotEmpty(message = "Id: can't be null")
    @Size(min=3,message = "Id: have to be 3 character long")
    private String id;

    @NotEmpty(message = "Name: can't be null")
    @Size(min = 3, message = "Name: have to be 3 length long")
    private String name;
}
