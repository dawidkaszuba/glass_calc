package pl.dawidkaszuba.glasscalc.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Glass3TilesTest {

    @Test
    public void shouldReturnMiddleTile() {
        Tile internalTile = new Tile();
        Tile middlelTile = new Tile();
        Tile externalTile = new Tile();
        internalTile.setThickness(6);
        middlelTile.setThickness(4);
        externalTile.setThickness(6);

        Glass3Tiles glass3Tiles = new Glass3Tiles();

        glass3Tiles.setExternalTile(externalTile);
        glass3Tiles.setInternalTile(internalTile);
        glass3Tiles.setMiddleTile(middlelTile);

        assertEquals(middlelTile,glass3Tiles.getThinnestTile());
    }


    @Test
    public void shouldReturnExternalTile() {
        Tile internalTile = new Tile();
        Tile middlelTile = new Tile();
        Tile externalTile = new Tile();
        internalTile.setThickness(8);
        middlelTile.setThickness(8);
        externalTile.setThickness(6);

        Glass3Tiles glass3Tiles = new Glass3Tiles();

        glass3Tiles.setExternalTile(externalTile);
        glass3Tiles.setInternalTile(internalTile);
        glass3Tiles.setMiddleTile(middlelTile);

        assertEquals(externalTile,glass3Tiles.getThinnestTile());
    }



}