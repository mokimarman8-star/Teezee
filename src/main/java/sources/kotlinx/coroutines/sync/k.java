package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.z;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class k {
    private static final int a;
    private static final z b;
    private static final z c;
    private static final z d;
    private static final z e;
    private static final int f;

    static {
        int e2;
        int e3;
        e2 = c0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        a = e2;
        b = new z("PERMIT");
        c = new z("TAKEN");
        d = new z("BROKEN");
        e = new z("CANCELLED");
        e3 = c0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f = e3;
    }

    public static final h a(int i, int i2) {
        return new j(i, i2);
    }

    public static /* synthetic */ h b(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l j(long j, l lVar) {
        return new l(j, lVar, 0);
    }
}
