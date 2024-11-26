package com.example.demo;
import com.example.demo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface productoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findProductByid(Long id);
}
