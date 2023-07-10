package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bane.instadownloader.videodownload.R;

public abstract class ActivityLoginBinding extends ViewDataBinding {
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final WebView webView;

    protected ActivityLoginBinding(Object obj, View view, int i, SwipeRefreshLayout swipeRefreshLayout2, WebView webView2) {
        super(obj, view, i);
        this.swipeRefreshLayout = swipeRefreshLayout2;
        this.webView = webView2;
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_login, viewGroup, z, obj);
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_login, null, false, obj);
    }

    public static ActivityLoginBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLoginBinding bind(View view, Object obj) {
        return (ActivityLoginBinding) bind(obj, view, R.layout.activity_login);
    }
}
