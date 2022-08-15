package controller;

import model.ApiResponse;
import model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.User_Service;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
public class User_Controller {

    private final User_Service userService ;

    public User_Controller(User_Service userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity getUser(){
        ArrayList<User> users=userService.getUser();
        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        userService.addUser(user);
        return ResponseEntity.status(201).body( new ApiResponse("New user added..",201));
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@RequestBody @Valid User user,@PathVariable int index,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));
        }
        userService.updateUser(index, user);
        return ResponseEntity.status(201).body(new ApiResponse("User updated !", 201));
    }
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteUser(@PathVariable int index){
        userService.deleteUser(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted..",200));
    }
}
