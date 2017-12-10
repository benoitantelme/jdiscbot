# JDISCBOT
Discord bots in Java

### Does:
* WordsBot: Contains a list of words to be listened for and counts those words usage
* SteamBot : API for game news request

### Usage:
* To build and use, replace the values of bot token and steam api key in the class com.discord.constants.BotConstants
* Add your bot to a discord using [this link](https://discordapp.com/oauth2/authorize?client_id=<CLIENT_ID>&scope=bot).

### WordsBot commands description:
* Summary command: **!sum** | Gives a summary of the words usage per user
* Add command: **!add _word_** | Adds a word to be accounted for

### SteamBot commands description:
* News command: **!news _gameName_** | Gives you the last news for that game
