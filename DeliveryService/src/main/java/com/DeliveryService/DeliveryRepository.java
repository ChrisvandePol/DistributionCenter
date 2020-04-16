package com.DeliveryService;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeliveryRepository extends CrudRepository<Delivery,Integer> {

    List<Delivery> findByStoreId(int StoreId);
    List<Delivery> findAll();
}
