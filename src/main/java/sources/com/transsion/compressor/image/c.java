package com.transsion.compressor.image;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class c implements d {
    private InputStream a;

    public abstract InputStream a();

    @Override // com.transsion.compressor.image.d
    public void close() {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            } catch (Throwable th2) {
                this.a = null;
                throw th2;
            }
            this.a = null;
        }
    }

    @Override // com.transsion.compressor.image.d
    public InputStream open() {
        close();
        InputStream a = a();
        this.a = a;
        return a;
    }
}
