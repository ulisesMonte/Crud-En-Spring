package com.example.demo.store;

import com.example.demo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

     Optional<Store> findById(Long id);


}
