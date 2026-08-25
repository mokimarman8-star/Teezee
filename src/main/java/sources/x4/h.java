package x4;

import androidx.core.os.s;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f18498a = new String[5];

    /* renamed from: b, reason: collision with root package name */
    private final long[] f18499b = new long[5];

    /* renamed from: c, reason: collision with root package name */
    private int f18500c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f18501d = 0;

    public void a(String str) {
        int i5 = this.f18500c;
        if (i5 == 5) {
            this.f18501d++;
            return;
        }
        this.f18498a[i5] = str;
        this.f18499b[i5] = System.nanoTime();
        s.a(str);
        this.f18500c++;
    }

    public float b(String str) {
        int i5 = this.f18501d;
        if (i5 > 0) {
            this.f18501d = i5 - 1;
            return 0.0f;
        }
        int i6 = this.f18500c - 1;
        this.f18500c = i6;
        if (i6 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(this.f18498a[i6])) {
            s.b();
            return (System.nanoTime() - this.f18499b[this.f18500c]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + this.f18498a[this.f18500c] + ".");
    }
}
