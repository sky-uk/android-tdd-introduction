package com.example.tweedm.topalbums.dto;

public class AlbumDto {

    private String imageUrl;
    private String label;

    public AlbumDto(String imageUrl, String label) {
        this.imageUrl = imageUrl;
        this.label = label;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLabel() {
        return label;
    }
}