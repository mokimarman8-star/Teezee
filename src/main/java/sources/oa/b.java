package oa;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.z2;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b extends h {
    private final DecoderInputBuffer n;
    private final d0 o;
    private long p;
    private a q;
    private long r;

    public b() {
        super(6);
        this.n = new DecoderInputBuffer(1);
        this.o = new d0();
    }

    private void A() {
        a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
    }

    private float[] z(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.o.N(byteBuffer.array(), byteBuffer.limit());
        this.o.P(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = Float.intBitsToFloat(this.o.q());
        }
        return fArr;
    }

    public int a(p1 p1Var) {
        return "application/x-camera-motion".equals(p1Var.l) ? z2.a(4) : z2.a(0);
    }

    public String getName() {
        return "CameraMotionRenderer";
    }

    public void handleMessage(int i, Object obj) {
        if (i == 8) {
            this.q = (a) obj;
        } else {
            super.handleMessage(i, obj);
        }
    }

    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    public boolean isReady() {
        return true;
    }

    protected void p() {
        A();
    }

    protected void r(long j, boolean z) {
        this.r = Long.MIN_VALUE;
        A();
    }

    public void render(long j, long j2) {
        while (!hasReadStreamToEnd() && this.r < 100000 + j) {
            this.n.b();
            if (w(k(), this.n, 0) != -4 || this.n.h()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.n;
            this.r = decoderInputBuffer.e;
            if (this.q != null && !decoderInputBuffer.g()) {
                this.n.n();
                float[] z = z((ByteBuffer) p0.j(this.n.c));
                if (z != null) {
                    ((a) p0.j(this.q)).a(this.r - this.p, z);
                }
            }
        }
    }

    protected void v(p1[] p1VarArr, long j, long j2) {
        this.p = j2;
    }
}
