package ru.geekbrains.ui_service.API;

public class EndpointsResolver {

    public Endpoints forRegion(Region region) {
        return new Endpoints("https://" + region.name().toLowerCase() + ".api.blizzard.com");
    }
}
