package com.example.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editinput=findViewById(R.id.input);
    }
    public void startService(View v){
        String input= editinput.getText().toString();

        Intent serviceIntent = new Intent(this,Myservice.class);
        serviceIntent.putExtra("inputExtra",input); //to send our input to the service

        ContextCompat.startForegroundService(this,serviceIntent);
    }
    public void stopService(View v) {
        Intent serviceIntent = new Intent(this,Myservice.class);
        stopService(serviceIntent);

    }
}