package nl.utwente.DeliverySOAP;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private int quantity;


    public Product(){}

    public Product(int id, String description){
        this.id = id;
        this.description = description;
    }

    public Product(int id) {
        this.id = id;
    }

    public String toString() {
        return "Product{id=" + id +
                ",description=" + description + "}";
    }

    public int getId() {return id;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

}
