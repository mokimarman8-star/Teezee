package com.transsion.transfer.impl;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l {
    public static final l a = new l();
    private static String b = HttpUrl.FRAGMENT_ENCODE_SET;

    private l() {
    }

    public final String a() {
        return b;
    }

    public final void b(String str) {
        Intrinsics.h(str, "<set-?>");
        b = str;
    }
}
