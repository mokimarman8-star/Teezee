package io.github.anilbeesetti.nextlib.media3ext.ffdecoder;

import android.os.Handler;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.q0;
import androidx.media3.common.y;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.d0;
import androidx.media3.exoplayer.audio.x;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends d0 {
    public b() {
        this((Handler) null, (x) null, new AudioProcessor[0]);
    }

    public b(Handler handler, x xVar, AudioSink audioSink) {
        super(handler, xVar, audioSink);
    }

    public b(Handler handler, x xVar, AudioProcessor... audioProcessorArr) {
        this(handler, xVar, (AudioSink) new DefaultAudioSink.g().m(audioProcessorArr).j());
    }

    private boolean o0(r rVar) {
        if (!p0(rVar, 2)) {
            return true;
        }
        if (Z(a1.j0(4, rVar.E, rVar.F)) != 2) {
            return false;
        }
        return !"audio/ac3".equals(rVar.o);
    }

    private boolean p0(r rVar, int i) {
        return j0(a1.j0(i, rVar.E, rVar.F));
    }

    public String getName() {
        return "FfmpegAudioRenderer";
    }

    protected int k0(r rVar) {
        String str = (String) androidx.media3.common.util.a.e(rVar.o);
        if (!FfmpegLibrary.d() || !y.o(str)) {
            return 0;
        }
        if (!FfmpegLibrary.e(str)) {
            return 1;
        }
        if (p0(rVar, 2) || p0(rVar, 4)) {
            return rVar.N != 0 ? 2 : 4;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public FfmpegAudioDecoder T(r rVar, androidx.media3.decoder.b bVar) {
        q0.a("createFfmpegAudioDecoder");
        int i = rVar.p;
        if (i == -1) {
            i = 5760;
        }
        FfmpegAudioDecoder ffmpegAudioDecoder = new FfmpegAudioDecoder(rVar, 16, 16, i, o0(rVar));
        q0.b();
        return ffmpegAudioDecoder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public r Y(FfmpegAudioDecoder ffmpegAudioDecoder) {
        androidx.media3.common.util.a.e(ffmpegAudioDecoder);
        return new r.b().u0("audio/raw").R(ffmpegAudioDecoder.y()).v0(ffmpegAudioDecoder.B()).o0(ffmpegAudioDecoder.z()).N();
    }

    public int supportsMixedMimeTypeAdaptation() {
        return 8;
    }
}
