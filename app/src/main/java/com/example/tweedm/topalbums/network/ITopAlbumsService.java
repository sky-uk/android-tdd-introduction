package com.example.tweedm.topalbums.network;

import com.example.tweedm.topalbums.dto.AlbumDto;

import java.util.List;

public interface ITopAlbumsService {

    void requestAlbums(Callback callback);

    interface Callback {
        void success(List<AlbumDto> albums);

        void failure();
    }
}