package com.softsquared.letslistenbymakeus.src.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.softsquared.letslistenbymakeus.MainActivity;
import com.softsquared.letslistenbymakeus.R;
import com.softsquared.letslistenbymakeus.src.BaseActivity;
import com.softsquared.letslistenbymakeus.src.lobby.lobby;

public class start extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Handler hd = new Handler();


        hd.postDelayed(new splashhandler(), 3000); // 1초 후에 hd handler 실행  3000ms = 3초




        ImageView mainlogo = (ImageView) findViewById(R.id.mainlogo);
        Glide.with(getBaseContext()).load(R.drawable.ic_launcher_background).into(mainlogo);
    }

    private class splashhandler implements Runnable{
        public void run(){

            startActivity(new Intent(getApplication(), lobby.class)); //로딩이 끝난 후, ChoiceFunction 이동
            start.this.finish(); // 로딩페이지 Activity stack에서 제거
        }


    }


    @Override
    protected void onPause() {
        super.onPause();

        //액티비티 종료시 애니메이션 주지 말기 .
    }

}
