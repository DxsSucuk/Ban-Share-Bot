package de.presti.basic.banshare.events;

import de.presti.basic.banshare.Main;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GuildBanEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventAdapter extends ListenerAdapter {

    @Override
    public void onGuildBan(@NotNull GuildBanEvent event) {
        super.onGuildBan(event);
        for (Guild guild : Main.getInstance().getBot().getGuilds()) {
            guild.ban(event.getUser(), 1).queue();
        }
    }
}
