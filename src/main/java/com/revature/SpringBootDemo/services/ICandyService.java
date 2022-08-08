package com.revature.SpringBootDemo.services;


import com.revature.SpringBootDemo.models.Candy;

import java.util.List;

public interface ICandyService{

    boolean create(Candy candy);
    Candy getById(int id);
    List<Candy> getAll();
    boolean update(Candy candy);
    boolean delete(Candy candy);
}
