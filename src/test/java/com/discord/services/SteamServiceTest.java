package com.discord.services;

import com.discord.constants.CommonConstants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SteamServiceTest {

    public static final String EXPECTED = "578080";

    private final static SteamService service = new SteamService();

    @Test
    public void testConstructor() {
        assertEquals(EXPECTED, service.newsService.mapOfGamesNameToId.get(CommonConstants.PLAYERUNKNOWN_S_BATTLEGROUNDS));
    }

}
