package com.google.zxing.qrcode.decoder;

import com.google.zxing.k;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class f {
    private final boolean a;

    f(boolean z) {
        this.a = z;
    }

    public void a(k[] kVarArr) {
        if (!this.a || kVarArr == null || kVarArr.length < 3) {
            return;
        }
        k kVar = kVarArr[0];
        kVarArr[0] = kVarArr[2];
        kVarArr[2] = kVar;
    }
}
