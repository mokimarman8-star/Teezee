package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.t;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e implements com.mbridge.msdk.tracker.network.c {
    @Override // com.mbridge.msdk.tracker.network.c
    public String a(t<?> tVar) {
        String t = tVar.t();
        int g = tVar.g();
        if (g == 0) {
            return t;
        }
        return Integer.toString(g) + '-' + t;
    }
}
