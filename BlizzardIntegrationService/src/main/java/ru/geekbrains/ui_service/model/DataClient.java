package ru.geekbrains.ui_service.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DataClient {

    //Никнейм персонажа клиента
    private String clientNickname;
    //Игровой сервер
    private String realm;
    //Регион
    private String region;
    //Героик или нормал
    private String raidType;
    //Селф или шара
    private String clientBoostType;
    //Тип услуги
    private String serviceType;
    //Тайминг начала заказа
    private String orderTime;
    //Баттл тег
    private String BTag;
    //Код заказа
    private String ordersCode;

}


//"WoW Retail, Vault of the Incarnates Heroic Raid Boost, (eu-servers) (selfplayed) (standard-8of8-bosses), (Fri 13 Jan @ 21:00 CET), proudmoon, grim-batol, Alliance, gnalfen#2968, &D23C87 " +
//"https://worldofwarcraft.com/en-gb/character/eu/grimbatol/proudmoon " +
//"=== "
//
//"WoW Retail, Vault Last Boss Raszageth the Storm-Eater carry, (eu-servers) (selfplayed) (heroic-mode), Eyolin, blackmoore, Alliance, Swisher93#2943, &A16DF1
//        https://worldofwarcraft.com/en-gb/character/eu/blackmoore/Eyolin
//        ==="

//"WoW Retail, Vault of the Incarnates Single Bosses Boost, (eu-servers) (selfplayed) (Heroic-mode) (Broodkeeper Diurna) Жадая-Гордунни ,альянс ,azzara#2294, &BY0079
//        ==="
//WoW Retail, Vault of the Incarnates Normal Raid Boost, (eu-servers) (selfplayed) (standard), (Sat 14 Jan @ 19:00 CET), qled, sylvanas, Alliance, gabriel#2484, &8DDFF0
//https://worldofwarcraft.com/en-gb/character/eu/sylvanas/qled