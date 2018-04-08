package com.discord.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.json.JSONObject;

public class SteamService {

    protected static final String STEAM_API = "http://api.steampowered.com/";

    protected static final String SLASHN = "\n";

    protected SteamAppNewsService newsService = new SteamAppNewsService();
    protected SteamPlayerInfoService playerInfoService = new SteamPlayerInfoService();
    protected SteamStoreFeaturedService storeFeaturedService = new SteamStoreFeaturedService();

    public String getGameNews(String gameName) throws JSONException {
        return newsService.getGameNews(gameName);
    }

    public String getPlayerInfo(String playerId) throws JSONException {
        return playerInfoService.getPlayerInfo(playerId);
    }

    public String getStoreFeatured() {
        return storeFeaturedService.getStoreFeatured();
    }

    protected static JSONObject getJsonObjectResponse(String uri) {
        JSONObject result;
        HttpResponse<JsonNode> response = null;

        try {
            response = Unirest.get(uri).asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        if (response != null && response.getBody() != null) {
            result = response.getBody().getObject();
        } else {
            result = new JSONObject();
        }

        return result;
    }

}
