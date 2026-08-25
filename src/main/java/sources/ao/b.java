package ao;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.flow.bean.PostSubjectBean;
import com.transsion.flow.bean.ShortTVRespData;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\tH§@¢\u0006\u0004\b\f\u0010\rJJ\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0012\u0010\u0013J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\tH§@¢\u0006\u0004\b\u0014\u0010\rJ*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\tH§@¢\u0006\u0004\b\u0015\u0010\rJ4\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0003\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lao/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "host", "postId", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/RequestBody;", "request", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", "d", "(Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "page", BuildConfig.FLAVOR, "perPage", "pageFrom", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "b", "Lcom/transsion/moviedetailapi/bean/ShortTVRespData;", "c", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface b {
    @GET("/wefeed-mobile-bff/post/get")
    Object a(@Query("host") String str, @Query("postId") String str2, Continuation<? super BaseDto<PostSubjectItem>> continuation);

    @POST("/wefeed-mobile-bff/post/delete")
    Object b(@Query("host") String str, @Body RequestBody requestBody, Continuation<? super BaseDto<String>> continuation);

    @GET("/wefeed-mobile-bff/shorts/favorite-list")
    Object c(@Query("host") String str, @Query("page") String str2, @Query("perPage") int i, Continuation<? super BaseDto<ShortTVRespData>> continuation);

    @POST("/wefeed-mobile-bff/post/list/immersive")
    Object d(@Query("host") String str, @Body RequestBody requestBody, Continuation<? super BaseDto<PostSubjectBean>> continuation);

    @GET("/wefeed-mobile-bff/post/list/immersive/v2")
    Object e(@Query("host") String str, @Query("postId") String str2, @Query("page") String str3, @Query("perPage") int i, @Query("pageFrom") String str4, Continuation<? super BaseDto<PostSubjectBean>> continuation);

    @POST("/wefeed-mobile-bff/post/list/correlation")
    Object f(@Query("host") String str, @Body RequestBody requestBody, Continuation<? super BaseDto<PostSubjectBean>> continuation);
}
