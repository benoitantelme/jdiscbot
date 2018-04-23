package com.discord.services;

import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class SteamStoreFeaturedServiceTest {

    private static SteamStoreFeaturedService storeFeaturedService;

    @BeforeClass
    public static void setup() {
        SteamService service = new SteamService();
        storeFeaturedService = service.storeFeaturedService;
    }

    @Test
    public void testParseStoreFeatured() {
        assertFalse(storeFeaturedService.parseStoreFeatured(featuredJson).isEmpty());
    }

    @Test
    public void testGetStoreFeatured() {
        assertFalse(storeFeaturedService.getStoreFeatured().isEmpty());
    }

    private JSONObject featuredJson = new JSONObject("{  \n" +
            "   \"0\":{  \n" +
            "  \"name\":\"Spotlights\",\n" +
            "  \"id\":\"cat_spotlight\",\n" +
            "  \"items\":[  \n" +
            " {  \n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/spotlights/ec03022f2eca5df9bc081d17/spotlight_image_english.png?t=1466442594\",\n" +
            "\"name\":\"\",\n" +
            "\"body\":\"Offer ends Monday at 10am Pacific Time.\",\n" +
            "\"url\":\"http://store.steampowered.com/sale/Weeklong_Deals\"\n" +
            " }\n" +
            "  ]\n" +
            "   },\n" +
            "   \"coming_soon\":{  \n" +
            "  \"name\":\"Coming Soon\",\n" +
            "  \"id\":\"cat_comingsoon\",\n" +
            "  \"items\":[  \n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/818430/header.jpg?t=1524093289\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/818430/capsule_616x353.jpg?t=1524093289\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/818430/capsule_184x69.jpg?t=1524093289\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"BurningBridges VR\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":818430,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842520/header.jpg?t=1524499205\",\n" +
            "\"original_price\":159,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842520/capsule_616x353.jpg?t=1524499205\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842520/capsule_184x69.jpg?t=1524499205\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":111,\n" +
            "\"discount_expiration\":1525107631,\n" +
            "\"name\":\"Neon Void Runner\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":842520,\n" +
            "\"discount_percent\":30,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842530/header.jpg?t=1524499240\",\n" +
            "\"original_price\":79,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842530/capsule_616x353.jpg?t=1524499240\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842530/capsule_184x69.jpg?t=1524499240\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":55,\n" +
            "\"discount_expiration\":1525107638,\n" +
            "\"name\":\"Police Patrol\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":842530,\n" +
            "\"discount_percent\":30,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842640/header.jpg?t=1524498823\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842640/capsule_616x353.jpg?t=1524498823\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842640/capsule_184x69.jpg?t=1524498823\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Deadly Tropics\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":842640,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/752370/header.jpg?t=1524218229\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/752370/capsule_616x353.jpg?t=1524218229\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/752370/capsule_184x69.jpg?t=1524218229\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Silent space VR\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":752370,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/798240/header.jpg?t=1523305556\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/798240/capsule_616x353.jpg?t=1523305556\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/798240/capsule_184x69.jpg?t=1523305556\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"CRYEP\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":798240,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/821390/header.jpg?t=1524246057\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/821390/capsule_616x353.jpg?t=1524246057\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/821390/capsule_184x69.jpg?t=1524246057\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Achievement Lurker: Another one bites the dust\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":821390,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/836260/header.jpg?t=1524318077\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/836260/capsule_616x353.jpg?t=1524318077\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/836260/capsule_184x69.jpg?t=1524318077\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Call of Bitcoin\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":836260,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/840410/header.jpg?t=1524142741\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/840410/capsule_616x353.jpg?t=1524142741\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/840410/capsule_184x69.jpg?t=1524142741\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Mushroom Heroes\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":840410,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842510/header.jpg?t=1523902836\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842510/capsule_616x353.jpg?t=1523902836\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842510/capsule_184x69.jpg?t=1523902836\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Survival Maze\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":842510,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " }\n" +
            "  ]\n" +
            "   },\n" +
            "   \"1\":{  \n" +
            "  \"name\":\"Spotlights\",\n" +
            "  \"id\":\"cat_spotlight\",\n" +
            "  \"items\":[  \n" +
            " {  \n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/spotlights/07ed95db163094fbf72d3c25/spotlight_image_english.jpg?t=1524156924\",\n" +
            "\"name\":\"Weekend Deal\",\n" +
            "\"body\":\"Offer ends Monday at 10am Pacific Time.\",\n" +
            "\"url\":\"http://store.steampowered.com/sale/daedalic\"\n" +
            " }\n" +
            "  ]\n" +
            "   },\n" +
            "   \"trailerslideshow\":{  \n" +
            "  \"name\":\"Trailer TV\",\n" +
            "  \"id\":\"cat_trailerslideshow\"\n" +
            "   },\n" +
            "   \"2\":{  \n" +
            "  \"name\":\"Daily Deal\",\n" +
            "  \"id\":\"cat_dailydeal\",\n" +
            "  \"items\":[  \n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/597170/header.jpg?t=1516903821\",\n" +
            "\"original_price\":1499,\n" +
            "\"final_price\":989,\n" +
            "\"purchase_package\":156571,\n" +
            "\"name\":\"Clone Drone in the Danger Zone\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"id\":597170,\n" +
            "\"type\":0,\n" +
            "\"discount_percent\":34\n" +
            " }\n" +
            "  ]\n" +
            "   },\n" +
            "   \"specials\":{  \n" +
            "  \"name\":\"Specials\",\n" +
            "  \"id\":\"cat_specials\",\n" +
            "  \"items\":[  \n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/524220/header.jpg?t=1515664275\",\n" +
            "\"original_price\":5999,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/524220/capsule_616x353.jpg?t=1515664275\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/524220/capsule_184x69.jpg?t=1515664275\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":2999,\n" +
            "\"discount_expiration\":1525626000,\n" +
            "\"name\":\"NieR:Automata™\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":524220,\n" +
            "\"discount_percent\":50,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/subs/88801/header_ratio.jpg?t=1524005483\",\n" +
            "\"original_price\":4999,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":1,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/subs/88801/capsule_616x353.jpg?t=1524005483\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/subs/88801/capsule_184x69.jpg?t=1524005483\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":1999,\n" +
            "\"discount_expiration\":1524502800,\n" +
            "\"name\":\"Dying Light Enhanced Edition\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":\"88801\",\n" +
            "\"discount_percent\":60,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/218620/header.jpg?t=1524248822\",\n" +
            "\"original_price\":999,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/218620/capsule_616x353.jpg?t=1524248822\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/218620/capsule_184x69.jpg?t=1524248822\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":499,\n" +
            "\"discount_expiration\":1525021500,\n" +
            "\"name\":\"PAYDAY 2\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":218620,\n" +
            "\"discount_percent\":50,\n" +
            "\"streamingvideo_available\":false,\n" +
            "\"headline\":\"VR Mode now in Beta!\"\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/391220/header.jpg?t=1524133923\",\n" +
            "\"original_price\":4999,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/391220/capsule_616x353.jpg?t=1524133923\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/391220/capsule_184x69.jpg?t=1524133923\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":1649,\n" +
            "\"discount_expiration\":1524502800,\n" +
            "\"name\":\"Rise of the Tomb Raider™\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":391220,\n" +
            "\"discount_percent\":67,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/489830/header.jpg?t=1523078122\",\n" +
            "\"original_price\":3999,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/489830/capsule_616x353.jpg?t=1523078122\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/489830/capsule_184x69.jpg?t=1523078122\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":1999,\n" +
            "\"discount_expiration\":1524502800,\n" +
            "\"name\":\"The Elder Scrolls V: Skyrim Special Edition\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":489830,\n" +
            "\"discount_percent\":50,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/239140/header.jpg?t=1523974222\",\n" +
            "\"original_price\":2999,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/239140/capsule_616x353.jpg?t=1523974222\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/239140/capsule_184x69.jpg?t=1523974222\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":1349,\n" +
            "\"discount_expiration\":1524502800,\n" +
            "\"name\":\"Dying Light\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":239140,\n" +
            "\"discount_percent\":55,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/580600/header.jpg?t=1495820905\",\n" +
            "\"original_price\":1399,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/580600/capsule_616x353.jpg?t=1495820905\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/580600/capsule_184x69.jpg?t=1495820905\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":699,\n" +
            "\"discount_expiration\":1525626000,\n" +
            "\"name\":\"NieR:Automata™ - 3C3C1D119440927\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":580600,\n" +
            "\"discount_percent\":50,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/559650/header.jpg?t=1524229936\",\n" +
            "\"original_price\":1499,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/559650/capsule_616x353.jpg?t=1524229936\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/559650/capsule_184x69.jpg?t=1524229936\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":749,\n" +
            "\"discount_expiration\":1524503100,\n" +
            "\"name\":\"Witch It\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":559650,\n" +
            "\"discount_percent\":50,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/527230/header.jpg?t=1524150098\",\n" +
            "\"original_price\":1999,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/527230/capsule_616x353.jpg?t=1524150098\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/527230/capsule_184x69.jpg?t=1524150098\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":1599,\n" +
            "\"discount_expiration\":1525359600,\n" +
            "\"name\":\"For The King\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":527230,\n" +
            "\"discount_percent\":20,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/418240/header.jpg?t=1524046553\",\n" +
            "\"original_price\":3999,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/418240/capsule_616x353.jpg?t=1524046553\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/418240/capsule_184x69.jpg?t=1524046553\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":1999,\n" +
            "\"discount_expiration\":1524503100,\n" +
            "\"name\":\"Shadow Tactics: Blades of the Shogun\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":418240,\n" +
            "\"discount_percent\":50,\n" +
            "\"streamingvideo_available\":false\n" +
            " }\n" +
            "  ]\n" +
            "   },\n" +
            "   \"genres\":{  \n" +
            "  \"name\":\"Genres\",\n" +
            "  \"id\":\"cat_genres\"\n" +
            "   },\n" +
            "   \"new_releases\":{  \n" +
            "  \"name\":\"New Releases\",\n" +
            "  \"id\":\"cat_newreleases\",\n" +
            "  \"items\":[  \n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842640/header.jpg?t=1524498823\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842640/capsule_616x353.jpg?t=1524498823\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/842640/capsule_184x69.jpg?t=1524498823\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Deadly Tropics\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":842640,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/818430/header.jpg?t=1524093289\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/818430/capsule_616x353.jpg?t=1524093289\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/818430/capsule_184x69.jpg?t=1524093289\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"BurningBridges VR\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":818430,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/810330/header.jpg?t=1522075379\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/810330/capsule_616x353.jpg?t=1522075379\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/810330/capsule_184x69.jpg?t=1522075379\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Fast Food Rampage\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":810330,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/717980/header.jpg?t=1524411624\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/717980/capsule_616x353.jpg?t=1524411624\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/717980/capsule_184x69.jpg?t=1524411624\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"伏雨录\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":717980,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/728730/header.jpg?t=1524488296\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/728730/capsule_616x353.jpg?t=1524488296\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/728730/capsule_184x69.jpg?t=1524488296\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Holyday City: Reloaded\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":728730,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/712060/header.jpg?t=1524477251\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/712060/capsule_616x353.jpg?t=1524477251\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/712060/capsule_184x69.jpg?t=1524477251\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"M.I.A. - Overture\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":712060,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/829390/header.jpg?t=1524475686\",\n" +
            "\"original_price\":399,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/829390/capsule_616x353.jpg?t=1524475686\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/829390/capsule_184x69.jpg?t=1524475686\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":279,\n" +
            "\"discount_expiration\":1525107635,\n" +
            "\"name\":\"Kitten Life Simulator\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":829390,\n" +
            "\"discount_percent\":30,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/797640/header.jpg?t=1524470705\",\n" +
            "\"original_price\":399,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/797640/capsule_616x353.jpg?t=1524470705\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/797640/capsule_184x69.jpg?t=1524470705\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":359,\n" +
            "\"discount_expiration\":1525107655,\n" +
            "\"name\":\"Monster RPG 3\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":797640,\n" +
            "\"discount_percent\":10,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831950/header.jpg?t=1524468140\",\n" +
            "\"original_price\":599,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831950/capsule_616x353.jpg?t=1524468140\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831950/capsule_184x69.jpg?t=1524468140\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":509,\n" +
            "\"discount_expiration\":1525107609,\n" +
            "\"name\":\"Infinite Survival\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":831950,\n" +
            "\"discount_percent\":15,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831690/header.jpg?t=1523591016\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831690/capsule_616x353.jpg?t=1523591016\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831690/capsule_184x69.jpg?t=1523591016\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Piano Play 3D\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":831690,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/840500/header.jpg?t=1524466755\",\n" +
            "\"original_price\":79,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/840500/capsule_616x353.jpg?t=1524466755\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/840500/capsule_184x69.jpg?t=1524466755\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":53,\n" +
            "\"discount_expiration\":1525021205,\n" +
            "\"name\":\"Dictator's dreams\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":840500,\n" +
            "\"discount_percent\":33,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/844140/header.jpg?t=1523339951\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/844140/capsule_616x353.jpg?t=1523339951\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/844140/capsule_184x69.jpg?t=1523339951\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Trivia Vault: Soccer Trivia\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":844140,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/806000/header.jpg?t=1524363735\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/806000/capsule_616x353.jpg?t=1524363735\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/806000/capsule_184x69.jpg?t=1524363735\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"OrcCraft\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":806000,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/835110/header.jpg?t=1524341341\",\n" +
            "\"original_price\":499,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/835110/capsule_616x353.jpg?t=1524341341\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/835110/capsule_184x69.jpg?t=1524341341\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":499,\n" +
            "\"name\":\"America's Retribution\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":835110,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/833690/header.jpg?t=1523272298\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/833690/capsule_616x353.jpg?t=1523272298\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/833690/capsule_184x69.jpg?t=1523272298\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Cubesc\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":833690,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/809770/header.jpg?t=1524325212\",\n" +
            "\"original_price\":79,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/809770/capsule_616x353.jpg?t=1524325212\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/809770/capsule_184x69.jpg?t=1524325212\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":71,\n" +
            "\"discount_expiration\":1524934801,\n" +
            "\"name\":\"DeerHunterX\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":809770,\n" +
            "\"discount_percent\":10,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/834750/header.jpg?t=1524316988\",\n" +
            "\"original_price\":399,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/834750/capsule_616x353.jpg?t=1524316988\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/834750/capsule_184x69.jpg?t=1524316988\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":399,\n" +
            "\"name\":\"Crucible Falls: Together Forever\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":834750,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/848270/header.jpg?t=1524231818\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/848270/capsule_616x353.jpg?t=1524231818\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/848270/capsule_184x69.jpg?t=1524231818\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Sky Conqueror\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":848270,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831180/header.jpg?t=1524310081\",\n" +
            "\"original_price\":399,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831180/capsule_616x353.jpg?t=1524310081\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831180/capsule_184x69.jpg?t=1524310081\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":319,\n" +
            "\"discount_expiration\":1524934851,\n" +
            "\"name\":\"Pixel Beef Battle\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":831180,\n" +
            "\"discount_percent\":20,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/833300/header.jpg?t=1524308542\",\n" +
            "\"original_price\":899,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/833300/capsule_616x353.jpg?t=1524308542\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/833300/capsule_184x69.jpg?t=1524308542\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":539,\n" +
            "\"discount_expiration\":1524934823,\n" +
            "\"name\":\"Fantasyland\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":833300,\n" +
            "\"discount_percent\":40,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/806220/header.jpg?t=1524299720\",\n" +
            "\"original_price\":329,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/806220/capsule_616x353.jpg?t=1524299720\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/806220/capsule_184x69.jpg?t=1524299720\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":279,\n" +
            "\"discount_expiration\":1524934810,\n" +
            "\"name\":\"Absolute Blue\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":806220,\n" +
            "\"discount_percent\":15,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831810/header.jpg?t=1524296383\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831810/capsule_616x353.jpg?t=1524296383\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831810/capsule_184x69.jpg?t=1524296383\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Bane of Asphodel\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":831810,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/840590/header.jpg?t=1524308444\",\n" +
            "\"original_price\":819,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/840590/capsule_616x353.jpg?t=1524308444\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/840590/capsule_184x69.jpg?t=1524308444\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":491,\n" +
            "\"discount_expiration\":1524848417,\n" +
            "\"name\":\"ANOIX\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":840590,\n" +
            "\"discount_percent\":40,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/805980/header.jpg?t=1524283303\",\n" +
            "\"original_price\":163,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/805980/capsule_616x353.jpg?t=1524283303\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/805980/capsule_184x69.jpg?t=1524283303\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":163,\n" +
            "\"name\":\"My Safe House\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":805980,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/777580/header.jpg?t=1524274612\",\n" +
            "\"original_price\":199,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/777580/capsule_616x353.jpg?t=1524274612\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/777580/capsule_184x69.jpg?t=1524274612\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":199,\n" +
            "\"name\":\"Champ Against Chumps Upgrade Edition\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":777580,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/438210/header.jpg?t=1523914390\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/438210/capsule_616x353.jpg?t=1523914390\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/438210/capsule_184x69.jpg?t=1523914390\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"MULE Returns\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":438210,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831230/header.jpg?t=1524265280\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831230/capsule_616x353.jpg?t=1524265280\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/831230/capsule_184x69.jpg?t=1524265280\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Doors Quest Demo\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":831230,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/812940/header.jpg?t=1524265248\",\n" +
            "\"original_price\":899,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/812940/capsule_616x353.jpg?t=1524265248\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/812940/capsule_184x69.jpg?t=1524265248\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":539,\n" +
            "\"discount_expiration\":1524848438,\n" +
            "\"name\":\"Dear Leader\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":812940,\n" +
            "\"discount_percent\":40,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/777710/header.jpg?t=1515154408\",\n" +
            "\"original_price\":null,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/777710/capsule_616x353.jpg?t=1515154408\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/777710/capsule_184x69.jpg?t=1515154408\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":0,\n" +
            "\"name\":\"Bloodbath Requiem\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":777710,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/638720/header.jpg?t=1524323934\",\n" +
            "\"original_price\":569,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/638720/capsule_616x353.jpg?t=1524323934\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/638720/capsule_184x69.jpg?t=1524323934\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":455,\n" +
            "\"discount_expiration\":1524848405,\n" +
            "\"name\":\"Final Battle\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":638720,\n" +
            "\"discount_percent\":20,\n" +
            "\"streamingvideo_available\":false\n" +
            " }\n" +
            "  ]\n" +
            "   },\n" +
            "   \"top_sellers\":{  \n" +
            "  \"name\":\"Top Sellers\",\n" +
            "  \"id\":\"cat_topsellers\",\n" +
            "  \"items\":[  \n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/552520/header.jpg?t=1523375561\",\n" +
            "\"original_price\":5999,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/552520/capsule_616x353.jpg?t=1523375561\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/552520/capsule_184x69.jpg?t=1523375561\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":5999,\n" +
            "\"name\":\"Far Cry® 5\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":552520,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/524220/header.jpg?t=1515664275\",\n" +
            "\"original_price\":5999,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/524220/capsule_616x353.jpg?t=1515664275\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/524220/capsule_184x69.jpg?t=1515664275\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":2999,\n" +
            "\"discount_expiration\":1525626000,\n" +
            "\"name\":\"NieR:Automata™\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":524220,\n" +
            "\"discount_percent\":50,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/637090/header.jpg?t=1524480974\",\n" +
            "\"original_price\":3999,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/637090/capsule_616x353.jpg?t=1524480974\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/637090/capsule_184x69.jpg?t=1524480974\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":3999,\n" +
            "\"name\":\"BATTLETECH\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":637090,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/489830/header.jpg?t=1523078122\",\n" +
            "\"original_price\":3999,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/489830/capsule_616x353.jpg?t=1523078122\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/489830/capsule_184x69.jpg?t=1523078122\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":1999,\n" +
            "\"discount_expiration\":1524502800,\n" +
            "\"name\":\"The Elder Scrolls V: Skyrim Special Edition\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":489830,\n" +
            "\"discount_percent\":50,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/subs/88801/header_ratio.jpg?t=1524005483\",\n" +
            "\"original_price\":4999,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":1,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/subs/88801/capsule_616x353.jpg?t=1524005483\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/subs/88801/capsule_184x69.jpg?t=1524005483\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":1999,\n" +
            "\"discount_expiration\":1524502800,\n" +
            "\"name\":\"Dying Light Enhanced Edition\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":\"88801\",\n" +
            "\"discount_percent\":60,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":true,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/391220/header.jpg?t=1524133923\",\n" +
            "\"original_price\":4999,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/391220/capsule_616x353.jpg?t=1524133923\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/391220/capsule_184x69.jpg?t=1524133923\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":1649,\n" +
            "\"discount_expiration\":1524502800,\n" +
            "\"name\":\"Rise of the Tomb Raider™\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":391220,\n" +
            "\"discount_percent\":67,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/252950/header.jpg?t=1522783996\",\n" +
            "\"original_price\":1999,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":0,\n" +
            "\"controller_support\":\"full\",\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/252950/capsule_616x353.jpg?t=1522783996\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/252950/capsule_184x69.jpg?t=1522783996\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":1999,\n" +
            "\"name\":\"Rocket League®\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":252950,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/578080/header.jpg?t=1524483267\",\n" +
            "\"original_price\":2999,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/578080/capsule_616x353.jpg?t=1524483267\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/578080/capsule_184x69.jpg?t=1524483267\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":2999,\n" +
            "\"name\":\"PLAYERUNKNOWN'S BATTLEGROUNDS\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":578080,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/621060/header.jpg?t=1524129700\",\n" +
            "\"original_price\":1999,\n" +
            "\"linux_available\":false,\n" +
            "\"type\":0,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/621060/capsule_616x353.jpg?t=1524129700\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/apps/621060/capsule_184x69.jpg?t=1524129700\",\n" +
            "\"mac_available\":false,\n" +
            "\"final_price\":1999,\n" +
            "\"name\":\"PC Building Simulator\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":621060,\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " },\n" +
            " {  \n" +
            "\"discounted\":false,\n" +
            "\"header_image\":\"https://steamcdn-a.akamaihd.net/steam/bundles/5555/liv1vt9cn3j11ykr/header_ratio.jpg?t=1512484983\",\n" +
            "\"original_price\":6396,\n" +
            "\"linux_available\":true,\n" +
            "\"type\":2,\n" +
            "\"large_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/bundles/5555/liv1vt9cn3j11ykr/capsule_616x353.jpg?t=1512484983\",\n" +
            "\"small_capsule_image\":\"https://steamcdn-a.akamaihd.net/steam/bundles/5555/liv1vt9cn3j11ykr/capsule_184x69.jpg?t=1512484983\",\n" +
            "\"mac_available\":true,\n" +
            "\"final_price\":5436,\n" +
            "\"name\":\"Euro Truck Simulator 2 Map Booster\",\n" +
            "\"currency\":\"EUR\",\n" +
            "\"windows_available\":true,\n" +
            "\"id\":\"5555\",\n" +
            "\"discount_percent\":0,\n" +
            "\"streamingvideo_available\":false\n" +
            " }\n" +
            "  ]\n" +
            "   },\n" +
            "   \"status\":1\n" +
            "}");
}
