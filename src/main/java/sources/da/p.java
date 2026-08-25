package da;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.q1;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.android.exoplayer2.z2;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class p extends com.google.android.exoplayer2.h implements Handler.Callback {
    private int A;
    private long B;
    private final Handler n;
    private final o o;
    private final k p;
    private final q1 q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private p1 v;
    private j w;
    private m x;
    private n y;
    private n z;

    public p(o oVar, Looper looper) {
        this(oVar, looper, k.a);
    }

    public p(o oVar, Looper looper, k kVar) {
        super(3);
        this.o = (o) com.google.android.exoplayer2.util.a.e(oVar);
        this.n = looper == null ? null : p0.v(looper, this);
        this.p = kVar;
        this.q = new q1();
        this.B = -9223372036854775807L;
    }

    private long A() {
        if (this.A == -1) {
            return Long.MAX_VALUE;
        }
        com.google.android.exoplayer2.util.a.e(this.y);
        if (this.A >= this.y.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.y.getEventTime(this.A);
    }

    private void B(SubtitleDecoderException subtitleDecoderException) {
        s.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.v, subtitleDecoderException);
        z();
        G();
    }

    private void C() {
        this.t = true;
        this.w = this.p.b((p1) com.google.android.exoplayer2.util.a.e(this.v));
    }

    private void D(List list) {
        this.o.onCues(list);
        this.o.onCues(new f(list));
    }

    private void E() {
        this.x = null;
        this.A = -1;
        n nVar = this.y;
        if (nVar != null) {
            nVar.l();
            this.y = null;
        }
        n nVar2 = this.z;
        if (nVar2 != null) {
            nVar2.l();
            this.z = null;
        }
    }

    private void F() {
        E();
        ((j) com.google.android.exoplayer2.util.a.e(this.w)).release();
        this.w = null;
        this.u = 0;
    }

    private void G() {
        F();
        C();
    }

    private void I(List list) {
        Handler handler = this.n;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            D(list);
        }
    }

    private void z() {
        I(Collections.emptyList());
    }

    public void H(long j) {
        com.google.android.exoplayer2.util.a.g(isCurrentStreamFinal());
        this.B = j;
    }

    public int a(p1 p1Var) {
        if (this.p.a(p1Var)) {
            return z2.a(p1Var.E == 0 ? 4 : 2);
        }
        return w.r(p1Var.l) ? z2.a(1) : z2.a(0);
    }

    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        D((List) message.obj);
        return true;
    }

    public boolean isEnded() {
        return this.s;
    }

    public boolean isReady() {
        return true;
    }

    protected void p() {
        this.v = null;
        this.B = -9223372036854775807L;
        z();
        F();
    }

    protected void r(long j, boolean z) {
        z();
        this.r = false;
        this.s = false;
        this.B = -9223372036854775807L;
        if (this.u != 0) {
            G();
        } else {
            E();
            ((j) com.google.android.exoplayer2.util.a.e(this.w)).flush();
        }
    }

    public void render(long j, long j2) {
        boolean z;
        if (isCurrentStreamFinal()) {
            long j3 = this.B;
            if (j3 != -9223372036854775807L && j >= j3) {
                E();
                this.s = true;
            }
        }
        if (this.s) {
            return;
        }
        if (this.z == null) {
            ((j) com.google.android.exoplayer2.util.a.e(this.w)).setPositionUs(j);
            try {
                this.z = (n) ((j) com.google.android.exoplayer2.util.a.e(this.w)).dequeueOutputBuffer();
            } catch (SubtitleDecoderException e) {
                B(e);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.y != null) {
            long A = A();
            z = false;
            while (A <= j) {
                this.A++;
                A = A();
                z = true;
            }
        } else {
            z = false;
        }
        n nVar = this.z;
        if (nVar != null) {
            if (nVar.h()) {
                if (!z && A() == Long.MAX_VALUE) {
                    if (this.u == 2) {
                        G();
                    } else {
                        E();
                        this.s = true;
                    }
                }
            } else if (((com.google.android.exoplayer2.decoder.f) nVar).b <= j) {
                n nVar2 = this.y;
                if (nVar2 != null) {
                    nVar2.l();
                }
                this.A = nVar.getNextEventTimeIndex(j);
                this.y = nVar;
                this.z = null;
                z = true;
            }
        }
        if (z) {
            com.google.android.exoplayer2.util.a.e(this.y);
            I(this.y.getCues(j));
        }
        if (this.u == 2) {
            return;
        }
        while (!this.r) {
            try {
                m mVar = this.x;
                if (mVar == null) {
                    mVar = (m) ((j) com.google.android.exoplayer2.util.a.e(this.w)).dequeueInputBuffer();
                    if (mVar == null) {
                        return;
                    } else {
                        this.x = mVar;
                    }
                }
                if (this.u == 1) {
                    mVar.k(4);
                    ((j) com.google.android.exoplayer2.util.a.e(this.w)).queueInputBuffer(mVar);
                    this.x = null;
                    this.u = 2;
                    return;
                }
                int w = w(this.q, mVar, 0);
                if (w == -4) {
                    if (mVar.h()) {
                        this.r = true;
                        this.t = false;
                    } else {
                        p1 p1Var = this.q.b;
                        if (p1Var == null) {
                            return;
                        }
                        mVar.i = p1Var.p;
                        mVar.n();
                        this.t &= !mVar.j();
                    }
                    if (!this.t) {
                        ((j) com.google.android.exoplayer2.util.a.e(this.w)).queueInputBuffer(mVar);
                        this.x = null;
                    }
                } else if (w == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                B(e2);
                return;
            }
        }
    }

    protected void v(p1[] p1VarArr, long j, long j2) {
        this.v = p1VarArr[0];
        if (this.w != null) {
            this.u = 1;
        } else {
            C();
        }
    }
}
