package nl.utwente.OrderService.soapClient.Rest;


import nl.utwente.OrderService.soapClient.SoapClient;
import nl.utwente.OrderService.soapClient.Transaction;
import nl.utwente.OrderService.soapClient.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {

    @Autowired private TransactionRepository transactionRepository;
    @Autowired
    SoapClient soapClient;

    @RequestMapping(path="/order",method=RequestMethod.POST)
    public Integer postDelivery(@RequestBody Integer storeId) {
        List<Transaction> transactions = transactionRepository.findByStoreId(storeId);
        soapClient.sendDelivery(transactions);
        transactionRepository.deleteAll(transactions);
        return 0;
    }

}
