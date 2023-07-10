package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bane.instadownloader.videodownload.R;

public abstract class FragmentWhatsappImageBinding extends ViewDataBinding {
    public final RecyclerView rvFileList;
    public final SwipeRefreshLayout swiperefresh;
    public final TextView tvNoResult;

    protected FragmentWhatsappImageBinding(Object obj, View view, int i, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TextView textView) {
        super(obj, view, i);
        this.rvFileList = recyclerView;
        this.swiperefresh = swipeRefreshLayout;
        this.tvNoResult = textView;
    }

    public static FragmentWhatsappImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWhatsappImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWhatsappImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_whatsapp_image, viewGroup, z, obj);
    }

    public static FragmentWhatsappImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWhatsappImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWhatsappImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_whatsapp_image, null, false, obj);
    }

    public static FragmentWhatsappImageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWhatsappImageBinding bind(View view, Object obj) {
        return (FragmentWhatsappImageBinding) bind(obj, view, R.layout.fragment_whatsapp_image);
    }
}
