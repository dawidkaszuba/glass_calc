package pl.dawidkaszuba.glasscalc.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
public class Tile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private double thickness;
    private boolean isTempered;
    @ManyToOne
    private Coating coating;
    @ManyToOne
    private TileGroup group;
    private double price;

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

    public boolean getIsTempered() {
        return isTempered;
    }

    public void setIsTempered(boolean tempered) {
        isTempered = tempered;
    }

    public TileGroup getGroup() {
        return group;
    }

    public void setGroup(TileGroup group) {
        this.group = group;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Coating getCoating() {
        return coating;
    }

    public void setCoating(Coating coating) {
        this.coating = coating;
    }

}
