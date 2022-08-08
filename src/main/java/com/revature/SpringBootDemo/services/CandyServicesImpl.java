package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.repos.ICandyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CandyServicesImpl implements ICandyService {

    @Autowired
    private ICandyRepo iCandyRepo;


    public CandyServicesImpl(ICandyRepo iCandyRepo) {
        this.iCandyRepo = iCandyRepo;
    }

    @Override
    public boolean create(Candy candy) {
       int pk = iCandyRepo.save(candy).getId();
        return (pk > 0) ? true : false;
    }

    @Override
    public Candy getById(int id) {
        return iCandyRepo.findById(id);
    }

    @Override
    public List<Candy> getAll() {
        return iCandyRepo.findAll();
    }

    @Override
    public boolean update(Candy candy) {
        return iCandyRepo.update(candy.getName(), candy.getPrice(), candy.getId());
    }

    @Override
    public boolean delete(Candy candy) {
        iCandyRepo.delete(candy);
        return true;
    }

}
