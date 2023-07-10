package bane.instadownloader.videodownload.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.activity.VideoPlayerActivity;
import bane.instadownloader.videodownload.databinding.ItemsWhatsappViewBinding;
import bane.instadownloader.videodownload.model.WhatsappStatusModel;
import bane.instadownloader.videodownload.util.Utils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

public class WhatsappStatusAdapter extends RecyclerView.Adapter<WhatsappStatusAdapter.ViewHolder> {
    public String SaveFilePath = (Utils.RootDirectoryWhatsappShow + "/");
    private Context context;
    private ArrayList<WhatsappStatusModel> fileArrayList;
    private LayoutInflater layoutInflater;

    public WhatsappStatusAdapter(Context context2, ArrayList<WhatsappStatusModel> arrayList) {
        this.context = context2;
        this.fileArrayList = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new ViewHolder((ItemsWhatsappViewBinding) DataBindingUtil.inflate(this.layoutInflater, R.layout.items_whatsapp_view, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final WhatsappStatusModel whatsappStatusModel = this.fileArrayList.get(i);
        if (whatsappStatusModel.getUri().toString().endsWith(".mp4")) {
            viewHolder.binding.ivPlay.setVisibility(0);
        } else {
            viewHolder.binding.ivPlay.setVisibility(8);
        }
        Glide.with(this.context).load(whatsappStatusModel.getPath()).into(viewHolder.binding.pcw);
        viewHolder.binding.ivPlay.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.adapter.WhatsappStatusAdapter.AnonymousClass1 */

            public void onClick(View view) {
                Intent intent = new Intent(WhatsappStatusAdapter.this.context, VideoPlayerActivity.class);
                intent.putExtra("PathVideo", whatsappStatusModel.getUri().toString());
                WhatsappStatusAdapter.this.context.startActivity(intent);
            }
        });
        viewHolder.binding.tvDownload.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.adapter.WhatsappStatusAdapter.AnonymousClass2 */

            public void onClick(View view) {
                Utils.createFileFolder();
                String path = whatsappStatusModel.getPath();
                String substring = path.substring(path.lastIndexOf("/") + 1);
                try {
                    FileUtils.copyFileToDirectory(new File(path), new File(WhatsappStatusAdapter.this.SaveFilePath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String substring2 = substring.substring(12);
                MediaScannerConnection.scanFile(WhatsappStatusAdapter.this.context, new String[]{new File(WhatsappStatusAdapter.this.SaveFilePath + substring2).getAbsolutePath()}, new String[]{whatsappStatusModel.getUri().toString().endsWith(".mp4") ? "video/*" : "image/*"}, new MediaScannerConnection.MediaScannerConnectionClient() {
                    /* class bane.instadownloader.videodownload.adapter.WhatsappStatusAdapter.AnonymousClass2.AnonymousClass1 */

                    public void onMediaScannerConnected() {
                    }

                    public void onScanCompleted(String str, Uri uri) {
                    }
                });
                new File(WhatsappStatusAdapter.this.SaveFilePath, substring).renameTo(new File(WhatsappStatusAdapter.this.SaveFilePath, substring2));
                Context context = WhatsappStatusAdapter.this.context;
                Toast.makeText(context, "Saved to: " + WhatsappStatusAdapter.this.SaveFilePath + substring2, 1).show();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<WhatsappStatusModel> arrayList = this.fileArrayList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemsWhatsappViewBinding binding;

        public ViewHolder(ItemsWhatsappViewBinding itemsWhatsappViewBinding) {
            super(itemsWhatsappViewBinding.getRoot());
            this.binding = itemsWhatsappViewBinding;
        }
    }
}
