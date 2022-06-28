package aquaGroup.converter;

import aquaGroup.dto.FishDTO;
import aquaGroup.model.Fish;

public class FishConverter {
    public FishDTO toDTO(Fish fish){
        FishDTO fishDTO = new FishDTO();
        fishDTO.setId(fish.getId());
        fishDTO.setWeight(fish.getWeight());
        fishDTO.setName(fish.getName());
        fishDTO.setSpecies(fish.getSpecies());
        fishDTO.setSpeed(fish.getSpeed());
        return fishDTO;
    }

    public Fish toFish(FishDTO fishDTO){
        Fish fish = new Fish();
        fish.setName(fishDTO.getName());
        fish.setWeight(fishDTO.getWeight());
        fish.setId(fishDTO.getId());
        fish.setSpecies(fishDTO.getSpecies());
        fish.setSpeed(fishDTO.getSpeed());
        return fish;
    }
}
