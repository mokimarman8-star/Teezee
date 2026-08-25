package com.transsion.baselib.kids;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/transsion/baselib/kids/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "host", "Lokhttp3/RequestBody;", "body", "Lcom/transsion/baselib/kids/ConsumeJudgeResponse;", "a", "(Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {

    /* renamed from: com.transsion.baselib.kids.a$a, reason: collision with other inner class name */
    public static final class C0016a {
        public static /* synthetic */ Object a(a aVar, String str, RequestBody requestBody, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: consumeJudge");
            }
            if ((i & 1) != 0) {
                str = gg.a.a.a();
            }
            return aVar.a(str, requestBody, continuation);
        }
    }

    @POST("/wefeed-mobile-bff/profile/consume-judge")
    Object a(@Query("host") String str, @Body RequestBody requestBody, Continuation<? super ConsumeJudgeResponse> continuation);
}
