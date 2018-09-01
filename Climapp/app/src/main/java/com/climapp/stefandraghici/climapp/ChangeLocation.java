package com.climapp.stefandraghici.climapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeLocation extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_location);

        final EditText editText=(EditText) findViewById(R.id.queryET);
        ImageButton backButton=(ImageButton) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                String newLocation=editText.getText().toString();
                Intent intent=new Intent(ChangeLocation.this, MainActivity.class);
                intent.putExtra("location", newLocation);
                startActivity(intent);
                return false;
            }
        });
    }
}
