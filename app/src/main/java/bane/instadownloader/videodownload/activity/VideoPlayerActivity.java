package bane.instadownloader.videodownload.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import bane.instadownloader.videodownload.R;

public class VideoPlayerActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_video_player);
        setStatusBar();
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String stringExtra = getIntent().getStringExtra("PathVideo");
        ((ImageView) findViewById(R.id.imBack)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                VideoPlayerActivity.this.onBackPressed();
            }
        });
        try {
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            Uri parse = Uri.parse(stringExtra);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(parse);
            videoView.start();
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer mediaPlayer) {
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                public void onCompletion(MediaPlayer mediaPlayer) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setStatusBar() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        } else if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        } else {
            window.clearFlags(0);
        }
    }

}
