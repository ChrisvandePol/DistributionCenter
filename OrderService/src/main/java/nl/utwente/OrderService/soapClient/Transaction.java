package nl.utwente.OrderService.soapClient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "storeId",
        "productId",
        "quantity"
})
@XmlRootElement(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @XmlElement(name = "storeId")
    private int storeId;
    private int productId;
    private int quantity;
    @XmlTransient
    private int deliveryId;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getStoreId() {return storeId;}
    public void setStoreId(int storeId) {this.storeId = storeId;}
    public int getProductId() {return productId;}
    public void setProductId(int productId) {this.productId = productId;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public int getDeliveryId() {return deliveryId;}
    public void setDeliveryId(int deliveryId) { this.deliveryId = deliveryId;}
}
