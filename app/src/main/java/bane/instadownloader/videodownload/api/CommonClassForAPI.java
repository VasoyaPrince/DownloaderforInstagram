package bane.instadownloader.videodownload.api;

import android.app.Activity;
import android.util.Log;

import com.google.gson.JsonObject;
import bane.instadownloader.videodownload.model.story.FullDetailModel;
import bane.instadownloader.videodownload.model.story.StoryModel;
import bane.instadownloader.videodownload.util.Utils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CommonClassForAPI {
    private static CommonClassForAPI CommonClassForAPI;
    private static Activity mActivity;

    public static CommonClassForAPI getInstance(Activity activity) {
        if (CommonClassForAPI == null) {
            CommonClassForAPI = new CommonClassForAPI();
        }
        mActivity = activity;
        return CommonClassForAPI;
    }

    public void callResult(final DisposableObserver disposableObserver, String str, String str2) {
        if (Utils.isNullOrEmpty(str2)) {
            str2 = "";
        }
        RestClient.getInstance(mActivity).getService().callResult(str, str2, "Instagram 9.5.2 (iPhone7,2; iPhone OS 9_3_3; en_US; en-US; scale=2.00; 750x1334) AppleWebKit/420+").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<JsonObject>() {

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(JsonObject jsonObject) {
                disposableObserver.onNext(jsonObject);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                disposableObserver.onError(th);
                Log.e("Error",th.toString());
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                disposableObserver.onComplete();
            }
        });
    }

    public void getStories(final DisposableObserver disposableObserver, String str) {
        if (Utils.isNullOrEmpty(str)) {
            str = "";
        }
        RestClient.getInstance(mActivity).getService().getStoriesApi("https://i.instagram.com/api/v1/feed/reels_tray/", str, "\"Instagram 9.5.2 (iPhone7,2; iPhone OS 9_3_3; en_US; en-US; scale=2.00; 750x1334) AppleWebKit/420+\"").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<StoryModel>() {

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(StoryModel storyModel) {
                disposableObserver.onNext(storyModel);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                disposableObserver.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                disposableObserver.onComplete();
            }
        });
    }

    public void getFullDetailFeed(final DisposableObserver disposableObserver, String str, String str2) {
        APIServices service = RestClient.getInstance(mActivity).getService();
        service.getFullDetailInfoApi("https://i.instagram.com/api/v1/users/" + str + "/full_detail_info?max_id=", str2, "\"Instagram 9.5.2 (iPhone7,2; iPhone OS 9_3_3; en_US; en-US; scale=2.00; 750x1334) AppleWebKit/420+\"").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<FullDetailModel>() {
            /* class bane.instadownloader.videodownload.api.CommonClassForAPI.AnonymousClass3 */

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            public void onNext(FullDetailModel fullDetailModel) {
                disposableObserver.onNext(fullDetailModel);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                disposableObserver.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                disposableObserver.onComplete();
            }
        });
    }
}
