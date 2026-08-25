package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class i0 {
    private String a;

    i0() {
    }

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? TtmlNode.ANONYMOUS_REGION_ID : installerPackageName;
    }

    synchronized String a(Context context) {
        try {
            if (this.a == null) {
                this.a = b(context);
            }
        } finally {
        }
        return TtmlNode.ANONYMOUS_REGION_ID.equals(this.a) ? null : this.a;
    }
}
