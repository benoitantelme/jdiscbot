package com.discord.services;

import com.discord.bot.steam.SteamJsonArrayPath;
import com.discord.constants.CommonConstants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Stream.of;

public class SteamStoreFeaturedService {

    private static final String STORE_FEATURED_API = "http://store.steampowered.com/api/featuredcategories/";

    public static final String SPECIAL_NOT_FOUND = "Specials not found";
    public static final String DOT = ".";
    public static final String PERCENT = " %";
    public static final String DISCOUNT_PERCENT = "discount_percent";

    private static final List<String> SPECIALS_INFO_LIST = of("name", "small_capsule_image", DISCOUNT_PERCENT)
            .collect(toCollection(ArrayList::new));

    private static final SteamJsonArrayPath STORE_SPECIALS_PATH = new SteamJsonArrayPath(of("specials")
            .collect(toCollection(ArrayList::new)), "items");

    public String getStoreFeatured() {
        JSONObject jsonResult = SteamService.getJsonObjectResponse(STORE_FEATURED_API);

        return parseStoreFeatured(jsonResult);
    }

    protected String parseStoreFeatured(JSONObject storeFeaturedNews) {
        StringBuilder result = new StringBuilder();

        JSONArray specialsInfoArray = STORE_SPECIALS_PATH.getArray(storeFeaturedNews);

        if (specialsInfoArray != null && specialsInfoArray.length() > 0) {
            specialsInfoArray.forEach(item -> {
                JSONObject news = (JSONObject) item;

                SPECIALS_INFO_LIST.forEach(info -> {
                    if (news.has(info)) {
                        if (info.equals(DISCOUNT_PERCENT))
                            result.append(news.get(info)).append(PERCENT).append(SteamService.SLASHN);
                        else
                            result.append(news.get(info)).append(SteamService.SLASHN);
                    }
                });

                String finalPrice = news.get("final_price").toString();
                String currency = news.get("currency").toString();
                if (finalPrice != null && currency != null) {
                    result.append(finalPrice.substring(0, finalPrice.length() - 2)).append(DOT).
                            append(finalPrice.substring(finalPrice.length() - 2, finalPrice.length())).append(CommonConstants.SPACE)
                            .append(currency).append(SteamService.SLASHN);
                }

                result.append(SteamService.SLASHN).append(SteamService.SLASHN);
            });
        } else {
            result.append(SPECIAL_NOT_FOUND);
        }

        return result.toString();
    }


}
