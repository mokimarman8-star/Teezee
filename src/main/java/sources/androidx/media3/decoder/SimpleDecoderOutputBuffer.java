package androidx.media3.decoder;

import androidx.media3.decoder.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class SimpleDecoderOutputBuffer extends h {

    /* renamed from: a, reason: collision with root package name */
    private final h.a f9614a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f9615b;

    public SimpleDecoderOutputBuffer(h.a aVar) {
        this.f9614a = aVar;
    }

    public ByteBuffer a(int i5) {
        ByteBuffer byteBuffer = (ByteBuffer) androidx.media3.common.util.a.e(this.f9615b);
        androidx.media3.common.util.a.a(i5 >= byteBuffer.limit());
        ByteBuffer order = ByteBuffer.allocateDirect(i5).order(ByteOrder.nativeOrder());
        int position = byteBuffer.position();
        byteBuffer.position(0);
        order.put(byteBuffer);
        order.position(position);
        order.limit(i5);
        this.f9615b = order;
        return order;
    }

    public ByteBuffer b(long j5, int i5) {
        this.timeUs = j5;
        ByteBuffer byteBuffer = this.f9615b;
        if (byteBuffer == null || byteBuffer.capacity() < i5) {
            this.f9615b = ByteBuffer.allocateDirect(i5).order(ByteOrder.nativeOrder());
        }
        this.f9615b.position(0);
        this.f9615b.limit(i5);
        return this.f9615b;
    }

    @Override // androidx.media3.decoder.h, androidx.media3.decoder.a
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f9615b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // androidx.media3.decoder.h
    public void release() {
        this.f9614a.a(this);
    }
}
