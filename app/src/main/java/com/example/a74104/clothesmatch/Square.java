package com.example.a74104.clothesmatch;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


class SquareMessageAdapter extends ArrayAdapter<SquareMessage>
{
    private static final String TAG="SquareMessageAdapter";
    private int resourceId;
    public SquareMessageAdapter(@NonNull Context context, int resource, List<SquareMessage> messageList) {
        super(context, resource,messageList);
        resourceId=resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Log.d(TAG, "getView: called");
        SquareMessage message = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView UserName = view.findViewById(R.id.UserName);
        TextView Text = view.findViewById(R.id.Text);
        UserName.setText(message.getUserName());
        Log.d(TAG, "getView: "+message.getUserName());
        Text.setText(message.getText());
        return view;
    }
}

public class Square extends AppCompatActivity {
    private List<SquareMessage> messageList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
        initMessages();
        SquareMessageAdapter adapter = new SquareMessageAdapter(Square.this, R.layout.square_message, messageList);
        ListView listView = findViewById(R.id.SquareMessage);
        listView.setAdapter(adapter);

        Button match=findViewById(R.id.Match);
        Button square=findViewById(R.id.Square);
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Square.this,Match.class);
                startActivity(intent);
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Square.this,Square.class);
                startActivity(intent);
            }
        });
    }
    private void initMessages()
    {
        /*获取广场信息数据*/
        for(int i=0;i<10;i++)
        {
            SquareMessage message=new SquareMessage("TSaber7","just for test");
            messageList.add(message);
        }
    }
}
