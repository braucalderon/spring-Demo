package com.revature.SpringBootDemo.controllers;

// Good practice for creating a RESTFUL app is using @RestController
//as well as maintaining the same 'base' url

import static com.revature.SpringBootDemo.utils.ClientMessageUtils.*;

import com.revature.SpringBootDemo.models.ClientMessage;
import com.revature.SpringBootDemo.models.Shop;
import com.revature.SpringBootDemo.services.IShopServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ShopController {


    @Autowired
    private IShopServices iShopServices;

    @GetMapping(value = "/shop", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Shop getById(@RequestParam int id){
        return(Shop) iShopServices.getById(id);
    }

    @GetMapping("/shops")
    public @ResponseBody List<Shop> getAll(){
        return iShopServices.getAll();
    }

    @PostMapping("/shops")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createShop(@RequestBody Shop shop){
        return iShopServices.create(shop) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/shop")
    public @ResponseBody ClientMessage updateShop(@RequestBody Shop shop){
        return iShopServices.update(shop) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    public @ResponseBody ClientMessage deleteShop(@RequestBody Shop shop){
        return iShopServices.delete(shop) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }


}
