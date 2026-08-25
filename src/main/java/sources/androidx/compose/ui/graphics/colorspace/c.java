package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f3346d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f3347a;

    /* renamed from: b, reason: collision with root package name */
    private final long f3348b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3349c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private c(String str, long j5, int i5) {
        this.f3347a = str;
        this.f3348b = j5;
        this.f3349c = i5;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if (i5 < -1 || i5 > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }

    public /* synthetic */ c(String str, long j5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j5, i5);
    }

    public final int a() {
        return b.f(this.f3348b);
    }

    public final int b() {
        return this.f3349c;
    }

    public abstract float c(int i5);

    public abstract float d(int i5);

    public final long e() {
        return this.f3348b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f3349c == cVar.f3349c && Intrinsics.c(this.f3347a, cVar.f3347a)) {
            return b.e(this.f3348b, cVar.f3348b);
        }
        return false;
    }

    public final String f() {
        return this.f3347a;
    }

    public boolean g() {
        return false;
    }

    public abstract long h(float f5, float f6, float f7);

    public int hashCode() {
        return (((this.f3347a.hashCode() * 31) + b.g(this.f3348b)) * 31) + this.f3349c;
    }

    public abstract float i(float f5, float f6, float f7);

    public abstract long j(float f5, float f6, float f7, float f8, c cVar);

    public String toString() {
        return this.f3347a + " (id=" + this.f3349c + ", model=" + ((Object) b.h(this.f3348b)) + ')';
    }
}
