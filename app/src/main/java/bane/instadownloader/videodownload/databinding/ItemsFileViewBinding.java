package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import bane.instadownloader.videodownload.R;

public abstract class ItemsFileViewBinding extends ViewDataBinding {
    public final ImageView ivImage;
    public final ImageView ivPlay;
    public final RelativeLayout rlMain;
    public final TextView tvFileName;

    protected ItemsFileViewBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, TextView textView) {
        super(obj, view, i);
        this.ivImage = imageView;
        this.ivPlay = imageView2;
        this.rlMain = relativeLayout;
        this.tvFileName = textView;
    }

    public static ItemsFileViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemsFileViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemsFileViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.items_file_view, viewGroup, z, obj);
    }

    public static ItemsFileViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemsFileViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemsFileViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.items_file_view, null, false, obj);
    }

    public static ItemsFileViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemsFileViewBinding bind(View view, Object obj) {
        return (ItemsFileViewBinding) bind(obj, view, R.layout.items_file_view);
    }
}
