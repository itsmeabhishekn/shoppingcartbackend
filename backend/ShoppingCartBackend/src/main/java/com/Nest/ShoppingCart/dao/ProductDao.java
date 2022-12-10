package com.Nest.ShoppingCart.dao;

import com.Nest.ShoppingCart.model.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends CrudRepository<Products, Integer> {

    @Query(value = "SELECT `id`, `category`, `description`, `image`, `name`, `price` FROM `products` WHERE `name` = :name", nativeQuery = true)
    List<Products> searchProd(@Param("name") String name);







}
