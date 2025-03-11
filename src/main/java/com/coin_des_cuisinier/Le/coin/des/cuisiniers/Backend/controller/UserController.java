package coin.cuisiniers.dashboard_backend.controller;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.User;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList= userService.getAllUsers();
        return new  ResponseEntity<>(userList,HttpStatus.OK);
    }

}
