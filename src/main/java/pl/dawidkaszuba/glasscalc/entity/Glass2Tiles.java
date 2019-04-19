package pl.dawidkaszuba.glasscalc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import pl.dawidkaszuba.glasscalc.errors.ErrorGlass;
import pl.dawidkaszuba.glasscalc.repository.BasePrice2TileRepository;
import pl.dawidkaszuba.glasscalc.repository.StandardPrice2TilesGlassRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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
        this.price = price;
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

    public List<ErrorGlass> checkIsCorrect() {

        List<ErrorGlass> errors = new ArrayList<>();

        if(this.checkIfhasOneLowEmislyCoating() != null){
            errors.add(this.checkIfhasOneLowEmislyCoating());
        }

        if(this.checkIfHasTwoLowEmislyCoating() != null){
            errors.add(this.checkIfHasTwoLowEmislyCoating());
        }
        if(this.checkIfHasCorrectDimension() !=null){
            errors.add(this.checkIfHasCorrectDimension());
        }

        return errors;
    }

    public ErrorGlass checkIfhasOneLowEmislyCoating(){
        String message = " szyba jednokomorowa powinna mieć conajmniej jedną powłokę niskoemisyjną";

        if(this.getInternalTile().getCoating().getLowEmisly() || this.getExternalTile().getCoating().getLowEmisly()){
            return null;
        }else{
            return new ErrorGlass(message);
        }
    }

    private ErrorGlass checkIfHasTwoLowEmislyCoating(){
        String message = "Szyba jednokomorowa powinna mieć jedną powłokę niskoemisyjną";

        if(this.getExternalTile().getCoating().getLowEmisly() &&
                this.getInternalTile().getCoating().getLowEmisly()){
            return new ErrorGlass(message);
        } else{
            return null;
        }
    }

    private Tile getThinnestTile(){

        if(this.getInternalTile().getThickness() > this.getExternalTile().getThickness()) {
            return this.getExternalTile();
        }else{
            return this.getInternalTile();
        }
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

        if(checkThicknessToCalculating(getThinnestTile()) >= 3.78) {
            if(this.getHeight() / this.getWidth() > 6 ) {
                return new ErrorGlass(for4ThicknessMessage);
            }else{
                return null;
            }
        } else if(checkThicknessToCalculating(getThinnestTile()) >= 5){
            if(this.getHeight() / this.getWidth() > 10 ) {
                return new ErrorGlass(for6ThicknessMessage);
            } else {
                return null;
            }

        }
        return null;
    }


}
