package com.atomath.final887330app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private static final String TITLE = "title";
    private static final String DESC = "directed";
    private static final String PIC = "picture_link";
    private String title;
    private String direct;
    private String image_link;
    private String desc;
    private TextView txt_title;
    private TextView txt_direct;
    private ImageView img_link;
    private TextView txt_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        readInboundIntent();
        bindWidget();
        setPage();
    }
    private void readInboundIntent() {
        title = getIntent().getStringExtra(TITLE);
        direct = getIntent().getStringExtra(DESC);
        image_link = getIntent().getStringExtra(PIC);
        desc = getIntent().getStringExtra("desc");

        //Toast.makeText(DetailActivity.this, "ID : " + youtubeID, Toast.LENGTH_SHORT).show();

    }

    private void bindWidget() {
        txt_title = (TextView) findViewById(R.id.txtNameMovie);
        txt_direct = (TextView) findViewById(R.id.txtNameDirector);
        img_link = (ImageView) findViewById(R.id.imgPoster);
        txt_desc = (TextView) findViewById(R.id.txtTrailer);


    }
    private void setPage() {
        txt_title.setText(title);
        txt_direct.setText(direct);
        Glide.with(getApplicationContext()).load(image_link).into(img_link);
        txt_desc.setText(desc);

    }
}
