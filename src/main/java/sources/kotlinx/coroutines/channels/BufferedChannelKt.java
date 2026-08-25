package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.z;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class BufferedChannelKt {
    private static final j a = new j(-1, null, null, 0);
    public static final int b;
    private static final int c;
    public static final z d;
    private static final z e;
    private static final z f;
    private static final z g;
    private static final z h;
    private static final z i;
    private static final z j;
    private static final z k;
    private static final z l;
    private static final z m;
    private static final z n;
    private static final z o;
    private static final z p;
    private static final z q;
    private static final z r;
    private static final z s;

    static {
        int e2;
        int e3;
        e2 = c0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        b = e2;
        e3 = c0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        c = e3;
        d = new z("BUFFERED");
        e = new z("SHOULD_BUFFER");
        f = new z("S_RESUMING_BY_RCV");
        g = new z("RESUMING_BY_EB");
        h = new z("POISONED");
        i = new z("DONE_RCV");
        j = new z("INTERRUPTED_SEND");
        k = new z("INTERRUPTED_RCV");
        l = new z("CHANNEL_CLOSED");
        m = new z("SUSPEND");
        n = new z("SUSPEND_NO_WAITER");
        o = new z("FAILED");
        p = new z("NO_RECEIVE_RESULT");
        q = new z("CLOSE_HANDLER_CLOSED");
        r = new z("CLOSE_HANDLER_INVOKED");
        s = new z("NO_CLOSE_CAUSE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A(int i2) {
        if (i2 == 0) {
            return 0L;
        }
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(kotlinx.coroutines.n nVar, Object obj, Function3 function3) {
        Object tryResume = nVar.tryResume(obj, null, function3);
        if (tryResume == null) {
            return false;
        }
        nVar.completeResume(tryResume);
        return true;
    }

    static /* synthetic */ boolean C(kotlinx.coroutines.n nVar, Object obj, Function3 function3, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            function3 = null;
        }
        return B(nVar, obj, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j2, boolean z) {
        return (z ? 4611686018427387904L : 0L) + j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(long j2, int i2) {
        return (i2 << 60) + j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j x(long j2, j jVar) {
        return new j(j2, jVar, jVar.y(), 0);
    }

    public static final KFunction y() {
        return BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    }

    public static final z z() {
        return l;
    }
}
