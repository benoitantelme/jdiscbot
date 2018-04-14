package com.discord.services;

import com.discord.bot.steam.SteamJsonArrayPath;
import com.discord.constants.CommonConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Stream.of;

public class SteamAppNewsService {

    private static final String APP_LIST_API = "ISteamApps/GetAppList/v0001/";
    private static final String NEWS_FOR_APP_API_1 = "ISteamNews/GetNewsForApp/v0002/?appid=";
    private static final String NEWS_FOR_APP_API_2 = "&count=3&maxlength=300&format=json";

    private static final String NAME = "name";
    private static final String APPID = "appid";

    private static final String TITLE = "title";
    private static final String CONTENTS = "contents";

    public static final String GAME_NOT_FOUND = "Game not found";
    private final JSONObject notFoundResult = new JSONObject("{\"error\": \"" + GAME_NOT_FOUND + "\"}");

    private static final SteamJsonArrayPath APP_PATH = new SteamJsonArrayPath(of("applist", "apps")
            .collect(toCollection(ArrayList::new)), "app");
    private static final SteamJsonArrayPath NEWS_ARRAY_PATH = new SteamJsonArrayPath(of("appnews")
            .collect(toCollection(ArrayList::new)), "newsitems");

    protected final Map<String, String> mapOfGamesNameToId = new HashMap<>();

    public SteamAppNewsService() {
        final String URI = SteamService.STEAM_API + APP_LIST_API;

        // initialize applications list gor game news
        JSONObject appList = SteamService.getJsonObjectResponse(URI);
        JSONArray array = APP_PATH.getArray(appList);

        array.forEach(item -> {
            JSONObject obj = (JSONObject) item;
            mapOfGamesNameToId.put(obj.get(NAME).toString(), obj.get(APPID).toString());
        });
    }


    public String getGameNews(String gameName) throws JSONException {
        JSONObject jsonResult = notFoundResult;
        String id = getGameId(gameName);

        if (id != null) {
            final String URI = SteamService.STEAM_API + NEWS_FOR_APP_API_1 + id + NEWS_FOR_APP_API_2;
            jsonResult = SteamService.getJsonObjectResponse(URI);
        }

        return jsonResult.has(CommonConstants.ERROR) ? jsonResult.get(CommonConstants.ERROR).toString() : parseGameNews(jsonResult);
    }

    protected String parseGameNews(JSONObject gameNewsJson) {
        StringBuilder result = new StringBuilder();

        JSONArray newsArray = NEWS_ARRAY_PATH.getArray(gameNewsJson);

        newsArray.forEach(item -> {
            JSONObject news = (JSONObject) item;
            result.append(news.get(TITLE)).append(SteamService.SLASHN).append(news.get(CONTENTS))
                    .append(SteamService.SLASHN).append(SteamService.SLASHN);
        });

        return result.toString();
    }

    protected String getGameId(String gameName) {
        return mapOfGamesNameToId.get(gameName);
    }
}
