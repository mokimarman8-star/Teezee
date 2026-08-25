package com.tn.lib.net.interceptor;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a implements HttpLoggingInterceptor$a {
    private String c = "HttpLogInterceptor";

    @Override // com.tn.lib.net.interceptor.HttpLoggingInterceptor$a
    public void log(String str) {
        Intrinsics.h(str, PglCryptUtils.KEY_MESSAGE);
        a.C0158a.f(wf.a.a, this.c, str, false, 4, null);
    }
}
