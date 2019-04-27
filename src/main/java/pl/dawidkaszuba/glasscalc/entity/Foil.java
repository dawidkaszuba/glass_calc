package pl.dawidkaszuba.glasscalc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Foil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double thickness;
    private boolean isMat;
    private boolean isAcustic;
    private double price;
    private int deliveryTime;

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

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public boolean getIsMat() {
        return isMat;
    }

    public void setIsMat(boolean mat) {
        isMat = mat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsAcustic() {
        return isAcustic;
    }

    public void setIsAcustic(boolean acustic) {
        isAcustic = acustic;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
