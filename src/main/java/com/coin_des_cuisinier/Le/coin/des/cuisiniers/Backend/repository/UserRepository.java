package com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.repository;

import com.coin_des_cuisinier.Le.coin.des.cuisiniers.Backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
