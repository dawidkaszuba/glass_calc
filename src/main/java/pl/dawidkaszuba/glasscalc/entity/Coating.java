package pl.dawidkaszuba.glasscalc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Coating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double value;
    @OneToMany
    @Transient
    private List<Tile> tiles;
    private boolean lowEmisly;

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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public boolean getLowEmisly() {
        return lowEmisly;
    }

    public void setLowEmisly(boolean lowEmisly) {
        this.lowEmisly = lowEmisly;
    }
}
