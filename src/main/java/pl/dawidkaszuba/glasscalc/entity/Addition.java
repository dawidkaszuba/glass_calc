package pl.dawidkaszuba.glasscalc.entity;

import javax.persistence.*;

@Entity
public class Addition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;
    private int deliveryTime;

    @Enumerated(EnumType.STRING)
    private MethodToCalculatePrice methodToCalculatePrice;

    public Addition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MethodToCalculatePrice getMethodToCalculatePrice() {
        return methodToCalculatePrice;
    }

    public void setMethodToCalculatePrice(MethodToCalculatePrice methodToCalculatePrice) {
        this.methodToCalculatePrice = methodToCalculatePrice;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
