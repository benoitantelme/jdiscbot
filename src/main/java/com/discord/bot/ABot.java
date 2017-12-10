package com.discord.bot;

import com.discord.constants.BotConstants;
import com.discord.constants.CommonConstants;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class ABot extends ListenerAdapter {

    public static final String WORDS = "Words";
    public static final String STEAM = "Steam";

    private final static Map<String, Supplier<ABot>> botsMap = new HashMap<>();

    static {
        botsMap.put(WORDS, WordsBot::new);
        botsMap.put(STEAM, SteamBot::new);
    }

    protected boolean fromBot(MessageReceivedEvent event) {
        boolean result = false;
        User author = event.getAuthor();
        if (author.isBot())
            result = true;

        return result;
    }

    protected void createBot(String botType) throws LoginException, RateLimitedException, InterruptedException {
        JDA jda = new JDABuilder(AccountType.BOT).setToken(BotConstants.TOKEN).buildBlocking();

        Supplier<ABot> sup = botsMap.get(botType);
        if (sup != null) {
            jda.addEventListener(sup.get());
        } else {
            throw new RuntimeException("Unknown type of bot: " + botType);
        }

    }

    protected String getArgForCmd(String message) {
        String[] splittedMessage = message.split(CommonConstants.SPACE, 2);
        String result = CommonConstants.EMPTY_STRING;

        if (splittedMessage.length == 2) {
            result = splittedMessage[1];
        }

        return result;
    }

}
