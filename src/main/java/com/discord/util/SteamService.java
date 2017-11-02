package com.discord.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class SteamService {

    private static final String STEAM_API = "http://api.steampowered.com/ISteamNews/";
    private static final String NEWS_FOR_APP_API_1 = "GetNewsForApp/v0002/?appid=";
    private static final String NEWS_FOR_APP_API_2 = "&count=3&maxlength=300&format=json";

    public JSONObject getGameNews(String gameId)
    {
        final String URI = STEAM_API + NEWS_FOR_APP_API_1 + gameId + NEWS_FOR_APP_API_2;
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(URI).asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody().getObject();
    }
}
