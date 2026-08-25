package androidx.media3.common.util;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class l0 {

    /* renamed from: c, reason: collision with root package name */
    public static final l0 f9083c = new l0(-1, -1);

    /* renamed from: d, reason: collision with root package name */
    public static final l0 f9084d = new l0(0, 0);

    /* renamed from: a, reason: collision with root package name */
    private final int f9085a;

    /* renamed from: b, reason: collision with root package name */
    private final int f9086b;

    public l0(int i5, int i6) {
        a.a((i5 == -1 || i5 >= 0) && (i6 == -1 || i6 >= 0));
        this.f9085a = i5;
        this.f9086b = i6;
    }

    public int a() {
        return this.f9086b;
    }

    public int b() {
        return this.f9085a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.f9085a == l0Var.f9085a && this.f9086b == l0Var.f9086b;
    }

    public int hashCode() {
        int i5 = this.f9086b;
        int i6 = this.f9085a;
        return i5 ^ ((i6 >>> 16) | (i6 << 16));
    }

    public String toString() {
        return this.f9085a + "x" + this.f9086b;
    }
}
