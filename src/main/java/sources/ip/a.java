package ip;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.flow.bean.PostSubjectBean;
import com.transsion.flow.bean.RoomBean;
import com.transsion.flow.bean.RoomFilterClasses;
import com.transsion.flow.bean.RoomItem;
import com.transsion.flow.bean.RoomNet;
import com.transsion.flow.bean.RoomTabBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.bean.CheckNameBean;
import io.reactivex.rxjava3.core.j;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J9\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\n\u0010\u000bJC\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0014\u0010\u0013J/\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0002H'¢\u0006\u0004\b\u0017\u0010\u0018J9\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u00022\b\b\u0003\u0010\u001a\u001a\u00020\u0005H'¢\u0006\u0004\b\u001c\u0010\u000bJ/\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u001d\u0010\u0013J/\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u001e\u0010\u0013JR\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010 \u001a\u00020\u00052\b\b\u0001\u0010!\u001a\u00020\u00022\b\b\u0001\u0010#\u001a\u00020\"H§@¢\u0006\u0004\b%\u0010&JV\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u001a\u001a\u00020\u00052\b\b\u0003\u0010'\u001a\u00020\u0005H§@¢\u0006\u0004\b(\u0010)J*\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0004\b*\u0010+J*\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0004\b-\u0010+J*\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0004\b.\u0010+J*\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0004\b/\u0010+J*\u00102\u001a\b\u0012\u0004\u0012\u0002010\b2\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00100\u001a\u00020\u0002H§@¢\u0006\u0004\b2\u00103¨\u00064"}, d2 = {"Lip/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "host", "page", BuildConfig.FLAVOR, "count", "Lio/reactivex/rxjava3/core/j;", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/moviedetailapi/bean/RoomBean;", "f", "(Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/j;", "userId", "o", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lio/reactivex/rxjava3/core/j;", "Lokhttp3/RequestBody;", "request", "Lcom/transsion/moviedetailapi/bean/RoomNet;", "g", "(Ljava/lang/String;Lokhttp3/RequestBody;)Lio/reactivex/rxjava3/core/j;", "b", "name", "Lcom/transsion/room/bean/CheckNameBean;", "e", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/j;", "groupId", "userAvatarNum", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "n", "i", "k", "id", "perPage", "rankType", BuildConfig.FLAVOR, "with", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", "j", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postNum", "d", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "(Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/transsion/moviedetailapi/bean/RoomFilterClasses;", "a", "l", "m", "version", "Lcom/transsion/moviedetailapi/bean/RoomTabBean;", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {

    /* renamed from: ip.a$a, reason: collision with other inner class name */
    public static final class C0077a {
        public static /* synthetic */ Object a(a aVar, String str, String str2, int i, String str3, int i2, int i3, Continuation continuation, int i4, Object obj) {
            if (obj == null) {
                return aVar.d(str, str2, i, str3, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 1 : i3, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyRoomsList");
        }

        public static /* synthetic */ j b(a aVar, String str, String str2, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRoomDetail");
            }
            if ((i2 & 4) != 0) {
                i = 8;
            }
            return aVar.n(str, str2, i);
        }

        public static /* synthetic */ Object c(a aVar, String str, String str2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRoomTabs");
            }
            if ((i & 1) != 0) {
                str = gg.a.a.a();
            }
            return aVar.c(str, str2, continuation);
        }
    }

    @POST("wefeed-mobile-bff/group/class")
    Object a(@Query("host") String str, @Body RequestBody requestBody, Continuation<? super BaseDto<RoomFilterClasses>> continuation);

    @POST("/wefeed-mobile-bff/group/update")
    j<BaseDto<RoomNet>> b(@Query("host") String host, @Body RequestBody request);

    @GET("/wefeed-mobile-bff/community/tab")
    Object c(@Query("host") String str, @Query("version") String str2, Continuation<? super BaseDto<RoomTabBean>> continuation);

    @GET("/wefeed-mobile-bff/group/list/my/v2")
    Object d(@Query("host") String str, @Query("page") String str2, @Query("perPage") int i, @Query("userId") String str3, @Query("userAvatarNum") int i2, @Query("postNum") int i3, Continuation<? super BaseDto<RoomBean>> continuation);

    @GET("/wefeed-mobile-bff/group/exist")
    j<BaseDto<CheckNameBean>> e(@Query("host") String host, @Query("name") String name);

    @GET("/wefeed-mobile-bff/group/rank")
    j<BaseDto<RoomBean>> f(@Query("host") String host, @Query("page") String page, @Query("perPage") int count);

    @POST("/wefeed-mobile-bff/group/create")
    j<BaseDto<RoomNet>> g(@Query("host") String host, @Body RequestBody request);

    @POST("/wefeed-mobile-bff/group/list/community-entrance")
    Object h(@Query("host") String str, @Body RequestBody requestBody, Continuation<? super BaseDto<RoomBean>> continuation);

    @POST("/wefeed-mobile-bff/group/join")
    j<BaseDto<RoomNet>> i(@Query("host") String host, @Body RequestBody request);

    @GET("/wefeed-mobile-bff/post/list/group")
    Object j(@Query("host") String str, @Query("id") String str2, @Query("page") String str3, @Query("perPage") int i, @Query("type") String str4, @Query("with") boolean z, Continuation<? super BaseDto<PostSubjectBean>> continuation);

    @POST("/wefeed-mobile-bff/group/leave")
    j<BaseDto<RoomNet>> k(@Query("host") String host, @Body RequestBody request);

    @POST("/wefeed-mobile-bff/group/list/class")
    Object l(@Query("host") String str, @Body RequestBody requestBody, Continuation<? super BaseDto<RoomBean>> continuation);

    @POST("/wefeed-mobile-bff/group/visit")
    Object m(@Query("host") String str, @Body RequestBody requestBody, Continuation<? super BaseDto<String>> continuation);

    @GET("/wefeed-mobile-bff/group/get")
    j<BaseDto<RoomItem>> n(@Query("host") String host, @Query("groupId") String groupId, @Query("userAvatarNum") int userAvatarNum);

    @GET("/wefeed-mobile-bff/group/list/user")
    j<BaseDto<RoomBean>> o(@Query("host") String host, @Query("page") String page, @Query("perPage") int count, @Query("userId") String userId);
}
