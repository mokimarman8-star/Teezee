package ea;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.f;
import com.google.android.exoplayer2.util.p0;
import da.i;
import da.j;
import da.m;
import da.n;
import ea.e;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class e implements j {
    private final ArrayDeque a = new ArrayDeque();
    private final ArrayDeque b;
    private final PriorityQueue c;
    private b d;
    private long e;
    private long f;

    private static final class b extends m implements Comparable {
        private long j;

        private b() {
        }

        @Override // java.lang.Comparable
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (h() != bVar.h()) {
                return h() ? 1 : -1;
            }
            long j = ((DecoderInputBuffer) this).e - ((DecoderInputBuffer) bVar).e;
            if (j == 0) {
                j = this.j - bVar.j;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c extends n {
        private f.a f;

        public c(f.a aVar) {
            this.f = aVar;
        }

        public final void l() {
            this.f.a(this);
        }
    }

    public e() {
        for (int i = 0; i < 10; i++) {
            this.a.add(new b());
        }
        this.b = new ArrayDeque();
        for (int i2 = 0; i2 < 2; i2++) {
            this.b.add(new c(new f.a() { // from class: ea.d
                public final void a(com.google.android.exoplayer2.decoder.f fVar) {
                    e.this.j((e.c) fVar);
                }
            }));
        }
        this.c = new PriorityQueue();
    }

    private void i(b bVar) {
        bVar.b();
        this.a.add(bVar);
    }

    protected abstract i a();

    protected abstract void b(m mVar);

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m dequeueInputBuffer() {
        com.google.android.exoplayer2.util.a.g(this.d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        b bVar = (b) this.a.pollFirst();
        this.d = bVar;
        return bVar;
    }

    @Override // 
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public n dequeueOutputBuffer() {
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty() && ((DecoderInputBuffer) ((b) p0.j((b) this.c.peek()))).e <= this.e) {
            b bVar = (b) p0.j((b) this.c.poll());
            if (bVar.h()) {
                n nVar = (n) p0.j((n) this.b.pollFirst());
                nVar.a(4);
                i(bVar);
                return nVar;
            }
            b(bVar);
            if (g()) {
                i a2 = a();
                n nVar2 = (n) p0.j((n) this.b.pollFirst());
                nVar2.m(((DecoderInputBuffer) bVar).e, a2, Long.MAX_VALUE);
                i(bVar);
                return nVar2;
            }
            i(bVar);
        }
        return null;
    }

    protected final n e() {
        return (n) this.b.pollFirst();
    }

    protected final long f() {
        return this.e;
    }

    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            i((b) p0.j((b) this.c.poll()));
        }
        b bVar = this.d;
        if (bVar != null) {
            i(bVar);
            this.d = null;
        }
    }

    protected abstract boolean g();

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(m mVar) {
        com.google.android.exoplayer2.util.a.a(mVar == this.d);
        b bVar = (b) mVar;
        if (bVar.g()) {
            i(bVar);
        } else {
            long j = this.f;
            this.f = 1 + j;
            bVar.j = j;
            this.c.add(bVar);
        }
        this.d = null;
    }

    protected void j(n nVar) {
        nVar.b();
        this.b.add(nVar);
    }

    public void release() {
    }

    @Override // da.j
    public void setPositionUs(long j) {
        this.e = j;
    }
}
