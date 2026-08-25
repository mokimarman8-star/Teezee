package g9;

import android.os.Looper;
import com.google.android.exoplayer2.p2;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.upstream.e;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface a extends p2.d, com.google.android.exoplayer2.source.p, e.a, com.google.android.exoplayer2.drm.s {
    void a(Exception exc);

    void b(String str);

    void c(String str);

    void d(long j);

    void e(Exception exc);

    void f(Object obj, long j);

    void g(Exception exc);

    void h(int i, long j, long j2);

    void i(long j, int i);

    void j(com.google.android.exoplayer2.decoder.e eVar);

    void k(com.google.android.exoplayer2.p1 p1Var, com.google.android.exoplayer2.decoder.g gVar);

    void m();

    void n(com.google.android.exoplayer2.decoder.e eVar);

    void o(com.google.android.exoplayer2.decoder.e eVar);

    void onAudioDecoderInitialized(String str, long j, long j2);

    void onDroppedFrames(int i, long j);

    void onVideoDecoderInitialized(String str, long j, long j2);

    void q(c cVar);

    void r(p2 p2Var, Looper looper);

    void release();

    void t(com.google.android.exoplayer2.p1 p1Var, com.google.android.exoplayer2.decoder.g gVar);

    void v(com.google.android.exoplayer2.decoder.e eVar);

    void x(List list, o.b bVar);
}
