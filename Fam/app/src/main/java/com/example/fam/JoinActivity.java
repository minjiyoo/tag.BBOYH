package com.example.fam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JoinActivity extends AppCompatActivity {

    Button btn_make_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        btn_make_account = (Button)findViewById(R.id.button_makeaccount);
        btn_make_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JoinActivity.this, LoginActivity.class));
            }
        });

    }

}
