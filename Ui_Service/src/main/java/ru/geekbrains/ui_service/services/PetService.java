package ru.geekbrains.ui_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.ui_service.API.CharacterIdentity;
import ru.geekbrains.ui_service.API.EndpointsResolver;

import java.util.Optional;

@Service
public class PetService {

//    private final RestTemplate restTemplate;
//
//    private final EndpointsResolver endpointsResolver;
//
//    @Autowired
//    public PetService(RestTemplate blizzardApiRestTemplate, EndpointsResolver endpointsResolver) {
//        this.restTemplate = blizzardApiRestTemplate;
//        this.endpointsResolver = endpointsResolver;
//    }
//
//    public Optional<Pets> forCharacter(CharacterIdentity characterIdentity) {
//        String endpoint = endpointsResolver.forRegion(characterIdentity.getRegion())
//                .characterBattlePets(characterIdentity.getRealm(), characterIdentity.getCharacter());
//
//        Character characterData = restTemplate.getForObject(endpoint, Character.class);
//        if (characterData == null || characterData.getPets() == null) {
//            return Optional.empty();
//        }
//        return Optional.of(characterData.getPets());
//    }
//
//    public List<Pet> getAll(Region region) {
//        String endpoint = endpointsResolver.forRegion(region).allPets();
//        AllPetsResponse response = restTemplate.getForObject(endpoint, AllPetsResponse.class);
//        if (response == null) {
//            throw new RuntimeException("Region pet data unavailable");
//        }
//        return response.getPets();
//    }
//
//    public static class AllPetsResponse {
//
//        @JsonProperty
//        private List<Pet> pets;
//
//        public List<Pet> getPets() {
//            return pets;
//        }
//
//    }
}
