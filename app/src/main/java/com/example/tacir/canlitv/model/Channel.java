package com.example.tacir.canlitv.model;

public class Channel {
    private String title;
    private String description;
    private String channelTitle;
    private String thumbnail;
    private String videoId;

    public Channel(String title, String description, String channelTitle, String thumbnail, String videoId) {
        this.title = title;
        this.description = description;
        this.channelTitle = channelTitle;
        this.thumbnail = thumbnail;
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "Kanal{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", channelTitle='" + channelTitle + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", videoId='" + videoId + '\'' +
                '}';
    }
}
