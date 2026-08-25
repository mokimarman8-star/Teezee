package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.z;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class l extends w {
    private final /* synthetic */ AtomicReferenceArray e;

    public l(long j, l lVar, int i) {
        super(j, lVar, i);
        int i2;
        i2 = k.f;
        this.e = new AtomicReferenceArray(i2);
    }

    @Override // kotlinx.coroutines.internal.w
    public int r() {
        int i;
        i = k.f;
        return i;
    }

    @Override // kotlinx.coroutines.internal.w
    public void s(int i, Throwable th, CoroutineContext coroutineContext) {
        z zVar;
        zVar = k.e;
        v().set(i, zVar);
        t();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.c + ", hashCode=" + hashCode() + ']';
    }

    public final /* synthetic */ AtomicReferenceArray v() {
        return this.e;
    }
}
