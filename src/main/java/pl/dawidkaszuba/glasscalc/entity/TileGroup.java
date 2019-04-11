package pl.dawidkaszuba.glasscalc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class TileGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Tile> tiles;
}
