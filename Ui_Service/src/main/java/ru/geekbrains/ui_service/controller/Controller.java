package ru.geekbrains.ui_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.ui_service.API.CharacterIdentity;
import ru.geekbrains.ui_service.API.Region;
import ru.geekbrains.ui_service.dto.Profile;
import ru.geekbrains.ui_service.services.CharacterService;

import java.util.Optional;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final CharacterService characterService;

    @GetMapping("/part")
    public String getMSG(){
        return "Hello";
    }

    @GetMapping("/{regionCode}/{realm}/{character}/{namespace}")
    public Optional<?> getCharacter(@PathVariable String regionCode, @PathVariable String realm, @PathVariable String character, @PathVariable String namespace) {
        System.out.println(123);
        Region region = Region.from(regionCode);
        CharacterIdentity characterIdentity = CharacterIdentity.of(region, realm, character, namespace);
        return characterService.forCharacter(characterIdentity);
    }
}
