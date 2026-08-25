package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.r;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface DrmSession {

    public static class DrmSessionException extends IOException {
        public final int errorCode;

        public DrmSessionException(Throwable th, int i5) {
            super(th);
            this.errorCode = i5;
        }
    }

    UUID a();

    boolean b();

    androidx.media3.decoder.b c();

    boolean d(String str);

    void e(r.a aVar);

    void f(r.a aVar);

    DrmSessionException getError();

    int getState();

    Map queryKeyStatus();
}
