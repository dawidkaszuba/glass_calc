package pl.dawidkaszuba.glasscalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.glasscalc.entity.Glass2Tiles;
import pl.dawidkaszuba.glasscalc.repository.BasePrice2TileRepository;
import pl.dawidkaszuba.glasscalc.repository.Glass2TilesRepository;
import pl.dawidkaszuba.glasscalc.repository.StandardPrice2TilesGlassRepository;

import java.util.List;

@Service
public class Glass2TilesServiceImpl implements Glass2TilesService {

    private final Glass2TilesRepository glass2TilesRepository;

    private final StandardPrice2TilesGlassRepository standardPrice2TilesGlassRepository;

    private final BasePrice2TileRepository basePrice2TileRepository;

    @Autowired
    public Glass2TilesServiceImpl(Glass2TilesRepository glass2TilesRepository, StandardPrice2TilesGlassRepository standardPrice2TilesGlassRepository, BasePrice2TileRepository basePrice2TileRepository) {
        this.glass2TilesRepository = glass2TilesRepository;
        this.standardPrice2TilesGlassRepository = standardPrice2TilesGlassRepository;
        this.basePrice2TileRepository = basePrice2TileRepository;
    }
    @Override
    public void save(Glass2Tiles glass2Tiles){

        glass2Tiles.setThickness();
        glass2Tiles.setName();
        glass2Tiles.setWeight();
        glass2Tiles.getDeliveryTime();
        glass2Tiles.setPrice(getPrice(glass2Tiles));
        this.glass2TilesRepository.save(glass2Tiles);

    }
    @Override
    public List<Glass2Tiles> findAll(){
        return this.glass2TilesRepository.findAll();
    }

    @Override
    public Glass2Tiles findById(Long id){
        return this.glass2TilesRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.glass2TilesRepository.delete(id);
    }

    @Override
    public double getPrice(Glass2Tiles glass2Tiles){

        if((glass2Tiles.getExternalTile().getPrice() + glass2Tiles.getInternalTile().getPrice() +
                glass2Tiles.getGas().getPrice()) == 0) {
            if(! glass2Tiles.checkIfAreaLowerThen04()) {

                return ((this.standardPrice2TilesGlassRepository.findOne(1L).getValue()
                        + glass2Tiles.getFrame().getPrice()) / 1000000
                        * (glass2Tiles.getWidth() * glass2Tiles.getHeight()))
                        * glass2Tiles.getHowIncreasePriceDependOnDimensions();
            }else {

                return (this.standardPrice2TilesGlassRepository.findOne(1L).getValue()
                        + glass2Tiles.getFrame().getPrice()) * 0.4;

            }
        }else{

            if(! glass2Tiles.checkIfAreaLowerThen04()) {

                return ((basePrice2TileRepository.findOne(1L).getValue() + glass2Tiles.getFrame().getPrice() +
                        glass2Tiles.getExternalTile().getPrice()
                        + glass2Tiles.getInternalTile().getPrice() + glass2Tiles.getGas().getPrice())
                        / 1000000 * (glass2Tiles.getWidth() * glass2Tiles.getHeight()))
                        * glass2Tiles.getHowIncreasePriceDependOnDimensions();
            }else {

                return (basePrice2TileRepository.findOne(1L).getValue() + glass2Tiles.getFrame().getPrice() +
                        glass2Tiles.getExternalTile().getPrice()
                        + glass2Tiles.getInternalTile().getPrice() + glass2Tiles.getGas().getPrice()) * 0.4;
            }
        }

    }

}