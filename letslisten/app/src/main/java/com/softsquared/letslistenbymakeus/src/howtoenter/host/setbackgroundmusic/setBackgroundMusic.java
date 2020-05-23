package com.softsquared.letslistenbymakeus.src.howtoenter.host.setbackgroundmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softsquared.letslistenbymakeus.R;
import com.softsquared.letslistenbymakeus.src.BaseActivity;
import com.softsquared.letslistenbymakeus.src.howtoenter.host.playlist.PlayList;
import com.softsquared.letslistenbymakeus.src.howtoenter.host.setbackgroundmusic.roomname.RoomName;

public class setBackgroundMusic extends BaseActivity {


    TextView complete_backgroundmusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_background_musci);
        complete_backgroundmusic=findViewById(R.id.complete_backgroundmusic);
        complete_backgroundmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), RoomName.class)); //로딩이 끝난 후, ChoiceFunction 이동
                setBackgroundMusic.this.finish(); // 로딩페이지 Activity stack에서 제거


            }
        });
    }
}
