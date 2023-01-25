package ru.geekbrains.slackintegrationservice.controller;


import com.slack.api.bolt.App;
import com.slack.api.bolt.servlet.SlackAppServlet;
import com.slack.api.model.event.MessageChangedEvent;
import com.slack.api.model.event.MessageDeletedEvent;
import com.slack.api.model.event.MessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.slackintegrationservice.services.MessageService;

import javax.servlet.annotation.WebServlet;
@WebServlet("/slack/events")
public class SlackAppController extends SlackAppServlet {

    private final MessageService messageService;


    public SlackAppController(App app, @Autowired MessageService messageService) {
        super(app);
        this.messageService = messageService;

        //Подписка на получение сообщений из канала в котором включен бот
        app.event(MessageEvent.class, (payload, ctx) -> {
            System.out.println("get event ");
            MessageEvent messageEvent = payload.getEvent();
            if (messageEvent.getText().contains("===")) {
                this.messageService.getMessageMethod(messageEvent);
            }
            return ctx.ack();
        });

        //Подписка на событие изменения сообщения
        app.event(MessageChangedEvent.class, (payload, ctx) -> {
            System.out.println("change event ");
            MessageChangedEvent messageChangedEvent = payload.getEvent();
            this.messageService.changeMessageMethod(messageChangedEvent);
            return ctx.ack();
        });

        //Подписка на удаление сообщения
        app.event(MessageDeletedEvent.class, (payload, ctx) -> {
            System.out.println("delete event ");
            MessageDeletedEvent messageDeletedEvent = payload.getEvent();
            this.messageService.deleteMessageMethod(messageDeletedEvent);
            return ctx.ack();
        });

    }


}
