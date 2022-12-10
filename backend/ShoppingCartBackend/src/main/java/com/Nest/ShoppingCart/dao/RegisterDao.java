package com.Nest.ShoppingCart.dao;

import com.Nest.ShoppingCart.model.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegisterDao extends CrudRepository <Registration, Integer>{
    @Query(value = "SELECT `id`, `address`, `email_id`, `name`, `password`, `phn_no`, `username` FROM `registration` WHERE `email_id`=:email_id and `password`=:password", nativeQuery = true)
    List<Registration> findUserLogin(@Param("email_id") String email_id,@Param("password") String password);


    @Query(value = "SELECT `id`, `address`, `email_id`, `name`, `password`, `phn_no`, `username` FROM `registration` WHERE `id`=:id", nativeQuery = true)
    List<Registration> findUserById(@Param("id") int id);

}
