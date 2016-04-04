package com.example.tweedm.topalbums;

import com.example.tweedm.topalbums.dto.AlbumDto;
import com.example.tweedm.topalbums.network.ITopAlbumsService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    private MainActivityPresenter presenter;

    @Mock
    private MainActivityView view;

    @Mock
    private ITopAlbumsService topAlbumsService;

    @Before
    public void setUp() {
        presenter = new MainActivityPresenter(view, topAlbumsService);
    }

    @Test
    public void whenRequestAlbumsCalledShouldPerformCorrectly() {

        //given
        List<AlbumDto> testDtoList = Collections.singletonList(new AlbumDto("testImageUrl", "testLabel"));
        ArgumentCaptor<ITopAlbumsService.Callback> callbackArgumentCaptor = ArgumentCaptor.forClass(ITopAlbumsService.Callback.class);

        //when
        presenter.requestAlbumsClicked();

        //then
        Mockito.verify(view).showProgressDialog();
        Mockito.verify(topAlbumsService).requestAlbums(callbackArgumentCaptor.capture());

        callbackArgumentCaptor.getValue().success(testDtoList);

        Mockito.verify(view).hideProgressDialog();
        Mockito.verify(view).displayAlbums(testDtoList);
    }

    @Test
    public void whenRequestAlbumsCalledAndNetworkCallFails() {

        //given
        ArgumentCaptor<ITopAlbumsService.Callback> callbackArgumentCaptor = ArgumentCaptor.forClass(ITopAlbumsService.Callback.class);

        //when
        presenter.requestAlbumsClicked();

        //then
        Mockito.verify(view).showProgressDialog();
        Mockito.verify(topAlbumsService).requestAlbums(callbackArgumentCaptor.capture());

        callbackArgumentCaptor.getValue().failure();

        Mockito.verify(view).hideProgressDialog();
        Mockito.verify(view).showErrorMessage();
    }
}