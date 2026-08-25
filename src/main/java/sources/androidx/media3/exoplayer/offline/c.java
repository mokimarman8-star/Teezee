package androidx.media3.exoplayer.offline;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final DownloadRequest f11088a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11089b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11090c;

    /* renamed from: d, reason: collision with root package name */
    public final long f11091d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11092e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11093f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11094g;

    /* renamed from: h, reason: collision with root package name */
    final l f11095h;

    public c(DownloadRequest downloadRequest, int i5, long j5, long j6, long j7, int i6, int i7) {
        this(downloadRequest, i5, j5, j6, j7, i6, i7, new l());
    }

    public c(DownloadRequest downloadRequest, int i5, long j5, long j6, long j7, int i6, int i7, l lVar) {
        androidx.media3.common.util.a.e(lVar);
        boolean z5 = false;
        androidx.media3.common.util.a.a((i7 == 0) == (i5 != 4));
        if (i6 != 0) {
            if (i5 != 2 && i5 != 0) {
                z5 = true;
            }
            androidx.media3.common.util.a.a(z5);
        }
        this.f11088a = downloadRequest;
        this.f11089b = i5;
        this.f11090c = j5;
        this.f11091d = j6;
        this.f11092e = j7;
        this.f11093f = i6;
        this.f11094g = i7;
        this.f11095h = lVar;
    }

    public long a() {
        return this.f11095h.f11099a;
    }

    public float b() {
        return this.f11095h.f11100b;
    }

    public boolean c() {
        int i5 = this.f11089b;
        return i5 == 3 || i5 == 4;
    }
}
