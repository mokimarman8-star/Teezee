package in;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements AudioProcessor {
    private int b;
    private float c = 1.0f;
    private float d = 1.0f;
    private float e = 1.0f;
    private AudioProcessor.a f;
    private AudioProcessor.a g;
    private AudioProcessor.a h;
    private AudioProcessor.a i;
    private boolean j;
    private h k;
    private ByteBuffer l;
    private ShortBuffer m;
    private ByteBuffer n;
    private long o;
    private long p;
    private boolean q;

    public i() {
        AudioProcessor.a aVar = AudioProcessor.a.e;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        this.i = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.l = byteBuffer;
        this.m = byteBuffer.asShortBuffer();
        this.n = byteBuffer;
        this.b = -1;
    }

    public AudioProcessor.a a(AudioProcessor.a aVar) {
        if (aVar.c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i = this.b;
        if (i == -1) {
            i = aVar.a;
        }
        this.f = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i, aVar.b, 2);
        this.g = aVar2;
        this.j = true;
        return aVar2;
    }

    public float b(float f) {
        if (this.e != f) {
            this.e = f;
            this.j = true;
            h hVar = this.k;
            if (hVar != null) {
                hVar.w(f);
            }
        }
        return f;
    }

    public void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f;
            this.h = aVar;
            AudioProcessor.a aVar2 = this.g;
            this.i = aVar2;
            if (this.j) {
                this.k = new h(aVar.a, aVar.b, this.c, this.d, this.e, aVar2.a);
            } else {
                h hVar = this.k;
                if (hVar != null) {
                    hVar.i();
                }
            }
        }
        this.n = AudioProcessor.a;
        this.o = 0L;
        this.p = 0L;
        this.q = false;
    }

    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.n;
        this.n = AudioProcessor.a;
        return byteBuffer;
    }

    public boolean isActive() {
        return this.g.a != -1 && (Math.abs(this.c - 1.0f) >= 0.01f || Math.abs(this.d - 1.0f) >= 0.01f || Math.abs(this.e) >= 0.01f || this.g.a != this.f.a);
    }

    public boolean isEnded() {
        h hVar;
        return this.q && ((hVar = this.k) == null || hVar.k() == 0);
    }

    public void queueEndOfStream() {
        h hVar = this.k;
        if (hVar != null) {
            hVar.r();
        }
        this.q = true;
    }

    public void queueInput(ByteBuffer byteBuffer) {
        h hVar = (h) androidx.media3.common.util.a.e(this.k);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.o += remaining;
            hVar.s(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int k = hVar.k();
        if (k > 0) {
            if (this.l.capacity() < k) {
                ByteBuffer order = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
                this.l = order;
                this.m = order.asShortBuffer();
            } else {
                this.l.clear();
                this.m.clear();
            }
            hVar.j(this.m);
            this.p += k;
            this.l.limit(k);
            this.n = this.l;
        }
    }

    public void reset() {
        this.c = 1.0f;
        this.d = 1.0f;
        this.e = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.e;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        this.i = aVar;
        ByteBuffer byteBuffer = AudioProcessor.a;
        this.l = byteBuffer;
        this.m = byteBuffer.asShortBuffer();
        this.n = byteBuffer;
        this.b = -1;
        this.j = false;
        this.k = null;
        this.o = 0L;
        this.p = 0L;
        this.q = false;
    }
}
