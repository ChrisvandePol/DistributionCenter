package nl.utwente.DeliverySOAP;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {


    List<Product> findAll();
}
