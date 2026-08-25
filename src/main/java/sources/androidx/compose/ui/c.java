package androidx.compose.ui;

import androidx.compose.ui.b;
import androidx.compose.ui.unit.LayoutDirection;
import o0.q;
import o0.t;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c implements androidx.compose.ui.b {

    /* renamed from: b, reason: collision with root package name */
    private final float f3101b;

    /* renamed from: c, reason: collision with root package name */
    private final float f3102c;

    public static final class a implements b.InterfaceC0025b {

        /* renamed from: a, reason: collision with root package name */
        private final float f3103a;

        public a(float f5) {
            this.f3103a = f5;
        }

        @Override // androidx.compose.ui.b.InterfaceC0025b
        public int a(int i5, int i6, LayoutDirection layoutDirection) {
            return Math.round(((i6 - i5) / 2.0f) * (1 + (layoutDirection == LayoutDirection.Ltr ? this.f3103a : (-1) * this.f3103a)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Float.compare(this.f3103a, ((a) obj).f3103a) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3103a);
        }

        public String toString() {
            return "Horizontal(bias=" + this.f3103a + ')';
        }
    }

    public static final class b implements b.c {

        /* renamed from: a, reason: collision with root package name */
        private final float f3104a;

        public b(float f5) {
            this.f3104a = f5;
        }

        @Override // androidx.compose.ui.b.c
        public int a(int i5, int i6) {
            return Math.round(((i6 - i5) / 2.0f) * (1 + this.f3104a));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Float.compare(this.f3104a, ((b) obj).f3104a) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3104a);
        }

        public String toString() {
            return "Vertical(bias=" + this.f3104a + ')';
        }
    }

    public c(float f5, float f6) {
        this.f3101b = f5;
        this.f3102c = f6;
    }

    @Override // androidx.compose.ui.b
    public long a(long j5, long j6, LayoutDirection layoutDirection) {
        float g5 = (t.g(j6) - t.g(j5)) / 2.0f;
        float f5 = (t.f(j6) - t.f(j5)) / 2.0f;
        float f6 = 1;
        return q.a(Math.round(g5 * ((layoutDirection == LayoutDirection.Ltr ? this.f3101b : (-1) * this.f3101b) + f6)), Math.round(f5 * (f6 + this.f3102c)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Float.compare(this.f3101b, cVar.f3101b) == 0 && Float.compare(this.f3102c, cVar.f3102c) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f3101b) * 31) + Float.floatToIntBits(this.f3102c);
    }

    public String toString() {
        return "BiasAlignment(horizontalBias=" + this.f3101b + ", verticalBias=" + this.f3102c + ')';
    }
}
