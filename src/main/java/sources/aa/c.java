package aa;

import com.google.android.exoplayer2.upstream.b0;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c implements e {
    private final e a;
    private final List b;

    public c(e eVar, List list) {
        this.a = eVar;
        this.b = list;
    }

    @Override // aa.e
    public b0.a a() {
        return new com.google.android.exoplayer2.offline.d(this.a.a(), this.b);
    }

    @Override // aa.e
    public b0.a b(com.google.android.exoplayer2.source.hls.playlist.e eVar, com.google.android.exoplayer2.source.hls.playlist.d dVar) {
        return new com.google.android.exoplayer2.offline.d(this.a.b(eVar, dVar), this.b);
    }
}
