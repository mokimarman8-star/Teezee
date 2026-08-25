package androidx.recyclerview.widget;

import androidx.recyclerview.widget.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class a implements l.a {

    /* renamed from: a, reason: collision with root package name */
    private androidx.core.util.f f12912a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f12913b;

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f12914c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC0093a f12915d;

    /* renamed from: e, reason: collision with root package name */
    Runnable f12916e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f12917f;

    /* renamed from: g, reason: collision with root package name */
    final l f12918g;

    /* renamed from: h, reason: collision with root package name */
    private int f12919h;

    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0093a {
        void a(int i5, int i6);

        void b(b bVar);

        void c(b bVar);

        void d(int i5, int i6);

        void e(int i5, int i6, Object obj);

        RecyclerView$a0 f(int i5);

        void g(int i5, int i6);

        void h(int i5, int i6);
    }

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        int f12920a;

        /* renamed from: b, reason: collision with root package name */
        int f12921b;

        /* renamed from: c, reason: collision with root package name */
        Object f12922c;

        /* renamed from: d, reason: collision with root package name */
        int f12923d;

        b(int i5, int i6, int i7, Object obj) {
            this.f12920a = i5;
            this.f12921b = i6;
            this.f12923d = i7;
            this.f12922c = obj;
        }

        String a() {
            int i5 = this.f12920a;
            return i5 != 1 ? i5 != 2 ? i5 != 4 ? i5 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i5 = this.f12920a;
            if (i5 != bVar.f12920a) {
                return false;
            }
            if (i5 == 8 && Math.abs(this.f12923d - this.f12921b) == 1 && this.f12923d == bVar.f12921b && this.f12921b == bVar.f12923d) {
                return true;
            }
            if (this.f12923d != bVar.f12923d || this.f12921b != bVar.f12921b) {
                return false;
            }
            Object obj2 = this.f12922c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f12922c)) {
                    return false;
                }
            } else if (bVar.f12922c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f12920a * 31) + this.f12921b) * 31) + this.f12923d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f12921b + "c:" + this.f12923d + ",p:" + this.f12922c + "]";
        }
    }

    a(InterfaceC0093a interfaceC0093a) {
        this(interfaceC0093a, false);
    }

    a(InterfaceC0093a interfaceC0093a, boolean z5) {
        this.f12912a = new androidx.core.util.g(30);
        this.f12913b = new ArrayList();
        this.f12914c = new ArrayList();
        this.f12919h = 0;
        this.f12915d = interfaceC0093a;
        this.f12917f = z5;
        this.f12918g = new l(this);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        boolean z5;
        char c5;
        int i5 = bVar.f12921b;
        int i6 = bVar.f12923d + i5;
        char c6 = 65535;
        int i7 = i5;
        int i8 = 0;
        while (i7 < i6) {
            if (this.f12915d.f(i7) != null || h(i7)) {
                if (c6 == 0) {
                    k(a(2, i5, i8, null));
                    z5 = true;
                } else {
                    z5 = false;
                }
                c5 = 1;
            } else {
                if (c6 == 1) {
                    v(a(2, i5, i8, null));
                    z5 = true;
                } else {
                    z5 = false;
                }
                c5 = 0;
            }
            if (z5) {
                i7 -= i8;
                i6 -= i8;
                i8 = 1;
            } else {
                i8++;
            }
            i7++;
            c6 = c5;
        }
        if (i8 != bVar.f12923d) {
            b(bVar);
            bVar = a(2, i5, i8, null);
        }
        if (c6 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i5 = bVar.f12921b;
        int i6 = bVar.f12923d + i5;
        int i7 = 0;
        boolean z5 = -1;
        int i8 = i5;
        while (i5 < i6) {
            if (this.f12915d.f(i5) != null || h(i5)) {
                if (!z5) {
                    k(a(4, i8, i7, bVar.f12922c));
                    i8 = i5;
                    i7 = 0;
                }
                z5 = true;
            } else {
                if (z5) {
                    v(a(4, i8, i7, bVar.f12922c));
                    i8 = i5;
                    i7 = 0;
                }
                z5 = false;
            }
            i7++;
            i5++;
        }
        if (i7 != bVar.f12923d) {
            Object obj = bVar.f12922c;
            b(bVar);
            bVar = a(4, i8, i7, obj);
        }
        if (z5) {
            v(bVar);
        } else {
            k(bVar);
        }
    }

    private boolean h(int i5) {
        int size = this.f12914c.size();
        for (int i6 = 0; i6 < size; i6++) {
            b bVar = (b) this.f12914c.get(i6);
            int i7 = bVar.f12920a;
            if (i7 == 8) {
                if (n(bVar.f12923d, i6 + 1) == i5) {
                    return true;
                }
            } else if (i7 == 1) {
                int i8 = bVar.f12921b;
                int i9 = bVar.f12923d + i8;
                while (i8 < i9) {
                    if (n(i8, i6 + 1) == i5) {
                        return true;
                    }
                    i8++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i5;
        int i6 = bVar.f12920a;
        if (i6 == 1 || i6 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z5 = z(bVar.f12921b, i6);
        int i7 = bVar.f12921b;
        int i8 = bVar.f12920a;
        if (i8 == 2) {
            i5 = 0;
        } else {
            if (i8 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i5 = 1;
        }
        int i9 = 1;
        for (int i10 = 1; i10 < bVar.f12923d; i10++) {
            int z6 = z(bVar.f12921b + (i5 * i10), bVar.f12920a);
            int i11 = bVar.f12920a;
            if (i11 == 2 ? z6 != z5 : !(i11 == 4 && z6 == z5 + 1)) {
                b a5 = a(i11, z5, i9, bVar.f12922c);
                l(a5, i7);
                b(a5);
                if (bVar.f12920a == 4) {
                    i7 += i9;
                }
                i9 = 1;
                z5 = z6;
            } else {
                i9++;
            }
        }
        Object obj = bVar.f12922c;
        b(bVar);
        if (i9 > 0) {
            b a6 = a(bVar.f12920a, z5, i9, obj);
            l(a6, i7);
            b(a6);
        }
    }

    private void v(b bVar) {
        this.f12914c.add(bVar);
        int i5 = bVar.f12920a;
        if (i5 == 1) {
            this.f12915d.g(bVar.f12921b, bVar.f12923d);
            return;
        }
        if (i5 == 2) {
            this.f12915d.d(bVar.f12921b, bVar.f12923d);
            return;
        }
        if (i5 == 4) {
            this.f12915d.e(bVar.f12921b, bVar.f12923d, bVar.f12922c);
        } else {
            if (i5 == 8) {
                this.f12915d.a(bVar.f12921b, bVar.f12923d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i5, int i6) {
        int i7;
        int i8;
        for (int size = this.f12914c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f12914c.get(size);
            int i9 = bVar.f12920a;
            if (i9 == 8) {
                int i10 = bVar.f12921b;
                int i11 = bVar.f12923d;
                if (i10 < i11) {
                    i8 = i10;
                    i7 = i11;
                } else {
                    i7 = i10;
                    i8 = i11;
                }
                if (i5 < i8 || i5 > i7) {
                    if (i5 < i10) {
                        if (i6 == 1) {
                            bVar.f12921b = i10 + 1;
                            bVar.f12923d = i11 + 1;
                        } else if (i6 == 2) {
                            bVar.f12921b = i10 - 1;
                            bVar.f12923d = i11 - 1;
                        }
                    }
                } else if (i8 == i10) {
                    if (i6 == 1) {
                        bVar.f12923d = i11 + 1;
                    } else if (i6 == 2) {
                        bVar.f12923d = i11 - 1;
                    }
                    i5++;
                } else {
                    if (i6 == 1) {
                        bVar.f12921b = i10 + 1;
                    } else if (i6 == 2) {
                        bVar.f12921b = i10 - 1;
                    }
                    i5--;
                }
            } else {
                int i12 = bVar.f12921b;
                if (i12 <= i5) {
                    if (i9 == 1) {
                        i5 -= bVar.f12923d;
                    } else if (i9 == 2) {
                        i5 += bVar.f12923d;
                    }
                } else if (i6 == 1) {
                    bVar.f12921b = i12 + 1;
                } else if (i6 == 2) {
                    bVar.f12921b = i12 - 1;
                }
            }
        }
        for (int size2 = this.f12914c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f12914c.get(size2);
            if (bVar2.f12920a == 8) {
                int i13 = bVar2.f12923d;
                if (i13 == bVar2.f12921b || i13 < 0) {
                    this.f12914c.remove(size2);
                    b(bVar2);
                }
            } else if (bVar2.f12923d <= 0) {
                this.f12914c.remove(size2);
                b(bVar2);
            }
        }
        return i5;
    }

    @Override // androidx.recyclerview.widget.l.a
    public b a(int i5, int i6, int i7, Object obj) {
        b bVar = (b) this.f12912a.acquire();
        if (bVar == null) {
            return new b(i5, i6, i7, obj);
        }
        bVar.f12920a = i5;
        bVar.f12921b = i6;
        bVar.f12923d = i7;
        bVar.f12922c = obj;
        return bVar;
    }

    @Override // androidx.recyclerview.widget.l.a
    public void b(b bVar) {
        if (this.f12917f) {
            return;
        }
        bVar.f12922c = null;
        this.f12912a.release(bVar);
    }

    public int e(int i5) {
        int size = this.f12913b.size();
        for (int i6 = 0; i6 < size; i6++) {
            b bVar = (b) this.f12913b.get(i6);
            int i7 = bVar.f12920a;
            if (i7 != 1) {
                if (i7 == 2) {
                    int i8 = bVar.f12921b;
                    if (i8 <= i5) {
                        int i9 = bVar.f12923d;
                        if (i8 + i9 > i5) {
                            return -1;
                        }
                        i5 -= i9;
                    } else {
                        continue;
                    }
                } else if (i7 == 8) {
                    int i10 = bVar.f12921b;
                    if (i10 == i5) {
                        i5 = bVar.f12923d;
                    } else {
                        if (i10 < i5) {
                            i5--;
                        }
                        if (bVar.f12923d <= i5) {
                            i5++;
                        }
                    }
                }
            } else if (bVar.f12921b <= i5) {
                i5 += bVar.f12923d;
            }
        }
        return i5;
    }

    void i() {
        int size = this.f12914c.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f12915d.c((b) this.f12914c.get(i5));
        }
        x(this.f12914c);
        this.f12919h = 0;
    }

    void j() {
        i();
        int size = this.f12913b.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = (b) this.f12913b.get(i5);
            int i6 = bVar.f12920a;
            if (i6 == 1) {
                this.f12915d.c(bVar);
                this.f12915d.g(bVar.f12921b, bVar.f12923d);
            } else if (i6 == 2) {
                this.f12915d.c(bVar);
                this.f12915d.h(bVar.f12921b, bVar.f12923d);
            } else if (i6 == 4) {
                this.f12915d.c(bVar);
                this.f12915d.e(bVar.f12921b, bVar.f12923d, bVar.f12922c);
            } else if (i6 == 8) {
                this.f12915d.c(bVar);
                this.f12915d.a(bVar.f12921b, bVar.f12923d);
            }
            Runnable runnable = this.f12916e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f12913b);
        this.f12919h = 0;
    }

    void l(b bVar, int i5) {
        this.f12915d.b(bVar);
        int i6 = bVar.f12920a;
        if (i6 == 2) {
            this.f12915d.h(i5, bVar.f12923d);
        } else {
            if (i6 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f12915d.e(i5, bVar.f12923d, bVar.f12922c);
        }
    }

    int m(int i5) {
        return n(i5, 0);
    }

    int n(int i5, int i6) {
        int size = this.f12914c.size();
        while (i6 < size) {
            b bVar = (b) this.f12914c.get(i6);
            int i7 = bVar.f12920a;
            if (i7 == 8) {
                int i8 = bVar.f12921b;
                if (i8 == i5) {
                    i5 = bVar.f12923d;
                } else {
                    if (i8 < i5) {
                        i5--;
                    }
                    if (bVar.f12923d <= i5) {
                        i5++;
                    }
                }
            } else {
                int i9 = bVar.f12921b;
                if (i9 > i5) {
                    continue;
                } else if (i7 == 2) {
                    int i10 = bVar.f12923d;
                    if (i5 < i9 + i10) {
                        return -1;
                    }
                    i5 -= i10;
                } else if (i7 == 1) {
                    i5 += bVar.f12923d;
                }
            }
            i6++;
        }
        return i5;
    }

    boolean o(int i5) {
        return (i5 & this.f12919h) != 0;
    }

    boolean p() {
        return this.f12913b.size() > 0;
    }

    boolean q() {
        return (this.f12914c.isEmpty() || this.f12913b.isEmpty()) ? false : true;
    }

    boolean r(int i5, int i6, Object obj) {
        if (i6 < 1) {
            return false;
        }
        this.f12913b.add(a(4, i5, i6, obj));
        this.f12919h |= 4;
        return this.f12913b.size() == 1;
    }

    boolean s(int i5, int i6) {
        if (i6 < 1) {
            return false;
        }
        this.f12913b.add(a(1, i5, i6, null));
        this.f12919h |= 1;
        return this.f12913b.size() == 1;
    }

    boolean t(int i5, int i6, int i7) {
        if (i5 == i6) {
            return false;
        }
        if (i7 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f12913b.add(a(8, i5, i6, null));
        this.f12919h |= 8;
        return this.f12913b.size() == 1;
    }

    boolean u(int i5, int i6) {
        if (i6 < 1) {
            return false;
        }
        this.f12913b.add(a(2, i5, i6, null));
        this.f12919h |= 2;
        return this.f12913b.size() == 1;
    }

    void w() {
        this.f12918g.b(this.f12913b);
        int size = this.f12913b.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = (b) this.f12913b.get(i5);
            int i6 = bVar.f12920a;
            if (i6 == 1) {
                c(bVar);
            } else if (i6 == 2) {
                f(bVar);
            } else if (i6 == 4) {
                g(bVar);
            } else if (i6 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f12916e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f12913b.clear();
    }

    void x(List list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            b((b) list.get(i5));
        }
        list.clear();
    }

    void y() {
        x(this.f12913b);
        x(this.f12914c);
        this.f12919h = 0;
    }
}
