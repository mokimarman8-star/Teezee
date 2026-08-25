package androidx.media3.exoplayer.upstream;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface m {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f11679a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11680b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11681c;

        /* renamed from: d, reason: collision with root package name */
        public final int f11682d;

        public a(int i5, int i6, int i7, int i8) {
            this.f11679a = i5;
            this.f11680b = i6;
            this.f11681c = i7;
            this.f11682d = i8;
        }

        public boolean a(int i5) {
            if (i5 == 1) {
                if (this.f11679a - this.f11680b <= 1) {
                    return false;
                }
            } else if (this.f11681c - this.f11682d <= 1) {
                return false;
            }
            return true;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f11683a;

        /* renamed from: b, reason: collision with root package name */
        public final long f11684b;

        public b(int i5, long j5) {
            androidx.media3.common.util.a.a(j5 >= 0);
            this.f11683a = i5;
            this.f11684b = j5;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final f2.i f11685a;

        /* renamed from: b, reason: collision with root package name */
        public final f2.j f11686b;

        /* renamed from: c, reason: collision with root package name */
        public final IOException f11687c;

        /* renamed from: d, reason: collision with root package name */
        public final int f11688d;

        public c(f2.i iVar, f2.j jVar, IOException iOException, int i5) {
            this.f11685a = iVar;
            this.f11686b = jVar;
            this.f11687c = iOException;
            this.f11688d = i5;
        }
    }

    int a(int i5);

    void b(long j5);

    long c(c cVar);

    b d(a aVar, c cVar);
}
