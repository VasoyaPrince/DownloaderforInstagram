package bane.instadownloader.videodownload.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import bane.instadownloader.videodownload.R;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {
    SplashScreen activity;
    Context context;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash_screen);
        this.activity = this;
        this.context = this;


        new Handler().postDelayed(() -> SplashScreen.this.startActivity(new Intent(SplashScreen.this, MainActivity.class)), 2500);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.activity = this;
    }
}
