package com.discord.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SteamService {

    private static final String STEAM_API = "http://api.steampowered.com/";
    private static final String NEWS_FOR_APP_API_1 = "ISteamNews/GetNewsForApp/v0002/?appid=";
    private static final String NEWS_FOR_APP_API_2 = "&count=3&maxlength=300&format=json";
    private static final String APP_LIST_API = "ISteamApps/GetAppList/v0001/";
    public static final String GAME_NOT_FOUND = "Game not found";

    protected final Map<String, String> mapOfGamesNameToId = new HashMap<>();

    public SteamService() {
        final String URI = STEAM_API + APP_LIST_API;

        JSONObject appList = getJsonObjectResponse(URI);
        JSONArray array = appList.getJSONObject("applist").getJSONObject("apps").getJSONArray("app");

        array.forEach(item -> {
            JSONObject obj = (JSONObject) item;
            mapOfGamesNameToId.put(obj.get("name").toString(), obj.get("appid").toString());
        });
    }

    public JSONObject getGameNews(String gameName) throws JSONException {
        JSONObject result;
        String id = getGameId(gameName);
        if (id == null) {
            result = new JSONObject("{\"error\": \"" + GAME_NOT_FOUND + "\"}");
        } else {
            final String URI = STEAM_API + NEWS_FOR_APP_API_1 + id + NEWS_FOR_APP_API_2;
            result = getJsonObjectResponse(URI);
        }
        return result;
    }

    protected String getGameId(String gameName) {
        return mapOfGamesNameToId.get(gameName);
    }

    private JSONObject getJsonObjectResponse(String uri) {
        HttpResponse<JsonNode> response = null;

        try {
            response = Unirest.get(uri).asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody().getObject();
    }

}
