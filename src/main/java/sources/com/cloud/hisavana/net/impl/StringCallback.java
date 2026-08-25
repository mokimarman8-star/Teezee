package com.cloud.hisavana.net.impl;

import okhttp3.Headers;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class StringCallback extends HttpCallbackImpl {
    protected StringCallback() {
    }

    public StringCallback(boolean z) {
        super(z);
    }

    public static String w(byte[] bArr, String str) {
        String str2 = bArr == null ? null : new String(bArr, str);
        if (str2 == null) {
            return str2;
        }
        try {
            return str2.startsWith("\ufeff") ? str2.substring(1) : str2;
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
    public void i(final int i, byte[] bArr, final Throwable th) {
        try {
            final String w = w(bArr, "UTF-8");
            q(new Runnable() { // from class: com.cloud.hisavana.net.impl.StringCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    StringCallback.this.x(i, w, th);
                }
            });
        } catch (Exception e) {
            q(new 4(this, i, e));
        }
    }

    @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
    public void l(Headers headers) {
    }

    @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
    public void n(final int i, byte[] bArr) {
        try {
            final String w = w(bArr, "UTF-8");
            q(new Runnable() { // from class: com.cloud.hisavana.net.impl.StringCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    StringCallback.this.y(i, w);
                }
            });
        } catch (Exception e) {
            q(new 2(this, i, e));
        }
    }

    public abstract void x(int i, String str, Throwable th);

    public abstract void y(int i, String str);
}
