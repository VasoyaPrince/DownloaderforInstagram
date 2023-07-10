package bane.instadownloader.videodownload.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.adapter.WhatsappStatusAdapter;
import bane.instadownloader.videodownload.databinding.FragmentWhatsappImageBinding;
import bane.instadownloader.videodownload.model.WhatsappStatusModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class WhatsappImageFragment extends Fragment {
    private File[] allfiles;
    FragmentWhatsappImageBinding binding;
    ArrayList<WhatsappStatusModel> statusModelArrayList;
    private WhatsappStatusAdapter whatsappStatusAdapter;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = (FragmentWhatsappImageBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_whatsapp_image, viewGroup, false);
        initViews();
        return this.binding.getRoot();
    }

    private void initViews() {
        this.statusModelArrayList = new ArrayList<>();
        getData();
        this.binding.swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            /* class bane.instadownloader.videodownload.fragment.$$Lambda$WhatsappImageFragment$XMajxGn3bK10E7PptN54kK3Ucg */

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                WhatsappImageFragment.this.lambda$initViews$0$WhatsappImageFragment();
            }
        });
    }

    public /* synthetic */ void lambda$initViews$0$WhatsappImageFragment() {
        this.statusModelArrayList = new ArrayList<>();
        getData();
        this.binding.swiperefresh.setRefreshing(false);
    }

    private void getData() {
        this.allfiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/WhatsApp/Media/.Statuses").listFiles();
        File[] listFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/WhatsApp Business/Media/.Statuses").listFiles();
        try {
            Arrays.sort(this.allfiles, $$Lambda$WhatsappImageFragment$NXqIIh9Oj3MOE7Mv1RUhpQM2Nws.INSTANCE);
            int i = 0;
            while (true) {
                File[] fileArr = this.allfiles;
                if (i < fileArr.length) {
                    File file = fileArr[i];
                    if (Uri.fromFile(file).toString().endsWith(".png") || Uri.fromFile(file).toString().endsWith(".jpg")) {
                        this.statusModelArrayList.add(new WhatsappStatusModel("WhatsStatus: " + (i + 1), Uri.fromFile(file), this.allfiles[i].getAbsolutePath(), file.getName()));
                    }
                    i++;
                }
                try {
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Arrays.sort(listFiles, $$Lambda$WhatsappImageFragment$06qI4LQaQ9sobuO60LMpANQntWc.INSTANCE);
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            File file2 = listFiles[i2];
            if (Uri.fromFile(file2).toString().endsWith(".png") || Uri.fromFile(file2).toString().endsWith(".jpg")) {
                this.statusModelArrayList.add(new WhatsappStatusModel("WhatsStatusB: " + (i2 + 1), Uri.fromFile(file2), listFiles[i2].getAbsolutePath(), file2.getName()));
            }
        }
        if (this.statusModelArrayList.size() != 0) {
            this.binding.tvNoResult.setVisibility(8);
        } else {
            this.binding.tvNoResult.setVisibility(0);
        }
        this.whatsappStatusAdapter = new WhatsappStatusAdapter(getActivity(), this.statusModelArrayList);
        this.binding.rvFileList.setAdapter(this.whatsappStatusAdapter);
    }

    static /* synthetic */ int lambda$getData$1(Object obj, Object obj2) {
        File file = (File) obj;
        File file2 = (File) obj2;
        if (file.lastModified() > file2.lastModified()) {
            return -1;
        }
        return file.lastModified() < file2.lastModified() ? 1 : 0;
    }

    static /* synthetic */ int lambda$getData$2(Object obj, Object obj2) {
        File file = (File) obj;
        File file2 = (File) obj2;
        if (file.lastModified() > file2.lastModified()) {
            return -1;
        }
        return file.lastModified() < file2.lastModified() ? 1 : 0;
    }
}
