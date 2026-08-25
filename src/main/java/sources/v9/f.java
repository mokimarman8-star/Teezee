package v9;

import android.net.Uri;
import com.google.android.exoplayer2.p1;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final /* synthetic */ class f implements i9.r {
    public final /* synthetic */ p1 b;

    @Override // i9.r
    public /* synthetic */ i9.l[] c(Uri uri, Map map) {
        return i9.q.a(this, uri, map);
    }

    @Override // i9.r
    public final i9.l[] createExtractors() {
        return com.google.android.exoplayer2.source.i.d(this.b);
    }
}
