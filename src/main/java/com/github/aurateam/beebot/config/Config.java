package com.github.aurateam.beebot.config;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import ch.jalu.configme.properties.Property;
import ch.jalu.configme.resource.YamlFileResourceOptions;

import java.io.File;

public class Config {
    private final SettingsManager config = SettingsManagerBuilder
            .withYamlFile(new File("./bee-config.yml"), YamlFileResourceOptions.builder().indentationSize(2).build())
            .useDefaultMigrationService()
            .configurationData(Settings.class)
            .create();

    public <T> T get(Property<T> property) {
        return config.getProperty(property);
    }
}
