package bane.instadownloader.videodownload.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
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

public class InstaDownloadedFragment extends Fragment implements FileListClickInterface {
    private GalleryActivity activity;
//    private FragmentHistoryBinding binding;
    private ArrayList<File> fileArrayList;
    private FileListAdapter fileListAdapter;

    RecyclerView rvFileList;
    SwipeRefreshLayout swiperefresh;
    TextView tvNoResult;

    public static InstaDownloadedFragment newInstance(String str) {
        InstaDownloadedFragment instaDownloadedFragment = new InstaDownloadedFragment();
        Bundle bundle = new Bundle();
        bundle.putString("m", str);
        instaDownloadedFragment.setArguments(bundle);
        return instaDownloadedFragment;
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
        View inflate = layoutInflater.inflate(R.layout.fragment_history, viewGroup, false);
         rvFileList=inflate.findViewById(R.id.rv_fileList);
         swiperefresh=inflate.findViewById(R.id.swiperefresh);
         tvNoResult=inflate.findViewById(R.id.tv_NoResult);

        initViews();
        return inflate;
    }

    private void initViews() {
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            /* class bane.instadownloader.videodownload.fragment.$$Lambda$InstaDownloadedFragment$a25KY72S3rELSsLeZ7QMqSfU74 */

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                InstaDownloadedFragment.this.lambda$initViews$0$InstaDownloadedFragment();
            }
        });
    }

    public /* synthetic */ void lambda$initViews$0$InstaDownloadedFragment() {
        getAllFiles();
        swiperefresh.setRefreshing(false);
    }

    private void getAllFiles() {
        this.fileArrayList = new ArrayList<>();
        File[] listFiles = Utils.RootDirectoryInstaShow.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                this.fileArrayList.add(file);
            }
            this.fileListAdapter = new
                    FileListAdapter(this.activity, this.fileArrayList, this);
            rvFileList.setAdapter(this.fileListAdapter);
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
