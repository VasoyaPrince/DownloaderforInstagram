package bane.instadownloader.videodownload.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import bane.instadownloader.videodownload.R;
import de.hdodenhof.circleimageview.CircleImageView;

public abstract class ItemUserListBinding extends ViewDataBinding {
    public final RelativeLayout RLStoryLayout;
    public final TextView realName;
    public final CircleImageView storyPc;
    public final TextView userName;

    protected ItemUserListBinding(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView, CircleImageView circleImageView, TextView textView2) {
        super(obj, view, i);
        this.RLStoryLayout = relativeLayout;
        this.realName = textView;
        this.storyPc = circleImageView;
        this.userName = textView2;
    }

    public static ItemUserListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_user_list, viewGroup, z, obj);
    }

    public static ItemUserListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_user_list, null, false, obj);
    }

    public static ItemUserListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemUserListBinding bind(View view, Object obj) {
        return (ItemUserListBinding) bind(obj, view, R.layout.item_user_list);
    }
}
