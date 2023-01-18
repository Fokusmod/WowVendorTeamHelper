package ru.geekbrains.slackintegrationservice.controller;

import com.slack.api.Slack;
import com.slack.api.audit.Actions;
import com.slack.api.bolt.App;
import com.slack.api.bolt.servlet.SlackAppServlet;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.request.conversations.ConversationsListRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import com.slack.api.model.ConversationType;
import com.slack.api.model.event.MessageBotEvent;
import com.slack.api.model.event.MessageEvent;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/slack/events")
public class SlackAppController extends SlackAppServlet {


    public SlackAppController(App app) {
        super(app);


    }
}
