package com.kut.with.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kut.with.R;

import javax.annotation.Nullable;

public class VideoPlayerActivity extends AppCompatActivity {
    public static final int REQUEST_TEST = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Intent intent = getIntent();
        TextView text = (TextView)findViewById(R.id.image_name);
        String name = intent.getStringExtra("name");
        if(name != null)
            text.setText(name);
    }

}