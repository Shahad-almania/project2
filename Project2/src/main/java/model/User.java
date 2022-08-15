package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class User {

    @NotEmpty(message = "Id: can't be null")
    @Size(min=3,message = "Id: have to be 3 character long")
    private String id;

    @NotEmpty(message = "Username: can't be null")
    @Size(min = 5,max = 5,message = "Username: have to be 5 length long")
    private String username;

    @NotEmpty(message = "Password: can't be null")
    @Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.*[A-Z]).{6,}$",message = "Password: have to be 6 length long, must have characters and digits ")
    private String password;

    @NotEmpty(message = "Email: can't be empty")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotEmpty(message = "Role: can't be empty")
    @Pattern(regexp = "(Admin|Customer)",message = "Role: must be in customer or admin only")
    private String role;

    @NotEmpty(message = "Balance: can't be null")
    @Positive(message = "Balance: must be positive number")
    private int balance;
}
