package pl.dawidkaszuba.glasscalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.glasscalc.entity.BasePrice3Tile;
import pl.dawidkaszuba.glasscalc.entity.Glass3Tiles;
import pl.dawidkaszuba.glasscalc.repository.BasePrice3TileRepository;
import pl.dawidkaszuba.glasscalc.repository.Glass3TilesRepository;
import pl.dawidkaszuba.glasscalc.repository.StandardPrice3TilesGlassRepository;

import java.util.List;
import java.util.Locale;

@Service
public class Glass3TilesServiceImpl implements Glass3TilesService{

    private final Glass3TilesRepository glass3TilesRepository;
    private final StandardPrice3TilesGlassRepository standardPrice3TilesGlassRepository;
    private final BasePrice3TileRepository basePrice3TileRepository;

    @Autowired
    public Glass3TilesServiceImpl(Glass3TilesRepository glass3TilesRepository,
                                  StandardPrice3TilesGlassRepository standardPrice3TilesGlassRepository,
                                  BasePrice3TileRepository basePrice3TileRepository) {
        this.glass3TilesRepository = glass3TilesRepository;
        this.standardPrice3TilesGlassRepository = standardPrice3TilesGlassRepository;
        this.basePrice3TileRepository = basePrice3TileRepository;
    }


    @Override
    public void save(Glass3Tiles glass3Tiles) {

        glass3Tiles.setName();
        glass3Tiles.setThickness();
        glass3Tiles.setWeight();
        String price = String.format(Locale.ROOT,"%.2f%n",getPrice(glass3Tiles));
        glass3Tiles.setPrice(Double.parseDouble(price));
        glass3Tiles.getDeliveryTime();
        this.glass3TilesRepository.save(glass3Tiles);
    }

    @Override
    public void delete(Long id) {
        this.glass3TilesRepository.delete(id);
    }

    @Override
    public List<Glass3Tiles> findAll() {

        return this.glass3TilesRepository.findAll();
    }

    @Override
    public Glass3Tiles findById(Long id) {
        return this.glass3TilesRepository.findOne(id);
    }

    @Override
    public double getPrice(Glass3Tiles glass3Tiles) {
        if((glass3Tiles.getExternalTile().getPrice()+ glass3Tiles.getMiddleTile().getPrice()
                + glass3Tiles.getInternalTile().getPrice() + glass3Tiles.getGas().getPrice())==0){
            if(! glass3Tiles.checkIfAreaLowerThen04()) {

                return ((this.standardPrice3TilesGlassRepository.findOne(1L).getValue()
                        + glass3Tiles.getFirstFrame().getPrice() + glass3Tiles.getSecondFrame().getPrice())
                        / 1000000 * (glass3Tiles.getWidth() * glass3Tiles.getHeight()))
                        * glass3Tiles.getHowIncreasePriceDependOnDimensions();
            }else{

                return (this.standardPrice3TilesGlassRepository.findOne(1L).getValue()
                        + glass3Tiles.getFirstFrame().getPrice() + glass3Tiles.getSecondFrame().getPrice()) * 0.4;
            }
        }else {
            BasePrice3Tile basePrice3Tiles = this.basePrice3TileRepository.findOne(1L);

            if(! glass3Tiles.checkIfAreaLowerThen04()) {


                return ((basePrice3Tiles.getValue() + glass3Tiles.getMiddleTile().getPrice()
                        + glass3Tiles.getExternalTile().getPrice() +
                        glass3Tiles.getInternalTile().getPrice() + glass3Tiles.getFirstFrame().getPrice()
                        + glass3Tiles.getSecondFrame().getPrice() + (2 * glass3Tiles.getGas().getPrice()))
                        / 1000000 * (glass3Tiles.getWidth() * glass3Tiles.getHeight()))
                        * glass3Tiles.getHowIncreasePriceDependOnDimensions();
            }else{

                return ((basePrice3Tiles.getValue() + glass3Tiles.getMiddleTile().getPrice()
                        + glass3Tiles.getExternalTile().getPrice() +
                        glass3Tiles.getInternalTile().getPrice() + glass3Tiles.getFirstFrame().getPrice()
                        + glass3Tiles.getSecondFrame().getPrice() + (2 * glass3Tiles.getGas().getPrice()))) * 0.4;
            }
        }
    }
}
