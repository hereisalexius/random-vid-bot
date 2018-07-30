package com.hereisalexius.rvb;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class RandomYoutubeVideoBot extends TelegramLongPollingBot {

    private final BotProperties properties;

    public RandomYoutubeVideoBot(BotProperties properties) {
        this.properties = properties;
    }

    @Override
    public void onUpdateReceived(Update update) {

        //lookup for received messages
        if (update.hasMessage() && update.getMessage().hasText()) {

            //Bot prepare message with our video
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(getContent()).enableWebPagePreview().enableHtml(true);

            try {
                //send if "/go" was typed
                if (update.getMessage().getText().equals("go") || update.getMessage().getText().equals("/go")) {
                    execute(message); // Call method to send the message
                }

                //send if "/help", bot says NO because there is NO help.
                if (update.getMessage().getText().equals("help") || update.getMessage().getText().equals("/help")) {
                    SendMessage messageNo = new SendMessage()
                            .setChatId(update.getMessage().getChatId())
                            .setText("No. \n Want to /go somewhere else?");
                    execute(messageNo); // Call method to send the message
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return properties.getUsername();
    }

    @Override
    public String getBotToken() {
        return properties.getToken();
    }

    /**
     * Get our random video from youtube using mityurl link and build it into telegram message
     *
     * @return Result message from request(video url)
     */
    private String getContent() {
        String url = "https://mityurl.com/y/j9Md/r";
        String result = "We have some problems with this...";
        try {
            URLConnection con = new URL(url).openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            result = "<a href=\"" + con.getURL().toString() + "\">That's it</a> or /go next?";
            is.close();
        } finally {
            return result;
        }
    }
}
