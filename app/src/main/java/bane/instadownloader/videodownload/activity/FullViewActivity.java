package bane.instadownloader.videodownload.activity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.adapter.ShowImagesAdapter;
import bane.instadownloader.videodownload.databinding.ActivityFullViewBinding;
import bane.instadownloader.videodownload.util.Utils;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class FullViewActivity extends AppCompatActivity {
    private int Position = 0;
    private FullViewActivity activity;
   // private ActivityFullViewBinding binding;
    private ArrayList<File> fileArrayList;
    ShowImagesAdapter showImagesAdapter;

    ImageView imClose;
    ImageView imDelete;
    ImageView imShare;
    ImageView imWhatsappShare;
    LinearLayout lnrFooter;
    LinearLayout lytBottom;
    ViewPager vpView;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_full_view);
        this.activity = this;
        setStatusBar();
        imClose = findViewById(R.id.im_close);
        imDelete = findViewById(R.id.imDelete);
        imShare = findViewById(R.id.imShare);
        imWhatsappShare = findViewById(R.id.imWhatsappShare);
        lnrFooter = findViewById(R.id.lnr_footer);
        lytBottom = findViewById(R.id.lyt_bottom);
        vpView = findViewById(R.id.vp_view);


        if (getIntent().getExtras() != null) {
            this.fileArrayList = (ArrayList) getIntent().getSerializableExtra("ImageDataFile");
            this.Position = getIntent().getIntExtra("Position", 0);
        }
        initViews();
    }

    public void initViews() {
        this.showImagesAdapter = new ShowImagesAdapter(this, this.fileArrayList, this);
        vpView.setAdapter(this.showImagesAdapter);
        vpView.setCurrentItem(this.Position);
        vpView.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class bane.instadownloader.videodownload.activity.FullViewActivity.AnonymousClass1 */

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FullViewActivity.this.Position = i;
                PrintStream printStream = System.out;
                printStream.println("Current position==" + FullViewActivity.this.Position);
            }
        });
        imDelete.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.activity.FullViewActivity.AnonymousClass2 */

            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FullViewActivity.this.activity);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    /* class bane.instadownloader.videodownload.activity.FullViewActivity.AnonymousClass2.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (((File) FullViewActivity.this.fileArrayList.get(FullViewActivity.this.Position)).delete()) {
                            FullViewActivity.this.deleteFileAA(FullViewActivity.this.Position);
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    /* class bane.instadownloader.videodownload.activity.FullViewActivity.AnonymousClass2.AnonymousClass2 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog create = builder.create();
                create.setTitle("Do you want to delete?");
                create.show();
            }
        });
        imShare.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.activity.FullViewActivity.AnonymousClass3 */

            public void onClick(View view) {
                if (((File) FullViewActivity.this.fileArrayList.get(FullViewActivity.this.Position)).getName().contains(".mp4")) {
                    Log.d("SSSSS", "onClick: " + FullViewActivity.this.fileArrayList.get(FullViewActivity.this.Position) + "");
                    Utils.shareVideo(FullViewActivity.this.activity, ((File) FullViewActivity.this.fileArrayList.get(FullViewActivity.this.Position)).getPath());
                    return;
                }
                Utils.shareImage(FullViewActivity.this.activity, ((File) FullViewActivity.this.fileArrayList.get(FullViewActivity.this.Position)).getPath());
            }
        });
        imWhatsappShare.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.activity.FullViewActivity.AnonymousClass4 */

            public void onClick(View view) {
                if (((File) FullViewActivity.this.fileArrayList.get(FullViewActivity.this.Position)).getName().contains(".mp4")) {
                    Utils.shareImageVideoOnWhatsapp(FullViewActivity.this.activity, ((File) FullViewActivity.this.fileArrayList.get(FullViewActivity.this.Position)).getPath(), true);
                } else {
                    Utils.shareImageVideoOnWhatsapp(FullViewActivity.this.activity, ((File) FullViewActivity.this.fileArrayList.get(FullViewActivity.this.Position)).getPath(), false);
                }
            }
        });
        imClose.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.activity.$$Lambda$FullViewActivity$qJe2eKW5agl1R5DpjAfmVbOPkz0 */

            public final void onClick(View view) {
                FullViewActivity.this.lambda$initViews$0$FullViewActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$initViews$0$FullViewActivity(View view) {
        onBackPressed();
    }

    
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        this.activity = this;
    }

    public void deleteFileAA(int i) {
        this.fileArrayList.remove(i);
        this.showImagesAdapter.notifyDataSetChanged();
        Utils.setToast(this.activity, "File Deleted.");
        if (this.fileArrayList.size() == 0) {
            onBackPressed();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }
    public void setStatusBar() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        } else if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.black));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        } else {
            window.clearFlags(0);
        }
    }
}
