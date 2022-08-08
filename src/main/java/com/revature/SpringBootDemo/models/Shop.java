package com.revature.SpringBootDemo.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shops")
@Data // will get all the getters and setters
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // serial
    @Column(name = "s_id")
    private int id;

    @Column(name = "s_name", unique = true, nullable = false)
    private String shopName;

    @Column(name = "s_invent_count", nullable = false)
    private  int inventoryCount;


    public Shop() {
    }

    public Shop(String shopName, int inventoryCount) {
        this.shopName = shopName;
        this.inventoryCount = this.inventoryCount;
    }

    public Shop(int id, String shopName, int invertorycount) {
        this.id = id;
        this.shopName = shopName;
        this.inventoryCount = invertorycount;
    }


}
