package com.discord.bot.steam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class SteamJsonArrayPath {

    private final List<String> jsonObjectsKeys;
    private final String lastNodeKey;

    public SteamJsonArrayPath(List<String> jsonObjectsKeys, String lastNodeKey) {
        this.jsonObjectsKeys = jsonObjectsKeys;
        this.lastNodeKey = lastNodeKey;
    }

    public JSONArray getArray(JSONObject object) throws JSONException {
        JSONArray result;
        JSONObject nextNode = object;

        for (String key : jsonObjectsKeys) {
            if (nextNode.has(key)) {
                nextNode = object.getJSONObject(key);
            } else {
                throw new JSONException("Can not reach node " + key);
            }
        }

        if (nextNode.has(lastNodeKey))
            result = nextNode.getJSONArray(lastNodeKey);
        else
            throw new JSONException("Can not reach node " + lastNodeKey);
        return result;
    }
}
