package da;

import com.cloud.tmc.miniutils.constant.MemoryConstants;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.common.primitives.Ints;
import i9.a0;
import i9.e0;
import i9.z;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class l implements i9.l {
    private final j a;
    private final p1 d;
    private i9.n g;
    private e0 h;
    private int i;
    private final d b = new d();
    private final d0 c = new d0();
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private int j = 0;
    private long k = -9223372036854775807L;

    public l(j jVar, p1 p1Var) {
        this.a = jVar;
        this.d = p1Var.b().e0("text/x-exoplayer-cues").I(p1Var.l).E();
    }

    private void a() {
        try {
            m mVar = (m) this.a.dequeueInputBuffer();
            while (mVar == null) {
                Thread.sleep(5L);
                mVar = (m) this.a.dequeueInputBuffer();
            }
            mVar.m(this.i);
            ((DecoderInputBuffer) mVar).c.put(this.c.d(), 0, this.i);
            ((DecoderInputBuffer) mVar).c.limit(this.i);
            this.a.queueInputBuffer(mVar);
            n nVar = (n) this.a.dequeueOutputBuffer();
            while (nVar == null) {
                Thread.sleep(5L);
                nVar = (n) this.a.dequeueOutputBuffer();
            }
            for (int i = 0; i < nVar.getEventTimeCount(); i++) {
                byte[] a = this.b.a(nVar.getCues(nVar.getEventTime(i)));
                this.e.add(Long.valueOf(nVar.getEventTime(i)));
                this.f.add(new d0(a));
            }
            nVar.l();
        } catch (SubtitleDecoderException e) {
            throw ParserException.createForMalformedContainer("SubtitleDecoder failed.", e);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    private boolean e(i9.m mVar) {
        int b = this.c.b();
        int i = this.i;
        if (b == i) {
            this.c.c(i + MemoryConstants.KB);
        }
        int read = mVar.read(this.c.d(), this.i, this.c.b() - this.i);
        if (read != -1) {
            this.i += read;
        }
        long length = mVar.getLength();
        return (length != -1 && ((long) this.i) == length) || read == -1;
    }

    private boolean f(i9.m mVar) {
        return mVar.skip((mVar.getLength() > (-1L) ? 1 : (mVar.getLength() == (-1L) ? 0 : -1)) != 0 ? Ints.d(mVar.getLength()) : MemoryConstants.KB) == -1;
    }

    private void g() {
        com.google.android.exoplayer2.util.a.i(this.h);
        com.google.android.exoplayer2.util.a.g(this.e.size() == this.f.size());
        long j = this.k;
        for (int g = j == -9223372036854775807L ? 0 : p0.g(this.e, Long.valueOf(j), true, true); g < this.f.size(); g++) {
            d0 d0Var = (d0) this.f.get(g);
            d0Var.P(0);
            int length = d0Var.d().length;
            this.h.c(d0Var, length);
            this.h.e(((Long) this.e.get(g)).longValue(), 1, length, 0, null);
        }
    }

    @Override // i9.l
    public void b(i9.n nVar) {
        com.google.android.exoplayer2.util.a.g(this.j == 0);
        this.g = nVar;
        this.h = nVar.track(0, 3);
        this.g.endTracks();
        this.g.g(new z(new long[]{0}, new long[]{0}, -9223372036854775807L));
        this.h.d(this.d);
        this.j = 1;
    }

    @Override // i9.l
    public boolean c(i9.m mVar) {
        return true;
    }

    @Override // i9.l
    public int d(i9.m mVar, a0 a0Var) {
        int i = this.j;
        com.google.android.exoplayer2.util.a.g((i == 0 || i == 5) ? false : true);
        if (this.j == 1) {
            this.c.L(mVar.getLength() != -1 ? Ints.d(mVar.getLength()) : MemoryConstants.KB);
            this.i = 0;
            this.j = 2;
        }
        if (this.j == 2 && e(mVar)) {
            a();
            g();
            this.j = 4;
        }
        if (this.j == 3 && f(mVar)) {
            g();
            this.j = 4;
        }
        return this.j == 4 ? -1 : 0;
    }

    @Override // i9.l
    public void release() {
        if (this.j == 5) {
            return;
        }
        this.a.release();
        this.j = 5;
    }

    @Override // i9.l
    public void seek(long j, long j2) {
        int i = this.j;
        com.google.android.exoplayer2.util.a.g((i == 0 || i == 5) ? false : true);
        this.k = j2;
        if (this.j == 2) {
            this.j = 1;
        }
        if (this.j == 4) {
            this.j = 3;
        }
    }
}
