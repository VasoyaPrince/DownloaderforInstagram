package bane.instadownloader.videodownload.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;

import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.fragment.InstaDownloadedFragment;
import bane.instadownloader.videodownload.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    GalleryActivity activity;
    // ActivityGalleryBinding binding;

    RelativeLayout RLTab;
    RelativeLayout RLTop;
    RelativeLayout RLTopLayout;
    TextView TVTitle;
    AdView adView;
    ImageView imBack;
    TabLayout tabs;
    ViewPager viewpager;

    
    @Override

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //ActivityGalleryBinding activityGalleryBinding = (ActivityGalleryBinding) DataBindingUtil.setContentView(this, R.layout.activity_gallery);
        setContentView((int) R.layout.activity_gallery);
        setStatusBar();


        RLTab = findViewById(R.id.RLTab);
        RLTop = findViewById(R.id.RLTop);
        RLTopLayout = findViewById(R.id.RLTopLayout);
        TVTitle = findViewById(R.id.TVTitle);
        imBack = findViewById(R.id.imBack);
        tabs = findViewById(R.id.tabs);
        viewpager = findViewById(R.id.viewpager);

        //   this.binding = activityGalleryBinding;
        this.activity = this;
//        AdsUtils.showGoogleBannerAd(this, activityGalleryBinding.adView);
        initViews();
    }

    public void initViews() {
        setupViewPager(viewpager);
        tabs.setupWithViewPager(viewpager);
        imBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GalleryActivity.this.onBackPressed();
            }
        });
        for (int i = 0; i < tabs.getTabCount(); i++) {
            tabs.getTabAt(i).setCustomView((TextView) LayoutInflater.from(this.activity).inflate(R.layout.custom_tab, (ViewGroup) null));
        }
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
       
            @Override 
            public void onPageScrollStateChanged(int i) {
            }

            @Override 
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override
            public void onPageSelected(int i) {
            }
        });
        Utils.createFileFolder();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.activity.getSupportFragmentManager(), 1);
        viewPagerAdapter.addFragment(new InstaDownloadedFragment(), "Instagram");
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(4);
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList();
        private final List<String> mFragmentTitleList = new ArrayList();

        ViewPagerAdapter(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        @Override
        public Fragment getItem(int i) {
            return this.mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return this.mFragmentList.size();
        }

         
        public void addFragment(Fragment fragment, String str) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(str);
        }

        @Override
        public CharSequence getPageTitle(int i) {
            return this.mFragmentTitleList.get(i);
        }
    }

    public void setStatusBar() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 23) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.color_background));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.color_background));
        } else if (Build.VERSION.SDK_INT == 21 || Build.VERSION.SDK_INT == 22) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.color_background));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.color_background));
        } else {
            window.clearFlags(0);
        }
    }
}
