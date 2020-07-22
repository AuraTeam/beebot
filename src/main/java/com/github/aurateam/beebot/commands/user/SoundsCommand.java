package com.github.aurateam.beebot.commands.user;

import com.github.aurateam.beebot.utils.Image;
import com.github.aurateam.beebot.utils.Colors;
import me.mattstudios.mfjda.annotations.Command;
import me.mattstudios.mfjda.annotations.Default;
import me.mattstudios.mfjda.base.CommandBase;
import net.dv8tion.jda.api.EmbedBuilder;

import java.time.Instant;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Command("sounds")
public class SoundsCommand extends CommandBase {

    private final String URL = "https://github.andre601.com/Spigot-Sounds/sounds/mc-";
    private final String list = Stream.of("1.8", "1.9", "1.10", "1.11", "1.12", "1.13", "1.14", "1.15", "1.16")
            .map(version -> "[" + version + ".x](" + URL + version + ')')
            .collect(Collectors.joining(", "));

    @Default
    public void onCommand() {
        final EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(Colors.GENERAL.get())
                .setAuthor("Spigot sounds list", "https://github.andre601.com/Spigot-Sounds/", Image.SPIGOT_LOGO.get())
                .appendDescription("Bellow you can find all sounds list, starting from Minecraft 1.8, created and maintained by [@Andre601](https://github.com/Andre601).\n\n")
                .appendDescription(list)
                .setFooter("Requested by " + getMessage().getAuthor().getName(), getJda().getSelfUser().getAvatarUrl())
                .setTimestamp(Instant.now());

        getMessage().getTextChannel().sendMessage(
                embedBuilder.build()
        ).queue();
    }
}
