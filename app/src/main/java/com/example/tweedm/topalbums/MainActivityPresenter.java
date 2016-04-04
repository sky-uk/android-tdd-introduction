package com.example.tweedm.topalbums;

import com.example.tweedm.topalbums.dto.AlbumDto;
import com.example.tweedm.topalbums.network.ITopAlbumsService;

import java.util.List;

public class MainActivityPresenter {

    private MainActivityView view;
    private ITopAlbumsService service;

    public MainActivityPresenter(MainActivityView view, ITopAlbumsService service) {

        this.view = view;
        this.service = service;
    }

    public void requestAlbumsClicked() {

        view.showProgressDialog();
        service.requestAlbums(new ITopAlbumsService.Callback() {
            @Override
            public void success(List<AlbumDto> albums) {

                view.hideProgressDialog();
                view.displayAlbums(albums);
            }

            @Override
            public void failure() {

                view.hideProgressDialog();
                view.showErrorMessage();
            }
        });
    }
}