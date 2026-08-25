package androidx.coroutines.util;

import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import y3.b;
import y3.e;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class h {
    public static final long a(b bVar) {
        Intrinsics.h(bVar, "connection");
        if (b(bVar) == 0) {
            return -1L;
        }
        e F0 = bVar.F0("SELECT last_insert_rowid()");
        try {
            F0.C0();
            long j5 = F0.getLong(0);
            AutoCloseableKt.a(F0, (Throwable) null);
            return j5;
        } finally {
        }
    }

    public static final int b(b bVar) {
        Intrinsics.h(bVar, "connection");
        e F0 = bVar.F0("SELECT changes()");
        try {
            F0.C0();
            int i5 = (int) F0.getLong(0);
            AutoCloseableKt.a(F0, (Throwable) null);
            return i5;
        } finally {
        }
    }
}
