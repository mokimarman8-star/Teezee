package com.cloud.hisavana.net.impl;

import okhttp3.Headers;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public interface IHttpCallback {
    void a();

    void b();

    void c(int i, byte[] bArr);

    void d(int i, byte[] bArr, Throwable th);

    void e(int i, byte[] bArr, String str);

    void f(int i, byte[] bArr, Headers headers);
}
