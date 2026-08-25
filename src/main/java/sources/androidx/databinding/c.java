package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class c implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private List f7400a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private long f7401b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long[] f7402c;

    /* renamed from: d, reason: collision with root package name */
    private int f7403d;

    /* renamed from: e, reason: collision with root package name */
    private final a f7404e;

    public static abstract class a {
        public abstract void a(Object obj, Object obj2, int i5, Object obj3);
    }

    public c(a aVar) {
        this.f7404e = aVar;
    }

    private boolean c(int i5) {
        int i6;
        if (i5 < 64) {
            return ((1 << i5) & this.f7401b) != 0;
        }
        long[] jArr = this.f7402c;
        if (jArr != null && (i6 = (i5 / 64) - 1) < jArr.length) {
            return ((1 << (i5 % 64)) & jArr[i6]) != 0;
        }
        return false;
    }

    private void e(Object obj, int i5, Object obj2, int i6, int i7, long j5) {
        long j6 = 1;
        while (i6 < i7) {
            if ((j5 & j6) == 0) {
                this.f7404e.a(this.f7400a.get(i6), obj, i5, obj2);
            }
            j6 <<= 1;
            i6++;
        }
    }

    private void g(Object obj, int i5, Object obj2) {
        e(obj, i5, obj2, 0, Math.min(64, this.f7400a.size()), this.f7401b);
    }

    private void h(Object obj, int i5, Object obj2) {
        int size = this.f7400a.size();
        int length = this.f7402c == null ? -1 : r0.length - 1;
        i(obj, i5, obj2, length);
        e(obj, i5, obj2, (length + 2) * 64, size, 0L);
    }

    private void i(Object obj, int i5, Object obj2, int i6) {
        if (i6 < 0) {
            g(obj, i5, obj2);
            return;
        }
        long j5 = this.f7402c[i6];
        int i7 = (i6 + 1) * 64;
        int min = Math.min(this.f7400a.size(), i7 + 64);
        i(obj, i5, obj2, i6 - 1);
        e(obj, i5, obj2, i7, min, j5);
    }

    private void k(int i5, long j5) {
        long j6 = Long.MIN_VALUE;
        for (int i6 = i5 + 63; i6 >= i5; i6--) {
            if ((j5 & j6) != 0) {
                this.f7400a.remove(i6);
            }
            j6 >>>= 1;
        }
    }

    private void l(int i5) {
        if (i5 < 64) {
            this.f7401b = (1 << i5) | this.f7401b;
            return;
        }
        int i6 = (i5 / 64) - 1;
        long[] jArr = this.f7402c;
        if (jArr == null) {
            this.f7402c = new long[this.f7400a.size() / 64];
        } else if (jArr.length <= i6) {
            long[] jArr2 = new long[this.f7400a.size() / 64];
            long[] jArr3 = this.f7402c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f7402c = jArr2;
        }
        long j5 = 1 << (i5 % 64);
        long[] jArr4 = this.f7402c;
        jArr4[i6] = j5 | jArr4[i6];
    }

    public synchronized void a(Object obj) {
        try {
            if (obj == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            int lastIndexOf = this.f7400a.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                if (c(lastIndexOf)) {
                }
            }
            this.f7400a.add(obj);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized c clone() {
        c cVar;
        CloneNotSupportedException e5;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e6) {
            cVar = null;
            e5 = e6;
        }
        try {
            cVar.f7401b = 0L;
            cVar.f7402c = null;
            cVar.f7403d = 0;
            cVar.f7400a = new ArrayList();
            int size = this.f7400a.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (!c(i5)) {
                    cVar.f7400a.add(this.f7400a.get(i5));
                }
            }
        } catch (CloneNotSupportedException e7) {
            e5 = e7;
            e5.printStackTrace();
            return cVar;
        }
        return cVar;
    }

    public synchronized void d(Object obj, int i5, Object obj2) {
        try {
            this.f7403d++;
            h(obj, i5, obj2);
            int i6 = this.f7403d - 1;
            this.f7403d = i6;
            if (i6 == 0) {
                long[] jArr = this.f7402c;
                if (jArr != null) {
                    for (int length = jArr.length - 1; length >= 0; length--) {
                        long j5 = this.f7402c[length];
                        if (j5 != 0) {
                            k((length + 1) * 64, j5);
                            this.f7402c[length] = 0;
                        }
                    }
                }
                long j6 = this.f7401b;
                if (j6 != 0) {
                    k(0, j6);
                    this.f7401b = 0L;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void j(Object obj) {
        try {
            if (this.f7403d == 0) {
                this.f7400a.remove(obj);
            } else {
                int lastIndexOf = this.f7400a.lastIndexOf(obj);
                if (lastIndexOf >= 0) {
                    l(lastIndexOf);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
