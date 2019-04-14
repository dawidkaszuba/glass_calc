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


}
