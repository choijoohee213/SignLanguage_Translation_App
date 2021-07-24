package com.kut.with.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kut.with.R;

import javax.annotation.Nullable;

public class VideoPlayerActivity extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private VideoView videoView;
    private MediaController mediaController;
    private ProgressDialog customProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        //로딩창 객체 생성
        customProgressDialog = new ProgressDialog(this);
        //로딩창을 투명하게
        customProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //출력된 단어 중 선택된 단어 텍스트 표시
        Intent intent = getIntent();
        TextView text = findViewById(R.id.video_name);
        String word = intent.getStringExtra("name").replace("ㆍ ","");

        if(word != null)
            text.setText("인식된 문자 : " + word);

        videoView = findViewById(R.id.video_view);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();

        customProgressDialog.show();

        //파이어베이스에서 영상 링크 가져오기
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference().child("SignLanguage").addValueEventListener(new ValueEventListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){

                    //해당 단어가 파이어베이스 목록에 있다면
                    if(ds.child("word").getValue(String.class).equals(word)) {
                        //비디오 설정,재생
                        Uri uri = Uri.parse(ds.child("video").getValue(String.class));
                        videoView.setVideoURI(uri);

                        //터치 시 영상 정지, 시작 처리
                        videoView.setOnTouchListener(new View.OnTouchListener() {
                            @SuppressLint("ClickableViewAccessibility")
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                if(videoView.isPlaying()){
                                    videoView.pause();
                                    return false;
                                }
                                else{
                                    videoView.start();
                                    return false;
                                }
                            }
                        });

                        // 동영상이 재생준비가 완료되었을 때를 알수있는 리스너
                        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            // 동영상 재생준비가 완료된후 호출되는 메서드
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                customProgressDialog.dismiss();
                            }
                        });

                        videoView.start();
                        return;
                    }
                }
                Toast.makeText(VideoPlayerActivity.this, "데이터 없음...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}