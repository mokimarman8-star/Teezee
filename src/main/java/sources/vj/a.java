package vj;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    private final void a(boolean z, uj.a aVar, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", aVar.j().getValue());
        hashMap.put("module_name", str);
        hashMap.put("game_name", aVar.d());
        String g = aVar.g();
        if (g != null) {
            hashMap.put("game_id", g);
        }
        if (str2 != null) {
            hashMap.put("action_type", str2);
        }
        String h = aVar.h();
        if (h != null) {
            if (z) {
                com.transsion.baselib.helper.a.a.b(h, hashMap);
            } else {
                com.transsion.baselib.helper.a.a.a(h, hashMap);
            }
        }
    }

    static /* synthetic */ void b(a aVar, boolean z, uj.a aVar2, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        aVar.a(z, aVar2, str, str2);
    }

    public final void c(uj.a aVar, String str) {
        Intrinsics.h(aVar, "info");
        Intrinsics.h(str, "pageStyle");
        b(this, false, aVar, str, null, 8, null);
    }

    public final void d(uj.a aVar, String str) {
        Intrinsics.h(aVar, "info");
        Intrinsics.h(str, "pageStyle");
        b(this, true, aVar, str, null, 8, null);
    }

    public final void e(uj.a aVar, String str, String str2) {
        Intrinsics.h(aVar, "info");
        Intrinsics.h(str, "pageStyle");
        Intrinsics.h(str2, "actionType");
        a(true, aVar, str, str2);
    }
}
