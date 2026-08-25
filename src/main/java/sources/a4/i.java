package a4;

import android.database.sqlite.SQLiteProgram;
import kotlin.jvm.internal.Intrinsics;
import z3.f;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class i implements f {

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteProgram f72a;

    public i(SQLiteProgram sQLiteProgram) {
        Intrinsics.h(sQLiteProgram, "delegate");
        this.f72a = sQLiteProgram;
    }

    @Override // z3.f
    public void V(int i5, String str) {
        Intrinsics.h(str, "value");
        this.f72a.bindString(i5, str);
    }

    @Override // z3.f
    public void a(int i5, double d5) {
        this.f72a.bindDouble(i5, d5);
    }

    @Override // z3.f
    public void c(int i5, long j5) {
        this.f72a.bindLong(i5, j5);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f72a.close();
    }

    @Override // z3.f
    public void g(int i5) {
        this.f72a.bindNull(i5);
    }

    @Override // z3.f
    public void k0(int i5, byte[] bArr) {
        Intrinsics.h(bArr, "value");
        this.f72a.bindBlob(i5, bArr);
    }
}
