package bane.instadownloader.videodownload;

import android.app.Application;
import com.google.firebase.messaging.FirebaseMessaging;


public class MyApplication extends Application {
    public static MyApplication application;


    public MyApplication() {
        application = this;
    }

    public static synchronized MyApplication getInstance() {
        return application;
    }

    public static MyApplication getApp() {
        if (application == null) {
            application = new MyApplication();
        }
        return application;
    }

    public void onCreate() {
        super.onCreate();
        application = this;
        FirebaseMessaging.getInstance().subscribeToTopic("all");

    }
}
