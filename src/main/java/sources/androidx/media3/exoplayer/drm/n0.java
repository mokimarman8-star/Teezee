package androidx.media3.exoplayer.drm;

import android.util.Pair;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class n0 {
    private static long a(Map map, String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            String str2 = (String) map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    public static Pair b(DrmSession drmSession) {
        Map queryKeyStatus = drmSession.queryKeyStatus();
        if (queryKeyStatus == null) {
            return null;
        }
        return new Pair(Long.valueOf(a(queryKeyStatus, "LicenseDurationRemaining")), Long.valueOf(a(queryKeyStatus, "PlaybackDurationRemaining")));
    }
}
