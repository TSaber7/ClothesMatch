package com.example.a74104.clothesmatch;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


class SquareMessageAdapter extends RecyclerView.Adapter<SquareMessageAdapter.ViewHolder>
{
    private static final String TAG="SquareMessageAdapter";
    private List<SquareMessage> MessageList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Image;
        TextView UserName;
        TextView Text;
        public ViewHolder(View view){
            super(view);
            UserName = view.findViewById(R.id.UserName);
            Text = view.findViewById(R.id.Text);
        }
    }
    public SquareMessageAdapter( List<SquareMessage> messageList) {
        MessageList=messageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.square_message,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        SquareMessage message = MessageList.get(position);
        holder.UserName.setText(message.getUserName());
        holder.Text.setText(message.getText());
    }

    @Override
    public int getItemCount() {
        return MessageList.size();
    }
}

public class Square extends AppCompatActivity {
    private List<SquareMessage> messageList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
        initMessages();
        RecyclerView recyclerView = findViewById(R.id.ShowSquareMessage);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SquareMessageAdapter adapter = new SquareMessageAdapter(messageList);
        recyclerView.setAdapter(adapter);
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
