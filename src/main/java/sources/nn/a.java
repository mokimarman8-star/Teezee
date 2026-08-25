package nn;

import com.transsion.player.p003enum.PlayMimeType;
import com.transsion.push.bean.MsgStyle;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ln.c;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();
    private static boolean b;

    private a() {
    }

    public final String a(ln.a aVar) {
        Intrinsics.h(aVar, "bean");
        if (aVar.v() == PlayMimeType.DASH) {
            return MsgStyle.NATIVE_STANDARD;
        }
        if (aVar.v() == PlayMimeType.HLS) {
            return aVar.w() ? MsgStyle.CUSTOM_LEFT_PIC_EMOJI : "6";
        }
        c cVar = (c) CollectionsKt.k0(aVar.j());
        return (cVar == null || !cVar.j()) ? "0" : MsgStyle.CUSTOM_BUTTON;
    }

    public final boolean b() {
        return b;
    }

    public final void c(boolean z) {
        b = z;
    }
}
