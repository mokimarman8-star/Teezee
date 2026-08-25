package ev;

import android.text.TextUtils;
import ci.p;
import com.tencent.mmkv.MMKV;
import kotlin.Result;
import kotlin.Result$Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mg.a;
import okhttp3.HttpUrl;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final String a() {
        MMKV c = mg.a.a.c();
        if (c != null) {
            return c.getString("key_user_agent", HttpUrl.FRAGMENT_ENCODE_SET);
        }
        return null;
    }

    public final void b() {
        try {
            Result$Companion result$Companion = Result.Companion;
            a.a aVar = mg.a.a;
            MMKV c = aVar.c();
            Object obj = null;
            String string = c != null ? c.getString("key_custom_date", HttpUrl.FRAGMENT_ENCODE_SET) : null;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (Intrinsics.c(p.a.c(), string)) {
                a.a.g(wf.a.a, "AdDeveloperUtil --> 特殊权限已授予", false, 2, (Object) null);
                obj = Unit.a;
            } else {
                a.a.g(wf.a.a, "AdDeveloperUtil --> 特殊权限授权已过期", false, 2, (Object) null);
                MMKV c2 = aVar.c();
                if (c2 != null) {
                    c2.putString("sp_code", HttpUrl.FRAGMENT_ENCODE_SET);
                }
                MMKV c3 = aVar.c();
                if (c3 != null) {
                    c3.putString("custom_local_iso", HttpUrl.FRAGMENT_ENCODE_SET);
                }
                MMKV c4 = aVar.c();
                if (c4 != null) {
                    c4.putString("custom_local_country", HttpUrl.FRAGMENT_ENCODE_SET);
                }
                MMKV c5 = aVar.c();
                if (c5 != null) {
                    obj = c5.putString("custom_country_code", HttpUrl.FRAGMENT_ENCODE_SET);
                }
            }
            Result.constructor-impl(obj);
        } catch (Throwable th) {
            Result$Companion result$Companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
    }

    public final void c(String customDate) {
        Intrinsics.h(customDate, "customDate");
        MMKV c = mg.a.a.c();
        if (c != null) {
            c.putString("key_custom_date", customDate);
        }
    }

    public final void d(String str) {
        MMKV c = mg.a.a.c();
        if (c != null) {
            c.putString("key_user_agent", str);
        }
    }
}
