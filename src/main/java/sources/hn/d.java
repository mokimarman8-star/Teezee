package hn;

import androidx.collection.s;
import androidx.compose.foundation.e;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import com.transsion.player.config.RenderType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d {
    private final RenderType a;
    private final boolean b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final long i;
    private final int j;
    private final int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private final String q;

    public d() {
        this(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 131071, null);
    }

    public d(RenderType renderType, boolean z, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str) {
        Intrinsics.h(renderType, "type");
        Intrinsics.h(str, "traceId");
        this.a = renderType;
        this.b = z;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.h = i6;
        this.i = j;
        this.j = i7;
        this.k = i8;
        this.l = z2;
        this.m = z3;
        this.n = z4;
        this.o = z5;
        this.p = z6;
        this.q = str;
    }

    public /* synthetic */ d(RenderType renderType, boolean z, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? RenderType.SURFACE_VIEW : renderType, (i9 & 2) != 0 ? true : z, (i9 & 4) != 0 ? 50 : i, (i9 & 8) != 0 ? 50000 : i2, (i9 & 16) != 0 ? 3000 : i3, (i9 & 32) != 0 ? 500 : i4, (i9 & 64) != 0 ? 2 : i5, (i9 & 128) != 0 ? 3 : i6, (i9 & 256) != 0 ? 4000L : j, (i9 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) == 0 ? i7 : 50, (i9 & 1024) != 0 ? 30000 : i8, (i9 & 2048) != 0 ? true : z2, (i9 & 4096) != 0 ? false : z3, (i9 & 8192) != 0 ? false : z4, (i9 & 16384) == 0 ? z5 : false, (32768 & i9) != 0 ? true : z6, (i9 & 65536) != 0 ? BuildConfig.FLAVOR : str);
    }

    public final int a() {
        return this.j;
    }

    public final boolean b() {
        return this.m;
    }

    public final boolean c() {
        return this.o;
    }

    public final boolean d() {
        return this.n;
    }

    public final boolean e() {
        return this.l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && this.b == dVar.b && this.c == dVar.c && this.d == dVar.d && this.e == dVar.e && this.f == dVar.f && this.g == dVar.g && this.h == dVar.h && this.i == dVar.i && this.j == dVar.j && this.k == dVar.k && this.l == dVar.l && this.m == dVar.m && this.n == dVar.n && this.o == dVar.o && this.p == dVar.p && Intrinsics.c(this.q, dVar.q);
    }

    public final int f() {
        return this.e;
    }

    public final int g() {
        return this.d;
    }

    public final int h() {
        return this.k;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.a.hashCode() * 31) + e.a(this.b)) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + s.a(this.i)) * 31) + this.j) * 31) + this.k) * 31) + e.a(this.l)) * 31) + e.a(this.m)) * 31) + e.a(this.n)) * 31) + e.a(this.o)) * 31) + e.a(this.p)) * 31) + this.q.hashCode();
    }

    public final boolean i() {
        return this.p;
    }

    public final boolean j() {
        return this.b;
    }

    public final int k() {
        return this.c;
    }

    public final long l() {
        return this.i;
    }

    public final int m() {
        return this.g;
    }

    public final int n() {
        return this.f;
    }

    public final String o() {
        return this.q;
    }

    public final RenderType p() {
        return this.a;
    }

    public String toString() {
        return "VodConfig(type=" + this.a + ", openCache=" + this.b + ", positionTimerIntervalMs=" + this.c + ", maxBufferDuration=" + this.d + ", highBufferDuration=" + this.e + ", startBufferDuration=" + this.f + ", retryCount=" + this.g + ", preloadCount=" + this.h + ", preloadDuration=" + this.i + ", cacheMaxSizeMB=" + this.j + ", networkTimeout=" + this.k + ", enableHardwareDecoder=" + this.l + ", clearFrameWhenStop=" + this.m + ", disableVideo=" + this.n + ", disableAudio=" + this.o + ", openAudioFocus=" + this.p + ", traceId=" + this.q + ")";
    }
}
