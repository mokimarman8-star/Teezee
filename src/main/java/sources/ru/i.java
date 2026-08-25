package ru;

import com.transsion.upgradesdk.bean.UpgradeData;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u000b\u0010\nJ/\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lru/i;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "pkgName", HttpUrl.FRAGMENT_ENCODE_SET, "timestamp", "Lretrofit2/d;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/transsion/upgradesdk/bean/UpgradeData;", "c", "(Ljava/lang/String;J)Lretrofit2/d;", "a", "b", "upgradesdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface i {
    @GET("appUpgradeInd/{pkgName}.json")
    retrofit2.d<List<UpgradeData>> a(@Path("pkgName") String pkgName, @Query("timestamp") long timestamp);

    @GET("appUpgradeEE1/{pkgName}.json")
    retrofit2.d<List<UpgradeData>> b(@Path("pkgName") String pkgName, @Query("timestamp") long timestamp);

    @GET("appUpgrade/{pkgName}.json")
    retrofit2.d<List<UpgradeData>> c(@Path("pkgName") String pkgName, @Query("timestamp") long timestamp);
}
