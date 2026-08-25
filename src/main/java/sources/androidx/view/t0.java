package androidx.view;

import java.io.Closeable;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import q1.f;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class t0 {
    private final f impl = new f();

    @Deprecated
    public /* synthetic */ void addCloseable(Closeable closeable) {
        Intrinsics.h(closeable, "closeable");
        f fVar = this.impl;
        if (fVar != null) {
            fVar.d(closeable);
        }
    }

    public void addCloseable(AutoCloseable autoCloseable) {
        Intrinsics.h(autoCloseable, "closeable");
        f fVar = this.impl;
        if (fVar != null) {
            fVar.d(autoCloseable);
        }
    }

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        Intrinsics.h(str, "key");
        Intrinsics.h(autoCloseable, "closeable");
        f fVar = this.impl;
        if (fVar != null) {
            fVar.e(str, autoCloseable);
        }
    }

    public final void clear$lifecycle_viewmodel_release() {
        f fVar = this.impl;
        if (fVar != null) {
            fVar.f();
        }
        onCleared();
    }

    public final <T extends AutoCloseable> T getCloseable(String str) {
        Intrinsics.h(str, "key");
        f fVar = this.impl;
        if (fVar != null) {
            return (T) fVar.h(str);
        }
        return null;
    }

    protected void onCleared() {
    }
}
