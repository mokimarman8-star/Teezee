package td;

import com.google.zxing.k;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class c {
    private final int a;
    private final int[] b;
    private final k[] c;

    public c(int i, int[] iArr, int i2, int i3, int i4) {
        this.a = i;
        this.b = iArr;
        float f = i2;
        float f2 = i4;
        this.c = new k[]{new k(f, f2), new k(i3, f2)};
    }

    public k[] a() {
        return this.c;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
