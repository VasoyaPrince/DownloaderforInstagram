package bane.instadownloader.videodownload.util;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class AdsUtils {
    public static void showGoogleBannerAd(Context context, AdView adView) {
        adView.setVisibility(0);
        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            /* class bane.instadownloader.videodownload.util.AdsUtils.AnonymousClass1 */

            @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adView.loadAd(new AdRequest.Builder().build());
    }
}
