package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import android.os.Handler;
import android.view.Surface;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.q0;
import androidx.media3.common.y;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.decoder.g;
import androidx.media3.exoplayer.video.i0;
import androidx.media3.exoplayer.x3;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d extends androidx.media3.exoplayer.video.b {
    private static final int b0 = ((a1.k(1280, 64) * a1.k(720, 64)) * 6144) / 2;
    private final int X;
    private final int Y;
    private final int Z;
    private FfmpegVideoDecoder a0;

    public d(long j, Handler handler, i0 i0Var, int i) {
        this(j, handler, i0Var, i, Runtime.getRuntime().availableProcessors(), 4, 4);
    }

    public d(long j, Handler handler, i0 i0Var, int i, int i2, int i3, int i4) {
        super(j, handler, i0Var, i);
        this.Z = i2;
        this.X = i3;
        this.Y = i4;
    }

    protected g R(r rVar, androidx.media3.decoder.b bVar) {
        q0.a("createFfmpegVideoDecoder");
        int i = rVar.p;
        if (i == -1) {
            i = b0;
        }
        FfmpegVideoDecoder ffmpegVideoDecoder = new FfmpegVideoDecoder(this.X, this.Y, i, this.Z, rVar);
        this.a0 = ffmpegVideoDecoder;
        q0.b();
        return ffmpegVideoDecoder;
    }

    public final int a(r rVar) {
        String str = (String) androidx.media3.common.util.a.e(rVar.o);
        if (FfmpegLibrary.d() && y.t(str)) {
            return !FfmpegLibrary.e(rVar.o) ? x3.a(1) : rVar.s != null ? x3.a(2) : x3.b(4, 16, 0);
        }
        return 0;
    }

    public String getName() {
        return "FfmpegVideoRenderer";
    }

    protected void q0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) {
        FfmpegVideoDecoder ffmpegVideoDecoder = this.a0;
        if (ffmpegVideoDecoder == null) {
            throw new FfmpegDecoderException("Failed to render output buffer to surface: decoder is not initialized.");
        }
        ffmpegVideoDecoder.z(videoDecoderOutputBuffer, surface);
        videoDecoderOutputBuffer.release();
    }

    protected void s0(int i) {
        FfmpegVideoDecoder ffmpegVideoDecoder = this.a0;
        if (ffmpegVideoDecoder != null) {
            ffmpegVideoDecoder.A(i);
        }
    }
}
