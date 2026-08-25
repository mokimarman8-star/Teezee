package zh;

import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.c;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.ps.activate.PsActivateDto;
import com.transsion.ad.ps.model.PsLinkDto;
import com.transsion.gslb.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import yg.l;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lzh/a;", BuildConfig.FLAVOR, "Lokhttp3/RequestBody;", "request", BuildConfig.FLAVOR, "url", "Lcom/transsion/ad/ps/model/PsLinkDto;", "b", "(Lokhttp3/RequestBody;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/transsion/ad/ps/activate/PsActivateDto;", "a", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {

    /* renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.a;

    /* renamed from: zh.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();

        private Companion() {
        }

        public final Map a(long j) {
            String str;
            String string;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String a2 = wg.a.a.a("Transsion" + j);
            linkedHashMap.put("curClientVersionCode", Long.valueOf(b.a.i()));
            linkedHashMap.put("channel", "Transsion");
            linkedHashMap.put("brand", Build.BRAND);
            linkedHashMap.put("timestamp", Long.valueOf(j));
            linkedHashMap.put("sign", a2);
            tg.b bVar = tg.b.a;
            linkedHashMap.put("gaid", bVar.i());
            linkedHashMap.put("systemVersionCode", Integer.valueOf(Build.VERSION.SDK_INT));
            linkedHashMap.put("netType", l.a.d());
            linkedHashMap.put("lan", bVar.j());
            MMKV c = mg.a.a.c();
            String str2 = null;
            if (c == null || (string = c.getString("custom_local_iso", BuildConfig.FLAVOR)) == null) {
                str = null;
            } else {
                str = string.toUpperCase(Locale.ROOT);
                Intrinsics.g(str, "toUpperCase(...)");
            }
            if (TextUtils.isEmpty(str)) {
                String g = bVar.g();
                if (g != null) {
                    str2 = g.toUpperCase(Locale.ROOT);
                    Intrinsics.g(str2, "toUpperCase(...)");
                }
                str = str2;
            }
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            linkedHashMap.put("countyrCode", str);
            linkedHashMap.put("ua", Build.MODEL);
            linkedHashMap.put("curVersionName", c.h());
            linkedHashMap.put("cpu", bVar.e());
            linkedHashMap.put("android_version", bVar.n());
            linkedHashMap.put("imei", BuildConfig.FLAVOR);
            linkedHashMap.put("imsi", BuildConfig.FLAVOR);
            linkedHashMap.put("sessionID", BuildConfig.FLAVOR);
            linkedHashMap.put("lastPage", BuildConfig.FLAVOR);
            linkedHashMap.put("curPage", BuildConfig.FLAVOR);
            linkedHashMap.put("shareChannel", BuildConfig.FLAVOR);
            linkedHashMap.put("platform", BuildConfig.FLAVOR);
            return linkedHashMap;
        }
    }

    @POST("/distribute/active/mb")
    Object a(@Body RequestBody requestBody, @Header("multiple_base_url") String str, Continuation<? super PsActivateDto> continuation);

    @POST("/distribute/candidate")
    Object b(@Body RequestBody requestBody, @Header("multiple_base_url") String str, Continuation<? super PsLinkDto> continuation);
}
