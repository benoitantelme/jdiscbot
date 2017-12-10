package com.discord.util;

import com.discord.constants.CommonConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SteamServiceTest {
    private static final String EXPECTED = "578080";
    private static final String PLAYER_INFO = "{\n" +
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
            "\"loccityid\":3961}]}}";

    private final SteamService service = new SteamService();

    @Test
    public void testConstructor() {
        assertEquals(EXPECTED, service.mapOfGamesNameToId.get(CommonConstants.PLAYERUNKNOWN_S_BATTLEGROUNDS));
    }

    @Test
    public void testGetGameId() {
        assertEquals(EXPECTED, service.getGameId(CommonConstants.PLAYERUNKNOWN_S_BATTLEGROUNDS));
    }

    @Test()
    public void testGetGameNotFoundNews() {
        assertEquals(SteamService.GAME_NOT_FOUND,
                service.getGameNews("whateverthatgameis"));
    }

    @Test
    public void testGetGameNewsOk() {
        assertFalse(service.getGameNews(CommonConstants.PLAYERUNKNOWN_S_BATTLEGROUNDS).toString().isEmpty());
    }

    @Test
    public void testParseGameNews() {
        String gameNewsResult = "{\n" +
                "\"appnews\":{\n" +
                "\"newsitems\":[{\n" +
                "\"date\":1511521620,\"feedlabel\":\"Rock, Paper, Shotgun\",\"feedname\":\"rps\",\"gid\":\"2149769425918014886\",\"contents\":" +
                "\"The sale event to end all sale events is here. That&#8217;s right, folks, <a href=\\\"https://www.rockpapershotgun.com/tag/Black-Friday/" +
                "\\\">Black Friday<\\/a> 2017 is here, and this year&#8217;s sales frenzy is set to be bigger than ever as we head into the Christmas " +
                "shopping period. In all honesty, they should just rename it Black November, as there have been deals goi...\",\"author\":\"" +
                "contact@rockpapershotgun.com (Katharine Byrne)\",\"appid\":115800,\"is_external_url\":true,\"title\":\"Black Friday 2017: " +
                "The best deals on graphics cards, monitors, SSDs and more\",\"feed_type\":0,\"url\":\"" +
                "http://store.steampowered.com/news/externalpost/rps/2149769425918014886\"},{\n" +
                "\"date\":1511470851,\"feedlabel\":\"Rock, Paper, Shotgun\",\"feedname\":\"rps\",\"gid\":\"2149769425915855521\",\"contents\":" +
                "\"This is <a href=\\\"https://www.rockpapershotgun.com/tag/playstyle-royale/\\\">Playstyle Royale<\\/a>, where I head into " +
                "<a href=\\\"https://www.rockpapershotgun.com/tag/playerunknowns-battlegrounds/\\\">Playerunknown s Battlegrounds<\\/a> " +
                "and try to win my chicken dinner while adhering to arbitrary rules. This week, I m going with Godwhacker s excellent suggestion " +
                "<a href=\\\"https://www.rockpapershotgun.com/2017/11/01/playstyle-royale-newb-school/#comment-2532679\\\">in the comments from last time" +
                "<\\/a>: Dump the Evidence . You re allowed one kill with a weapon, but the...\",\"author\":\"contact@rockpapershotgun.com (Matt Cox)\"," +
                "\"appid\":578080,\"is_external_url\":true,\"title\":\"Playstyle Royale: Dump The Evidence\",\"feed_type\":0,\"url\":\"" +
                "http://store.steampowered.com/news/externalpost/rps/2149769425915855521\"},{\n" +
                "\"date\":1511456443,\"feedlabel\":\"Rock, Paper, Shotgun\",\"feedname\":\"rps\",\"gid\":\"2149769425915252726\",\"contents\":" +
                "\"Cowardice is a virtue. So says the team on this week&#8217;s RPS podcast, the <a href=\\\"" +
                "https://www.rockpapershotgun.com/tag/the-rps-electronic-wireless-show/\\\">Electronic Wireless Show<\\/a>. " +
                "That&#8217;s because our theme is &#8220;running away&#8221; &#8211; games that encourage you to flee from danger, " +
                "or that give you a choice between fight <em>and<\\/em> flight. Adam will run from the soldie...\",\"author\":\"contact@rockpapershotgun.com" +
                " (Brendan Caldwell)\",\"appid\":17410,\"is_external_url\":true,\"title\":\"Podcast: Into The Breach, Playerunknown s Battlegrounds " +
                "and running away \",\"feed_type\":0,\"url\":\"http://store.steampowered.com/news/externalpost/rps/2149769425915252726\"}]," +
                "\"appid\":578080,\"count\":312}}\n";
        JSONObject jsonObj = new JSONObject(gameNewsResult);
        assertFalse(service.parseGameNews(jsonObj).isEmpty());
    }

    @Test
    public void testGetPlayerInfoOk() {
        assertFalse(service.getPlayerInfo("76561197960435530").toString().isEmpty());
    }

    @Test
    public void testGetPlayerInfoKo() {
        assertEquals(SteamService.PLAYER_NOT_FOUND, service.getPlayerInfo("notAnId"));
    }

    @Test
    public void testParsePlayerInfo() {
        SteamService service = new SteamService();

        JSONObject jsonObj = new JSONObject(PLAYER_INFO);
        assertFalse(service.parsePlayerInfo(jsonObj).isEmpty());
    }

    @Test
    public void testGetPlayers() {
        JSONObject jsonObj = new JSONObject(PLAYER_INFO);
        JSONArray array = service.getPlayersArray(jsonObj);
        assertTrue(array != null && array.length() == 1);
    }

}
