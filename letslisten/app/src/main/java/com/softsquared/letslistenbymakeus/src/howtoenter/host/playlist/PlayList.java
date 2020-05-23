package com.softsquared.letslistenbymakeus.src.howtoenter.host.playlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.softsquared.letslistenbymakeus.R;
import com.softsquared.letslistenbymakeus.src.BaseActivity;
import com.softsquared.letslistenbymakeus.src.howtoenter.HowToEnter;
import com.softsquared.letslistenbymakeus.src.howtoenter.host.setbackgroundmusic.roomname.RoomName;

public class PlayList extends BaseActivity {

    TextView submitPlaylistOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_playlist);
        submitPlaylistOne=findViewById(R.id.submit_playlist);
        submitPlaylistOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), RoomName.class)); //로딩이 끝난 후, ChoiceFunction 이동
                PlayList.this.finish(); // 로딩페이지 Activity stack에서 제거
            }
        });

    }


    
}
