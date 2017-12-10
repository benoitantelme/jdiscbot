package com.discord.util;

import com.discord.constants.BotConstants;
import com.discord.constants.CommonConstants;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class SteamService {

    private static final String STEAM_API = "http://api.steampowered.com/";
    private static final String NEWS_FOR_APP_API_1 = "ISteamNews/GetNewsForApp/v0002/?appid=";
    private static final String NEWS_FOR_APP_API_2 = "&count=3&maxlength=300&format=json";
    private static final String APP_LIST_API = "ISteamApps/GetAppList/v0001/";
    private static final String PLAYER_SUMMARY_API_1 = "ISteamUser/GetPlayerSummaries/v0002/?key=";
    private static final String PLAYER_SUMMARY_API_2 = "&steamids=";

    protected static final String GAME_NOT_FOUND = "Game not found";
    protected static final String PLAYER_NOT_FOUND = "Player not found";
    private static final String TITLE = "title";
    private static final String CONTENTS = "contents";
    private static final String SLASHN = "\n";
    private static final String NAME = "name";
    private static final String APPID = "appid";

    protected final Map<String, String> mapOfGamesNameToId = new HashMap<>();

    public SteamService() {
        final String URI = STEAM_API + APP_LIST_API;

        JSONObject appList = getJsonObjectResponse(URI);
        JSONArray array = appList.getJSONObject("applist").getJSONObject("apps").getJSONArray("app");

        array.forEach(item -> {
            JSONObject obj = (JSONObject) item;
            mapOfGamesNameToId.put(obj.get(NAME).toString(), obj.get(APPID).toString());
        });
    }

    public String getGameNews(String gameName) throws JSONException {
        JSONObject jsonResult;
        String id = getGameId(gameName);
        if (id == null) {
            jsonResult = new JSONObject("{\"error\": \"" + GAME_NOT_FOUND + "\"}");
        } else {
            final String URI = STEAM_API + NEWS_FOR_APP_API_1 + id + NEWS_FOR_APP_API_2;
            jsonResult = getJsonObjectResponse(URI);
        }

        return jsonResult.has(CommonConstants.ERROR) ? jsonResult.get(CommonConstants.ERROR).toString() : parseGameNews(jsonResult);
    }

    protected String parseGameNews(JSONObject gameNewsJson) {
        StringBuilder result = new StringBuilder();

        JSONArray newsArray = gameNewsJson.getJSONObject("appnews").getJSONArray("newsitems");

        newsArray.forEach(item -> {
            JSONObject news = (JSONObject) item;
            result.append(news.get(TITLE)).append(SLASHN).append(news.get(CONTENTS)).append(SLASHN).append(SLASHN);
        });

        return result.toString();
    }

    protected String getGameId(String gameName) {
        return mapOfGamesNameToId.get(gameName);
    }

    public String getPlayerInfo(String playerId) throws JSONException {
        final String URI = STEAM_API + PLAYER_SUMMARY_API_1 + BotConstants.STEAM_KEY + PLAYER_SUMMARY_API_2 + playerId;
        JSONObject jsonResult = getJsonObjectResponse(URI);

        return jsonResult.has(CommonConstants.ERROR) ? jsonResult.get(CommonConstants.ERROR).toString() : parsePlayerInfo(jsonResult);
    }

    protected String parsePlayerInfo(JSONObject gameNewsJson) {
        StringBuilder result = new StringBuilder();

        JSONArray playerInfoArray = getPlayersArray(gameNewsJson);

        if (playerInfoArray != null && playerInfoArray.length() > 0) {
            playerInfoArray.forEach(item -> {
                JSONObject news = (JSONObject) item;
                result.append(news.get("profileurl")).append(SLASHN).append(news.get("realname")).
                        append(SLASHN).append(news.get("loccountrycode")).append(SLASHN).append(news.get("avatar")).append(SLASHN);

                // get time of creation if present
                Object timeOfCreation = news.get("timecreated");
                if (timeOfCreation != null) {
                    result.append(Instant.ofEpochSecond(Long.valueOf(timeOfCreation.toString()))).append(SLASHN);
                }

                result.append(SLASHN).append(SLASHN);
            });
        } else {
            result.append(PLAYER_NOT_FOUND);
        }

        return result.toString();
    }

    protected JSONArray getPlayersArray(JSONObject playerInfoResponse) {
        return playerInfoResponse.getJSONObject("response").getJSONArray("players");
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
