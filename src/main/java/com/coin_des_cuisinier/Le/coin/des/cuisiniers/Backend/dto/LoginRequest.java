package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String phoneNumber;
    private String password;
}
