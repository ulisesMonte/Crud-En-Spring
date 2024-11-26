package com.example.demo.store;
import com.example.demo.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import com.example.demo.Dto.StoreDTO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServices {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    StoreRepository repository;
    @Autowired
    productoRepository productRepo;

    public StoreDTO toDTO(Store store) {
        List<Long> productIds = store.getProductsInStore().stream()
                .map(Producto::getId)
                .collect(Collectors.toList());
        return new StoreDTO(store.getIdStore(), store.getStoreName(), productIds);
    }

    public void addProductInTheStore(Long storeId, Producto product)  {
        Store store = repository.findById(storeId).get();
        store.addProducto(product);
        repository.save(store);
    }



    public void deleteProductById(Long storeId,Long productId){
        Store store = repository.findById(storeId).get();
        Producto product = productRepo.findProductByid(productId).get();

        store.eliminarP(product);

        repository.save(store);

    }


    public List<Producto> getAllProductsFromStore(Long storeId){
        Store store = repository.findById(storeId).get();
        return store.getProductsInStore();
    }

    public Producto getProductByIdInstore(Long idStore, Long idP){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Producto> query = cb.createQuery(Producto.class);
        Root<Store> storeRoot = query.from(Store.class);

        Join<Store, Producto> productoStoreJoin= storeRoot.join("productsInStore");
        query.select(productoStoreJoin)
                .where(
                        cb.equal(storeRoot.get("idStore"), idStore),
                        cb.equal(productoStoreJoin.get("idproducto"),idP));
        TypedQuery<Producto> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }

    public Store addStore(Store store){
        for (Producto producto : store.getProductsInStore()) {
            Optional<Producto> existingProduct = productRepo.findProductByid(producto.getId());
            if (existingProduct.isPresent()) {
                store.addProducto(existingProduct.get());
                store.setStoreName(store.getStoreName());
            } else {
                productRepo.save(producto);
                store.addProducto(producto);
            }
        }
        return repository.save(store);
    }

}
