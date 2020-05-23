package com.softsquared.letslistenbymakeus.src.lobby;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softsquared.letslistenbymakeus.R;
import com.softsquared.letslistenbymakeus.src.BaseActivity;
import com.softsquared.letslistenbymakeus.src.inputnickname.inputnickname;
import com.softsquared.letslistenbymakeus.src.start.start;

public class lobby extends BaseActivity {

    TextView mNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        mNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), inputnickname.class)); //로딩이 끝난 후, ChoiceFunction 이동
                lobby.this.finish(); // 로딩페이지 Activity stack에서 제거

            }
        });
    }
}
