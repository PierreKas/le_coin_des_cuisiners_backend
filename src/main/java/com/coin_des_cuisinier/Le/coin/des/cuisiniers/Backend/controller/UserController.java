package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.controller;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.dto.LoginRequest;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.dto.LoginResponse;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.Product;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.User;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList= userService.getAllUsers();
        return new  ResponseEntity<>(userList,HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addClient(@RequestBody User user){
        try {
            User savedUser = userService.addUser(user);
            return new  ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("error ", e);
            return null;
        }

    }

    @GetMapping("/by-id")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable int userId){
        try {
            Optional<User> userInfo= userService.findUserById(userId);
            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        } catch (Exception e) {
            log.error("error ", e);

            return null;
        }
    }

    @PutMapping(value = "/update/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateProduct(@PathVariable int userId, @RequestBody User user){
        try {
            User updatedUser = userService.updateUser(userId, user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            log.error("error ", e);

            return null;
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int userId){
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error("error ", e);

            return null;
        }
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = userService.login(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

}
