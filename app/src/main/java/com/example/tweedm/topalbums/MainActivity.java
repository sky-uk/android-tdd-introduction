package com.example.tweedm.topalbums;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tweedm.topalbums.dto.AlbumDto;
import com.example.tweedm.topalbums.network.TopAlbumsServiceImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private TextView requestAlbumsTextView;

    private MainActivityPresenter presenter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this, new TopAlbumsServiceImpl());

        requestAlbumsTextView = (TextView) findViewById(R.id.request_albums);

        requestAlbumsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestAlbumsClicked();
            }
        });
    }

    @Override
    public void showProgressDialog() {
        progressDialog = ProgressDialog.show(this, null, getResources().getString(R.string.loading), true);
    }

    @Override
    public void displayAlbums(List<AlbumDto> albumDtoList) {
        for (AlbumDto dto : albumDtoList) {
            Toast.makeText(this, dto.getLabel(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
    }
}