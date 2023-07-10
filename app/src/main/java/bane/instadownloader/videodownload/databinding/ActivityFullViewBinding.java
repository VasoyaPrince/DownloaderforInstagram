package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import bane.instadownloader.videodownload.R;

public abstract class ActivityFullViewBinding extends ViewDataBinding {
    public final ImageView imClose;
    public final ImageView imDelete;
    public final ImageView imShare;
    public final ImageView imWhatsappShare;
    public final LinearLayout lnrFooter;
    public final LinearLayout lytBottom;
    public final ViewPager vpView;

    protected ActivityFullViewBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout2, ViewPager viewPager) {
        super(obj, view, i);
        this.imClose = imageView;
        this.imDelete = imageView2;
        this.imShare = imageView3;
        this.imWhatsappShare = imageView4;
        this.lnrFooter = linearLayout;
        this.lytBottom = linearLayout2;
        this.vpView = viewPager;
    }

    public static ActivityFullViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFullViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFullViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_full_view, viewGroup, z, obj);
    }

    public static ActivityFullViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFullViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFullViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_full_view, null, false, obj);
    }

    public static ActivityFullViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFullViewBinding bind(View view, Object obj) {
        return (ActivityFullViewBinding) bind(obj, view, R.layout.activity_full_view);
    }
}
