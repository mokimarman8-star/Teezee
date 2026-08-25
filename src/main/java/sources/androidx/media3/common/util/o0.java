package androidx.media3.common.util;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    private long[] f9108a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f9109b;

    /* renamed from: c, reason: collision with root package name */
    private int f9110c;

    /* renamed from: d, reason: collision with root package name */
    private int f9111d;

    public o0() {
        this(10);
    }

    public o0(int i5) {
        this.f9108a = new long[i5];
        this.f9109b = f(i5);
    }

    private void b(long j5, Object obj) {
        int i5 = this.f9110c;
        int i6 = this.f9111d;
        Object[] objArr = this.f9109b;
        int length = (i5 + i6) % objArr.length;
        this.f9108a[length] = j5;
        objArr[length] = obj;
        this.f9111d = i6 + 1;
    }

    private void d(long j5) {
        if (this.f9111d > 0) {
            if (j5 <= this.f9108a[((this.f9110c + r0) - 1) % this.f9109b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f9109b.length;
        if (this.f9111d < length) {
            return;
        }
        int i5 = length * 2;
        long[] jArr = new long[i5];
        Object[] f5 = f(i5);
        int i6 = this.f9110c;
        int i7 = length - i6;
        System.arraycopy(this.f9108a, i6, jArr, 0, i7);
        System.arraycopy(this.f9109b, this.f9110c, f5, 0, i7);
        int i8 = this.f9110c;
        if (i8 > 0) {
            System.arraycopy(this.f9108a, 0, jArr, i7, i8);
            System.arraycopy(this.f9109b, 0, f5, i7, this.f9110c);
        }
        this.f9108a = jArr;
        this.f9109b = f5;
        this.f9110c = 0;
    }

    private static Object[] f(int i5) {
        return new Object[i5];
    }

    private Object h(long j5, boolean z5) {
        Object obj = null;
        long j6 = Long.MAX_VALUE;
        while (this.f9111d > 0) {
            long j7 = j5 - this.f9108a[this.f9110c];
            if (j7 < 0 && (z5 || (-j7) >= j6)) {
                break;
            }
            obj = k();
            j6 = j7;
        }
        return obj;
    }

    private Object k() {
        a.g(this.f9111d > 0);
        Object[] objArr = this.f9109b;
        int i5 = this.f9110c;
        Object obj = objArr[i5];
        objArr[i5] = null;
        this.f9110c = (i5 + 1) % objArr.length;
        this.f9111d--;
        return obj;
    }

    public synchronized void a(long j5, Object obj) {
        d(j5);
        e();
        b(j5, obj);
    }

    public synchronized void c() {
        this.f9110c = 0;
        this.f9111d = 0;
        Arrays.fill(this.f9109b, (Object) null);
    }

    public synchronized Object g(long j5) {
        return h(j5, false);
    }

    public synchronized Object i() {
        return this.f9111d == 0 ? null : k();
    }

    public synchronized Object j(long j5) {
        return h(j5, true);
    }

    public synchronized int l() {
        return this.f9111d;
    }
}
