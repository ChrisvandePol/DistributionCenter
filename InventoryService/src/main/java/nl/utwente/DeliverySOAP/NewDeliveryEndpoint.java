package nl.utwente.DeliverySOAP;

import nl.utwente.DeliverySOAP.integration.DeliveryPart;
import nl.utwente.DeliverySOAP.integration.NewDeliveryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class NewDeliveryEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8084/deliveryDoneService/";
    @Autowired ProductRepository productRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "newDeliveryRequest")
    public void notifyNewDelivery(@RequestPayload NewDeliveryRequest newDeliveryRequest) {
        System.out.println("New delivery registered:");
        for (DeliveryPart part : newDeliveryRequest.getDeliveryContent()) {
            System.out.println(part.getProductId());
            System.out.println(part.getAmount());

            Product product = productRepository.findById(part.getProductId()).get();
            if (product == null) {
                product = new Product();
                product.setQuantity(part.getAmount());
            }
            product.setQuantity(product.getQuantity()+part.getAmount());
            productRepository.save(product);
        }
    }
}
