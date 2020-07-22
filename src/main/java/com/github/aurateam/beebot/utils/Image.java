package com.github.aurateam.beebot.utils;

public enum Image {
    PAPER_LOGO("https://i.imgur.com/S3Xb769.png", "https://avatars2.githubusercontent.com/u/7608950?s=200&v=4"),
    SPIGOT_LOGO("https://i.imgur.com/zM37iBu.png", "https://static.spigotmc.org/img/spigot.png");

    private final String url;
    private final String originalUrl;

    Image(String url, String originalUrl) {
        this.url = url;
        this.originalUrl = originalUrl;
    }

    public String get() {
        return url;
    }

    public String getOriginal() {
        return originalUrl;
    }
}
