package androidx.media3.decoder;

import androidx.media3.common.r;
import androidx.media3.common.u;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class DecoderInputBuffer extends a {

    /* renamed from: a, reason: collision with root package name */
    public r f9592a;

    /* renamed from: b, reason: collision with root package name */
    public final c f9593b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f9594c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9595d;

    /* renamed from: e, reason: collision with root package name */
    public long f9596e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f9597f;

    /* renamed from: g, reason: collision with root package name */
    private final int f9598g;

    /* renamed from: h, reason: collision with root package name */
    private final int f9599h;

    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        public InsufficientCapacityException(int i5, int i6) {
            super("Buffer too small (" + i5 + " < " + i6 + ")");
            this.currentCapacity = i5;
            this.requiredCapacity = i6;
        }
    }

    static {
        u.a("media3.decoder");
    }

    public DecoderInputBuffer(int i5) {
        this(i5, 0);
    }

    public DecoderInputBuffer(int i5, int i6) {
        this.f9593b = new c();
        this.f9598g = i5;
        this.f9599h = i6;
    }

    private ByteBuffer a(int i5) {
        int i6 = this.f9598g;
        if (i6 == 1) {
            return ByteBuffer.allocate(i5);
        }
        if (i6 == 2) {
            return ByteBuffer.allocateDirect(i5);
        }
        ByteBuffer byteBuffer = this.f9594c;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i5);
    }

    public static DecoderInputBuffer f() {
        return new DecoderInputBuffer(0);
    }

    public void b(int i5) {
        int i6 = i5 + this.f9599h;
        ByteBuffer byteBuffer = this.f9594c;
        if (byteBuffer == null) {
            this.f9594c = a(i6);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i7 = i6 + position;
        if (capacity >= i7) {
            this.f9594c = byteBuffer;
            return;
        }
        ByteBuffer a5 = a(i7);
        a5.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            a5.put(byteBuffer);
        }
        this.f9594c = a5;
    }

    @Override // androidx.media3.decoder.a
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f9594c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f9597f;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f9595d = false;
    }

    public final void d() {
        ByteBuffer byteBuffer = this.f9594c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f9597f;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean e() {
        return getFlag(1073741824);
    }

    public void g(int i5) {
        ByteBuffer byteBuffer = this.f9597f;
        if (byteBuffer == null || byteBuffer.capacity() < i5) {
            this.f9597f = ByteBuffer.allocate(i5);
        } else {
            this.f9597f.clear();
        }
    }
}
