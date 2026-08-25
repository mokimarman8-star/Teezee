package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoder;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.decoder.h;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class FfmpegVideoDecoder extends SimpleDecoder {
    private final String o;
    private long p;
    private final byte[] q;
    private r r;
    private volatile int s;

    public FfmpegVideoDecoder(int i, int i2, int i3, int i4, r rVar) {
        super(new DecoderInputBuffer[i], new VideoDecoderOutputBuffer[i2]);
        if (!FfmpegLibrary.d()) {
            throw new FfmpegDecoderException("Failed to load decoder native library.");
        }
        String str = (String) androidx.media3.common.util.a.e(FfmpegLibrary.a(rVar.o));
        this.o = str;
        byte[] x = x(rVar.o, rVar.r);
        this.q = x;
        this.r = rVar;
        long ffmpegInitialize = ffmpegInitialize(str, x, i4);
        this.p = ffmpegInitialize;
        if (ffmpegInitialize == 0) {
            throw new FfmpegDecoderException("Failed to initialize decoder.");
        }
        s(i3);
    }

    private native long ffmpegInitialize(String str, @Nullable byte[] bArr, int i);

    private native int ffmpegReceiveFrame(long j, int i, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z);

    private native void ffmpegRelease(long j);

    private native int ffmpegRenderFrame(long j, Surface surface, VideoDecoderOutputBuffer videoDecoderOutputBuffer, int i, int i2);

    private native long ffmpegReset(long j);

    private native int ffmpegSendPacket(long j, ByteBuffer byteBuffer, int i, long j2);

    private static byte[] x(String str, List list) {
        if (list.isEmpty()) {
            return null;
        }
        str.hashCode();
        if (str.equals("video/hevc")) {
            return (byte[]) list.get(0);
        }
        if (!str.equals("video/avc")) {
            return null;
        }
        byte[] bArr = (byte[]) list.get(0);
        byte[] bArr2 = (byte[]) list.get(1);
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public void A(int i) {
        this.s = i;
    }

    protected DecoderInputBuffer e() {
        return new DecoderInputBuffer(2);
    }

    public String getName() {
        return "ffmpeg" + FfmpegLibrary.c() + "-" + this.o;
    }

    public void release() {
        super.release();
        ffmpegRelease(this.p);
        this.p = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public VideoDecoderOutputBuffer f() {
        return new VideoDecoderOutputBuffer(new h.a() { // from class: io.github.anilbeesetti.nextlib.media3ext.ffdecoder.c
            public final void a(h hVar) {
                FfmpegVideoDecoder.this.p((VideoDecoderOutputBuffer) hVar);
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
    public FfmpegDecoderException h(DecoderInputBuffer decoderInputBuffer, VideoDecoderOutputBuffer videoDecoderOutputBuffer, boolean z) {
        if (z) {
            long ffmpegReset = ffmpegReset(this.p);
            this.p = ffmpegReset;
            if (ffmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        ByteBuffer byteBuffer = (ByteBuffer) a1.i(decoderInputBuffer.c);
        int ffmpegSendPacket = ffmpegSendPacket(this.p, byteBuffer, byteBuffer.limit(), decoderInputBuffer.e);
        if (ffmpegSendPacket == -1) {
            ((h) videoDecoderOutputBuffer).shouldBeSkipped = true;
            return null;
        }
        if (ffmpegSendPacket == -3) {
            StringBuilder sb = new StringBuilder();
            sb.append("VIDEO_DECODER_ERROR_READ_FRAME: timeUs=");
            sb.append(decoderInputBuffer.e);
        } else if (ffmpegSendPacket == -2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        boolean l = l(decoderInputBuffer.e);
        int ffmpegReceiveFrame = ffmpegReceiveFrame(this.p, this.s, videoDecoderOutputBuffer, !l);
        if (ffmpegReceiveFrame == -2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        if (ffmpegReceiveFrame == -1) {
            ((h) videoDecoderOutputBuffer).shouldBeSkipped = true;
        }
        if (l) {
            videoDecoderOutputBuffer.format = decoderInputBuffer.a;
        }
        return null;
    }

    public void z(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) {
        if (videoDecoderOutputBuffer.mode != 1) {
            throw new FfmpegDecoderException("Invalid output mode.");
        }
        if (ffmpegRenderFrame(this.p, surface, videoDecoderOutputBuffer, videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height) == -2) {
            throw new FfmpegDecoderException("Buffer render error: ");
        }
    }
}
