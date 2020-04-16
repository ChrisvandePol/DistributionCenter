package nl.utwente.OrderService.soapClient;

import nl.utwente.OrderService.integration.DeliveryPart;
import nl.utwente.OrderService.integration.NewDeliveryRequest;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

public class SoapClient extends WebServiceGatewaySupport {


    public void sendDelivery(List<Transaction> transactions) {
        NewDeliveryRequest request = new NewDeliveryRequest();
        List<DeliveryPart> deliveryContent = request.getDeliveryContent();
        for (Transaction i : transactions) {
            DeliveryPart part = new DeliveryPart();
            part.setProductId(i.getProductId());
            part.setAmount(i.getQuantity());
            deliveryContent.add(part);
        }

        getWebServiceTemplate().marshalSendAndReceive("http://localhost:8084/deliveryDoneService/",
                request, new SoapActionCallback("http://localhost:8084/deliveryDoneService/newDeliveryRequest"));

    }
}
