package com.discord.bot.steam;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Stream.of;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SteamJsonArrayPathTest {

    private final String exampleString = "{\"menu\": {\n" +
            "  \"id\": \"file\",\n" +
            "  \"value\": \"File\",\n" +
            "  \"popup\": {\n" +
            "    \"menuitem\": [\n" +
            "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
            "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
            "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
            "    ]\n" +
            "  }\n" +
            "}}";

    private final JSONObject jsonObj = new JSONObject(exampleString);

    @Test
    public void testGetArrayOk() throws Exception {
        SteamJsonArrayPath path = new SteamJsonArrayPath(of("menu", "popup")
                .collect(toCollection(ArrayList::new)), "menuitem");

        assertEquals(3, path.getArray(jsonObj).length());
    }

    @Test
    public void testGetArrayBadArrayKey() throws Exception {
        SteamJsonArrayPath pathWrongArrayName = new SteamJsonArrayPath(of("data", "stuff")
                .collect(toCollection(ArrayList::new)), "onetypeeee");

        assertThrows(JSONException.class, () -> {
            pathWrongArrayName.getArray(jsonObj);
        });
    }

    @Test
    public void testGetArrayBadObjectKey() throws Exception {
        SteamJsonArrayPath pathWrongObjectName = new SteamJsonArrayPath(of("data", "stufffff")
                .collect(toCollection(ArrayList::new)), "onetype");

        assertThrows(JSONException.class, () -> {
            pathWrongObjectName.getArray(jsonObj);
        });

    }
}


