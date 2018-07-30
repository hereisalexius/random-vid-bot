package com.hereisalexius.rvb;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotApplication {

    public static void main(String[] args) {

        if(hasValidArgs(args)) {
            ApiContextInitializer.init();

            TelegramBotsApi botsApi = new TelegramBotsApi();

            try {
                botsApi.registerBot(new RandomYoutubeVideoBot(new BotProperties(args)));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Try : \n\tjava -jar rvid-bot-jar-with-dependencie.jar -u=<telegram_bot_username> -t=<telegram_bot_token> -murl=<mityurl[like = https://mityurl.com/y/j9Md/r]>");
        }
    }


    private static boolean hasValidArgs(String... args) {

        boolean containsUsername = false;
        boolean containsToken = false;
        boolean containsMityurl = false;

        for (String arg : args) {
            containsUsername = arg.matches("-u=.+")|| containsUsername;
            containsToken = arg.matches("-t=.+") || containsToken;
            containsMityurl = arg.matches("-murl=.+") || containsMityurl;
        }

        return containsUsername && containsToken && containsMityurl;
    }

}
