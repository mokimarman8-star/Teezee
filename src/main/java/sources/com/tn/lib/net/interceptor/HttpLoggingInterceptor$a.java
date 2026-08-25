package com.tn.lib.net.interceptor;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public interface HttpLoggingInterceptor$a {
    public static final a a = a.a;
    public static final HttpLoggingInterceptor$a b = new a.C0137a();

    public static final class a {
        static final /* synthetic */ a a = new a();

        /* renamed from: com.tn.lib.net.interceptor.HttpLoggingInterceptor$a$a$a, reason: collision with other inner class name */
        private static final class C0137a implements HttpLoggingInterceptor$a {
            @Override // com.tn.lib.net.interceptor.HttpLoggingInterceptor$a
            public void log(String str) {
                Intrinsics.h(str, PglCryptUtils.KEY_MESSAGE);
                Platform.log$default(Platform.Companion.get(), str, 0, (Throwable) null, 6, (Object) null);
            }
        }

        private a() {
        }
    }

    void log(String str);
}
