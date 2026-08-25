package g9;

import android.media.metrics.LogSessionId;
import x1.d4;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class u1 {
    public static final u1 b;
    private final a a;

    private static final class a {
        public static final a b = new a(d4.a());
        public final LogSessionId a;

        public a(LogSessionId logSessionId) {
            this.a = logSessionId;
        }
    }

    static {
        b = com.google.android.exoplayer2.util.p0.a < 31 ? new u1() : new u1(a.b);
    }

    public u1() {
        this((a) null);
        com.google.android.exoplayer2.util.a.g(com.google.android.exoplayer2.util.p0.a < 31);
    }

    public u1(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }

    private u1(a aVar) {
        this.a = aVar;
    }

    public LogSessionId a() {
        return ((a) com.google.android.exoplayer2.util.a.e(this.a)).a;
    }
}
