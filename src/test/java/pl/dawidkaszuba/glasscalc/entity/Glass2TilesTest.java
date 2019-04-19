package pl.dawidkaszuba.glasscalc.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Glass2TilesTest {



    @Test
    public void ShouldReturn175() {
        Glass2Tiles glass2Tiles = new Glass2Tiles();
        glass2Tiles.setWidth(3001);
        glass2Tiles.setHeight(2001);
        assertEquals(1.75,glass2Tiles.getHowIncreasePriceDependOnDimensions(),0.01);
    }

    @Test
    public void ShouldReturn1() {
        Glass2Tiles glass2Tiles = new Glass2Tiles();
        glass2Tiles.setWidth(3000);
        glass2Tiles.setHeight(2400);
        assertEquals(1,glass2Tiles.getHowIncreasePriceDependOnDimensions(),0.01);
    }

    @Test
    public void ShouldReturn25() {
        Glass2Tiles glass2Tiles = new Glass2Tiles();
        glass2Tiles.setWidth(5001);
        glass2Tiles.setHeight(2401);
        assertEquals(2.5,glass2Tiles.getHowIncreasePriceDependOnDimensions(),0.01);
    }

    @Test
    public void ShouldReturn15() {
        Glass2Tiles glass2Tiles = new Glass2Tiles();
        glass2Tiles.setWidth(2401);
        glass2Tiles.setHeight(2401);
        assertEquals(1.5,glass2Tiles.getHowIncreasePriceDependOnDimensions(),0.01);
    }



}