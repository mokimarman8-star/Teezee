package com.transsion.lib_web.download_render.utils;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    public final String a(String str) {
        Intrinsics.h(str, "url");
        String uri = Uri.parse(str).buildUpon().clearQuery().build().toString();
        Intrinsics.g(uri, "toString(...)");
        return uri;
    }
}
