package com.example.a74104.clothesmatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StyleChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_choose);
        Button startMatch = findViewById(R.id.StartMatch);
        startMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* 获取搭配数据，存入suit类 */
                Suit TestSuit=new Suit();
                TestSuit.data="This is data from suit";
                Intent intent=new Intent(StyleChoose.this,PresentMatch.class);
                intent.putExtra("TestData",TestSuit);
                startActivity(intent);
            }
        });
        Button match=findViewById(R.id.Match);
        Button square=findViewById(R.id.Square);
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StyleChoose.this,Match.class);
                startActivity(intent);
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StyleChoose.this,Square.class);
                startActivity(intent);
            }
        });
    }
}
