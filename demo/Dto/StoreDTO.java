package com.example.demo.Dto;

import java.util.List;

public class StoreDTO {
    private Long idStore;
    private String storeName;
    private List<Long> productIds; // Assuming you want to transfer only the product IDs

    public StoreDTO() {
    }

    public StoreDTO(Long idStore, String storeName, List<Long> productIds) {
        this.idStore = idStore;
        this.storeName = storeName;
        this.productIds = productIds;
    }

    public Long getIdStore() {
        return idStore;
    }

    public void setIdStore(Long idStore) {
        this.idStore = idStore;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}