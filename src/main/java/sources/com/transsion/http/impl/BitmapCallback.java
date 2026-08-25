package com.transsion.http.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class BitmapCallback extends q {
    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap x(byte[] bArr) {
        return BitmapFactory.decodeStream(kl.a.f(ByteBuffer.wrap(bArr)));
    }

    @Override // com.transsion.http.impl.q
    public void m(int i, byte[] bArr, Throwable th2) {
        h(new c(this, i, th2));
    }

    @Override // com.transsion.http.impl.q
    public void s(int i, byte[] bArr) {
        b bVar = new b(this, bArr, i);
        if (k() || j()) {
            bVar.run();
        } else {
            new Thread(bVar).start();
        }
    }

    public abstract void y(int i, Bitmap bitmap, Throwable th2);

    public abstract void z(int i, Bitmap bitmap);
}
