package ru.geekbrains.ui_service.utils;

public class RequestParserFactory {

    public static RequestParser createRequestParser() {
        return new RequestParserImpl();
    }
}
