package s2;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    public final long f17727a;

    /* renamed from: b, reason: collision with root package name */
    public final List f17728b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f17729a;

        /* renamed from: b, reason: collision with root package name */
        public final String f17730b;

        /* renamed from: c, reason: collision with root package name */
        public final long f17731c;

        /* renamed from: d, reason: collision with root package name */
        public final long f17732d;

        public a(String str, String str2, long j5, long j6) {
            this.f17729a = str;
            this.f17730b = str2;
            this.f17731c = j5;
            this.f17732d = j6;
        }
    }

    public c(long j5, List list) {
        this.f17727a = j5;
        this.f17728b = list;
    }

    public z2.a a(long j5) {
        long j6;
        if (this.f17728b.size() < 2) {
            return null;
        }
        long j7 = j5;
        long j8 = -1;
        long j9 = -1;
        long j10 = -1;
        long j11 = -1;
        boolean z5 = false;
        for (int size = this.f17728b.size() - 1; size >= 0; size--) {
            a aVar = (a) this.f17728b.get(size);
            boolean equals = "video/mp4".equals(aVar.f17729a) | z5;
            if (size == 0) {
                j7 -= aVar.f17732d;
                j6 = 0;
            } else {
                j6 = j7 - aVar.f17731c;
            }
            long j12 = j7;
            j7 = j6;
            if (!equals || j7 == j12) {
                z5 = equals;
            } else {
                j11 = j12 - j7;
                j10 = j7;
                z5 = false;
            }
            if (size == 0) {
                j8 = j7;
                j9 = j12;
            }
        }
        if (j10 == -1 || j11 == -1 || j8 == -1 || j9 == -1) {
            return null;
        }
        return new z2.a(j8, j9, this.f17727a, j10, j11);
    }
}
