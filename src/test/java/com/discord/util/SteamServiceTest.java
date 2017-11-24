package com.discord.util;

import org.json.JSONException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SteamServiceTest {
    public static final String PLAYERUNKNOWN_S_BATTLEGROUNDS = "PLAYERUNKNOWN'S BATTLEGROUNDS";
    public static final String EXPECTED = "578080";

    @Rule
    public ExpectedException exceptions = ExpectedException.none();

    @Test
    public void testConstructor() {
        SteamService service = new SteamService();
        assertEquals(EXPECTED, service.mapOfGamesNameToId.get(PLAYERUNKNOWN_S_BATTLEGROUNDS));
    }

    @Test
    public void testGetGameId() {
        SteamService service = new SteamService();
        assertEquals(EXPECTED, service.getGameId(PLAYERUNKNOWN_S_BATTLEGROUNDS));
    }

    @Test(expected = JSONException.class)
    public void testGetGameNewsError() {
        SteamService service = new SteamService();
        service.getGameNewsJson(PLAYERUNKNOWN_S_BATTLEGROUNDS).get("error");
    }

    @Test()
    public void testGetGameNewsOk() {
        SteamService service = new SteamService();
        service.getGameNewsJson("whateverthatgameis").get("error");
        assertEquals(SteamService.GAME_NOT_FOUND,
                service.getGameNewsJson("whateverthatgameis").get("error").toString());
    }

    @Test
    public void testGetGameNews() {
        SteamService service = new SteamService();
        assertFalse(service.getGameNewsJson(PLAYERUNKNOWN_S_BATTLEGROUNDS).toString().isEmpty());
    }

    @Test
    public void testParseGameNews() {
        SteamService service = new SteamService();
        assertFalse(service.parseGameNews(service.getGameNewsJson(PLAYERUNKNOWN_S_BATTLEGROUNDS)).isEmpty());
    }

}
