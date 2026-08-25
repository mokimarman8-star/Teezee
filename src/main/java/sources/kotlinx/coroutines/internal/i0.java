package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i0 implements CoroutineContext$Key {
    private final ThreadLocal a;

    public i0(ThreadLocal threadLocal) {
        this.a = threadLocal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i0) && Intrinsics.c(this.a, ((i0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.a + ')';
    }
}
