package com.example.demo.store;
import jakarta.persistence.*;
import com.example.demo.Producto;

import java.util.*;

@Entity
@Table(name="Stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idStore;
    String StoreName;
    @ManyToMany
    private List<Producto> productsInStore = new ArrayList<>();
    @JoinTable(
            name = "store_productos",
            joinColumns = @JoinColumn(name = "id_productos"),
            inverseJoinColumns = @JoinColumn(name = "id_store")
    )


    public void addProducto(Producto product) {
        if (!productsInStore.contains(product)) {
            productsInStore.add(product);
        }
    }
    public void setStoreName(String nameS){
        this.StoreName = nameS;
    }
    public Producto getProductById(Long prodcutId) {
        for (Producto p : productsInStore) {
            if (p.getId() == prodcutId) {
                return p;
            }
        }
        return null;
    }
    public List<Producto> getProductsInStore() {

        return productsInStore;
    }
    public void setProductsInStore(List<Producto> productsStore) {
        this.productsInStore = productsStore;
    }

    public void eliminarP(Producto product) {
        if (productsInStore.remove(product)) {
            productsInStore.remove(product);
        }
    }
    public Long getIdStore(){
        return this.idStore;
    }
    public String getStoreName(){
        return this.StoreName;
    }
}

