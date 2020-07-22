package com.github.aurateam.beebot.config;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;

import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class Settings implements SettingsHolder {

    @Comment("Bot's token")
    public static final Property<String> TOKEN = newProperty("bot.token", "YOUR TOKEN HERE");
}
