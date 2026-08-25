package androidx.compose.runtime.internal;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final int f2764a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f2765b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f2766c;

    public f(int i5, long[] jArr, Object[] objArr) {
        this.f2764a = i5;
        this.f2765b = jArr;
        this.f2766c = objArr;
    }

    private final int a(long j5) {
        int i5 = this.f2764a - 1;
        if (i5 == -1) {
            return -1;
        }
        int i6 = 0;
        if (i5 == 0) {
            long j6 = this.f2765b[0];
            if (j6 == j5) {
                return 0;
            }
            return j6 > j5 ? -2 : -1;
        }
        while (i6 <= i5) {
            int i7 = (i6 + i5) >>> 1;
            long j7 = this.f2765b[i7] - j5;
            if (j7 < 0) {
                i6 = i7 + 1;
            } else {
                if (j7 <= 0) {
                    return i7;
                }
                i5 = i7 - 1;
            }
        }
        return -(i6 + 1);
    }

    public final Object b(long j5) {
        int a5 = a(j5);
        if (a5 >= 0) {
            return this.f2766c[a5];
        }
        return null;
    }

    public final f c(long j5, Object obj) {
        int i5 = this.f2764a;
        int i6 = 0;
        int i7 = 0;
        for (Object obj2 : this.f2766c) {
            if (obj2 != null) {
                i7++;
            }
        }
        int i8 = i7 + 1;
        long[] jArr = new long[i8];
        Object[] objArr = new Object[i8];
        if (i8 > 1) {
            int i9 = 0;
            while (true) {
                if (i6 >= i8 || i9 >= i5) {
                    break;
                }
                long j6 = this.f2765b[i9];
                Object obj3 = this.f2766c[i9];
                if (j6 > j5) {
                    jArr[i6] = j5;
                    objArr[i6] = obj;
                    i6++;
                    break;
                }
                if (obj3 != null) {
                    jArr[i6] = j6;
                    objArr[i6] = obj3;
                    i6++;
                }
                i9++;
            }
            if (i9 == i5) {
                jArr[i7] = j5;
                objArr[i7] = obj;
            } else {
                while (i6 < i8) {
                    long j7 = this.f2765b[i9];
                    Object obj4 = this.f2766c[i9];
                    if (obj4 != null) {
                        jArr[i6] = j7;
                        objArr[i6] = obj4;
                        i6++;
                    }
                    i9++;
                }
            }
        } else {
            jArr[0] = j5;
            objArr[0] = obj;
        }
        return new f(i8, jArr, objArr);
    }

    public final boolean d(long j5, Object obj) {
        int a5 = a(j5);
        if (a5 < 0) {
            return false;
        }
        this.f2766c[a5] = obj;
        return true;
    }
}
