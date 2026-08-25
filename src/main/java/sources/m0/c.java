package m0;

import java.util.Map;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private int[] f16483a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f16484b;

    /* renamed from: c, reason: collision with root package name */
    private int f16485c;

    @JvmOverloads
    public c() {
        this(0, 1, null);
    }

    public c(int i5) {
        if (i5 == 0) {
            this.f16483a = a.f16471a;
            this.f16484b = a.f16472b;
        } else {
            this.f16483a = new int[i5];
            this.f16484b = new Object[i5 << 1];
        }
        this.f16485c = 0;
    }

    public /* synthetic */ c(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0 : i5);
    }

    public final boolean a(Object obj) {
        return d(obj) >= 0;
    }

    public final Object b(Object obj) {
        int d5 = d(obj);
        if (d5 >= 0) {
            return this.f16484b[(d5 << 1) + 1];
        }
        return null;
    }

    protected final int c(Object obj, int i5) {
        int i6 = this.f16485c;
        if (i6 == 0) {
            return -1;
        }
        int a5 = a.a(this.f16483a, i6, i5);
        if (a5 < 0 || Intrinsics.c(obj, this.f16484b[a5 << 1])) {
            return a5;
        }
        int i7 = a5 + 1;
        while (i7 < i6 && this.f16483a[i7] == i5) {
            if (Intrinsics.c(obj, this.f16484b[i7 << 1])) {
                return i7;
            }
            i7++;
        }
        for (int i8 = a5 - 1; i8 >= 0 && this.f16483a[i8] == i5; i8--) {
            if (Intrinsics.c(obj, this.f16484b[i8 << 1])) {
                return i8;
            }
        }
        return ~i7;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj, obj.hashCode());
    }

    protected final int e() {
        int i5 = this.f16485c;
        if (i5 == 0) {
            return -1;
        }
        int a5 = a.a(this.f16483a, i5, 0);
        if (a5 < 0 || this.f16484b[a5 << 1] == null) {
            return a5;
        }
        int i6 = a5 + 1;
        while (i6 < i5 && this.f16483a[i6] == 0) {
            if (this.f16484b[i6 << 1] == null) {
                return i6;
            }
            i6++;
        }
        for (int i7 = a5 - 1; i7 >= 0 && this.f16483a[i7] == 0; i7--) {
            if (this.f16484b[i7 << 1] == null) {
                return i7;
            }
        }
        return ~i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof c) {
                c cVar = (c) obj;
                int i5 = this.f16485c;
                if (i5 != cVar.f16485c) {
                    return false;
                }
                for (int i6 = 0; i6 < i5; i6++) {
                    Object g5 = g(i6);
                    Object h5 = h(i6);
                    Object b5 = cVar.b(g5);
                    if (h5 == null) {
                        if (b5 != null || !cVar.a(g5)) {
                            return false;
                        }
                    } else if (!Intrinsics.c(h5, b5)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f16485c != ((Map) obj).size()) {
                return false;
            }
            int i7 = this.f16485c;
            for (int i8 = 0; i8 < i7; i8++) {
                Object g6 = g(i8);
                Object h6 = h(i8);
                Object obj2 = ((Map) obj).get(g6);
                if (h6 == null) {
                    if (obj2 != null || !((Map) obj).containsKey(g6)) {
                        return false;
                    }
                } else if (!Intrinsics.c(h6, obj2)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final boolean f() {
        return this.f16485c <= 0;
    }

    public final Object g(int i5) {
        return this.f16484b[i5 << 1];
    }

    public final Object h(int i5) {
        return this.f16484b[(i5 << 1) + 1];
    }

    public int hashCode() {
        int[] iArr = this.f16483a;
        Object[] objArr = this.f16484b;
        int i5 = this.f16485c;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            i8 += (obj != null ? obj.hashCode() : 0) ^ iArr[i7];
            i7++;
            i6 += 2;
        }
        return i8;
    }

    public String toString() {
        if (f()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f16485c * 28);
        sb.append('{');
        int i5 = this.f16485c;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            Object g5 = g(i6);
            if (g5 != this) {
                sb.append(g5);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object h5 = h(i6);
            if (h5 != this) {
                sb.append(h5);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
