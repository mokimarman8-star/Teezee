package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b implements AudioProcessor {

    /* renamed from: b, reason: collision with root package name */
    protected AudioProcessor.a f8503b;

    /* renamed from: c, reason: collision with root package name */
    protected AudioProcessor.a f8504c;

    /* renamed from: d, reason: collision with root package name */
    private AudioProcessor.a f8505d;

    /* renamed from: e, reason: collision with root package name */
    private AudioProcessor.a f8506e;

    /* renamed from: f, reason: collision with root package name */
    private ByteBuffer f8507f;

    /* renamed from: g, reason: collision with root package name */
    private ByteBuffer f8508g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8509h;

    public b() {
        ByteBuffer byteBuffer = AudioProcessor.f8491a;
        this.f8507f = byteBuffer;
        this.f8508g = byteBuffer;
        AudioProcessor.a aVar = AudioProcessor.a.f8492e;
        this.f8505d = aVar;
        this.f8506e = aVar;
        this.f8503b = aVar;
        this.f8504c = aVar;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final AudioProcessor.a a(AudioProcessor.a aVar) {
        this.f8505d = aVar;
        this.f8506e = c(aVar);
        return isActive() ? this.f8506e : AudioProcessor.a.f8492e;
    }

    protected final boolean b() {
        return this.f8508g.hasRemaining();
    }

    protected AudioProcessor.a c(AudioProcessor.a aVar) {
        return AudioProcessor.a.f8492e;
    }

    protected void d() {
    }

    protected void e() {
    }

    protected void f() {
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void flush() {
        this.f8508g = AudioProcessor.f8491a;
        this.f8509h = false;
        this.f8503b = this.f8505d;
        this.f8504c = this.f8506e;
        d();
    }

    protected final ByteBuffer g(int i5) {
        if (this.f8507f.capacity() < i5) {
            this.f8507f = ByteBuffer.allocateDirect(i5).order(ByteOrder.nativeOrder());
        } else {
            this.f8507f.clear();
        }
        ByteBuffer byteBuffer = this.f8507f;
        this.f8508g = byteBuffer;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f8508g;
        this.f8508g = AudioProcessor.f8491a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return this.f8506e != AudioProcessor.a.f8492e;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isEnded() {
        return this.f8509h && this.f8508g == AudioProcessor.f8491a;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueEndOfStream() {
        this.f8509h = true;
        e();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f8507f = AudioProcessor.f8491a;
        AudioProcessor.a aVar = AudioProcessor.a.f8492e;
        this.f8505d = aVar;
        this.f8506e = aVar;
        this.f8503b = aVar;
        this.f8504c = aVar;
        f();
    }
}
