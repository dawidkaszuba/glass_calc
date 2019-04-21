package pl.dawidkaszuba.glasscalc.entity;

import javax.persistence.*;

@Entity
public class Addition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

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
}
