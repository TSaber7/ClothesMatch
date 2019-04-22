package com.example.a74104.clothesmatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditSquareMessage extends AppCompatActivity {
    private static final String TAG = "EditSquareMessage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_square_message);
        //获取搭配数据
        Suit TestSuit = (Suit) getIntent().getSerializableExtra("TestData");
        Log.d(TAG, "onCreate: "+TestSuit.data);
        //发送消息到广场
        Button send = findViewById(R.id.Send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                //将广场消息发送给服务器
                SquareMessage squareMessage=new SquareMessage("TestUser",editText.getText().toString());
                Log.d(TAG, "onClick: "+squareMessage.getText());
                //返回搭配界面
                Intent intent = new Intent(EditSquareMessage.this, Match.class);
                startActivity(intent);
            }
        });
    }
}
