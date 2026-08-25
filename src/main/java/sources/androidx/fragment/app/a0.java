package androidx.fragment.app;

import java.io.Writer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class a0 extends Writer {

    /* renamed from: a, reason: collision with root package name */
    private final String f8187a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuilder f8188b = new StringBuilder(128);

    a0(String str) {
        this.f8187a = str;
    }

    private void d() {
        if (this.f8188b.length() > 0) {
            this.f8188b.toString();
            StringBuilder sb = this.f8188b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        d();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            char c5 = cArr[i5 + i7];
            if (c5 == '\n') {
                d();
            } else {
                this.f8188b.append(c5);
            }
        }
    }
}
