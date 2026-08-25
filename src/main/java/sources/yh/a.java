package yh;

import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J<\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lyh/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "url", "version", "versionAdScene", BuildConfig.FLAVOR, "withAdScene", "Lcom/transsion/ad/monopoly/model/MbAdPlansDto;", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {

    /* renamed from: yh.a$a, reason: collision with other inner class name */
    public static final class C0104a {
        public static /* synthetic */ Object a(a aVar, String str, String str2, String str3, boolean z, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAdConfig");
            }
            if ((i & 8) != 0) {
                z = true;
            }
            return aVar.a(str, str2, str3, z, continuation);
        }
    }

    @GET
    Object a(@Url String str, @Query("version") String str2, @Query("versionAdScene") String str3, @Query("withAdScene") boolean z, Continuation<? super MbAdPlansDto> continuation);
}
