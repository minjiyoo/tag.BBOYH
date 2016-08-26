package com.example.fam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TalkActivity extends AppCompatActivity {

    Button btn_board,btn_calendar,btn_home,btn_set,btn_talk,btn_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);


        btn_board = (Button)findViewById(R.id.button_talk_board);
        btn_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TalkActivity.this, BoardActivity.class));
            }
        });

        btn_calendar = (Button)findViewById(R.id.button_talk_calendar);
        btn_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TalkActivity.this, CalendarActivity.class));
            }
        });

        btn_account = (Button)findViewById(R.id.button_talk_account);
        btn_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TalkActivity.this, AccountBookActivity.class));
            }
        });
/**
 btn_set = (Button)findViewById(R.id.button_talk_setting);
 btn_set.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
startActivity(new Intent(MainActivity.this, .class));
}
});

 */

        btn_home = (Button)findViewById(R.id.button_talk_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TalkActivity.this, MainActivity.class));
            }
        });

        btn_talk = (Button)findViewById(R.id.button_talk_chat);
        btn_talk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TalkActivity.this, TalkActivity.class));
            }
        });
    }
}
