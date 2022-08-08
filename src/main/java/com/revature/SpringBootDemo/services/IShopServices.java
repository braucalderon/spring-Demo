package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Shop;

import java.util.List;

public interface IShopServices {

    boolean create(Shop shop);
    Shop getById(int id);
    List<Shop> getAll();
    boolean update(Shop shop);
    boolean delete(Shop shop);
}
