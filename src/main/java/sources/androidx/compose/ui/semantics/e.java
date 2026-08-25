package androidx.compose.ui.semantics;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final a f4955d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final e f4956e = new e(0.0f, RangesKt.b(0.0f, 0.0f), 0, 4, null);

    /* renamed from: a, reason: collision with root package name */
    private final float f4957a;

    /* renamed from: b, reason: collision with root package name */
    private final ClosedFloatingPointRange f4958b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4959c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            return e.f4956e;
        }
    }

    public e(float f5, ClosedFloatingPointRange closedFloatingPointRange, int i5) {
        this.f4957a = f5;
        this.f4958b = closedFloatingPointRange;
        this.f4959c = i5;
        if (Float.isNaN(f5)) {
            throw new IllegalArgumentException("current must not be NaN");
        }
    }

    public /* synthetic */ e(float f5, ClosedFloatingPointRange closedFloatingPointRange, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, closedFloatingPointRange, (i6 & 4) != 0 ? 0 : i5);
    }

    public final float b() {
        return this.f4957a;
    }

    public final ClosedFloatingPointRange c() {
        return this.f4958b;
    }

    public final int d() {
        return this.f4959c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f4957a == eVar.f4957a && Intrinsics.c(this.f4958b, eVar.f4958b) && this.f4959c == eVar.f4959c;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f4957a) * 31) + this.f4958b.hashCode()) * 31) + this.f4959c;
    }

    public String toString() {
        return "ProgressBarRangeInfo(current=" + this.f4957a + ", range=" + this.f4958b + ", steps=" + this.f4959c + ')';
    }
}
