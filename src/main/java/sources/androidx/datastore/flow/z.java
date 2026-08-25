package androidx.datastore.flow;

import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class z extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final FileOutputStream f7485a;

    public z(FileOutputStream fileOutputStream) {
        Intrinsics.h(fileOutputStream, "fileOutputStream");
        this.f7485a = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f7485a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i5) {
        this.f7485a.write(i5);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        Intrinsics.h(bArr, "b");
        this.f7485a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) {
        Intrinsics.h(bArr, "bytes");
        this.f7485a.write(bArr, i5, i6);
    }
}
