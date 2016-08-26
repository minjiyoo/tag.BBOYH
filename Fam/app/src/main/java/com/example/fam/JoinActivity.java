package com.example.fam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


public class JoinActivity extends Activity {

    Button btn_make_account;

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
        setContentView(R.layout.activity_join);


        btn_make_account = (Button)findViewById(R.id.button_join_makeaccount);
        btn_make_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                attemptSend();
            }
        });


    }


    private void attemptSend() {

        EditText editText_personName = (EditText)findViewById(R.id.editText_join_personname);
        EditText editText_phoneNum = (EditText)findViewById(R.id.editText_join_phoneNum);
        EditText editText_email = (EditText)findViewById(R.id.editText_join_email);
        EditText editText_password = (EditText)findViewById(R.id.editText_join_password);

        String[] message = new String[4];

        message[0] = editText_personName.getText().toString();
        message[1] = editText_phoneNum.getText().toString();
        message[2] = editText_email.getText().toString();
        message[3] = editText_password.getText().toString();

        if (TextUtils.isEmpty(message[0])||TextUtils.isEmpty(message[1])||TextUtils.isEmpty(message[2])||TextUtils.isEmpty(message[3])) {
            return;
        }

        editText_personName.setText("");
        editText_phoneNum.setText("");
        editText_email.setText("");
        editText_password.setText("");
        mSocket.emit("joinMember", message[2],message[3],message[0],message[1]);

    }

}
