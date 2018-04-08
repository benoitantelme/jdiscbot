package com.discord.services;

import com.discord.bot.steam.SteamJsonArrayPath;
import com.discord.constants.BotConstants;
import com.discord.constants.CommonConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Stream.of;

public class SteamPlayerInfoService {

    private static final String PLAYER_SUMMARY_API_1 = "ISteamUser/GetPlayerSummaries/v0002/?key=";
    private static final String PLAYER_SUMMARY_API_2 = "&steamids=";

    public static final String PLAYER_NOT_FOUND = "Player not found";

    private static final List<String> PLAYER_INFO_LIST = of("profileurl", "realname", "loccountrycode", "avatar")
            .collect(toCollection(ArrayList::new));

    protected static final SteamJsonArrayPath PLAYERS_INFO_PATH = new SteamJsonArrayPath(of("response")
            .collect(toCollection(ArrayList::new)), "players");

    public String getPlayerInfo(String playerId) throws JSONException {
        final String URI = SteamService.STEAM_API + PLAYER_SUMMARY_API_1 + BotConstants.STEAM_KEY + PLAYER_SUMMARY_API_2 + playerId;
        JSONObject jsonResult = SteamService.getJsonObjectResponse(URI);

        return jsonResult.has(CommonConstants.ERROR) ? jsonResult.get(CommonConstants.ERROR).toString() : parsePlayerInfo(jsonResult);
    }

    protected String parsePlayerInfo(JSONObject gameNewsJson) {
        StringBuilder result = new StringBuilder();

        JSONArray playerInfoArray = PLAYERS_INFO_PATH.getArray(gameNewsJson);

        if (playerInfoArray != null && playerInfoArray.length() > 0) {
            playerInfoArray.forEach(item -> {
                JSONObject news = (JSONObject) item;

                PLAYER_INFO_LIST.forEach(info -> {
                    if (news.has(info))
                        result.append(news.get(info)).append(SteamService.SLASHN);
                });

                Object timeOfCreation = news.get("timecreated");
                if (timeOfCreation != null) {
                    result.append(Instant.ofEpochSecond(Long.valueOf(timeOfCreation.toString())))
                            .append(SteamService.SLASHN);
                }

                result.append(SteamService.SLASHN).append(SteamService.SLASHN);
            });
        } else {
            result.append(PLAYER_NOT_FOUND);
        }

        return result.toString();
    }


}
