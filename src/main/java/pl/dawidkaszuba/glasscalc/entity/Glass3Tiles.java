package pl.dawidkaszuba.glasscalc.entity;

import pl.dawidkaszuba.glasscalc.errors.ErrorGlass;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private Gas gas;

    private String name;

    private double price;

    private double thickness;

    private int width;
    private int height;

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
        this.name = this.externalTile.getName() + " / " + this.firstFrame.getName() + " " + this.gas.getName()
        + " / " + this.middleTile.getName() + " / " + this.secondFrame.getName() + " / " + this.gas.getName() + " / "
                + this.internalTile.getName();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Gas getGas() {
        return gas;
    }

    public void setGas(Gas gas) {
        this.gas = gas;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness() {
        this.thickness = this.getInternalTile().getThickness() + this.middleTile.getThickness() +
                this.getExternalTile().getThickness() + this.firstFrame.getThickness() + this.secondFrame.getThickness();
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


    public List<ErrorGlass> checkIsCorrect() {

        List<ErrorGlass> errors = new ArrayList<>();

        if(this.checkIfhasTwoLowEmislyCoating() != null){
            errors.add(this.checkIfhasTwoLowEmislyCoating());
        }
        if(this.checkIfMiddleTileIsTempered() !=null){
            errors.add(this.checkIfMiddleTileIsTempered());
        }
        if(this.checkIfHasCorrectDimension() !=null){
            errors.add(checkIfHasCorrectDimension());
        }
        if(this.checkIfHasCorrectArea() != null){
            errors.add(checkIfHasCorrectArea());
        }

        return errors;
    }

    private ErrorGlass checkIfhasTwoLowEmislyCoating(){
        String message = "szyba dwukomorowa powinna mieć conajmniej dwie powłoki niskoemisyjne";
        List<Boolean> list = new ArrayList<>();

        if(this.getExternalTile().getCoating().getLowEmisly()){
            list.add(true);
        }
        if(this.getMiddleTile().getCoating().getLowEmisly()){
            list.add(true);
        }
        if(this.getInternalTile().getCoating().getLowEmisly()){
            list.add(true);
        }

        if(list.size()>=1){
            return null;
        }else {
            return new ErrorGlass(message);
        }

    }

    private ErrorGlass checkIfMiddleTileIsTempered(){

        String middleLowEmislyShouldBeTempered = "Wewnętrzna tafla jeśli ma powłokę niskoemisyjną musi byc hartowana";
        boolean middleTileCoating = this.getMiddleTile().getCoating().getLowEmisly();

        if(middleTileCoating){
            return new ErrorGlass(middleLowEmislyShouldBeTempered);
        }else{
            return null;
        }
    }

    public Tile getThinnestTile(){

        List<Tile> tiles = new ArrayList<>();

        double min = Double.MAX_VALUE;
        Tile minThicknessTile = new Tile();

        tiles.add(this.getExternalTile());
        tiles.add(this.getMiddleTile());
        tiles.add(this.getInternalTile());

        for(Tile tile: tiles){
            if(tile.getThickness() < min){
                minThicknessTile = tile;
                min = tile.getThickness();
            }
        }
        return minThicknessTile;
    }

    private double checkThicknessToCalculating(Tile tile){

        if(tile.getFoil() != null){
            double thickness = tile.getFoil().getThickness() -
                    tile.getFoil().getThickness();
            return thickness * 0.63;
        }else{
            return tile.getThickness();
        }
    }

    private ErrorGlass checkIfHasCorrectDimension(){

        String for4ThicknessMessage = "przekroczony stosunek boków dla szyby 4, prawidłowy max 1:6";
        String for6ThicknessMessage = "przekroczony stosunek boków dla szyby 6 i grubszych, prawidłowy max 1:10";

        if(checkThicknessToCalculating(getThinnestTile()) >= 5) {
            if(this.getHeight() / this.getWidth() > 10 ) {
                return new ErrorGlass(for6ThicknessMessage);
            }else{
                return null;
            }
        } else if(checkThicknessToCalculating(getThinnestTile()) >= 3.78){
            if(this.getHeight() / this.getWidth() > 6 ) {
                return new ErrorGlass(for4ThicknessMessage);
            } else {
                return null;
            }

        }
        return null;
    }

    private ErrorGlass checkIfHasCorrectArea(){

        String for4MaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 4 mm max 3.35m2";
        String for5MaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 5 mm max 5 m2";
        String for6MaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 6 mm max 7 m2";


        if(checkThicknessToCalculating(getThinnestTile()) <= 4){
            if((this.getHeight() * this.getWidth() * 0.000001) > 3.35) {
                return new ErrorGlass(for4MaxAreaMessage);
            }else{
                return null;
            }
        }else if(checkThicknessToCalculating(getThinnestTile()) <= 5){
            if((this.getHeight() * this.getWidth() * 0.000001) > 5) {
                return new ErrorGlass(for5MaxAreaMessage);
            }else{
                return null;
            }
        }else if(checkThicknessToCalculating(getThinnestTile()) <= 6){
            if((this.getHeight() * this.getWidth() * 0.000001) > 7){
                return new ErrorGlass(for6MaxAreaMessage);
            }else{
                return null;
            }
        }
        return null;
    }



    public double getHowIncreasePriceDependOnDimensions(){

        double greater = 0;
        double lower = 0;


        if(this.getHeight() > this.getWidth()){
            greater = this.height;
            lower = this.width;
        }else{
            greater = this.width;
            lower = this.height;
        }

        if(greater > 5000 && lower > 2400) {
            return 2.5;
        }else if(greater > 5000 && lower > 2000){
            return 2.25;
        }else if(greater > 4000 && lower > 2400){
            return 2.25;
        }else if(greater > 4000 && lower > 2000){
            return 2;
        }else if(greater > 3000 && lower > 2400){
            return 2;
        }else if(greater > 3000 && lower > 2000){
            return 1.75;
        }else if(greater > 2400 && lower > 2400){
            return 1.5;
        }else if(greater > 5000){
            return 2;
        }else if(greater > 4000){
            return 1.75;
        }else if(greater > 3000){
            return 1.5;
        }
        else{
            return 1;
        }

    }

    public boolean checkIfAreaLowerThen04(){

        return ((this.getHeight() * 0.001) * (this.getWidth() * 0.001)) <= 0.4;
    }
}
