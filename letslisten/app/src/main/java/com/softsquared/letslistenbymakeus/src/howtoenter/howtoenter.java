package com.softsquared.letslistenbymakeus.src.howtoenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.softsquared.letslistenbymakeus.R;

public class howtoenter extends AppCompatActivity {

    ImageView host,guest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtoenter);
        host=findViewById(R.id.host);
        guest=findViewById(R.id.guest);

        host.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
