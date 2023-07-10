package bane.instadownloader.videodownload.api;

import com.google.gson.JsonObject;
import bane.instadownloader.videodownload.model.story.FullDetailModel;
import bane.instadownloader.videodownload.model.story.StoryModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface APIServices {
    @GET
    Observable<JsonObject> callResult(@Url String str, @Header("Cookie") String str2, @Header("User-Agent") String str3);

    @GET
    Observable<FullDetailModel> getFullDetailInfoApi(@Url String str, @Header("Cookie") String str2, @Header("User-Agent") String str3);

    @GET
    Observable<StoryModel> getStoriesApi(@Url String str, @Header("Cookie") String str2, @Header("User-Agent") String str3);
}
