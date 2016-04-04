package com.example.tweedm.topalbums;

import com.example.tweedm.topalbums.dto.AlbumDto;

import java.util.List;

public interface MainActivityView {
    void showProgressDialog();

    void hideProgressDialog();

    void displayAlbums(List<AlbumDto> albums);

    void showErrorMessage();
}
