package bane.instadownloader.videodownload.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.databinding.ActivityLoginBinding;
import bane.instadownloader.videodownload.util.SharePrefs;

public class LoginActivity extends AppCompatActivity {
    LoginActivity activity;
    //ActivityLoginBinding binding;
    SwipeRefreshLayout swipeRefreshLayout;
    WebView webView;
    private String cookies;

    
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_login);
       // this.binding = (ActivityLoginBinding) DataBindingUtil.setContentView(this, R.layout.activity_login);
        this.activity = this;
        swipeRefreshLayout=findViewById(R.id.swipeRefreshLayout);
        webView=findViewById(R.id.webView);
        WebView webView;
        
        LoadPage();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            /* class bane.instadownloader.videodownload.activity.LoginActivity.AnonymousClass1 */

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                LoginActivity.this.LoadPage();
            }
        });
    }

    public void LoadPage() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);
        webView.setWebViewClient(new MyBrowser());
        CookieSyncManager.createInstance(this.activity);
        CookieManager.getInstance().removeAllCookie();
        webView.loadUrl("https://www.instagram.com/accounts/login/");
        webView.setWebChromeClient(new WebChromeClient() {
            /* class bane.instadownloader.videodownload.activity.LoginActivity.AnonymousClass2 */

            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    swipeRefreshLayout.setRefreshing(false);
                } else {
                    swipeRefreshLayout.setRefreshing(true);
                }
            }
        });
    }

    public String getCookie(String str, String str2) {
        String cookie = CookieManager.getInstance().getCookie(str);
        if (cookie != null && !cookie.isEmpty()) {
            String[] split = cookie.split(";");
            for (String str3 : split) {
                if (str3.contains(str2)) {
                    return str3.split("=")[1];
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public class MyBrowser extends WebViewClient {
        private MyBrowser() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }

        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            LoginActivity.this.cookies = CookieManager.getInstance().getCookie(str);
            try {
                String cookie = LoginActivity.this.getCookie(str, "sessionid");
                String cookie2 = LoginActivity.this.getCookie(str, "csrftoken");
                String cookie3 = LoginActivity.this.getCookie(str, "ds_user_id");
                if (cookie != null && cookie2 != null && cookie3 != null) {
                    SharePrefs.getInstance(LoginActivity.this.activity).putString(SharePrefs.COOKIES, LoginActivity.this.cookies);
                    SharePrefs.getInstance(LoginActivity.this.activity).putString(SharePrefs.CSRF, cookie2);
                    SharePrefs.getInstance(LoginActivity.this.activity).putString(SharePrefs.SESSIONID, cookie);
                    SharePrefs.getInstance(LoginActivity.this.activity).putString(SharePrefs.USERID, cookie3);
                    SharePrefs.getInstance(LoginActivity.this.activity).putBoolean(SharePrefs.ISINSTALOGIN, true);
                    webView.destroy();
                    Intent intent = new Intent();
                    intent.putExtra("result", "result");
                    LoginActivity.this.setResult(-1, intent);
                    LoginActivity.this.finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }
}
