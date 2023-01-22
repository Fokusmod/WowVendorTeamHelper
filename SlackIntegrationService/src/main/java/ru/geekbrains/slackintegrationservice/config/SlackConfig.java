package ru.geekbrains.slackintegrationservice.config;



import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;





@Configuration
@RequiredArgsConstructor
public class SlackConfig {


    //TODO Поменять на переменные окружения.
    @Bean
    public AppConfig loadSingleWorkspaceAppConfig() {
        return AppConfig.builder()
                .singleTeamBotToken("xoxb-4639953086342-4664911587190-QKHC84uqViOeIwpv4Ry2K8It")
                .signingSecret("fb185ea73d08a1d32bf7ebeafaecffb6")
                .build();
    }

    // If you would like to run this app for multiple workspaces,
    // enabling this Bean factory should work for you.
//    @Bean
//    public AppConfig loadOAuthConfig() {
//        return AppConfig.builder()
//                .singleTeamBotToken(null)
//                .clientId(System.getenv("SLACK_CLIENT_ID"))
//                .clientSecret(System.getenv("SLACK_CLIENT_SECRET"))
//                .signingSecret(System.getenv("SLACK_SIGNING_SECRET"))
//                .scope("app_mentions:read,channels:history,chat:write,groups:history,commands,im:history")
//                .oauthInstallPath("/slack/install")
//                .oauthRedirectUriPath("/slack/oauth_redirect")
//                .build();
//    }

    @Bean
    public App initSlackApp(AppConfig config) {
        App app = new App(config);

        //На всякий случай чтобы не запустились настройки для нескольких рабочих пространств.
        app.config().setClientId(null);
        app.config().setClientSecret(null);

//        if (config.getClientId() != null) {
//            app.asOAuthApp(true);
//        }
        return app;
    }
}