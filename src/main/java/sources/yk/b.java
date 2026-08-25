package yk;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.CategoryBean;
import com.transsion.home.bean.FilmListResponse;
import com.transsion.home.bean.HomePreferencesList;
import com.transsion.home.bean.HomePreferencesSubmitRequest;
import com.transsion.home.bean.PlayListResp;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\b\u0010\tJf\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\nH§@¢\u0006\u0004\b\u0013\u0010\u0014J>\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\nH§@¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\b\b\u0003\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lyk/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "host", "Lokhttp3/RequestBody;", "request", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/home/bean/CategoryBean;", "c", "(Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "page", "perPage", "label", "category", "recType", "topIds", "tabId", "Lcom/transsion/home/bean/PlayListResp;", "d", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "type", "Lcom/transsion/home/bean/FilmListResponse;", "b", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/transsion/home/bean/HomePreferencesList;", "e", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/transsion/home/bean/HomePreferencesSubmitRequest;", "body", "a", "(Ljava/lang/String;Lcom/transsion/home/bean/HomePreferencesSubmitRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ Object a(b bVar, String str, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHomePreferencesConfig");
            }
            if ((i & 1) != 0) {
                str = gg.a.a.a();
            }
            return bVar.e(str, continuation);
        }

        public static /* synthetic */ Object b(b bVar, String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, Continuation continuation, int i4, Object obj) {
            if (obj == null) {
                return bVar.d((i4 & 1) != 0 ? gg.a.a.a() : str, i, i2, str2, str3, str4, str5, i3, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPlayList");
        }

        public static /* synthetic */ Object c(b bVar, String str, HomePreferencesSubmitRequest homePreferencesSubmitRequest, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submitHomePreferences");
            }
            if ((i & 1) != 0) {
                str = gg.a.a.a();
            }
            return bVar.a(str, homePreferencesSubmitRequest, continuation);
        }
    }

    @POST("/wefeed-mobile-bff/profile/preference-submit")
    Object a(@Query("host") String str, @Body HomePreferencesSubmitRequest homePreferencesSubmitRequest, Continuation<? super BaseDto<Object>> continuation);

    @GET("/wefeed-mobile-bff/ugc/operating/genre-top")
    Object b(@Query("host") String str, @Query("type") String str2, @Query("page") int i, @Query("perPage") int i2, Continuation<? super BaseDto<FilmListResponse>> continuation);

    @POST("wefeed-mobile-bff/subject-api/genre-top")
    Object c(@Query("host") String str, @Body RequestBody requestBody, Continuation<? super BaseDto<CategoryBean>> continuation);

    @GET("/wefeed-mobile-bff/playlist/content")
    Object d(@Query("host") String str, @Query("page") int i, @Query("perPage") int i2, @Query("label") String str2, @Query("category") String str3, @Query("recType") String str4, @Query("topIds") String str5, @Query("tabId") int i3, Continuation<? super BaseDto<PlayListResp>> continuation);

    @GET("/wefeed-mobile-bff/profile/preference-options")
    Object e(@Query("host") String str, Continuation<? super BaseDto<HomePreferencesList>> continuation);
}
