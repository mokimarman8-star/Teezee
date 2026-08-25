package androidx.coroutines;

import android.net.Uri;
import android.os.Build;
import androidx.compose.foundation.e;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.work.b, reason: case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class C0209b {

    /* renamed from: i, reason: collision with root package name */
    public static final C0113b f13902i = new C0113b(null);

    /* renamed from: j, reason: collision with root package name */
    public static final C0209b f13903j = new C0209b(null, false, false, false, false, 0, 0, null, 255, null);

    /* renamed from: a, reason: collision with root package name */
    private final NetworkType f13904a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f13905b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f13906c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f13907d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f13908e;

    /* renamed from: f, reason: collision with root package name */
    private final long f13909f;

    /* renamed from: g, reason: collision with root package name */
    private final long f13910g;

    /* renamed from: h, reason: collision with root package name */
    private final Set f13911h;

    /* renamed from: androidx.work.b$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f13912a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f13913b;

        /* renamed from: d, reason: collision with root package name */
        private boolean f13915d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f13916e;

        /* renamed from: c, reason: collision with root package name */
        private NetworkType f13914c = NetworkType.NOT_REQUIRED;

        /* renamed from: f, reason: collision with root package name */
        private long f13917f = -1;

        /* renamed from: g, reason: collision with root package name */
        private long f13918g = -1;

        /* renamed from: h, reason: collision with root package name */
        private Set f13919h = new LinkedHashSet();

        public final C0209b a() {
            Set f5;
            long j5;
            long j6;
            if (Build.VERSION.SDK_INT >= 24) {
                f5 = CollectionsKt.W0(this.f13919h);
                j5 = this.f13917f;
                j6 = this.f13918g;
            } else {
                f5 = SetsKt.f();
                j5 = -1;
                j6 = -1;
            }
            return new C0209b(this.f13914c, this.f13912a, this.f13913b, this.f13915d, this.f13916e, j5, j6, f5);
        }

        public final a b(NetworkType networkType) {
            Intrinsics.h(networkType, "networkType");
            this.f13914c = networkType;
            return this;
        }
    }

    /* renamed from: androidx.work.b$b, reason: collision with other inner class name */
    public static final class C0113b {
        private C0113b() {
        }

        public /* synthetic */ C0113b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: androidx.work.b$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f13920a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f13921b;

        public c(Uri uri, boolean z5) {
            Intrinsics.h(uri, "uri");
            this.f13920a = uri;
            this.f13921b = z5;
        }

        public final Uri a() {
            return this.f13920a;
        }

        public final boolean b() {
            return this.f13921b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.c(c.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Intrinsics.f(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            c cVar = (c) obj;
            return Intrinsics.c(this.f13920a, cVar.f13920a) && this.f13921b == cVar.f13921b;
        }

        public int hashCode() {
            return (this.f13920a.hashCode() * 31) + e.a(this.f13921b);
        }
    }

    public C0209b() {
        this(null, false, false, false, false, 0L, 0L, null, 255, null);
    }

    public C0209b(NetworkType networkType, boolean z5, boolean z6, boolean z7, boolean z8, long j5, long j6, Set set) {
        Intrinsics.h(networkType, "requiredNetworkType");
        Intrinsics.h(set, "contentUriTriggers");
        this.f13904a = networkType;
        this.f13905b = z5;
        this.f13906c = z6;
        this.f13907d = z7;
        this.f13908e = z8;
        this.f13909f = j5;
        this.f13910g = j6;
        this.f13911h = set;
    }

    public /* synthetic */ C0209b(NetworkType networkType, boolean z5, boolean z6, boolean z7, boolean z8, long j5, long j6, Set set, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i5 & 2) != 0 ? false : z5, (i5 & 4) != 0 ? false : z6, (i5 & 8) != 0 ? false : z7, (i5 & 16) == 0 ? z8 : false, (i5 & 32) != 0 ? -1L : j5, (i5 & 64) == 0 ? j6 : -1L, (i5 & 128) != 0 ? SetsKt.f() : set);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0209b(C0209b c0209b) {
        this(c0209b.f13904a, r3, r4, c0209b.f13907d, c0209b.f13908e, c0209b.f13909f, c0209b.f13910g, c0209b.f13911h);
        Intrinsics.h(c0209b, "other");
        boolean z5 = c0209b.f13905b;
        boolean z6 = c0209b.f13906c;
    }

    public final long a() {
        return this.f13910g;
    }

    public final long b() {
        return this.f13909f;
    }

    public final Set c() {
        return this.f13911h;
    }

    public final NetworkType d() {
        return this.f13904a;
    }

    public final boolean e() {
        return !this.f13911h.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.c(C0209b.class, obj.getClass())) {
            return false;
        }
        C0209b c0209b = (C0209b) obj;
        if (this.f13905b == c0209b.f13905b && this.f13906c == c0209b.f13906c && this.f13907d == c0209b.f13907d && this.f13908e == c0209b.f13908e && this.f13909f == c0209b.f13909f && this.f13910g == c0209b.f13910g && this.f13904a == c0209b.f13904a) {
            return Intrinsics.c(this.f13911h, c0209b.f13911h);
        }
        return false;
    }

    public final boolean f() {
        return this.f13907d;
    }

    public final boolean g() {
        return this.f13905b;
    }

    public final boolean h() {
        return this.f13906c;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f13904a.hashCode() * 31) + (this.f13905b ? 1 : 0)) * 31) + (this.f13906c ? 1 : 0)) * 31) + (this.f13907d ? 1 : 0)) * 31) + (this.f13908e ? 1 : 0)) * 31;
        long j5 = this.f13909f;
        int i5 = (hashCode + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.f13910g;
        return ((i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.f13911h.hashCode();
    }

    public final boolean i() {
        return this.f13908e;
    }
}
