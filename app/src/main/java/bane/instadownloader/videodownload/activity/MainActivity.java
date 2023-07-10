package bane.instadownloader.videodownload.activity;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.util.ClipboardListener;
import bane.instadownloader.videodownload.util.Utils;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String CopyKey = "";
    String CopyValue = "";
    MainActivity activity;
    boolean doubleBackToExitPressedOnce = false;
    String[] permissions = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
    LinearLayout bannerContainer;
    ImageView downloaded;
    LinearLayout linearLayout;
    RelativeLayout main;
    LinearLayout mainlin;
    ImageView rateapp;
    ImageView reels;
    CardView rvGallery;
    CardView rvInsta;
    RelativeLayout rvRateApp;
    RelativeLayout rvShareApp;
    RelativeLayout rvPremiumPlan;
    ImageView shareimage;
    TextView textrate;
    RelativeLayout toolbar;
    private ClipboardManager clipBoard;

    public static String extractLinks(String str) {
        Matcher matcher = Patterns.WEB_URL.matcher(str);
        if (!matcher.find()) {
            return "";
        }
        String group = matcher.group();
        Log.d("New URL", "URL extracted: " + group);
        return group;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.activity = this;
        setStatusBar();


        bannerContainer = findViewById(R.id.banner_container);
        downloaded = findViewById(R.id.downloaded);
        linearLayout = findViewById(R.id.linearLayout);
        main = findViewById(R.id.main);
        mainlin = findViewById(R.id.mainlin);
        rateapp = findViewById(R.id.rateapp);
        reels = findViewById(R.id.reels);
        rvGallery = findViewById(R.id.rvGallery);
        rvInsta = findViewById(R.id.rvInsta);
        rvRateApp = findViewById(R.id.rvRateApp);
        rvShareApp = findViewById(R.id.rvShareApp);
        rvPremiumPlan = findViewById(R.id.rvPremiumPlan);
        shareimage = findViewById(R.id.shareimage);
        textrate = findViewById(R.id.textrate);
        toolbar = findViewById(R.id.toolbar);


        initViews();

    }

    @Override
    public void onResume() {
        super.onResume();
        this.activity = this;
        this.clipBoard = (ClipboardManager) getSystemService("clipboard");
    }

    public void initViews() {
        this.clipBoard = (ClipboardManager) this.activity.getSystemService("clipboard");
        if (this.activity.getIntent().getExtras() != null) {
            for (String str : this.activity.getIntent().getExtras().keySet()) {
                this.CopyKey = str;
                String string = this.activity.getIntent().getExtras().getString(this.CopyKey);
                if (this.CopyKey.equals("android.intent.extra.TEXT")) {
                    this.CopyValue = this.activity.getIntent().getExtras().getString(this.CopyKey);
                    callText(string);
                } else {
                    this.CopyValue = "";
                    callText(string);
                }
            }
        }
        ClipboardManager clipboardManager = this.clipBoard;
        if (clipboardManager != null) {
            clipboardManager.addPrimaryClipChangedListener(new ClipboardListener() {
                /* class bane.instadownloader.videodownload.activity.MainActivity.AnonymousClass2 */

                public void onPrimaryClipChanged() {
                    try {
                        MainActivity mainActivity = MainActivity.this;
                        CharSequence text = mainActivity.clipBoard.getPrimaryClip().getItemAt(0).getText();
                        Objects.requireNonNull(text);
                        mainActivity.showNotification(text.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (Build.VERSION.SDK_INT >= 23) {
            checkPermissions(0);
        }
        this.rvInsta.setOnClickListener(this);
        this.rvGallery.setOnClickListener(this);
        this.rvShareApp.setOnClickListener(this);
        this.rvPremiumPlan.setOnClickListener(this);
        this.rvRateApp.setOnClickListener(this);

        Utils.createFileFolder();
    }

    private void callText(String str) {
        try {
            if (!str.contains("instagram.com")) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                checkPermissions(101);
            } else {
                callInstaActivity();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rvGallery:
                if (Build.VERSION.SDK_INT >= 23) {
                    checkPermissions(105);
                    return;
                } else {
                    callGalleryActivity();
                    return;
                }
            case R.id.rvInsta:
                if (Build.VERSION.SDK_INT >= 23) {
                    checkPermissions(101);
                    return;
                } else {
                    callInstaActivity();
                    return;
                }
            case R.id.rvRateApp:
                Utils.RateApp(this.activity);
                return;
            case R.id.rvRateApp2:
            default:
                return;
            case R.id.rvShareApp:
                Utils.ShareApp(this.activity);
                return;
        }
    }

    public void callInstaActivity() {
        Intent intent = new Intent(this.activity, InstagramActivity.class);
        intent.putExtra("CopyIntent", this.CopyValue);
        startActivity(intent);
    }

    public void callWhatsappActivity() {
        startActivity(new Intent(this.activity, WhatsappActivity.class));
    }

    public void callGalleryActivity() {
        startActivity(new Intent(this.activity, GalleryActivity.class));
    }

    public void showNotification(String str) {
        if (str.contains("instagram.com")) {
            Intent intent = new Intent(this.activity, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("Notification", str);
            PendingIntent activity2 = PendingIntent.getActivity(this.activity, 0, intent, PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_IMMUTABLE);
            NotificationManager notificationManager = (NotificationManager) this.activity.getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(getResources().getString(R.string.app_name), getResources().getString(R.string.app_name), 4);
                notificationChannel.enableLights(true);
                notificationChannel.setLockscreenVisibility(1);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(1, new NotificationCompat.Builder(this.activity, getResources().getString(R.string.app_name)).setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher_foreground).setColor(getResources().getColor(R.color.black)).setLargeIcon(BitmapFactory.decodeResource(this.activity.getResources(), R.mipmap.ic_launcher_foreground)).setDefaults(-1).setPriority(1).setContentTitle("Copied text").setContentText(str).setChannelId(getResources().getString(R.string.app_name)).setFullScreenIntent(activity2, true).build());
        }
    }

    private boolean checkPermissions(int i) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = this.permissions;
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(this.activity, str) != 0) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            ActivityCompat.requestPermissions(this.activity, (String[]) arrayList.toArray(new String[arrayList.size()]), i);
            return false;
        } else if (i == 101) {
            callInstaActivity();
            return true;
        } else if (i == 102) {
            callWhatsappActivity();
            return true;
        } else if (i != 105) {
            return true;
        } else {
            callGalleryActivity();
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 101) {
            if (iArr.length > 0 && iArr[0] == 0) {
                callInstaActivity();
            }
        } else if (i == 102) {
            if (iArr.length > 0 && iArr[0] == 0) {
                callWhatsappActivity();
            }
        } else if (i == 105 && iArr.length > 0 && iArr[0] == 0) {
            callGalleryActivity();
        }
    }

    @Override
    public void onBackPressed() {
        if (this.doubleBackToExitPressedOnce) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            startActivity(intent);
        }
        this.doubleBackToExitPressedOnce = true;
        Utils.setToast(this.activity, "Please click BACK again to exit");
        new Handler().postDelayed(new Runnable() {

            public void run() {
                MainActivity.this.doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    public void setStatusBar() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.app_color));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.app_color));
        } else if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.app_color));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.app_color));
        } else {
            window.clearFlags(0);
        }
    }
}
