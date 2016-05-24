package com.atomath.final887330app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class welcomeActivity extends AppCompatActivity {

    private Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        bindWidget();
        setWidgetEventListener();


    }
    private void bindWidget() {
        btnHome = (Button) findViewById(R.id.btnHome);


    }
    private void setWidgetEventListener() {

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TabActivity.class);

                startActivity(i);
                // ส่งค่าไปหน้าอื่น
            }
        });

    }
}
