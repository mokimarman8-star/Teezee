package androidx.media3.exoplayer.drm;

import android.os.Build;
import java.util.UUID;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c0 implements androidx.media3.decoder.b {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f10244d;

    /* renamed from: a, reason: collision with root package name */
    public final UUID f10245a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f10246b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10247c;

    static {
        boolean z5;
        if ("Amazon".equals(Build.MANUFACTURER)) {
            String str = Build.MODEL;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z5 = true;
                f10244d = z5;
            }
        }
        z5 = false;
        f10244d = z5;
    }

    public c0(UUID uuid, byte[] bArr) {
        this(uuid, bArr, false);
    }

    public c0(UUID uuid, byte[] bArr, boolean z5) {
        this.f10245a = uuid;
        this.f10246b = bArr;
        this.f10247c = z5;
    }
}
