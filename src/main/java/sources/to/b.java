package to;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.notification.PullMsgResp;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.PermanentPushResp;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J6\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001a\u00020\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u0002H§@¢\u0006\u0004\b\b\u0010\tJ \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lto/b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "host", "page", "perPage", "Lcom/tn/lib/net/bean/BaseDto;", "Lcom/transsion/push/bean/PermanentPushResp;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/transsion/baselib/db/notification/PullMsgResp;", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ Object a(b bVar, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPermanentPushData");
            }
            if ((i & 1) != 0) {
                str = gg.a.a.a();
            }
            if ((i & 2) != 0) {
                str2 = MsgStyle.CUSTOM_LEFT_PIC;
            }
            if ((i & 4) != 0) {
                str3 = "30";
            }
            return bVar.a(str, str2, str3, continuation);
        }
    }

    @GET("/wefeed-mobile-bff/message/notify-bar/v2")
    Object a(@Query("host") String str, @Query("page") String str2, @Query("perPage") String str3, Continuation<? super BaseDto<PermanentPushResp>> continuation);

    @GET("/wefeed-mobile-bff/message/push/local/list")
    Object b(@Query("host") String str, Continuation<? super BaseDto<PullMsgResp>> continuation);
}
