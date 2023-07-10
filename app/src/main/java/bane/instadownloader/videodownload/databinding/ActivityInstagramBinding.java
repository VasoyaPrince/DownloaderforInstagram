package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.gms.ads.AdView;
import bane.instadownloader.videodownload.R;

public abstract class ActivityInstagramBinding extends ViewDataBinding {
    public final LinearLayout LLOpenInstagram;
    public final LinearLayout RLDownloadLayout;
    public final RelativeLayout RLEdittextLayout;
    public final RelativeLayout RLLoginInstagram;
    public final RelativeLayout RLTopLayout;
    public final Switch SwitchLogin;
    public final AdView adView;
    public final EditText etText;
    public final ImageView imBack;
    public final LinearLayout imInfo;
    public final LayoutHowToBinding layoutHowTo;
    public final LinearLayout lnrMain;
    public final TextView loginBtn1;
    public final ImageView rateapp1;
    public final LinearLayout rvRateApp2;
    public final LinearLayout top2bar;
    public final LinearLayout top3bar;
    public final LinearLayout top4bar;
    public final LinearLayout topbar;
    public final TextView tvLoginInstagram;
    public final TextView tvPaste;

    protected ActivityInstagramBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, Switch r11, AdView adView2, EditText editText, ImageView imageView, LinearLayout linearLayout3, LayoutHowToBinding layoutHowToBinding, LinearLayout linearLayout4, TextView textView, ImageView imageView2, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.LLOpenInstagram = linearLayout;
        this.RLDownloadLayout = linearLayout2;
        this.RLEdittextLayout = relativeLayout;
        this.RLLoginInstagram = relativeLayout2;
        this.RLTopLayout = relativeLayout3;
        this.SwitchLogin = r11;
        this.adView = adView2;
        this.etText = editText;
        this.imBack = imageView;
        this.imInfo = linearLayout3;
        this.layoutHowTo = layoutHowToBinding;
        this.lnrMain = linearLayout4;
        this.loginBtn1 = textView;
        this.rateapp1 = imageView2;
        this.rvRateApp2 = linearLayout5;
        this.top2bar = linearLayout6;
        this.top3bar = linearLayout7;
        this.top4bar = linearLayout8;
        this.topbar = linearLayout9;
        this.tvLoginInstagram = textView2;
        this.tvPaste = textView3;
    }

    public static ActivityInstagramBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInstagramBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityInstagramBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_instagram, viewGroup, z, obj);
    }

    public static ActivityInstagramBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInstagramBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityInstagramBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_instagram, null, false, obj);
    }

    public static ActivityInstagramBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityInstagramBinding bind(View view, Object obj) {
        return (ActivityInstagramBinding) bind(obj, view, R.layout.activity_instagram);
    }
}
