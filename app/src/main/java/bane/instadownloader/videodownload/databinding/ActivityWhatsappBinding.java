package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;
import bane.instadownloader.videodownload.R;

public abstract class ActivityWhatsappBinding extends ViewDataBinding {
    public final RelativeLayout LLOpenWhatsapp;
    public final RelativeLayout RLTab;
    public final RelativeLayout RLTopLayout;
    public final ImageView TVTitle;
    public final AdView adView;
    public final ImageView imBack;
    public final TabLayout tabs;
    public final ViewPager viewpager;

    protected ActivityWhatsappBinding(Object obj, View view, int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, ImageView imageView, AdView adView2, ImageView imageView2, TabLayout tabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.LLOpenWhatsapp = relativeLayout;
        this.RLTab = relativeLayout2;
        this.RLTopLayout = relativeLayout3;
        this.TVTitle = imageView;
        this.adView = adView2;
        this.imBack = imageView2;
        this.tabs = tabLayout;
        this.viewpager = viewPager;
    }

    public static ActivityWhatsappBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWhatsappBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityWhatsappBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_whatsapp, viewGroup, z, obj);
    }

    public static ActivityWhatsappBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWhatsappBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityWhatsappBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_whatsapp, null, false, obj);
    }

    public static ActivityWhatsappBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWhatsappBinding bind(View view, Object obj) {
        return (ActivityWhatsappBinding) bind(obj, view, R.layout.activity_whatsapp);
    }
}
