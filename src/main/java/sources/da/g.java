package da;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class g implements j {
    private final c a = new c();
    private final m b = new m();
    private final Deque c = new ArrayDeque();
    private int d;
    private boolean e;

    class a extends n {
        a() {
        }

        public void l() {
            g.this.e(this);
        }
    }

    private static final class b implements i {
        private final long a;
        private final ImmutableList b;

        public b(long j, ImmutableList immutableList) {
            this.a = j;
            this.b = immutableList;
        }

        @Override // da.i
        public List getCues(long j) {
            return j >= this.a ? this.b : ImmutableList.of();
        }

        @Override // da.i
        public long getEventTime(int i) {
            com.google.android.exoplayer2.util.a.a(i == 0);
            return this.a;
        }

        @Override // da.i
        public int getEventTimeCount() {
            return 1;
        }

        @Override // da.i
        public int getNextEventTimeIndex(long j) {
            return this.a > j ? 0 : -1;
        }
    }

    public g() {
        for (int i = 0; i < 2; i++) {
            this.c.addFirst(new a());
        }
        this.d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        com.google.android.exoplayer2.util.a.g(this.c.size() < 2);
        com.google.android.exoplayer2.util.a.a(!this.c.contains(nVar));
        nVar.b();
        this.c.addFirst(nVar);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m dequeueInputBuffer() {
        com.google.android.exoplayer2.util.a.g(!this.e);
        if (this.d != 0) {
            return null;
        }
        this.d = 1;
        return this.b;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n dequeueOutputBuffer() {
        com.google.android.exoplayer2.util.a.g(!this.e);
        if (this.d != 2 || this.c.isEmpty()) {
            return null;
        }
        n nVar = (n) this.c.removeFirst();
        if (this.b.h()) {
            nVar.a(4);
        } else {
            m mVar = this.b;
            nVar.m(((DecoderInputBuffer) this.b).e, new b(((DecoderInputBuffer) mVar).e, this.a.a(((ByteBuffer) com.google.android.exoplayer2.util.a.e(((DecoderInputBuffer) mVar).c)).array())), 0L);
        }
        this.b.b();
        this.d = 0;
        return nVar;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(m mVar) {
        com.google.android.exoplayer2.util.a.g(!this.e);
        com.google.android.exoplayer2.util.a.g(this.d == 1);
        com.google.android.exoplayer2.util.a.a(this.b == mVar);
        this.d = 2;
    }

    public void flush() {
        com.google.android.exoplayer2.util.a.g(!this.e);
        this.b.b();
        this.d = 0;
    }

    public void release() {
        this.e = true;
    }

    @Override // da.j
    public void setPositionUs(long j) {
    }
}
