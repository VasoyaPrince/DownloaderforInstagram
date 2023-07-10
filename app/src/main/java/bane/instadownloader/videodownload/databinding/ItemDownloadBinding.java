package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import bane.instadownloader.videodownload.R;

public abstract class ItemDownloadBinding extends ViewDataBinding {
    public final RelativeLayout RLProgress;
    public final ProgressBar simpleProgressBar;
    public final TextView tvName;

    protected ItemDownloadBinding(Object obj, View view, int i, RelativeLayout relativeLayout, ProgressBar progressBar, TextView textView) {
        super(obj, view, i);
        this.RLProgress = relativeLayout;
        this.simpleProgressBar = progressBar;
        this.tvName = textView;
    }

    public static ItemDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDownloadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_download, viewGroup, z, obj);
    }

    public static ItemDownloadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDownloadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDownloadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_download, null, false, obj);
    }

    public static ItemDownloadBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemDownloadBinding bind(View view, Object obj) {
        return (ItemDownloadBinding) bind(obj, view, R.layout.item_download);
    }
}
