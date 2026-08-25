package pp;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.room.sub.bean.subscription.SubscriptionFeedBean;
import com.transsion.room.sub.bean.subscription.SubscriptionStatsBean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0004\b\t\u0010\nJ*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u0002H§@¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lpp/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "host", "cursor", BuildConfig.FLAVOR, "limit", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/room/sub/bean/subscription/SubscriptionFeedBean;", "b", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uid", "Lcom/transsion/room/sub/bean/subscription/SubscriptionStatsBean;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {
    @GET("/wefeed-mobile-bff/subscription/stats")
    Object a(@Query("host") String str, @Query("uid") String str2, Continuation<? super BaseDto<SubscriptionStatsBean>> continuation);

    @GET("/wefeed-mobile-bff/subscription/feed")
    Object b(@Query("host") String str, @Query("cursor") String str2, @Query("limit") int i, Continuation<? super BaseDto<SubscriptionFeedBean>> continuation);
}
