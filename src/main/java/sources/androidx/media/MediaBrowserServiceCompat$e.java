package androidx.media;

import android.os.Bundle;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MediaBrowserServiceCompat$e {

    /* renamed from: a, reason: collision with root package name */
    private final String f8423a;

    /* renamed from: b, reason: collision with root package name */
    private final Bundle f8424b;

    public MediaBrowserServiceCompat$e(String str, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
        }
        this.f8423a = str;
        this.f8424b = bundle;
    }

    public Bundle c() {
        return this.f8424b;
    }

    public String d() {
        return this.f8423a;
    }
}
