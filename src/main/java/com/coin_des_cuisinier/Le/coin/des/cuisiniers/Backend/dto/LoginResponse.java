package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.dto;

import lombok.Data;

@Data
public class LoginResponse {

    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;
    private String userStatus;
    private String role;
}
