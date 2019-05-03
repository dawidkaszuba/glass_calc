package pl.dawidkaszuba.glasscalc.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Addition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private double price;

    @Min(1)
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
