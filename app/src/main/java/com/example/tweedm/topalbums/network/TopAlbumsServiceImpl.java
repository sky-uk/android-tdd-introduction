package com.example.tweedm.topalbums.network;

import com.example.tweedm.topalbums.dto.AlbumDto;

import java.util.Arrays;

public class TopAlbumsServiceImpl implements ITopAlbumsService {
    @Override
    public void requestAlbums(Callback callback) {
        callback.success(Arrays.asList(new AlbumDto("testImage", "testLabel")));
    }
}