package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import bane.instadownloader.videodownload.R;

public abstract class LayoutHowToBinding extends ViewDataBinding {
    public final LinearLayout LLHowToLayout;
    public final LinearLayout LLHowToOne;
    public final ImageView imHowto1;
    public final ImageView imHowto2;
    public final ImageView imHowto3;
    public final ImageView imHowto4;
    public final TextView tvHowTo1;
    public final TextView tvHowTo2;
    public final TextView tvHowTo3;
    public final TextView tvHowTo4;
    public final TextView tvHowToHeadOne;
    public final TextView tvHowToHeadTwo;

    protected LayoutHowToBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.LLHowToLayout = linearLayout;
        this.LLHowToOne = linearLayout2;
        this.imHowto1 = imageView;
        this.imHowto2 = imageView2;
        this.imHowto3 = imageView3;
        this.imHowto4 = imageView4;
        this.tvHowTo1 = textView;
        this.tvHowTo2 = textView2;
        this.tvHowTo3 = textView3;
        this.tvHowTo4 = textView4;
        this.tvHowToHeadOne = textView5;
        this.tvHowToHeadTwo = textView6;
    }

    public static LayoutHowToBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutHowToBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutHowToBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_how_to, viewGroup, z, obj);
    }

    public static LayoutHowToBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutHowToBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutHowToBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_how_to, null, false, obj);
    }

    public static LayoutHowToBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutHowToBinding bind(View view, Object obj) {
        return (LayoutHowToBinding) bind(obj, view, R.layout.layout_how_to);
    }
}
