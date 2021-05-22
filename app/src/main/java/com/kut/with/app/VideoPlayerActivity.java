package com.kut.with.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.kut.with.R;

import javax.annotation.Nullable;

public class VideoPlayerActivity extends AppCompatActivity {
    public static final int REQUEST_TEST = 1;
    protected VideoView videoView;
    protected MediaController mediaController;
    protected String videoHighschool = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EA%B3%A0%EB%93%B1%ED%95%99%EA%B5%90.mp4?alt=media&token=fa29adb8-894d-47c4-a231-834aa74cca31";
    protected String videobakery = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EB%B9%B5%EC%A7%91.mp4?alt=media&token=fc829bf7-a32f-4f1d-8d1f-924765bff352";
    protected String videocafe = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EC%B9%B4%ED%8E%98.mp4?alt=media&token=548a858f-0a11-45f6-b1da-ebd0a92e1843";
    protected String videoelemetary_school = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EC%B4%88%EB%93%B1%ED%95%99%EA%B5%90.mp4?alt=media&token=352f3738-c631-4a80-a015-d10766dd6a4a";
    protected String videohospital = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EB%B3%91%EC%9B%90%2C%EC%9D%98%EC%9B%90.mp4?alt=media&token=58d840f9-e6cb-426a-8539-65d029c9148b";
    protected String videoman = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EB%82%A8%EC%9E%90%2C%EB%82%A8%EC%84%B1.mp4?alt=media&token=4fd30a81-fb28-481c-8fd3-b5a48a7fc6bb";
    protected String videomiddle_shcool = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EC%A4%91%ED%95%99%EA%B5%90.mp4?alt=media&token=69d96045-8311-4916-ad03-c48e182f34a7";
    protected String videopostoffice = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EC%9A%B0%EC%B2%B4%EA%B5%AD.mp4?alt=media&token=8ec3018f-18fa-43de-b9a0-4eb297464384";
    protected String videorestarunt = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EC%8B%9D%EB%8B%B9%2C%EC%9D%8C%EC%8B%9D%EC%A0%90.mp4?alt=media&token=25d08b1b-1cc0-4912-a0ca-675a746d7ad1";
    protected String videouniversity = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EB%8C%80%ED%95%99%EA%B5%90.mp4?alt=media&token=33689c79-c89d-4343-b263-2e8cebc3133a";
    protected String videowoman = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%EC%97%AC%EC%9E%90%2C%EC%97%AC%EC%84%B1.mp4?alt=media&token=b6853552-a6da-46b2-83d9-ab3dd5402732";
    protected String videobathroom = "https://firebasestorage.googleapis.com/v0/b/my-database-837d5.appspot.com/o/%ED%99%94%EC%9E%A5%EC%8B%A4.mp4?alt=media&token=ef65e923-4c2e-449f-b23d-f95dda788abf";
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        Intent intent = getIntent();
        TextView text = (TextView)findViewById(R.id.image_name);
        String name = intent.getStringExtra("name");
            if(name != null) {
                text.setText(name);
            }
        videoView = findViewById(R.id.videoview);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri highschool = Uri.parse(videoHighschool);
        Uri bakery = Uri.parse(videobakery);
        Uri cafe = Uri.parse(videocafe);
        Uri elemetary_school = Uri.parse(videoelemetary_school);
        Uri hospital = Uri.parse(videohospital);
        Uri man = Uri.parse(videoman);
        Uri middle_shcool = Uri.parse(videomiddle_shcool);
        Uri postoffice = Uri.parse(videopostoffice);
        Uri restarunt = Uri.parse(videorestarunt);
        Uri university = Uri.parse(videouniversity);
        Uri woman = Uri.parse(videowoman);
        Uri bathroom = Uri.parse(videobathroom);

        if(name.contains("고등학교")){
            videoView.setVideoURI(highschool);
        }
        else if(name.contains("빵집")){
            videoView.setVideoURI(bakery);
        }
        else if(name.contains("카페")){
            videoView.setVideoURI(cafe);
        }

        else if(name.contains("초등학교")){
            videoView.setVideoURI(elemetary_school);
        }

        else if(name.contains("병원") || name.contains("의원")){
            videoView.setVideoURI(hospital);
        }

        else if(name.contains("남성") || name.contains("남자")){
            videoView.setVideoURI(man);
        }

        else if(name.contains("중학교")){
            videoView.setVideoURI(middle_shcool);
        }

        else if(name.contains("우체국")){
            videoView.setVideoURI(postoffice);
        }

        else if(name.contains("음식점") || name.contains("식당")){
            videoView.setVideoURI(restarunt);
        }

        else if(name.contains("대학교")){
            videoView.setVideoURI(university);
        }
        else if(name.contains("여성") || name.contains("여자")){
            videoView.setVideoURI(woman);

        }
        else if(name.contains("화장실")){
            videoView.setVideoURI(bathroom);
        }
        videoView.setMediaController(mediaController);
        videoView.start();

    }

}