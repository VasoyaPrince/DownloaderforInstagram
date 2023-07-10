package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bane.instadownloader.videodownload.R;

public abstract class ActivityWebviewBinding extends ViewDataBinding {
    public final RelativeLayout RLTop;
    public final RelativeLayout RLTopLayout;
    public final TextView TVTitle;
    public final ImageView imBack;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final WebView webView1;

    protected ActivityWebviewBinding(Object obj, View view, int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, ImageView imageView, SwipeRefreshLayout swipeRefreshLayout2, WebView webView) {
        super(obj, view, i);
        this.RLTop = relativeLayout;
        this.RLTopLayout = relativeLayout2;
        this.TVTitle = textView;
        this.imBack = imageView;
        this.swipeRefreshLayout = swipeRefreshLayout2;
        this.webView1 = webView;
    }

    public static ActivityWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_webview, viewGroup, z, obj);
    }

    public static ActivityWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWebviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_webview, null, false, obj);
    }

    public static ActivityWebviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWebviewBinding bind(View view, Object obj) {
        return (ActivityWebviewBinding) bind(obj, view, R.layout.activity_webview);
    }
}
