package com.discord.bot.steam;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Stream.of;
import static org.junit.Assert.assertEquals;

public class SteamJsonArrayPathTest {

    private final String exampleString = "{ \n" +
            "    \"stuff\": {\n" +
            "        \"onetype\": [\n" +
            "            {\"id\":1,\"name\":\"John Doe\"},\n" +
            "            {\"id\":2,\"name\":\"Don Joeh\"}\n" +
            "        ],\n" +
            "        \"othertype\": {\"id\":2,\"company\":\"ACME\"}\n" +
            "    }, \n" +
            "    \"otherstuff\": {\n" +
            "        \"thing\": [[1,42],[2,2]]\n" +
            "     }\n" +
            "}";

    private final JSONObject jsonObj = new JSONObject(exampleString);

    @Test
    public void testGetArrayOk() throws Exception {
        SteamJsonArrayPath path = new SteamJsonArrayPath(of("stuff")
                .collect(toCollection(ArrayList::new)), "onetype");

        assertEquals(2, path.getArray(jsonObj).length());
    }

    @Test(expected = JSONException.class)
    public void testGetArrayBadArrayKey() throws Exception {
        SteamJsonArrayPath pathWrongArrayName = new SteamJsonArrayPath(of("data", "stuff")
                .collect(toCollection(ArrayList::new)), "onetypeeee");

        pathWrongArrayName.getArray(jsonObj);
    }

    @Test(expected = JSONException.class)
    public void testGetArrayBadObjectKey() throws Exception {
        SteamJsonArrayPath pathWrongObjectName = new SteamJsonArrayPath(of("data", "stufffff")
                .collect(toCollection(ArrayList::new)), "onetype");

        pathWrongObjectName.getArray(jsonObj);
    }
}


