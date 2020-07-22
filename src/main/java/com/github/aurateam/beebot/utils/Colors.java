package com.github.aurateam.beebot.utils;

import java.awt.*;

public enum Colors {
    GENERAL(Color.decode("#FED667"));

    private final Color color;

    Colors(Color color) {
        this.color = color;
    }

    public Color get() {
        return color;
    }
}
