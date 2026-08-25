package org.apache.tools.ant.util;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class j extends OutputStream {
    private ByteArrayOutputStream a = new ByteArrayOutputStream(Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE);
    private boolean b = false;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.a.size() > 0) {
            d();
        }
        super.close();
    }

    protected void d() {
        try {
            f(this.a.toString());
        } finally {
            this.a.reset();
        }
    }

    protected abstract void f(String str);

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        if (this.a.size() > 0) {
            d();
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        byte b = (byte) i;
        if (b != 10 && b != 13) {
            this.a.write(i);
        } else if (!this.b) {
            d();
        }
        this.b = b == 13;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        byte b;
        while (i2 > 0) {
            int i3 = i;
            while (i2 > 0 && (b = bArr[i3]) != 10 && b != 13) {
                i3++;
                i2--;
            }
            int i4 = i3 - i;
            if (i4 > 0) {
                this.a.write(bArr, i, i4);
            }
            i = i3;
            while (i2 > 0) {
                byte b2 = bArr[i];
                if (b2 == 10 || b2 == 13) {
                    write(b2);
                    i++;
                    i2--;
                }
            }
        }
    }
}
