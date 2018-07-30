package com.hereisalexius.rvb;

import java.util.HashMap;
import java.util.Map;

public class BotProperties {

    public static final String USERNAME_FLAG = "-u";
    public static final String TOKEN_FLAG = "-t";
    public static final String MITYURL_FLAG = "-murl";

    private String username;
    private String token;
    private String mityurl;

    public BotProperties(String... args) {
        Map<String, String> argsMap = getArgsMap(args);
        username = argsMap.get(USERNAME_FLAG);
        token = argsMap.get(TOKEN_FLAG);
        mityurl = argsMap.get(MITYURL_FLAG);
    }

    private Map<String, String> getArgsMap(String... args) {
        Map<String, String> argsMap = new HashMap<>();
        for (String arg : args) {
            String[] splitedArg = arg.split("=");
            argsMap.put(splitedArg[0], splitedArg[1]);
        }

        return argsMap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMityurl() {
        return mityurl;
    }

    public void setMityurl(String mityurl) {
        this.mityurl = mityurl;
    }
}
