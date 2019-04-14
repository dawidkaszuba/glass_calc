package pl.dawidkaszuba.glasscalc.entity;

import javax.persistence.*;

@Entity
public class Glass3Tiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tile externalTile;

    @ManyToOne
    private Tile middleTile;

    @ManyToOne
    private Tile internalTile;

    @ManyToOne
    private Frame firstFrame;

    @ManyToOne
    private Frame secondFrame;

    @ManyToOne
    private Gas Gas;

    private String name;

    private double price;

    public Glass3Tiles() {
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

    public Tile getMiddleTile() {
        return middleTile;
    }

    public void setMiddleTile(Tile middleTile) {
        this.middleTile = middleTile;
    }

    public Tile getInternalTile() {
        return internalTile;
    }

    public void setInternalTile(Tile internalTile) {
        this.internalTile = internalTile;
    }

    public Frame getFirstFrame() {
        return firstFrame;
    }

    public void setFirstFrame(Frame firstFrame) {
        this.firstFrame = firstFrame;
    }

    public Frame getSecondFrame() {
        return secondFrame;
    }

    public void setSecondFrame(Frame secondFrame) {
        this.secondFrame = secondFrame;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = this.externalTile.getName() + " / " + this.firstFrame.getName() + " / "
        + this.middleTile.getName() + " / " + this.secondFrame.getName() + " / " + this.internalTile.getName();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public pl.dawidkaszuba.glasscalc.entity.Gas getGas() {
        return Gas;
    }

    public void setGas(pl.dawidkaszuba.glasscalc.entity.Gas gas) {
        Gas = gas;
    }
}
