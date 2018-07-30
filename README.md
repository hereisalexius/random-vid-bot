# random-vid-bot
Telegram Bot for sending random youtube videos(or links) with mityurl.com
## Getting Started

Few setps to make it run

### 1 Create Bot with BotFather

1.1 Find @BotFather in your telegram app and connect to it

1.2 Type /start then /newbot and follow the instructions

1.3 As result you will get USERNAME and TOKEN for your bot

### 2 Prepare our video set

2.1 Go to https://mityurl.com/

2.2 Enter link to yourl video-list to the field and press "Create List"

2.3 As result you wil get "short-link" to your list, use /r param in the end of link to make it "random"

### 3 Run

3.1 Fill the arguments and run in command-line

```
cd target
-jar rvid-bot-jar-with-dependencies.jar -u=<username> -t=<token> -murl=<url>
```
