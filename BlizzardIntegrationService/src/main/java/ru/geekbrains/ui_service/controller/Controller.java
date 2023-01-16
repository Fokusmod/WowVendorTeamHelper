package ru.geekbrains.ui_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.ui_service.API.CharacterIdentity;
import ru.geekbrains.ui_service.API.Region;
import ru.geekbrains.ui_service.dto.Profile;
import ru.geekbrains.ui_service.services.CharacterService;
import ru.geekbrains.ui_service.services.ClientParseService;

import java.util.Optional;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

    private final CharacterService characterService;

    private final ClientParseService clientParseService;

    @GetMapping("/part")
    public String getMSG(){
        return "Hello";
    }

    @GetMapping("/{regionCode}/{realm}/{character}/{namespace}")
    public Optional<?> getCharacter(@PathVariable String regionCode, @PathVariable String realm, @PathVariable String character, @PathVariable String namespace) {
        Region region = Region.from(regionCode);
        CharacterIdentity characterIdentity = CharacterIdentity.of(region, realm, character, namespace);
        return characterService.forCharacter(characterIdentity);
    }

    @GetMapping("/client")
    public void getClient(){
        String clientList = "WoW Retail, Vault of the Incarnates Heroic Raid Boost, (eu-servers) (selfplayed) (standard-8of8-bosses), (Fri 13 Jan @ 21:00 CET), proudmoon, grim-batol, Alliance, gnalfen#2968, &D23C87 " +
                "https://worldofwarcraft.com/en-gb/character/eu/grimbatol/proudmoon " +
                "=== " +
                "WoW Retail, Vault of the Incarnates Heroic Raid Boost, (eu-servers) (selfplayed) (standard-7of8-bosses), (Fri 13 Jan @ 21:00 CET), Valaril, antonidas, Alliance, Revage#2343, &05BB5E " +
                "https://worldofwarcraft.com/en-gb/character/eu/antonidas/Valaril " +
                "=== ";
        clientParseService.getClientList(clientList);

    }



//Протестить шару
//"WoW Retail, Vault of the Incarnates Heroic Raid Boost, (eu-servers) (ac-sharing) (standard-8of8-bosses) (VPN - Switzerland, Lucerne), (Sat 14 Jan @ 21:00 CET), Tirilya, silvermoon, Alliance, Pikaryu#2201, &92301F
//        https://worldofwarcraft.com/en-gb/character/eu/silvermoon/Tirilya
//==="

//Протестить фанпей
//"WoW Retail, Vault of the Incarnates Heroic Raid Boost , (eu-servers) (selfplayed) (standard 8 of 8 bosses) Викингтут-РФ, орда ,Медоед#21778 , &BY0078
//==="

//протестить сингл
//WoW Retail, Vault of the Incarnates Single Bosses Boost, (eu-servers) (selfplayed) (normal-mode) (Broodkeeper Diurna), maddisôn, thrall, Horde, Kronez#21548, &025093
//        https://worldofwarcraft.com/en-gb/character/eu/thrall/maddisôn
//        ===

//Протестить ласта
//+ласт
//"WoW Retail, Vault Last Boss Raszageth the Storm-Eater boost, (eu-servers) (selfplayed) (heroic-mode), (Sat 14 Jan @ 18:30 CET), Solidschneck, tarren-mill, Horde, Sadd#2727, &83E0A4
//https://worldofwarcraft.com/en-gb/character/eu/tarrenmill/Solidschneck
//===" (отредактировано)

}
