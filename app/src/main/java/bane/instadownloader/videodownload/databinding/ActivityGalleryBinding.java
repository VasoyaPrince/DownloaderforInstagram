package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;
import bane.instadownloader.videodownload.R;

public abstract class ActivityGalleryBinding extends ViewDataBinding {
    public final RelativeLayout RLTab;
    public final RelativeLayout RLTop;
    public final RelativeLayout RLTopLayout;
    public final TextView TVTitle;
    public final AdView adView;
    public final ImageView imBack;
    public final TabLayout tabs;
    public final ViewPager viewpager;

    protected ActivityGalleryBinding(Object obj, View view, int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, AdView adView2, ImageView imageView, TabLayout tabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.RLTab = relativeLayout;
        this.RLTop = relativeLayout2;
        this.RLTopLayout = relativeLayout3;
        this.TVTitle = textView;
        this.adView = adView2;
        this.imBack = imageView;
        this.tabs = tabLayout;
        this.viewpager = viewPager;
    }

    public static ActivityGalleryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityGalleryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGalleryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_gallery, viewGroup, z, obj);
    }

    public static ActivityGalleryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityGalleryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGalleryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_gallery, null, false, obj);
    }

    public static ActivityGalleryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityGalleryBinding bind(View view, Object obj) {
        return (ActivityGalleryBinding) bind(obj, view, R.layout.activity_gallery);
    }
}
