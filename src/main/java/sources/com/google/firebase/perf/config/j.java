package com.google.firebase.perf.config;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class j extends u {
    private static j a;

    protected j() {
    }

    protected static synchronized j e() {
        j jVar;
        synchronized (j.class) {
            try {
                if (a == null) {
                    a = new j();
                }
                jVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    @Override // com.google.firebase.perf.config.u
    protected String a() {
        return "com.google.firebase.perf.SdkDisabledVersions";
    }

    @Override // com.google.firebase.perf.config.u
    protected String c() {
        return "fpr_disabled_android_versions";
    }

    protected String d() {
        return TtmlNode.ANONYMOUS_REGION_ID;
    }
}
