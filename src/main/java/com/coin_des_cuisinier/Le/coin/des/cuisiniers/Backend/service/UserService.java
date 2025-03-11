package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.service;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.User;
import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User addUser(User user){
        return userRepository.save(user);
    }
    public Optional<User> findUserById(int id){
        Optional<User> user= userRepository.findById(id);
        return user;
    }

    public User updateUser(int userId,User updatedUser){
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()){
            User user = existingUser.get();
            user.setUserStatus(updatedUser.getUserStatus());
            user.setEmail(updatedUser.getEmail());
            user.setAddress(updatedUser.getAddress());
            user.setRole(updatedUser.getRole());
            user.setFullName(updatedUser.getFullName());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            user.setPassword(updatedUser.getPassword());

            return userRepository.save(updatedUser);

        }else {
            return null;
        }

    }

    public void deleteUser(int id){

        userRepository.deleteById(id);
    }
}
