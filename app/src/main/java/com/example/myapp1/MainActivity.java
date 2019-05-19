package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String EXTRA_MESSAGE;
    private Button mybtn;
    private TextView text_View;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybtn=new Button(this);
        text_View=new TextView(this);
        mybtn=(Button)findViewById(R.id.button1);
        text_View=(TextView)findViewById(R.id.result1);

        mybtn.setOnClickListener(this);


    }
    String ops(String message){
        char sign;
        int i=0;
        String lefthand="";
        int lefthandi;
        String righthand="";
        int righthandi;
        double result=0.0;
        String ret="";
        while(message.charAt(i)!='+' || message.charAt(i)!='*'|| message.charAt(i)!='/' || message.charAt(i)!='-'){
            lefthand+=message.charAt(i);
            i++;
        }
        sign=message.charAt(i);
        i++;
        lefthandi=Integer.parseInt(lefthand);
        while(i<message.length()){
            righthand+=message.charAt(i);
            i++;
        }
        righthandi=Integer.parseInt(righthand);

        if(sign=='+'){
            result=lefthandi+righthandi;
        }
        if(sign=='-'){
            result=lefthandi-righthandi;
        }
        if(sign=='*'){
            result=lefthandi*righthandi;
        }
        if(sign=='/'){
            result=lefthandi/righthandi;
        }
        ret+=result;
        return ret;
    }

    @Override
    public void onClick(View v) {
        input=(EditText)findViewById(R.id.editText);
        String ret=ops(input.getText().toString());
        text_View.setText(ret);
    }
}
