package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import androidx.media3.decoder.h;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.http2.Settings;

@SuppressLint({"UnsafeOptInUsageError"})
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FfmpegAudioDecoder extends SimpleDecoder {
    private final String o;
    private final byte[] p;
    private final int q;
    private int r;
    private long s;
    private boolean t;
    private volatile int u;
    private volatile int v;

    public FfmpegAudioDecoder(r rVar, int i, int i2, int i3, boolean z) {
        super(new DecoderInputBuffer[i], new SimpleDecoderOutputBuffer[i2]);
        if (!FfmpegLibrary.d()) {
            throw new FfmpegDecoderException("Failed to load decoder native libraries.");
        }
        androidx.media3.common.util.a.e(rVar.o);
        String str = (String) androidx.media3.common.util.a.e(FfmpegLibrary.a(rVar.o));
        this.o = str;
        byte[] A = A(rVar.o, rVar.r);
        this.p = A;
        this.q = z ? 4 : 2;
        this.r = z ? 131070 : Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        long ffmpegInitialize = ffmpegInitialize(str, A, z, rVar.F, rVar.E);
        this.s = ffmpegInitialize;
        if (ffmpegInitialize == 0) {
            throw new FfmpegDecoderException("Initialization failed.");
        }
        s(i3);
    }

    private static byte[] A(String str, List list) {
        if (list.isEmpty()) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "audio/vorbis":
                return C(list);
            case "audio/mp4a-latm":
            case "audio/opus":
                return (byte[]) list.get(0);
            case "audio/alac":
                return x(list);
            default:
                return null;
        }
    }

    private static byte[] C(List list) {
        byte[] bArr = (byte[]) list.get(0);
        byte[] bArr2 = (byte[]) list.get(1);
        byte[] bArr3 = new byte[bArr.length + bArr2.length + 6];
        bArr3[0] = (byte) (bArr.length >> 8);
        bArr3[1] = (byte) (bArr.length & 255);
        System.arraycopy(bArr, 0, bArr3, 2, bArr.length);
        bArr3[bArr.length + 2] = 0;
        bArr3[bArr.length + 3] = 0;
        bArr3[bArr.length + 4] = (byte) (bArr2.length >> 8);
        bArr3[bArr.length + 5] = (byte) (bArr2.length & 255);
        System.arraycopy(bArr2, 0, bArr3, bArr.length + 6, bArr2.length);
        return bArr3;
    }

    private native int ffmpegDecode(long j, ByteBuffer byteBuffer, int i, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, ByteBuffer byteBuffer2, int i2);

    private native int ffmpegGetChannelCount(long j);

    private native int ffmpegGetSampleRate(long j);

    private native long ffmpegInitialize(String str, @Nullable byte[] bArr, boolean z, int i, int i2);

    private native void ffmpegRelease(long j);

    private native long ffmpegReset(long j, @Nullable byte[] bArr);

    @Keep
    private ByteBuffer growOutputBuffer(SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, int i) {
        this.r = i;
        return simpleDecoderOutputBuffer.a(i);
    }

    private static byte[] x(List list) {
        byte[] bArr = (byte[]) list.get(0);
        int length = bArr.length + 12;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1634492771);
        allocate.putInt(0);
        allocate.put(bArr, 0, bArr.length);
        return allocate.array();
    }

    public int B() {
        return this.v;
    }

    protected DecoderInputBuffer e() {
        return new DecoderInputBuffer(2, FfmpegLibrary.b());
    }

    public String getName() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.o;
    }

    public void release() {
        super.release();
        ffmpegRelease(this.s);
        this.s = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public SimpleDecoderOutputBuffer f() {
        return new SimpleDecoderOutputBuffer(new h.a() { // from class: io.github.anilbeesetti.nextlib.media3ext.ffdecoder.a
            public final void a(h hVar) {
                FfmpegAudioDecoder.this.p((SimpleDecoderOutputBuffer) hVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public FfmpegDecoderException g(Throwable th) {
        return new FfmpegDecoderException("Unexpected decode error", th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public FfmpegDecoderException h(DecoderInputBuffer decoderInputBuffer, SimpleDecoderOutputBuffer simpleDecoderOutputBuffer, boolean z) {
        if (z) {
            long ffmpegReset = ffmpegReset(this.s, this.p);
            this.s = ffmpegReset;
            if (ffmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) a1.i(decoderInputBuffer.c);
        int ffmpegDecode = ffmpegDecode(this.s, byteBuffer, byteBuffer.limit(), simpleDecoderOutputBuffer, simpleDecoderOutputBuffer.b(decoderInputBuffer.e, this.r), this.r);
        if (ffmpegDecode == -2) {
            return new FfmpegDecoderException("Error decoding (see logcat).");
        }
        if (ffmpegDecode == -1) {
            ((h) simpleDecoderOutputBuffer).shouldBeSkipped = true;
            return null;
        }
        if (ffmpegDecode == 0) {
            ((h) simpleDecoderOutputBuffer).shouldBeSkipped = true;
            return null;
        }
        if (!this.t) {
            this.u = ffmpegGetChannelCount(this.s);
            this.v = ffmpegGetSampleRate(this.s);
            if (this.v == 0 && "alac".equals(this.o)) {
                androidx.media3.common.util.a.e(this.p);
                j0 j0Var = new j0(this.p);
                j0Var.W(this.p.length - 4);
                this.v = j0Var.L();
            }
            this.t = true;
        }
        ByteBuffer byteBuffer2 = (ByteBuffer) androidx.media3.common.util.a.e(simpleDecoderOutputBuffer.b);
        byteBuffer2.position(0);
        byteBuffer2.limit(ffmpegDecode);
        return null;
    }

    public int y() {
        return this.u;
    }

    public int z() {
        return this.q;
    }
}
