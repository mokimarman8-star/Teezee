package hn;

import com.transsion.push.bean.MsgStyle;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import qi.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final void a(String str, String str2, String str3, boolean z) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        h hVar = h.a;
        if (str == null) {
            str = hVar.h();
        }
        hVar.o(str, MapsKt.l(new Pair[]{new Pair("module_name", "play_screen"), new Pair("subject_id", str2), new Pair("ops", str3), new Pair("type", z ? MsgStyle.CUSTOM_LEFT_PIC : "0")}));
    }
}
