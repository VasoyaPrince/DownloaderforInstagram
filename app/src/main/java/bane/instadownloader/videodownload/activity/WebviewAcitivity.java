package bane.instadownloader.videodownload.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.databinding.ActivityWebviewBinding;

public class WebviewAcitivity extends AppCompatActivity {
    String IntentTitle = "";
    String IntentURL;
    ActivityWebviewBinding binding;

    
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityWebviewBinding) DataBindingUtil.setContentView(this, R.layout.activity_webview);
        this.IntentURL = getIntent().getStringExtra("URL");
        this.IntentTitle = getIntent().getStringExtra("Title");
        this.binding.imBack.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.activity.WebviewAcitivity.AnonymousClass1 */

            public void onClick(View view) {
                WebviewAcitivity.this.onBackPressed();
            }
        });
        this.binding.TVTitle.setText(this.IntentTitle);
        this.binding.swipeRefreshLayout.post(new Runnable() {
            /* class bane.instadownloader.videodownload.activity.WebviewAcitivity.AnonymousClass2 */

            public void run() {
                WebviewAcitivity.this.binding.swipeRefreshLayout.setRefreshing(true);
                WebviewAcitivity webviewAcitivity = WebviewAcitivity.this;
                webviewAcitivity.LoadPage(webviewAcitivity.IntentURL);
            }
        });
        this.binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            /* class bane.instadownloader.videodownload.activity.WebviewAcitivity.AnonymousClass3 */

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                WebviewAcitivity webviewAcitivity = WebviewAcitivity.this;
                webviewAcitivity.LoadPage(webviewAcitivity.IntentURL);
            }
        });
    }

    public void LoadPage(String str) {
        this.binding.webView1.setWebViewClient(new MyBrowser());
        this.binding.webView1.setWebChromeClient(new WebChromeClient() {
            /* class bane.instadownloader.videodownload.activity.WebviewAcitivity.AnonymousClass4 */

            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    WebviewAcitivity.this.binding.swipeRefreshLayout.setRefreshing(false);
                } else {
                    WebviewAcitivity.this.binding.swipeRefreshLayout.setRefreshing(true);
                }
            }
        });
        this.binding.webView1.getSettings().setLoadsImagesAutomatically(true);
        this.binding.webView1.getSettings().setJavaScriptEnabled(true);
        this.binding.webView1.setScrollBarStyle(0);
        this.binding.webView1.loadUrl(str);
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
    }
}
