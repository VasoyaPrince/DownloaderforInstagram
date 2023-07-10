package bane.instadownloader.videodownload.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.activity.FullViewActivity;
import bane.instadownloader.videodownload.activity.VideoPlayerActivity;
import bane.instadownloader.videodownload.util.Utils;
import java.io.File;
import java.util.ArrayList;

public class ShowImagesAdapter extends PagerAdapter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Context context;
    FullViewActivity fullViewActivity;
    private ArrayList<File> imageList;
    private LayoutInflater inflater;

    @Override
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    public ShowImagesAdapter(Context context2, ArrayList<File> arrayList, FullViewActivity fullViewActivity2) {
        this.context = context2;
        this.imageList = arrayList;
        this.fullViewActivity = fullViewActivity2;
        this.inflater = LayoutInflater.from(context2);
    }

    @Override
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, final int i) {
        View inflate = this.inflater.inflate(R.layout.slidingimages_layout, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.im_vpPlay);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.im_share);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.im_delete);
        Glide.with(this.context).load(this.imageList.get(i).getPath()).into((ImageView) inflate.findViewById(R.id.im_fullViewImage));
        viewGroup.addView(inflate, 0);
        if (this.imageList.get(i).getName().substring(this.imageList.get(i).getName().lastIndexOf(".")).equals(".mp4")) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() {

            public final /* synthetic */ int f$1;

            {
                this.f$1 = i;
            }

            public final void onClick(View view) {
                ShowImagesAdapter.this.lambda$instantiateItem$0$ShowImagesAdapter(this.f$1, view);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (((File) ShowImagesAdapter.this.imageList.get(i)).delete()) {
                    ShowImagesAdapter.this.fullViewActivity.deleteFileAA(i);
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (((File) ShowImagesAdapter.this.imageList.get(i)).getName().substring(((File) ShowImagesAdapter.this.imageList.get(i)).getName().lastIndexOf(".")).equals(".mp4")) {
                    Utils.shareVideo(ShowImagesAdapter.this.context, ((File) ShowImagesAdapter.this.imageList.get(i)).getPath());
                } else {
                    Utils.shareImage(ShowImagesAdapter.this.context, ((File) ShowImagesAdapter.this.imageList.get(i)).getPath());
                }
            }
        });
        return inflate;
    }

    public /* synthetic */ void lambda$instantiateItem$0$ShowImagesAdapter(int i, View view) {
        Intent intent = new Intent(this.context, VideoPlayerActivity.class);
        intent.putExtra("PathVideo", this.imageList.get(i).getPath());
        this.context.startActivity(intent);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.imageList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }
}
