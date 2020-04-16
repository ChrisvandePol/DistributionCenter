package com.DeliveryService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@JsonIgnoreProperties
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int storeId;
    private LocalDateTime requestedAt;
    public enum Status {
        Requested,
        OnTheWay,
        Delivered
    };
    private Status status;

    //TODO geef status
    //TODO maak producten
    public Delivery(int storeId) {
        this.storeId = storeId;
        this.requestedAt = LocalDateTime.now();
        this.status = status.Requested;
    }

    public Delivery(){};

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public int getStore() {
        return storeId;
    }
    public void setStore(int storeId){this.storeId = storeId;}


    public Status getStatus(){return status;}
    public void setStatus(Status status) {this.status = status;}

    public Delivery sendDelivery() {
        this.status = Status.OnTheWay;
        return this;
    }

    public Delivery finishDelivery() {
        this.status = Status.Delivered;
        return this;
    }



    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }
    public void setRequestedAt(LocalDateTime requestedAt) {this.requestedAt = requestedAt;}


    public String toString() {
        return "Delivery{" +
                "id="+ id +
                ", store=" + storeId +
                ", requestedAt=" + requestedAt +
                ", status=" + status + "}";
    }
}
