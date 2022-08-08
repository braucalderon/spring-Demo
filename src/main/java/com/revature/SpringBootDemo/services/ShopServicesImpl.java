package com.revature.SpringBootDemo.services;


import com.revature.SpringBootDemo.models.Shop;
import com.revature.SpringBootDemo.repos.IShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShopServicesImpl implements IShopServices{

   @Autowired
    IShopRepo shopRepo;


    public ShopServicesImpl(IShopRepo shopRepo) {
        this.shopRepo = shopRepo;
    }

    @Override
    public boolean create(Shop shop) {
        int pk = shopRepo.save(shop).getId();
        return (pk > 0) ? true : false;
    }

    @Override
    public Shop getById(int id) {
        try{
            Optional<Shop> target = shopRepo.findById(id);
            Shop shop = target.get();
            return shop;
        } catch( Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Shop> getAll() {
        return shopRepo.findAll();
    }

    @Override
    public boolean update(Shop shop) {
        return shopRepo.update(shop.getShopName(), shop.getInventoryCount(), shop.getId());
    }

    @Override
    public boolean delete(Shop shop) {
        shopRepo.delete(shop);
        return true;
    }
}
