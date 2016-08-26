package com.example.fam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class LoginActivity extends Activity {

    Button btn_login, btn_join;

    Socket mSocket;
    {
        try {
 //           mSocket = IO.socket("http://chat.socket.io");
            mSocket = IO.socket("http://10.0.2.2:3000");
        } catch (URISyntaxException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSocket.connect();

        btn_join = (Button)findViewById(R.id.button_login_join);
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, JoinActivity.class));
            }
        });

        btn_login = (Button)findViewById(R.id.button_login_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }
}
