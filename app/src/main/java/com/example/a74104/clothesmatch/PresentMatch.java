package com.example.a74104.clothesmatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;





public class PresentMatch extends AppCompatActivity {
    private static final String TAG = "PresentMatch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_match);
        Button match=findViewById(R.id.Match);
        Button square=findViewById(R.id.Square);
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PresentMatch.this,Match.class);
                startActivity(intent);
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PresentMatch.this,Square.class);
                startActivity(intent);
            }
        });
        //获取测试搭配数据
        Suit TestSuit = (Suit) getIntent().getSerializableExtra("TestData");
        Log.i(TAG,TestSuit.data);
        //将搭配发送到广场之前，进入编辑界面
        Button sendToSquare = findViewById(R.id.SendToSquare);
        sendToSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PresentMatch.this, EditSquareMessage.class);
                Suit TestSuit = (Suit) getIntent().getSerializableExtra("TestData");
                intent.putExtra("TestData",TestSuit);
                startActivity(intent);
            }
        });

    }
}
