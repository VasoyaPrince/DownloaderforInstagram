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

public abstract class ItemsWhatsappViewBinding extends ViewDataBinding {
    public final RelativeLayout RLM;
    public final ImageView ivPlay;
    public final ImageView pcw;
    public final RelativeLayout rlMain;
    public final TextView tvDownload;

    protected ItemsWhatsappViewBinding(Object obj, View view, int i, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, TextView textView) {
        super(obj, view, i);
        this.RLM = relativeLayout;
        this.ivPlay = imageView;
        this.pcw = imageView2;
        this.rlMain = relativeLayout2;
        this.tvDownload = textView;
    }

    public static ItemsWhatsappViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemsWhatsappViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemsWhatsappViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.items_whatsapp_view, viewGroup, z, obj);
    }

    public static ItemsWhatsappViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemsWhatsappViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemsWhatsappViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.items_whatsapp_view, null, false, obj);
    }

    public static ItemsWhatsappViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemsWhatsappViewBinding bind(View view, Object obj) {
        return (ItemsWhatsappViewBinding) bind(obj, view, R.layout.items_whatsapp_view);
    }
}
