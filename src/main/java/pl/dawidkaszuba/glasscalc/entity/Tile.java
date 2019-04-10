package pl.dawidkaszuba.glasscalc.entity;

import javax.persistence.*;

@Entity
public class Tile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double thickness;
    private boolean isTempered;
    @ManyToOne
    private Group group;
    private double price;
}
