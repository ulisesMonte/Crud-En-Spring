package com.example.demo;
import jakarta.persistence.*;

import com.example.demo.store.Store;
import java.util.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idproducto;


    private String name;
    private double price;

    public Long getId(){
        return idproducto;
    }

    public void setId(long id) {this.idproducto=id;}
    public String getNombre(){
        return name;
    }

    public void setNombre(String nombre){
        this.name = nombre;
    }
    public void setPrecio(int precio){
        this.price = precio;
    }
    public Double getPrecio(){
        return price;
    }


}
