package de.presti.basic.banshare;

import de.presti.basic.banshare.events.EventAdapter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {

    private static Main instance;
    private JDA botInstance;

    public static void main(String[] args) throws LoginException {
        instance = new Main();
        instance.botInstance = JDABuilder.createDefault(args[0]).enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS)).build();
        instance.botInstance.getPresence().setActivity(Activity.listening("to Jesus"));
        instance.botInstance.addEventListener(new EventAdapter());
    }

    public JDA getBot() {
        return botInstance;
    }

    public static Main getInstance() {
        return instance;
    }

}
