package com.discord.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SteamPlayerInfoServiceTest {

    public static final String PLAYER_ID = "76561197960435530";

    private static SteamPlayerInfoService playerInfoService;

    @BeforeAll
    public static void setup() {
        SteamService service = new SteamService();
        playerInfoService = service.playerInfoService;
    }

    @Test
    public void testGetPlayerInfoOk() {

        assertFalse(playerInfoService.getPlayerInfo(PLAYER_ID).isEmpty());
    }

    @Test
    public void testGetPlayerInfoKo() {
        assertEquals(SteamPlayerInfoService.PLAYER_NOT_FOUND, playerInfoService.getPlayerInfo("notAnId"));
    }

    @Test
    public void testParsePlayerInfo() {
        assertFalse(playerInfoService.parsePlayerInfo(jsonObj).isEmpty());
    }

    @Test
    public void testGetPlayersArray() {
        JSONArray array = SteamPlayerInfoService.PLAYERS_INFO_PATH.getArray(jsonObj);

        assertTrue(array != null && array.length() == 1);
    }

    private JSONObject jsonObj = new JSONObject("{\n" +
            "\"response\":{\n" +
            "\"players\":[{\n" +
            "\"personastate\":0,\n" +
            "\"profileurl\":\"http://steamcommunity.com/id/robinwalker/\",\n" +
            "\"profilestate\":1,\n" +
            "\"primaryclanid\":\"103582791429521412\",\n" +
            "\"avatarfull\":\"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/f1/f1dd60a188883caf82d0cbfccfe6aba0af1732d4_full.jpg\",\n" +
            "\"avatarmedium\":\"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/f1/f1dd60a188883caf82d0cbfccfe6aba0af1732d4_medium.jpg\",\n" +
            "\"locstatecode\":\"WA\",\n" +
            "\"avatar\":\"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/f1/f1dd60a188883caf82d0cbfccfe6aba0af1732d4.jpg\",\n" +
            "\"personaname\":\"Robin\",\n" +
            "\"personastateflags\":0,\n" +
            "\"realname\":\"Robin Walker\",\n" +
            "\"steamid\":\"76561197960435530\",\n" +
            "\"timecreated\":1063407589,\n" +
            "\"lastlogoff\":1512894857,\n" +
            "\"loccountrycode\":\"US\",\n" +
            "\"communityvisibilitystate\":3,\n" +
            "\"loccityid\":3961}]}}");

}
