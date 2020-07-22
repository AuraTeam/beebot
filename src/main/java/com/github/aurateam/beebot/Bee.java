package com.github.aurateam.beebot;

import com.github.aurateam.beebot.commands.user.SoundsCommand;
import com.github.aurateam.beebot.config.Config;
import com.github.aurateam.beebot.config.Settings;
import me.mattstudios.mfjda.base.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.checkerframework.checker.units.qual.C;

import javax.security.auth.login.LoginException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class Bee {

    private JDA bee;
    private final Config config = new Config();

    public Bee() {
        final Set<GatewayIntent> indents = EnumSet.of(
                GatewayIntent.GUILD_MESSAGES
        );

        try {
            this.bee = JDABuilder.create(config.get(Settings.TOKEN), indents)
                    .disableCache(Collections.singleton(CacheFlag.ACTIVITY))
                    .setStatus(OnlineStatus.IDLE)
                    .setActivity(Activity.watching("flowers growing"))
                    .build();

            loadCommands();
        } catch (LoginException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void loadCommands() {
        final CommandManager commandManager = new CommandManager(bee, "b!");

        commandManager.register(new SoundsCommand());
    }
}
