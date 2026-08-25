package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class NavDestination$a implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    private final NavDestination f12458a;

    /* renamed from: b, reason: collision with root package name */
    private final Bundle f12459b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f12460c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f12461d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12462e;

    public NavDestination$a(NavDestination navDestination, Bundle bundle, boolean z5, boolean z6, int i5) {
        Intrinsics.h(navDestination, "destination");
        this.f12458a = navDestination;
        this.f12459b = bundle;
        this.f12460c = z5;
        this.f12461d = z6;
        this.f12462e = i5;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(NavDestination$a navDestination$a) {
        Intrinsics.h(navDestination$a, "other");
        boolean z5 = this.f12460c;
        if (z5 && !navDestination$a.f12460c) {
            return 1;
        }
        if (!z5 && navDestination$a.f12460c) {
            return -1;
        }
        Bundle bundle = this.f12459b;
        if (bundle != null && navDestination$a.f12459b == null) {
            return 1;
        }
        if (bundle == null && navDestination$a.f12459b != null) {
            return -1;
        }
        if (bundle != null) {
            int size = bundle.size();
            Bundle bundle2 = navDestination$a.f12459b;
            Intrinsics.e(bundle2);
            int size2 = size - bundle2.size();
            if (size2 > 0) {
                return 1;
            }
            if (size2 < 0) {
                return -1;
            }
        }
        boolean z6 = this.f12461d;
        if (z6 && !navDestination$a.f12461d) {
            return 1;
        }
        if (z6 || !navDestination$a.f12461d) {
            return this.f12462e - navDestination$a.f12462e;
        }
        return -1;
    }

    public final NavDestination b() {
        return this.f12458a;
    }

    public final Bundle d() {
        return this.f12459b;
    }
}
