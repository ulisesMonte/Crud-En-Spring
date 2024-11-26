package com.example.demo.store;
import com.example.demo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Dto.StoreDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/store")
public class ProductsController {
    @Autowired
    public StoreServices services;
    @Autowired
    private StoreRepository repository;

    @GetMapping
    public List<StoreDTO> getStores() {
        List<Store> stores = repository.findAll();
        List<StoreDTO> storeDTOs = new ArrayList<>();

        // Convertir cada tienda a StoreDTO
        for (Store store : stores) {
            StoreDTO dto = services.toDTO(store);
            storeDTOs.add(dto);
        }

        return storeDTOs;
    }

    @GetMapping("/{idStore}")
    public List<Producto> getProductsInTheStore(@PathVariable Long idStore) {
        return services.getAllProductsFromStore(idStore);
    }

    @GetMapping("/{idStore}/{idP}")
    public Producto getProductInTheStoreByid(@PathVariable Long idStore, @PathVariable  Long idP) {
        Producto p = services.getProductByIdInstore(idStore,idP);
        return p;

    }

    @DeleteMapping("/{idStore}/{idProduct}")
    public void DeleteProductInTheStore(@PathVariable Long idStore, @PathVariable Long idProduct) {
        services.deleteProductById(idStore, idProduct);
    }

    @PostMapping("/{idStore}")
    public void addProductinTheStore(@RequestBody Producto product,Long idStore) throws Exception {
         services.addProductInTheStore(idStore, product);
    }

    @DeleteMapping("/{idStore}")
    public void DeleteStore(@PathVariable Long idStore){
        repository.deleteById(idStore);
    }

    @PostMapping
    public Store createStore(@RequestBody Store store ) {
        return services.addStore(store);
    }





}
