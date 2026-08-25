package tu;

import android.content.Context;
import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i {
    public static final h b = new h();
    public static volatile i c;
    public final MMKV a;

    public i(Context context) {
        try {
            MMKV.C(context);
            this.a = MMKV.o();
        } catch (Throwable unused) {
        }
    }

    public final String a(String key, String defaultValue) {
        Intrinsics.h(key, "key");
        Intrinsics.h(defaultValue, "defaultValue");
        MMKV mmkv = this.a;
        String l = mmkv != null ? mmkv.l(key, defaultValue) : null;
        return l == null ? defaultValue : l;
    }

    public final void b(String key, String value) {
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        MMKV mmkv = this.a;
        if (mmkv != null) {
            mmkv.v(key, value);
        }
    }
}
