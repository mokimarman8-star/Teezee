package hv;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.ugcvideodetail.api.bean.UGCVideoList;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.HttpUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J8\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u0002H§@¢\u0006\u0004\b\t\u0010\nJD\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u0002H§@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lhv/c;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "page", HttpUrl.FRAGMENT_ENCODE_SET, "perPage", "host", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoList;", "a", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uid", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ Object a(c cVar, String str, Integer num, String str2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyPublishedVideos");
            }
            if ((i & 4) != 0) {
                str2 = gg.a.a.a();
            }
            return cVar.a(str, num, str2, continuation);
        }

        public static /* synthetic */ Object b(c cVar, String str, String str2, Integer num, String str3, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserPublishedVideos");
            }
            if ((i & 8) != 0) {
                str3 = gg.a.a.a();
            }
            return cVar.b(str, str2, num, str3, continuation);
        }
    }

    @GET("/wefeed-mobile-bff/ugc/video/list/by-my")
    Object a(@Query("page") String str, @Query("perPage") Integer num, @Query("host") String str2, Continuation<? super BaseDto<UGCVideoList>> continuation);

    @GET("/wefeed-mobile-bff/ugc/video/list/by-user")
    Object b(@Query("uid") String str, @Query("page") String str2, @Query("perPage") Integer num, @Query("host") String str3, Continuation<? super BaseDto<UGCVideoList>> continuation);
}
