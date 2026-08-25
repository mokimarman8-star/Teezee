package tb;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e {
    private static final b c = new b();
    private final xb.g a;
    private c b;

    private static final class b implements c {
        private b() {
        }

        @Override // tb.c
        public void a() {
        }

        @Override // tb.c
        public String b() {
            return null;
        }

        @Override // tb.c
        public byte[] c() {
            return null;
        }

        @Override // tb.c
        public void d() {
        }

        @Override // tb.c
        public void e(long j, String str) {
        }
    }

    public e(xb.g gVar) {
        this.a = gVar;
        this.b = c;
    }

    public e(xb.g gVar, String str) {
        this(gVar);
        e(str);
    }

    private File d(String str) {
        return this.a.q(str, "userlog");
    }

    public void a() {
        this.b.d();
    }

    public byte[] b() {
        return this.b.c();
    }

    public String c() {
        return this.b.b();
    }

    public final void e(String str) {
        this.b.a();
        this.b = c;
        if (str == null) {
            return;
        }
        f(d(str), C.DEFAULT_BUFFER_SEGMENT_SIZE);
    }

    void f(File file, int i) {
        this.b = new h(file, i);
    }

    public void g(long j, String str) {
        this.b.e(j, str);
    }
}
