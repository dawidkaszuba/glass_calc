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
    private int deliveryTime;
    private double weight;

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
        + " / " + this.middleTile.getName() + " / " + this.secondFrame.getName() + " " + this.gas.getName() + " / "
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
        if(this.checkIfSideIsToLong() != null){
            errors.add(checkIfSideIsToLong());
        }
        if(this.checkIfShorterSideIsCorrect() != null){
            errors.add(checkIfShorterSideIsCorrect());
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

        String middleLowEmislyShouldBeTempered = "Wewnętrzna tafla jeśli ma powłokę niskoemisyjną musi być hartowana";
        boolean middleTileCoating = this.getMiddleTile().getCoating().getLowEmisly();
        boolean tempered = this.getMiddleTile().getIsTempered();

        if(middleTileCoating && (!tempered)){
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

        String incorrectTile = "tafla powinna mieć conajmniej 3 mm grubości";
        String incorrectFrame = "ramka powinna mieć conajmniej 6 mm grubości";
        String incorrectFrameFor3 = "szyba 3mm dostepona w pakiecie z ramką min 9mm";
        String for3FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 3 mm max 1.5 m2";
        String for4And6FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 4 mm i ramce <=6 max 2 m2";
        String for4And9FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 4 mm i ramce <=9 max 2.5 m2";
        String for4And16FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 4 mm i ramce <=16 max 3.5 m2";
        String for5And6FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 5 mm i ramce <=6 max 2.5 m2";
        String for5And9FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 5 mm i ramce <=9 max 3.5 m2";
        String for6And6FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 6 mm i ramce <=6 max 3 m2";
        String for6And9FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 6 mm i ramce <=9 max 4.5 m2";
        String for6And16FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 6 mm i ramce <=16 max 7 m2";
        String for8And6FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 8 mm i ramce <=6 max 4 m2";
        String for8And9FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 8 mm i ramce <=9 max 6 m2";
        String for8And12FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 8 mm i ramce <=12 max 8.75 m2";
        String for8And16FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 8 mm i ramce <=16 max 10 m2";
        String for10And16FrameMaxAreaMessage = "powierzchnia szyby za duża. Przy tafli 10 mm i ramce <=16 max 13.5 m2";


        if(checkThicknessToCalculating(getThinnestTile()) < 3){

            return new ErrorGlass(incorrectTile);
        }
        if(this.getThicknessOfThinnestFrame() < 6){

            return new ErrorGlass(incorrectFrame);
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 3 && this.getThicknessOfThinnestFrame() <9){
            return new ErrorGlass(incorrectFrameFor3);

        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 3 && this.getThicknessOfThinnestFrame() <=16){
            if((this.getHeight() * this.getWidth() * 0.000001) > 1.5) {
                return new ErrorGlass(for3FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 4 && this.getThicknessOfThinnestFrame() <=8){
            if((this.getHeight() * this.getWidth() * 0.000001) > 2) {
                return new ErrorGlass(for4And6FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 4 && (this.getThicknessOfThinnestFrame() > 8 && this.getThicknessOfThinnestFrame() < 16)){
            if((this.getHeight() * this.getWidth() * 0.000001) > 2.5) {
                return new ErrorGlass(for4And9FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 4 && this.getThicknessOfThinnestFrame() > 15){
            if((this.getHeight() * this.getWidth() * 0.000001) > 3.5) {
                return new ErrorGlass(for4And16FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 5 && this.getThicknessOfThinnestFrame() <=8){
            if((this.getHeight() * this.getWidth() * 0.000001) > 2.5) {
                return new ErrorGlass(for5And6FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 5 && (this.getThicknessOfThinnestFrame() > 8 && this.getThicknessOfThinnestFrame() < 16)){
            if((this.getHeight() * this.getWidth() * 0.000001) > 3.5) {
                return new ErrorGlass(for5And9FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 5 && this.getThicknessOfThinnestFrame() > 15){
            if((this.getHeight() * this.getWidth() * 0.000001) > 3.3) {
                return new ErrorGlass(for5And9FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 6 && this.getThicknessOfThinnestFrame() <=8){
            if((this.getHeight() * this.getWidth() * 0.000001) > 3) {
                return new ErrorGlass(for6And6FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 6 && (this.getThicknessOfThinnestFrame() > 8 && this.getThicknessOfThinnestFrame() < 16)){
            if((this.getHeight() * this.getWidth() * 0.000001) > 4.5) {
                return new ErrorGlass(for6And9FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 6 && this.getThicknessOfThinnestFrame() > 15){
            if((this.getHeight() * this.getWidth() * 0.000001) > 7) {
                return new ErrorGlass(for6And16FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 8 && this.getThicknessOfThinnestFrame() <=8){
            if((this.getHeight() * this.getWidth() * 0.000001) > 4) {
                return new ErrorGlass(for8And6FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 8
                && (this.getThicknessOfThinnestFrame() > 8 && this.getThicknessOfThinnestFrame() < 12)){
            if((this.getHeight() * this.getWidth() * 0.000001) > 4) {
                return new ErrorGlass(for8And9FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 8
                && (this.getThicknessOfThinnestFrame() > 11 && this.getThicknessOfThinnestFrame() < 16)){
            if((this.getHeight() * this.getWidth() * 0.000001) > 8.75) {
                return new ErrorGlass(for8And12FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 8 && this.getThicknessOfThinnestFrame() > 15){
            if((this.getHeight() * this.getWidth() * 0.000001) > 10) {
                return new ErrorGlass(for8And16FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        if(checkThicknessToCalculating(getThinnestTile()) <= 10 && this.getThicknessOfThinnestFrame() >= 16){
            if((this.getHeight() * this.getWidth() * 0.000001) > 13.5) {
                return new ErrorGlass(for10And16FrameMaxAreaMessage);
            }else{
                return null;
            }
        }
        else{
            return null;
        }
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

    public double getThicknessOfThinnestFrame(){

        if(this.firstFrame.getThickness() < this.secondFrame.getThickness()){
            return this.firstFrame.getThickness();
        }else {
            return this.secondFrame.getThickness();
        }

    }

    private ErrorGlass checkIfSideIsToLong(){

        Tile tile = this.getThinnestTile();

        String messageForFrameLowerThen6 = "minimalna szerokość ramki to 6 mm";
        String messageForTileLowerThen3 = "minimalna grubość tafli to 3 mm";
        String messageFor3AndLowerThen9 = "minimalna szerokość ramki dla szyby 3 mm wynosi 9 mm";
        String messageFor3 = "max długość boku dla szyby 3 mm wynosi 1500 mm";
        String messageFor4and9Frame = "max długość boku dla szyby <=4 mm i ramki <= 9 wynosi 2500 mm";
        String messageFor4and6Frame = "max długość boku dla szyby <=4 mm i ramki <= 6 wynosi 2000 mm";
        String messageFor5and12Frame = "max długość boku dla szyby <=5 mm i ramki <= 12 wynosi 3300 mm";
        String messageFor5and9Frame = "max długość boku dla szyby <=5 mm i ramki <= 9 wynosi 3000 mm";
        String messageFor5and6Frame = "max długość boku dla szyby <=5 mm i ramki <= 6 wynosi 2500 mm";
        String messageFor6and12Frame = "max długość boku dla szyby <=6 mm i ramki <= 12 wynosi 3500 mm";
        String messageFor6and6Frame = "max długość boku dla szyby <=6 mm i ramki <= 6 wynosi 3500 mm";
        String messageFor8and16Frame = "max długość boku dla szyby <=8 mm i ramki <= 16 wynosi 5000 mm";
        String messageFor8and12Frame = "max długość boku dla szyby <=8 mm i ramki <= 12 wynosi 3500 mm";
        String messageFor8and6Frame = "max długość boku dla szyby <=8 mm i ramki <= 6 wynosi 3000 mm";

        if(this.getThicknessOfThinnestFrame() < 6){
            return new ErrorGlass(messageForFrameLowerThen6);
        }
        if(tile.getThickness() < 3){
            return new ErrorGlass(messageForTileLowerThen3);
        }
        if((tile.getThickness() == 3) && (this.getThicknessOfThinnestFrame() < 9)) {
            if((this.getWidth() > 1500 || this.getHeight() > 1500)){
                return new ErrorGlass(messageFor3AndLowerThen9);
            }else {
                return null;
            }

        }
        if((tile.getThickness() == 3) && (this.getThicknessOfThinnestFrame() > 8)) {
            if((this.getWidth() > 1500 || this.getHeight() > 1500)){
                return new ErrorGlass(messageFor3);
            }else {
                return null;
            }

        }
        if((tile.getThickness() <= 4) && (this.getThicknessOfThinnestFrame() >= 9)) {
            if((this.getWidth() > 2500 || this.getHeight() > 2500)){
                return new ErrorGlass(messageFor4and9Frame);
            }else {
                return null;
            }

        }
        if((tile.getThickness() <= 4) && (this.getThicknessOfThinnestFrame() >= 6)){
            if((this.getWidth() > 2000 || this.getHeight() > 2000)){
                return new ErrorGlass(messageFor4and6Frame);
            }else{
                return null;
            }
        }
        if((tile.getThickness() <= 5) && (this.getThicknessOfThinnestFrame() >= 12)){
            if((this.getWidth() > 3300 || this.getHeight() > 3300)){
                return new ErrorGlass(messageFor5and12Frame);
            }else{
                return null;
            }
        }
        if((tile.getThickness() <= 5) && (this.getThicknessOfThinnestFrame() >= 9)){
            if((this.getWidth() > 3000 || this.getHeight() > 3000)){
                return new ErrorGlass(messageFor5and9Frame);
            }else{
                return null;
            }
        }
        if((tile.getThickness() <= 5) && (this.getThicknessOfThinnestFrame() >= 6)){
            if((this.getWidth() > 2500 || this.getHeight() > 2500)){
                return new ErrorGlass(messageFor5and6Frame);
            }else{
                return null;
            }
        }
        if((tile.getThickness() <= 6) && (this.getThicknessOfThinnestFrame() >= 12)){
            if((this.getWidth() > 3500 || this.getHeight() > 3500)){
                return new ErrorGlass(messageFor6and12Frame);
            }else{
                return null;
            }
        }
        if((tile.getThickness() <= 6) && (this.getThicknessOfThinnestFrame() >= 6)){
            if((this.getWidth() > 3000 || this.getHeight() > 3000)){
                return new ErrorGlass(messageFor6and6Frame);
            }else{
                return null;
            }
        }
        if((tile.getThickness() <= 8) && (this.getThicknessOfThinnestFrame() >= 16)){
            if((this.getWidth() > 5000 || this.getHeight() > 5000)){
                return new ErrorGlass(messageFor8and16Frame);
            }else{
                return null;
            }
        }
        if((tile.getThickness() <= 8) && (this.getThicknessOfThinnestFrame() >= 12)){
            if((this.getWidth() > 3500 || this.getHeight() > 3500)){
                return new ErrorGlass(messageFor8and12Frame);
            }else{
                return null;
            }
        }
        if((tile.getThickness() <= 8) && (this.getThicknessOfThinnestFrame() >= 6)){
            if((this.getWidth() > 3000 || this.getHeight() > 3000)){
                return new ErrorGlass(messageFor8and6Frame);
            }else{
                return null;
            }
        }

        return null;
    }

    private ErrorGlass checkIfShorterSideIsCorrect(){

        String messageForToLongShorterSide = " krótszy bok nie może być dłuższy niż 2700 mm";

        if(this.width < this.height){
            if(this.width > 2700){
                return new ErrorGlass(messageForToLongShorterSide);
            }else{
                return null;
            }
        }else{
            if(this.height > 2700){
                return new ErrorGlass(messageForToLongShorterSide);
            }else{
                return null;
            }
        }
    }

    public int getDeliveryTime(){

        List<Integer> deliveryTimes = new ArrayList<>();

        deliveryTimes.add(this.externalTile.getDeliveryTime());
        deliveryTimes.add(this.internalTile.getDeliveryTime());
        deliveryTimes.add(this.middleTile.getDeliveryTime());
        deliveryTimes.add(this.firstFrame.getDeliveryTime());
        deliveryTimes.add(this.secondFrame.getDeliveryTime());
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < deliveryTimes.size(); i++) {
            if(deliveryTimes.get(i)>max){
                max = deliveryTimes.get(i);
            }
        }
        deliveryTime=max;
        return deliveryTime;

    }

    public void setWeight(){

        double areaInM2 = (this.getWidth() * this.getHeight()) * 0.000001;

        if(this.getExternalTile().getFoil() == null && this.getInternalTile().getFoil() == null
                && this.getMiddleTile().getFoil() == null) {
            this.weight = (this.getInternalTile().getThickness() + getExternalTile().getThickness()
                    + getMiddleTile().getThickness()) * 2.5 * areaInM2;
        }else
            if(this.getExternalTile().getFoil() != null){
                this.weight =  (this.getInternalTile().getThickness() + getExternalTile().getThickness()
                        + getMiddleTile().getThickness() - this.getExternalTile().getFoil().getThickness())
                        * 2.5 * areaInM2;
            }
            else
                if(this.getMiddleTile().getFoil() != null){
                    this.weight =  (this.getInternalTile().getThickness() + getExternalTile().getThickness()
                            + getMiddleTile().getThickness() - this.getMiddleTile().getFoil().getThickness())
                            * 2.5 * areaInM2;
                }
                else{
                    this.weight =  (this.getInternalTile().getThickness() + getExternalTile().getThickness()
                            + getMiddleTile().getThickness() - this.getInternalTile().getFoil().getThickness())
                            * 2.5 * areaInM2;
                }
    }

    public double getWeight() {
        return weight;
    }
}
