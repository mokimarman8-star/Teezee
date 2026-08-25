package z2;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import com.google.common.primitives.Longs;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f18850a;

    /* renamed from: b, reason: collision with root package name */
    public final long f18851b;

    /* renamed from: c, reason: collision with root package name */
    public final long f18852c;

    /* renamed from: d, reason: collision with root package name */
    public final long f18853d;

    /* renamed from: e, reason: collision with root package name */
    public final long f18854e;

    public a(long j5, long j6, long j7, long j8, long j9) {
        this.f18850a = j5;
        this.f18851b = j6;
        this.f18852c = j7;
        this.f18853d = j8;
        this.f18854e = j9;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f18850a == aVar.f18850a && this.f18851b == aVar.f18851b && this.f18852c == aVar.f18852c && this.f18853d == aVar.f18853d && this.f18854e == aVar.f18854e;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return w.a(this);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ r getWrappedMetadataFormat() {
        return w.b(this);
    }

    public int hashCode() {
        return ((((((((527 + Longs.e(this.f18850a)) * 31) + Longs.e(this.f18851b)) * 31) + Longs.e(this.f18852c)) * 31) + Longs.e(this.f18853d)) * 31) + Longs.e(this.f18854e);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f18850a + ", photoSize=" + this.f18851b + ", photoPresentationTimestampUs=" + this.f18852c + ", videoStartPosition=" + this.f18853d + ", videoSize=" + this.f18854e;
    }
}
