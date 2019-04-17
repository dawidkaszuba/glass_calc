package pl.dawidkaszuba.glasscalc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Glass2Tiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Tile externalTile;
    @ManyToOne
    private Frame frame;
    @ManyToOne
    private Tile internalTile;
    private double price;
    private String name;
    @ManyToOne
    private Gas gas;
    private double thickness;
    @NotNull
    private int width;
    @NotNull
    private int height;

    public Glass2Tiles() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tile getExternalTile() {
        return externalTile;
    }

    public void setExternalTile(Tile externalTile) {
        this.externalTile = externalTile;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public Tile getInternalTile() {
        return internalTile;
    }

    public void setInternalTile(Tile internalTile) {
        this.internalTile = internalTile;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price=price;

    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = this.externalTile.getName() + " / " +  this.frame.getName() + " "+ this.gas.getName()
                     + " / " + this.internalTile.getName();
    }

    public Gas getGas() {
        return gas;
    }

    public void setGas(Gas gas) {
        this.gas = gas;
    }

    public void setThickness() {
        this.thickness = this.getInternalTile().getThickness() +
                this.getExternalTile().getThickness() + this.frame.getThickness();
    }

    public double getThickness() {
        return thickness;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
