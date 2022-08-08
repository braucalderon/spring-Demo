package com.revature.SpringBootDemo.controllers;

import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.models.ClientMessage;
import com.revature.SpringBootDemo.services.ICandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.revature.SpringBootDemo.utils.ClientMessageUtils.*;
import static com.revature.SpringBootDemo.utils.ClientMessageUtils.DELETION_FAILED;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "Access-Control-Allow-Origin", origins={"*"})
public class CandyController {


    @Autowired
    private ICandyService iCandyService;

    @GetMapping(value = "/candy", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Candy getById(@RequestParam int id){
        return(Candy) iCandyService.getById(id);
    }

    @GetMapping("/candies")
    public @ResponseBody
    List<Candy> getAll(){
        return iCandyService.getAll();
    }

    @PostMapping("/candies")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody
    ClientMessage createShop(@RequestBody Candy candy){
        return iCandyService.create(candy) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/candy")
    public @ResponseBody ClientMessage updateShop(@RequestBody Candy candy){
        return iCandyService.update(candy) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    public @ResponseBody ClientMessage deleteShop(@RequestBody Candy candy){
        return iCandyService.delete(candy) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }
}
