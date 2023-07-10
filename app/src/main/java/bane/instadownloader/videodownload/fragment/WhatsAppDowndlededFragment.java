package bane.instadownloader.videodownload.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.activity.FullViewActivity;
import bane.instadownloader.videodownload.activity.GalleryActivity;
import bane.instadownloader.videodownload.adapter.FileListAdapter;
import bane.instadownloader.videodownload.databinding.FragmentHistoryBinding;
import bane.instadownloader.videodownload.interfaces.FileListClickInterface;
import bane.instadownloader.videodownload.util.Utils;
import java.io.File;
import java.util.ArrayList;

public class WhatsAppDowndlededFragment extends Fragment implements FileListClickInterface {
    private GalleryActivity activity;
    private FragmentHistoryBinding binding;
    private ArrayList<File> fileArrayList;
    private FileListAdapter fileListAdapter;

    public static WhatsAppDowndlededFragment newInstance(String str) {
        WhatsAppDowndlededFragment whatsAppDowndlededFragment = new WhatsAppDowndlededFragment();
        Bundle bundle = new Bundle();
        bundle.putString("m", str);
        whatsAppDowndlededFragment.setArguments(bundle);
        return whatsAppDowndlededFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (GalleryActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            getArguments().getString("m");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.activity = (GalleryActivity) getActivity();
        getAllFiles();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (FragmentHistoryBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_history, viewGroup, false);
        initViews();
        return this.binding.getRoot();
    }

    private void initViews() {
        this.binding.swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            /* class bane.instadownloader.videodownload.fragment.$$Lambda$WhatsAppDowndlededFragment$syS8TstDXf53YZpiV4gKNRoxf2c */

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                WhatsAppDowndlededFragment.this.lambda$initViews$0$WhatsAppDowndlededFragment();
            }
        });
    }

    public /* synthetic */ void lambda$initViews$0$WhatsAppDowndlededFragment() {
        getAllFiles();
        this.binding.swiperefresh.setRefreshing(false);
    }

    private void getAllFiles() {
        this.fileArrayList = new ArrayList<>();
        File[] listFiles = Utils.RootDirectoryWhatsappShow.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                this.fileArrayList.add(file);
            }
            this.fileListAdapter = new FileListAdapter(this.activity, this.fileArrayList, this);
            this.binding.rvFileList.setAdapter(this.fileListAdapter);
        }
    }

    @Override // bane.instadownloader.videodownload.interfaces.FileListClickInterface
    public void getPosition(int i, File file) {
        Intent intent = new Intent(this.activity, FullViewActivity.class);
        intent.putExtra("ImageDataFile", this.fileArrayList);
        intent.putExtra("Position", i);
        this.activity.startActivity(intent);
    }
}
