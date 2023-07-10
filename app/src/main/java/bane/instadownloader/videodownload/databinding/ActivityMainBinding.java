package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import bane.instadownloader.videodownload.R;

public abstract class ActivityMainBinding extends ViewDataBinding {
    public final View admobNativeContainer;
    public final FrameLayout adsContainer;
    public final LinearLayout bannerContainer;
    public final ImageView downloaded;
    public final LinearLayout linearLayout;
    public final LinearLayout main;
    public final LinearLayout mainlin;
    public final ImageView rateapp;
    public final ImageView reels;
    public final CardView rvGallery;
    public final CardView rvInsta;
    public final CardView rvRateApp;
    public final CardView rvShareApp;
    public final ImageView shareimage;
    public final TextView textrate;
    public final RelativeLayout toolbar;
    public final TextView toptext;
    public final TextView toptext2;

    protected ActivityMainBinding(Object obj, View view, int i, View view2, FrameLayout frameLayout, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, ImageView imageView2, ImageView imageView3, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4, ImageView imageView4, TextView textView, RelativeLayout relativeLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.admobNativeContainer = view2;
        this.adsContainer = frameLayout;
        this.bannerContainer = linearLayout2;
        this.downloaded = imageView;
        this.linearLayout = linearLayout3;
        this.main = linearLayout4;
        this.mainlin = linearLayout5;
        this.rateapp = imageView2;
        this.reels = imageView3;
        this.rvGallery = cardView;
        this.rvInsta = cardView2;
        this.rvRateApp = cardView3;
        this.rvShareApp = cardView4;
        this.shareimage = imageView4;
        this.textrate = textView;
        this.toolbar = relativeLayout;
        this.toptext = textView2;
        this.toptext2 = textView3;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, viewGroup, z, obj);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, null, false, obj);
    }

    public static ActivityMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding bind(View view, Object obj) {
        return (ActivityMainBinding) bind(obj, view, R.layout.activity_main);
    }
}
