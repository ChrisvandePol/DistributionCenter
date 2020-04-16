package com.DeliveryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class DeliveryRestController {

    @Autowired private DeliveryRepository deliveryRepository;
    RestTemplate restTemplate = new RestTemplate();
    private static final String orderUrl = "http://localhost:8085/order/";

    @RequestMapping(path ="/delivery/{id}", method= RequestMethod.GET)
    public Delivery getDelivery(@PathVariable Integer id) {
        return deliveryRepository.findById(id).get();
    }

    @RequestMapping(path ="/delivery/", method= RequestMethod.GET)
    public List<Delivery> getDeliveries(@RequestParam(required = false, defaultValue = "0") Integer store) {
        if(store == 0) {
            return deliveryRepository.findAll();
        } else {
            return deliveryRepository.findByStoreId(store);
        }
    }

    @RequestMapping(path="/delivery",method=RequestMethod.POST)
    public Delivery postDelivery(@RequestBody Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @RequestMapping(path="/delivery/{id}",method=RequestMethod.PUT)
    public Delivery patchDelivery(@RequestBody Delivery delivery, @PathVariable("id") Integer id) {
        if(delivery.getStatus() == Delivery.Status.Delivered) {
            restTemplate.postForEntity(orderUrl,delivery.getStore(),Integer.class);
        }
        return deliveryRepository.save(delivery);
    }
}
