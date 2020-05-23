package com.softsquared.letslistenbymakeus.src.inputnickname;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.softsquared.letslistenbymakeus.R;
import com.softsquared.letslistenbymakeus.src.BaseActivity;
import com.softsquared.letslistenbymakeus.src.howtoenter.HowToEnter;

public class InputnickName extends BaseActivity {

    TextView completeNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputnickname);
        completeNickname=findViewById(R.id.complete_set_nickname);
        completeNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), HowToEnter.class)); //로딩이 끝난 후, ChoiceFunction 이동
                InputnickName.this.finish(); // 로딩페이지 Activity stack에서 제거

            }
        });
    }
}
