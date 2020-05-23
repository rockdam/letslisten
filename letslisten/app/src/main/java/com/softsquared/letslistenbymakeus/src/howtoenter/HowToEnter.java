package com.softsquared.letslistenbymakeus.src.howtoenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.softsquared.letslistenbymakeus.R;
import com.softsquared.letslistenbymakeus.src.BaseActivity;
import com.softsquared.letslistenbymakeus.src.howtoenter.guest.RoomCode;
import com.softsquared.letslistenbymakeus.src.howtoenter.host.playlist.PlayList;

public class HowToEnter extends BaseActivity {

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
                startActivity(new Intent(getApplication(), PlayList.class)); //로딩이 끝난 후, ChoiceFunction 이동
                HowToEnter.this.finish(); // 로딩페이지 Activity stack에서 제거
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), RoomCode.class)); //로딩이 끝난 후, ChoiceFunction 이동
            }
        });
    }
}
