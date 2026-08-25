package z;

import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.p4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class m extends h {

    /* renamed from: e, reason: collision with root package name */
    public static final a f18708e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final int f18709f = c5.f3315a.a();

    /* renamed from: g, reason: collision with root package name */
    private static final int f18710g = d5.f3427a.b();

    /* renamed from: a, reason: collision with root package name */
    private final float f18711a;

    /* renamed from: b, reason: collision with root package name */
    private final float f18712b;

    /* renamed from: c, reason: collision with root package name */
    private final int f18713c;

    /* renamed from: d, reason: collision with root package name */
    private final int f18714d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return m.f18709f;
        }
    }

    private m(float f5, float f6, int i5, int i6, p4 p4Var) {
        super(null);
        this.f18711a = f5;
        this.f18712b = f6;
        this.f18713c = i5;
        this.f18714d = i6;
    }

    public /* synthetic */ m(float f5, float f6, int i5, int i6, p4 p4Var, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? 0.0f : f5, (i7 & 2) != 0 ? 4.0f : f6, (i7 & 4) != 0 ? f18709f : i5, (i7 & 8) != 0 ? f18710g : i6, (i7 & 16) != 0 ? null : p4Var, null);
    }

    public /* synthetic */ m(float f5, float f6, int i5, int i6, p4 p4Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, i5, i6, p4Var);
    }

    public final int b() {
        return this.f18713c;
    }

    public final int c() {
        return this.f18714d;
    }

    public final float d() {
        return this.f18712b;
    }

    public final p4 e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f18711a != mVar.f18711a || this.f18712b != mVar.f18712b || !c5.e(this.f18713c, mVar.f18713c) || !d5.e(this.f18714d, mVar.f18714d)) {
            return false;
        }
        mVar.getClass();
        return Intrinsics.c((Object) null, (Object) null);
    }

    public final float f() {
        return this.f18711a;
    }

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.f18711a) * 31) + Float.floatToIntBits(this.f18712b)) * 31) + c5.f(this.f18713c)) * 31) + d5.f(this.f18714d)) * 31;
    }

    public String toString() {
        return "Stroke(width=" + this.f18711a + ", miter=" + this.f18712b + ", cap=" + ((Object) c5.g(this.f18713c)) + ", join=" + ((Object) d5.g(this.f18714d)) + ", pathEffect=" + ((Object) null) + ')';
    }
}
