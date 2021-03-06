package pl.dawidkaszuba.glasscalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.glasscalc.entity.Glass2Tiles;
import pl.dawidkaszuba.glasscalc.entity.User;
import pl.dawidkaszuba.glasscalc.app.config.security.AuthenticationFacade;
import pl.dawidkaszuba.glasscalc.repository.BasePrice2TileRepository;
import pl.dawidkaszuba.glasscalc.repository.Glass2TilesRepository;
import pl.dawidkaszuba.glasscalc.repository.StandardPrice2TilesGlassRepository;

import java.util.List;
import java.util.Locale;

@Service
public class Glass2TilesServiceImpl implements Glass2TilesService {

    private final Glass2TilesRepository glass2TilesRepository;

    private final StandardPrice2TilesGlassRepository standardPrice2TilesGlassRepository;

    private final BasePrice2TileRepository basePrice2TileRepository;
    private final AuthenticationFacade authenticationFacade;


    @Autowired
    public Glass2TilesServiceImpl(Glass2TilesRepository glass2TilesRepository,
                                  StandardPrice2TilesGlassRepository standardPrice2TilesGlassRepository,
                                  BasePrice2TileRepository basePrice2TileRepository,
                                  AuthenticationFacade authenticationFacade) {
        this.glass2TilesRepository = glass2TilesRepository;
        this.standardPrice2TilesGlassRepository = standardPrice2TilesGlassRepository;
        this.basePrice2TileRepository = basePrice2TileRepository;
        this.authenticationFacade = authenticationFacade;

    }

    @Override
    public List<Glass2Tiles> findAllByUserId() {
        Authentication authentication = authenticationFacade.getAuthentication();
        User user = (User) authentication.getPrincipal();

        return this.glass2TilesRepository.findAllByUserId(user.getId());
    }

    @Override
    public void save(Glass2Tiles glass2Tiles){

        String thickness = String.format(Locale.ROOT,"%.2f%n", calculateThickness(glass2Tiles));
        glass2Tiles.setThickness(Double.parseDouble(thickness));
        glass2Tiles.setName();
        glass2Tiles.setWeight();
        glass2Tiles.setDeliveryTime();
        Authentication authentication = authenticationFacade.getAuthentication();
        User user = (User) authentication.getPrincipal();
        glass2Tiles.setUser(user);
        String price = String.format(Locale.ROOT,"%.2f%n", calculatePrice(glass2Tiles));
        glass2Tiles.setPrice(Double.parseDouble(price));
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
    public double calculatePrice(Glass2Tiles glass2Tiles){

        if((glass2Tiles.getExternalTile().getPrice() + glass2Tiles.getInternalTile().getPrice() +
                glass2Tiles.getGas().getPrice()) == 0) {
            if(! glass2Tiles.checkIfAreaLowerThen04()) {

                return ((this.standardPrice2TilesGlassRepository.findOne(1L).getValue()
                        + glass2Tiles.getFrame().getPrice()) * 0.000001
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
                        * 0.000001 * (glass2Tiles.getWidth() * glass2Tiles.getHeight()))
                        * glass2Tiles.getHowIncreasePriceDependOnDimensions();
            }else {

                return (basePrice2TileRepository.findOne(1L).getValue() + glass2Tiles.getFrame().getPrice() +
                        glass2Tiles.getExternalTile().getPrice()
                        + glass2Tiles.getInternalTile().getPrice() + glass2Tiles.getGas().getPrice()) * 0.4;
            }
        }

    }


    private double calculateThickness(Glass2Tiles glass2Tiles){

        return glass2Tiles.getInternalTile().getThickness() +
                glass2Tiles.getExternalTile().getThickness() + glass2Tiles.getFrame().getThickness();

    }

}
