package aquaGroup.service;

import aquaGroup.converter.FishConverter;
import aquaGroup.dao.FishDao;
import aquaGroup.dto.FishDTO;
import aquaGroup.model.Fish;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
// import java.util.logging.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FishEJB {
    @Inject
    private FishDao fishDao;

    @Inject
    private FishConverter fishConverter;

    //private static Logger logger = Logger.getLogger(FishEJB.class.getName());

    public Response getFishById(Long id) {
        if (id == null || id == 0) {
            return Response.status(403).build();
        }
        Fish resultDatabase = fishDao.getFishById(id);
        FishDTO resultFishDTO = fishConverter.toDTO(resultDatabase);
        return Response.ok(resultFishDTO).build();
    }

    public Response getFishs() {
        List<Fish> fishList = fishDao.getFishs();
        List<FishDTO> fishDTOList = new ArrayList<>();
        for (Fish fish : fishList) {
            FishDTO fishDTO = fishConverter.toDTO(fish);
            fishDTOList.add(fishDTO);
        }
        return Response.ok(fishDTOList).build();
    }

    public Response addFish(FishDTO fish) {
        if (fish.getWeight() == null || fish.getName() == null || fish.getSpeed() == null || fish.getSpecies() == null) {
            return Response.status(403).build();
        }
        Fish entityFish = fishConverter.toFish(fish);
        boolean result = fishDao.addFish(entityFish);
        return Response.ok(Boolean.toString(result)).build();
    }

    public Response deleteFish(Long id) {
        if (id == null || id == 0) {
            return Response.status(403).build();
        }
        boolean result = fishDao.deleteFishById(id);
        return Response.ok(Boolean.toString(result)).build();
    }

    public Response updateFish(Long id, FishDTO fish) {
        if (id == null || id == 0) {
            return Response.status(403).build();
        }
        if (fish.getSpecies() == null || fish.getName() == null){
            return Response.status(403).build();
        }
        Fish entityFish = fishDao.getFishById(id);
        entityFish.setSpecies(fish.getSpecies());
        entityFish.setName(fish.getName());
        boolean result = fishDao.updateFishMember(entityFish);
        return Response.ok(Boolean.toString(result)).build();

    }
}
