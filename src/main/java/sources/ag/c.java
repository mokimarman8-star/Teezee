package ag;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c {
    public static final c a = new c();
    private static MMKV b;

    private c() {
    }

    public final String a(String str, String str2) {
        String string;
        Intrinsics.h(str, "key");
        Intrinsics.h(str2, "defaultValue");
        if (b == null) {
            b = MMKV.I("mmkv_net");
        }
        MMKV mmkv = b;
        return (mmkv == null || (string = mmkv.getString(str, str2)) == null) ? str2 : string;
    }

    public final void b(String str, String str2) {
        Intrinsics.h(str, "key");
        Intrinsics.h(str2, "value");
        if (b == null) {
            b = MMKV.I("mmkv_net");
        }
        MMKV mmkv = b;
        if (mmkv != null) {
            mmkv.putString(str, str2);
        }
    }
}
