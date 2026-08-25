package com.google.firebase.perf.session.gauges;

import com.google.firebase.perf.v1.ApplicationProcessState;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
/* synthetic */ class GaugeManager$a {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ApplicationProcessState.values().length];
        a = iArr;
        try {
            iArr[ApplicationProcessState.BACKGROUND.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[ApplicationProcessState.FOREGROUND.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
