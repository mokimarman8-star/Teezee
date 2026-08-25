package com.google.common.util.concurrent;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class d extends AbstractFuture$h {
    private static final b c;
    private static final q d = new q(d.class);
    private volatile Set a;
    private volatile int b;

    private static abstract class b {
        private b() {
        }
    }

    private static final class c extends b {
        final AtomicReferenceFieldUpdater a;
        final AtomicIntegerFieldUpdater b;

        c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }
    }

    /* renamed from: com.google.common.util.concurrent.d$d, reason: collision with other inner class name */
    private static final class C0019d extends b {
        private C0019d() {
            super();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        b c0019d;
        Throwable th = null;
        Object[] objArr = 0;
        try {
            c0019d = new c(AtomicReferenceFieldUpdater.newUpdater(d.class, Set.class, "a"), AtomicIntegerFieldUpdater.newUpdater(d.class, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B));
        } catch (Throwable th2) {
            c0019d = new C0019d();
            th = th2;
        }
        c = c0019d;
        if (th != null) {
            d.a().log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }
}
