package nl.utwente.OrderService.soapClient;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Table;
import java.util.List;

@Table(name = "CUSTOMER_ORDERS")
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    List<Transaction> findByStoreId(int storeId);
}
