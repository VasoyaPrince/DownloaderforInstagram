package bane.instadownloader.videodownload.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.activity.VideoPlayerActivity;
import bane.instadownloader.videodownload.interfaces.FileListClickInterface;

import java.io.File;
import java.util.ArrayList;

public class FileListAdapter extends RecyclerView.Adapter<FileListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<File> fileArrayList;
    private FileListClickInterface fileListClickInterface;
    private LayoutInflater layoutInflater;

    public FileListAdapter(Context context2, ArrayList<File> arrayList, FileListClickInterface fileListClickInterface2) {
        this.context = context2;
        this.fileArrayList = arrayList;
        this.fileListClickInterface = fileListClickInterface2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_file_view, viewGroup, false));
        // return new ViewHolder((ItemsFileViewBinding) DataBindingUtil.inflate(this.layoutInflater, R.layout.items_file_view, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        final File file = this.fileArrayList.get(i);
        try {
            if (file.getName().substring(file.getName().lastIndexOf(".")).equals(".mp4")) {
                viewHolder.ivPlay.setVisibility(0);
            } else {
                viewHolder.ivPlay.setVisibility(8);
            }
            Glide.with(this.context).load(file.getPath()).into(viewHolder.ivImage);
        } catch (Exception unused) {
        }
        viewHolder.ivPlay.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.adapter.$$Lambda$FileListAdapter$GknSc1e3dTAbSH8gl5fuXEpec */
            public final /* synthetic */ File f$1;

            {
                this.f$1 = file;
            }

            public final void onClick(View view) {
                FileListAdapter.this.lambda$onBindViewHolder$0$FileListAdapter(this.f$1, view);
            }
        });
        viewHolder.rlMain.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.adapter.FileListAdapter.AnonymousClass1 */

            public void onClick(View view) {
                FileListAdapter.this.fileListClickInterface.getPosition(i, file);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$FileListAdapter(File file, View view) {
        Intent intent = new Intent(this.context, VideoPlayerActivity.class);
        intent.putExtra("PathVideo", file.getPath().toString());
        this.context.startActivity(intent);
//
//        Intent intent = new Intent(this.context, VideoPlayerActivity.class);
//        intent.putExtra("PathVideo", file.getPath().toString());
//        this.context.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<File> arrayList = this.fileArrayList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //   ItemsFileViewBinding mbinding;
        ImageView ivImage;
        ImageView ivPlay;
        RelativeLayout rlMain;
        TextView tvFileName;

        public ViewHolder(View view) {
            super(view);
            this.ivImage = view.findViewById(R.id.iv_image);
            this.ivPlay = view.findViewById(R.id.iv_play);
            this.rlMain = view.findViewById(R.id.rl_main);
            this.tvFileName = view.findViewById(R.id.tv_fileName);
        }
    }
}
