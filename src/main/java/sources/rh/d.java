package rh;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class d {
    public static final d a = new d();
    private static String b = TtmlNode.ANONYMOUS_REGION_ID;

    private d() {
    }

    public final String a() {
        return b;
    }

    public final void b(String str) {
        Intrinsics.h(str, "sceneId");
        b = str;
    }
}
