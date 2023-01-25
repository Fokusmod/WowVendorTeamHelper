package ru.geekbrains.ui_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.ui_service.API.CharacterIdentity;
import ru.geekbrains.ui_service.API.EndpointsResolver;
import ru.geekbrains.ui_service.dto.Profile;

import java.net.URI;
import java.net.URLEncoder;
import java.util.Optional;

@Service
public class CharacterService {
    private final RestTemplate restTemplate;

    private final EndpointsResolver endpointsResolver;

    @Autowired
    public CharacterService(RestTemplate blizzardApiRestTemplate, EndpointsResolver endpointsResolver) {
        this.restTemplate = blizzardApiRestTemplate;
        this.endpointsResolver = endpointsResolver;
    }

    public Optional<?> forCharacter(CharacterIdentity characterIdentity) {
        String endpoint = endpointsResolver.forRegion(characterIdentity.getRegion())
                .characterWow(characterIdentity.getRealm(), characterIdentity.getCharacter(), characterIdentity.getNamespace());
        System.out.println(endpoint);
        Profile characterData = restTemplate.getForObject(endpoint, Profile.class);

        assert characterData != null;
        return Optional.of(characterData);
    }


}
