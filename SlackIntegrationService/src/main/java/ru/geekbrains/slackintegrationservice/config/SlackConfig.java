package ru.geekbrains.slackintegrationservice.config;


import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.model.event.MessageBotEvent;
import com.slack.api.model.event.MessageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
public class SlackConfig {

//    private final String CLIENT_ID = "1128391916193.4643061959205";
//    private final String CLIENT_SECRET = "cf6f33912333ee5d367ed6a6b25da0a1";
//    private final String SIGNING_SECRET = "27256d9f2860422ef096a3cf89daef6c";

    // If you would like to run this app for a single workspace,
    // enabling this Bean factory should work for you.
//    @Bean
//    public AppConfig loadSingleWorkspaceAppConfig() {
//        return AppConfig.builder()
//                .singleTeamBotToken(System.getenv("SLACK_BOT_TOKEN"))
//                .signingSecret(System.getenv("SLACK_SIGNING_SECRET"))
//                .build();
//    }

    // If you would like to run this app for multiple workspaces,
    // enabling this Bean factory should work for you.
    @Bean
    public AppConfig loadOAuthConfig() {
        return AppConfig.builder()
//                .singleTeamBotToken(null)
                .singleTeamBotToken(System.getenv("SLACK_BOT_TOKEN"))
                .clientId(System.getenv("SLACK_CLIENT_ID"))
                .clientSecret(System.getenv("SLACK_CLIENT_SECRET"))
                .signingSecret(System.getenv("SLACK_SIGNING_SECRET"))
                .scope("app_mentions:read,channels:history,channels:read,groups:history,groups:read,incoming-webhook")
                .oauthInstallPath("/slack/install")
                .oauthRedirectUriPath("/slack/oauth_redirect")
                .build();
    }

    @Bean
    public App initSlackApp(AppConfig config) {
        App app = new App(config);
        if (config.getClientId() != null) {
            app.asOAuthApp(true);
        }

        app.command("/hello", (req, ctx) -> {
            return ctx.ack(r -> r.text("Thanks!"));
        });

        return app;
    }
}


//"id": "C04JL0F56G7",
//"name": "тестовое-приложение",



