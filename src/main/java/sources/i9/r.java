package i9;

import android.net.Uri;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface r {
    public static final r a = new r() { // from class: i9.p
        @Override // i9.r
        public /* synthetic */ l[] c(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // i9.r
        public final l[] createExtractors() {
            return q.b();
        }
    };

    l[] c(Uri uri, Map map);

    l[] createExtractors();
}
