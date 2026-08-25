package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.tracker.network.t;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d {
    public static String a(String str, t<?> tVar) {
        if (TextUtils.isEmpty(str) || tVar == null) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        byte[] b = tVar.b();
        if (b == null || b.length == 0) {
            return str;
        }
        if (str.endsWith("?")) {
            return str + new String(b);
        }
        return str + "?" + new String(b);
    }
}
