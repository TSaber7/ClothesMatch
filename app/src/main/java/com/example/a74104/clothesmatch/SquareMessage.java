package com.example.a74104.clothesmatch;

import android.widget.Toast;

/**
 * Created by 74104 on 2019/4/14.
 */

public class SquareMessage {
    private String UserName;
    /*用于展示服装搭配的数据*/
    private String Text;
    public SquareMessage(String UserName, String Text)
    {
        this.UserName=UserName;
        this.Text=Text;
    }

    public String getUserName() {
        return UserName;
    }

    public String getText() {
        return Text;
    }
}
