package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public static final a f5421c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final m f5422d = new m(1.0f, 0.0f);

    /* renamed from: a, reason: collision with root package name */
    private final float f5423a;

    /* renamed from: b, reason: collision with root package name */
    private final float f5424b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final m a() {
            return m.f5422d;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public m() {
        this(r2, r2, 3, null);
        float f5 = 0.0f;
    }

    public m(float f5, float f6) {
        this.f5423a = f5;
        this.f5424b = f6;
    }

    public /* synthetic */ m(float f5, float f6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 1.0f : f5, (i5 & 2) != 0 ? 0.0f : f6);
    }

    public final float b() {
        return this.f5423a;
    }

    public final float c() {
        return this.f5424b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f5423a == mVar.f5423a && this.f5424b == mVar.f5424b;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f5423a) * 31) + Float.floatToIntBits(this.f5424b);
    }

    public String toString() {
        return "TextGeometricTransform(scaleX=" + this.f5423a + ", skewX=" + this.f5424b + ')';
    }
}
