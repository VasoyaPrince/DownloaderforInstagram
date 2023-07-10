package bane.instadownloader.videodownload.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.activity.VideoPlayerActivity;
import bane.instadownloader.videodownload.databinding.ItemsWhatsappViewBinding;
import bane.instadownloader.videodownload.model.story.ItemModel;
import bane.instadownloader.videodownload.util.Utils;
import java.util.ArrayList;

public class StoriesListAdapter extends RecyclerView.Adapter<StoriesListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ItemModel> storyItemModelList;

    public StoriesListAdapter(Context context2, ArrayList<ItemModel> arrayList) {
        this.context = context2;
        this.storyItemModelList = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder((ItemsWhatsappViewBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.items_whatsapp_view, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final ItemModel itemModel = this.storyItemModelList.get(i);
        try {
            if (itemModel.getMedia_type() == 2) {
                viewHolder.binding.ivPlay.setVisibility(0);
            } else {
                viewHolder.binding.ivPlay.setVisibility(8);
            }
            Glide.with(this.context).load(itemModel.getImage_versions2().getCandidates().get(0).getUrl()).into(viewHolder.binding.pcw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolder.binding.ivPlay.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.adapter.StoriesListAdapter.AnonymousClass1 */

            public void onClick(View view) {
                Intent intent = new Intent(StoriesListAdapter.this.context, VideoPlayerActivity.class);
                intent.putExtra("PathVideo", itemModel.getVideo_versions().get(0).getUrl());
                StoriesListAdapter.this.context.startActivity(intent);
            }
        });
        viewHolder.binding.tvDownload.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.adapter.StoriesListAdapter.AnonymousClass2 */

            public void onClick(View view) {
                if (itemModel.getMedia_type() == 2) {
                    String url = itemModel.getVideo_versions().get(0).getUrl();
                    String str = Utils.RootDirectoryInsta;
                    Context context = StoriesListAdapter.this.context;
                    Utils.startDownload(url, str, context, "story_" + itemModel.getId() + ".mp4");
                    return;
                }
                String url2 = itemModel.getImage_versions2().getCandidates().get(0).getUrl();
                String str2 = Utils.RootDirectoryInsta;
                Context context2 = StoriesListAdapter.this.context;
                Utils.startDownload(url2, str2, context2, "story_" + itemModel.getId() + ".png");
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<ItemModel> arrayList = this.storyItemModelList;
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
