package bane.instadownloader.videodownload.activity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.api.CommonClassForAPI;
import bane.instadownloader.videodownload.databinding.ActivityInstagramBinding;
import bane.instadownloader.videodownload.databinding.LayoutHowToBinding;
import bane.instadownloader.videodownload.model.Edge;
import bane.instadownloader.videodownload.model.EdgeSidecarToChildren;
import bane.instadownloader.videodownload.model.ResponseModel;
import bane.instadownloader.videodownload.util.AdsUtils;
import bane.instadownloader.videodownload.util.SharePrefs;
import bane.instadownloader.videodownload.util.Utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class InstagramActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private String PhotoUrl;
    private String VideoUrl;
    private InstagramActivity activity;
  //  private ActivityInstagramBinding binding;
    private ClipboardManager clipBoard;
    CommonClassForAPI commonClassForAPI;
    Context context;
    private DisposableObserver<JsonObject> instaObserver = new DisposableObserver<JsonObject>() {

        public void onNext(JsonObject jsonObject) {
            Utils.hideProgressDialog(InstagramActivity.this.activity);
            try {
                Log.e("onNext: ", jsonObject.toString());
                ResponseModel responseModel = (ResponseModel) new Gson().fromJson(jsonObject.toString(), new TypeToken<ResponseModel>() {

                }.getType());
                EdgeSidecarToChildren edge_sidecar_to_children = responseModel.getGraphql().getShortcode_media().getEdge_sidecar_to_children();
                if (edge_sidecar_to_children != null) {
                    List<Edge> edges = edge_sidecar_to_children.getEdges();
                    for (int i = 0; i < edges.size(); i++) {
                        if (edges.get(i).getNode().isIs_video()) {
                            InstagramActivity.this.VideoUrl = edges.get(i).getNode().getVideo_url();
                            String str = InstagramActivity.this.VideoUrl;
                            String str2 = Utils.RootDirectoryInsta;
                            InstagramActivity instagramActivity = InstagramActivity.this.activity;
                            InstagramActivity instagramActivity2 = InstagramActivity.this;
                            Utils.startDownload(str, str2, instagramActivity, instagramActivity2.getVideoFilenameFromURL(instagramActivity2.VideoUrl));
                            etText.setText("");
                            InstagramActivity.this.VideoUrl = "";
                        } else {
                            InstagramActivity.this.PhotoUrl = edges.get(i).getNode().getDisplay_resources().get(edges.get(i).getNode().getDisplay_resources().size() - 1).getSrc();
                            String str3 = InstagramActivity.this.PhotoUrl;
                            String str4 = Utils.RootDirectoryInsta;
                            InstagramActivity instagramActivity3 = InstagramActivity.this.activity;
                            InstagramActivity instagramActivity4 = InstagramActivity.this;
                            Utils.startDownload(str3, str4, instagramActivity3, instagramActivity4.getImageFilenameFromURL(instagramActivity4.PhotoUrl));
                            InstagramActivity.this.PhotoUrl = "";
                           etText.setText("");
                        }
                    }
                } else if (responseModel.getGraphql().getShortcode_media().isIs_video()) {
                    InstagramActivity.this.VideoUrl = responseModel.getGraphql().getShortcode_media().getVideo_url();
                    String str5 = InstagramActivity.this.VideoUrl;
                    String str6 = Utils.RootDirectoryInsta;
                    InstagramActivity instagramActivity5 = InstagramActivity.this.activity;
                    InstagramActivity instagramActivity6 = InstagramActivity.this;
                    Utils.startDownload(str5, str6, instagramActivity5, instagramActivity6.getVideoFilenameFromURL(instagramActivity6.VideoUrl));
                    InstagramActivity.this.VideoUrl = "";
                    etText.setText("");
                } else {
                    InstagramActivity.this.PhotoUrl = responseModel.getGraphql().getShortcode_media().getDisplay_resources().get(responseModel.getGraphql().getShortcode_media().getDisplay_resources().size() - 1).getSrc();
                    String str7 = InstagramActivity.this.PhotoUrl;
                    String str8 = Utils.RootDirectoryInsta;
                    InstagramActivity instagramActivity7 = InstagramActivity.this.activity;
                    InstagramActivity instagramActivity8 = InstagramActivity.this;
                    Utils.startDownload(str7, str8, instagramActivity7, instagramActivity8.getImageFilenameFromURL(instagramActivity8.PhotoUrl));
                    InstagramActivity.this.PhotoUrl = "";
                    etText.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Utils.hideProgressDialog(InstagramActivity.this.activity);
            th.printStackTrace();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Utils.hideProgressDialog(InstagramActivity.this.activity);
        }
    };

    LinearLayout LLOpenInstagram;
    LinearLayout RLDownloadLayout;
    RelativeLayout RLEdittextLayout;
    RelativeLayout RLLoginInstagram;
    RelativeLayout RLTopLayout;
    Switch SwitchLogin;
    AdView adView;
    EditText etText;
    ImageView imBack;
    LinearLayout imInfo;
  //  LayoutHowToBinding layoutHowTo;
    LinearLayout lnrMain;
    TextView loginBtn1;
    ImageView rateapp1;
    LinearLayout rvRateApp2;
    LinearLayout top2bar;
    LinearLayout top3bar;
    LinearLayout top4bar;
    LinearLayout topbar;
    TextView tvLoginInstagram;
    TextView tvPaste;

    LinearLayout LLHowToLayout;
    LinearLayout LLHowToOne;
    ImageView imHowto1;
    ImageView imHowto2;
    ImageView imHowto3;
    TextView tvHowTo1;
    TextView tvHowTo2;
    TextView tvHowTo3;
    TextView tvHowTo4;
    TextView tvHowToHeadOne;
    TextView tvHowToHeadTwo;

    ImageView img_clear;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_instagram);
        this.activity = this;
        this.context = this;


        this.commonClassForAPI = CommonClassForAPI.getInstance(this);

        LLOpenInstagram = findViewById(R.id.LLOpenInstagram);
        RLDownloadLayout = findViewById(R.id.RLDownloadLayout);
        RLEdittextLayout = findViewById(R.id.RLEdittextLayout);
        RLLoginInstagram = findViewById(R.id.RLLoginInstagram);
        RLTopLayout = findViewById(R.id.RLTopLayout);
        SwitchLogin = findViewById(R.id.SwitchLogin);

        etText = findViewById(R.id.et_text);
        imBack = findViewById(R.id.imBack);
        imInfo = findViewById(R.id.imInfo);
           //layoutHowTo = findViewById(R.id.layoutHowTo);
        lnrMain = findViewById(R.id.lnr_main);
        loginBtn1 = findViewById(R.id.login_btn1);
        rateapp1 = findViewById(R.id.rateapp1);
        rvRateApp2 = findViewById(R.id.rvRateApp2);
        top2bar = findViewById(R.id.top2bar);
        top3bar = findViewById(R.id.top3bar);
        top4bar = findViewById(R.id.top4bar);
        topbar = findViewById(R.id.topbar);
        tvLoginInstagram = findViewById(R.id.tvLoginInstagram);
        tvPaste = findViewById(R.id.tv_paste);

        LLHowToLayout = findViewById(R.id.LLHowToLayout);
        LLHowToOne = findViewById(R.id.LLHowToOne);
        imHowto1 = findViewById(R.id.im_howto1);
        imHowto2 = findViewById(R.id.im_howto2);
        imHowto3 = findViewById(R.id.im_howto3);
        tvHowTo1 = findViewById(R.id.tvHowTo1);
        tvHowTo2 = findViewById(R.id.tvHowTo2);
        tvHowTo3 = findViewById(R.id.tvHowTo3);
        tvHowTo4 = findViewById(R.id.tvHowTo4);
        tvHowToHeadOne = findViewById(R.id.tvHowToHeadOne);
        tvHowToHeadTwo = findViewById(R.id.tvHowToHeadTwo);

        img_clear = findViewById(R.id.img_clear);


        Utils.createFileFolder();
       // AdsUtils.showGoogleBannerAd(this, adView);
        //InterstitialAdsINIT();
        initViews();
        setStatusBar();


        img_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etText.setText("");
            }
        });
    }

    
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        this.activity = this;
        this.context = this;
        this.clipBoard = (ClipboardManager) getSystemService("clipboard");
        PasteText();
    }

    private void initViews() {
        this.clipBoard = (ClipboardManager) this.activity.getSystemService("clipboard");
        imBack.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.activity.InstagramActivity.AnonymousClass1 */

            public void onClick(View view) {
                InstagramActivity.this.onBackPressed();
            }
        });
        imInfo.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.activity.InstagramActivity.AnonymousClass2 */

            public void onClick(View view) {
                LLHowToLayout.setVisibility(0);
            }
        });
        imHowto1.setImageResource(R.drawable.insta1);
        imHowto2.setImageResource(R.drawable.insta2);
        imHowto3.setImageResource(R.drawable.insta3);
        if (!SharePrefs.getInstance(this.activity).getBoolean(SharePrefs.ISSHOWHOWTOINSTA).booleanValue()) {
            SharePrefs.getInstance(this.activity).putBoolean(SharePrefs.ISSHOWHOWTOINSTA, true);
            LLHowToLayout.setVisibility(0);
        } else {
            LLHowToLayout.setVisibility(8);
        }
        loginBtn1.setOnClickListener(new View.OnClickListener() {

            public final void onClick(View view) {
                InstagramActivity.this.lambda$initViews$0$InstagramActivity(view);
            }
        });
        rvRateApp2.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.activity.InstagramActivity.AnonymousClass3 */

            public void onClick(View view) {
                String packageName = InstagramActivity.this.context.getPackageName();
                try {
                    Context context = InstagramActivity.this.context;
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
                } catch (ActivityNotFoundException unused) {
                    Context context2 = InstagramActivity.this.context;
                    context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)));
                }
            }
        });
        tvPaste.setOnClickListener(new View.OnClickListener() {

            public final void onClick(View view) {
                InstagramActivity.this.lambda$initViews$1$InstagramActivity(view);
            }
        });
        LLOpenInstagram.setOnClickListener(new View.OnClickListener() {

            public final void onClick(View view) {
                InstagramActivity.this.lambda$initViews$2$InstagramActivity(view);
            }
        });
        new GridLayoutManager(getApplicationContext(), 1).setOrientation(0);
        if (SharePrefs.getInstance(this.activity).getBoolean(SharePrefs.ISINSTALOGIN).booleanValue()) {
            SwitchLogin.setChecked(true);
        } else {
            SwitchLogin.setChecked(false);
        }
        RLLoginInstagram.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (!SharePrefs.getInstance(InstagramActivity.this.activity).getBoolean(SharePrefs.ISINSTALOGIN).booleanValue()) {
                    InstagramActivity.this.startActivityForResult(new Intent(InstagramActivity.this.activity, LoginActivity.class), 100);
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(InstagramActivity.this.activity);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharePrefs.getInstance(InstagramActivity.this.activity).putBoolean(SharePrefs.ISINSTALOGIN, false);
                        SharePrefs.getInstance(InstagramActivity.this.activity).putString(SharePrefs.COOKIES, "");
                        SharePrefs.getInstance(InstagramActivity.this.activity).putString(SharePrefs.CSRF, "");
                        SharePrefs.getInstance(InstagramActivity.this.activity).putString(SharePrefs.SESSIONID, "");
                        SharePrefs.getInstance(InstagramActivity.this.activity).putString(SharePrefs.USERID, "");
                        if (SharePrefs.getInstance(InstagramActivity.this.activity).getBoolean(SharePrefs.ISINSTALOGIN).booleanValue()) {
                            SwitchLogin.setChecked(true);
                        } else {
                            SwitchLogin.setChecked(false);
                        }
                        dialogInterface.cancel();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog create = builder.create();
                create.setTitle("Don't Want to Download Media from Private Account?");
                create.show();
            }
        });
        new GridLayoutManager(getApplicationContext(), 3).setOrientation(1);
    }

    public /* synthetic */ void lambda$initViews$0$InstagramActivity(View view) {
        String obj = etText.getText().toString();
        if (obj.equals("")) {
            Utils.setToast(this.activity, "Enter Url");
        } else if (!Patterns.WEB_URL.matcher(obj).matches()) {
            Utils.setToast(this.activity, "Enter Valid Url");
        } else {
            GetInstagramData();
            //showInterstitial();
        }
    }

    public /* synthetic */ void lambda$initViews$1$InstagramActivity(View view) {
        PasteText();
    }

    public /* synthetic */ void lambda$initViews$2$InstagramActivity(View view) {
        Utils.OpenApp(this.activity, "com.instagram.android");
    }

    private void GetInstagramData() {
        try {
            Utils.createFileFolder();
            String host = new URL(etText.getText().toString()).getHost();
            Log.e("initViews: ", host);
            if (host.equals("www.instagram.com")) {
                callDownload(etText.getText().toString());
            } else {
                Utils.setToast(this.activity, "Enter Valid Url");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void PasteText() {
        try {
            etText.setText("");
            String stringExtra = getIntent().getStringExtra("CopyIntent");
            if (stringExtra.equals("")) {
                if (this.clipBoard.hasPrimaryClip()) {
                    if (this.clipBoard.getPrimaryClipDescription().hasMimeType("text/plain")) {
                        ClipData.Item itemAt = this.clipBoard.getPrimaryClip().getItemAt(0);
                        if (itemAt.getText().toString().contains("instagram.com")) {
                            etText.setText(itemAt.getText().toString());
                        }
                    } else if (this.clipBoard.getPrimaryClip().getItemAt(0).getText().toString().contains("instagram.com")) {
                        etText.setText(this.clipBoard.getPrimaryClip().getItemAt(0).getText().toString());
                    }
                }
            } else if (stringExtra.contains("instagram.com")) {
                etText.setText(stringExtra);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getUrlWithoutParameters(String str) {
        try {
            URI uri = new URI(str);
            return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            Utils.setToast(this.activity, "Enter Valid Url");
            return "";
        }
    }

    private void callDownload(String str) {
        String urlWithoutParameters = getUrlWithoutParameters(str);
        System.out.println(urlWithoutParameters);
        String str2 = urlWithoutParameters + "?__a=1";
        if (str2.contains("reel")) {
            str2 = str2.replace("reel", "p");
        }
        System.out.println(str2);
        try {
            if (!new Utils(this.activity).isNetworkAvailable()) {
                Utils.setToast(this.activity, "No Internet Connection");
            } else if (this.commonClassForAPI != null) {
                Utils.showProgressDialog(this.activity);
                this.commonClassForAPI.callResult(this.instaObserver, str2, "ds_user_id=" + SharePrefs.getInstance(this.activity).getString(SharePrefs.USERID) + "; sessionid=" + SharePrefs.getInstance(this.activity).getString(SharePrefs.SESSIONID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getImageFilenameFromURL(String str) {
        try {
            return new File(new URL(str).getPath().toString()).getName();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return System.currentTimeMillis() + ".png";
        }
    }

    public String getVideoFilenameFromURL(String str) {
        try {
            return new File(new URL(str).getPath().toString()).getName();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return System.currentTimeMillis() + ".mp4";
        }
    }

    
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.instaObserver.dispose();
    }

    
    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            super.onActivityResult(i, i2, intent);
            if (i == 100 && i2 == -1) {
                intent.getStringExtra("key");
                if (SharePrefs.getInstance(this.activity).getBoolean(SharePrefs.ISINSTALOGIN).booleanValue()) {
                    SwitchLogin.setChecked(true);
                } else {
                    SwitchLogin.setChecked(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setStatusBar() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.white));
        } else if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.white));
        } else {
            window.clearFlags(0);
        }
    }
}
