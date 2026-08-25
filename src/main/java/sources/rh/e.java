package rh;

import com.blankj.utilcode.util.o;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    public final boolean a() {
        com.transsion.ad.strategy.e.a.c().getBoolean("kv_is_skip_ad", false);
        return true;
    }

    public final void b(List list) {
        Intrinsics.h(list, "strings");
        com.transsion.ad.strategy.e.a.c().putString("member_scene_id_whit_list", o.j(list));
    }

    public final void c(boolean z) {
        com.transsion.ad.strategy.e.a.c().putBoolean("kv_is_skip_ad", true);
    }
}
