package in;

import android.content.Context;
import android.os.Handler;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.x;
import androidx.media3.exoplayer.mediacodec.h0;
import androidx.media3.exoplayer.o;
import androidx.media3.exoplayer.video.i0;
import com.transsion.player.exo.ORExoDecoderType;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g extends o {
    public static final a n = new a(null);
    private final ORExoDecoderType l;
    private final Lazy m;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ORExoDecoderType.values().length];
            try {
                iArr[ORExoDecoderType.AV1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, ORExoDecoderType oRExoDecoderType) {
        super(context);
        Intrinsics.h(context, "context");
        Intrinsics.h(oRExoDecoderType, "videoRendererType");
        this.l = oRExoDecoderType;
        this.m = LazyKt.b(new Function0() { // from class: in.f
            public final Object invoke() {
                i t;
                t = g.t();
                return t;
            }
        });
    }

    private final i r() {
        return (i) this.m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i t() {
        return new i();
    }

    protected void c(Context context, int i, h0 h0Var, boolean z, AudioSink audioSink, Handler handler, x xVar, ArrayList arrayList) {
        Intrinsics.h(context, "context");
        Intrinsics.h(h0Var, "mediaCodecSelector");
        Intrinsics.h(audioSink, "audioSink");
        Intrinsics.h(handler, "eventHandler");
        Intrinsics.h(xVar, "eventListener");
        Intrinsics.h(arrayList, "out");
        super.c(context, i, h0Var, z, audioSink, handler, xVar, arrayList);
        sn.e eVar = sn.e.a;
        eVar.e("ORRenderersFactory", "buildAudioRenderers, mode:" + i, true);
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            arrayList.add(size, new io.github.anilbeesetti.nextlib.media3ext.ffdecoder.b(handler, xVar, audioSink));
            eVar.e("ORRenderersFactory", "Loaded FfmpegAudioRenderer.", true);
        } catch (Exception e) {
            e.printStackTrace();
            sn.e.a.c("ORRenderersFactory", "Error instantiating Ffmpeg extension :" + e, true);
        }
    }

    protected AudioSink d(Context context, boolean z, boolean z2) {
        Intrinsics.h(context, "context");
        DefaultAudioSink j = new DefaultAudioSink.g(context).o(z).n(z2).m(new i[]{r()}).j();
        Intrinsics.g(j, "build(...)");
        return j;
    }

    protected void k(Context context, int i, h0 h0Var, boolean z, Handler handler, i0 i0Var, long j, ArrayList arrayList) {
        Intrinsics.h(context, "context");
        Intrinsics.h(h0Var, "mediaCodecSelector");
        Intrinsics.h(handler, "eventHandler");
        Intrinsics.h(i0Var, "eventListener");
        Intrinsics.h(arrayList, "out");
        super.k(context, i, h0Var, z, handler, i0Var, j, arrayList);
        sn.e eVar = sn.e.a;
        eVar.e("ORRenderersFactory", "buildVideoRenderers, mode:" + i, true);
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            arrayList.add(size, b.a[this.l.ordinal()] == 1 ? new androidx.media3.decoder.av1.c(j, handler, i0Var, 50) : new io.github.anilbeesetti.nextlib.media3ext.ffdecoder.d(j, handler, i0Var, 50));
            eVar.e("ORRenderersFactory", "Loaded FfmpegVideoRenderer.", true);
        } catch (Exception e) {
            e.printStackTrace();
            sn.e.a.c("ORRenderersFactory", "Error instantiating Ffmpeg extension :" + e, true);
        }
    }

    public void s(float f) {
        if (f > 1.0f) {
            f = (2 * f) - 1.0f;
        }
        r().b(f);
    }
}
