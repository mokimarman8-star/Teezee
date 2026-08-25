package gk;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import io.reactivex.rxjava3.core.j;
import kotlin.Metadata;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00070\u00062\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lgk/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "host", "Lokhttp3/RequestBody;", "body", "Lio/reactivex/rxjava3/core/j;", "Lcom/tn/lib/net/bean/BaseDto;", "a", "(Ljava/lang/String;Lokhttp3/RequestBody;)Lio/reactivex/rxjava3/core/j;", "Fission_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {

    /* renamed from: gk.a$a, reason: collision with other inner class name */
    public static final class C0071a {
        public static /* synthetic */ j a(a aVar, String str, RequestBody requestBody, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fissionBingInvitationCode");
            }
            if ((i & 1) != 0) {
                str = gg.a.a.a();
            }
            return aVar.a(str, requestBody);
        }
    }

    @POST("/wefeed-mobile-bff/activity/fission/bind")
    j<BaseDto<Object>> a(@Query("host") String host, @Body RequestBody body);
}
