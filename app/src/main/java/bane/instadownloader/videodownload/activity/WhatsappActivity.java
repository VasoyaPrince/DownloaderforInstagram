package bane.instadownloader.videodownload.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import bane.instadownloader.videodownload.R;
import bane.instadownloader.videodownload.databinding.ActivityWhatsappBinding;
import bane.instadownloader.videodownload.fragment.WhatsappImageFragment;
import bane.instadownloader.videodownload.fragment.WhatsappVideoFragment;
import bane.instadownloader.videodownload.util.AdsUtils;
import bane.instadownloader.videodownload.util.Utils;
import java.util.ArrayList;
import java.util.List;

public class WhatsappActivity extends AppCompatActivity {
    private WhatsappActivity activity;
    private ActivityWhatsappBinding binding;

    
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ActivityWhatsappBinding) DataBindingUtil.setContentView(this, R.layout.activity_whatsapp);
        this.activity = this;
        Utils.createFileFolder();
        initViews();
        AdsUtils.showGoogleBannerAd(this, this.binding.adView);
    }

    
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        this.activity = this;
    }

    private void initViews() {
        setupViewPager(this.binding.viewpager);
        this.binding.tabs.setupWithViewPager(this.binding.viewpager);
        this.binding.imBack.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.activity.WhatsappActivity.AnonymousClass1 */

            public void onClick(View view) {
                WhatsappActivity.this.onBackPressed();
            }
        });
        for (int i = 0; i < this.binding.tabs.getTabCount(); i++) {
            this.binding.tabs.getTabAt(i).setCustomView((TextView) LayoutInflater.from(this.activity).inflate(R.layout.custom_tab, (ViewGroup) null));
        }
        this.binding.LLOpenWhatsapp.setOnClickListener(new View.OnClickListener() {
            /* class bane.instadownloader.videodownload.activity.$$Lambda$WhatsappActivity$2mKtemxD6hv8B_i0QGqxwoyFjEQ */

            public final void onClick(View view) {
                WhatsappActivity.this.lambda$initViews$0$WhatsappActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$initViews$0$WhatsappActivity(View view) {
        Utils.OpenApp(this.activity, "com.whatsapp");
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.activity.getSupportFragmentManager(), 1);
        viewPagerAdapter.addFragment(new WhatsappImageFragment(), "Images");
        viewPagerAdapter.addFragment(new WhatsappVideoFragment(), "Videos");
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(1);
    }

     
    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList();
        private final List<String> mFragmentTitleList = new ArrayList();

        ViewPagerAdapter(FragmentManager fragmentManager, int i) {
            super(fragmentManager, i);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.mFragmentList.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragmentList.size();
        }

         
        public void addFragment(Fragment fragment, String str) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(str);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.mFragmentTitleList.get(i);
        }
    }
}
