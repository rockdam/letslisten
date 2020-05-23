package com.softsquared.letslistenbymakeus.src.howtoenter.host.setbackgroundmusic.roomname;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softsquared.letslistenbymakeus.R;
import com.softsquared.letslistenbymakeus.src.BaseActivity;
import com.softsquared.letslistenbymakeus.src.howtoenter.host.setbackgroundmusic.setBackgroundMusic;
import com.softsquared.letslistenbymakeus.src.howtoenter.room.roomActivity;

public class RoomName extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_name);
        TextView completeRoomName;
        completeRoomName=findViewById(R.id.complete_room_name);
        completeRoomName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), roomActivity.class)); //로딩이 끝난 후, ChoiceFunction 이동
                RoomName.this.finish(); // 로딩페이지 Activity stack에서 제거


            }
        });
    }
}
