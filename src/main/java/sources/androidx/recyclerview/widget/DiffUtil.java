package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class DiffUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator f12735a = new Comparator<c>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar.f12738a - cVar2.f12738a;
        }
    };

    public static abstract class a {
        public abstract boolean a(int i5, int i6);

        public abstract boolean b(int i5, int i6);

        public Object c(int i5, int i6) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f12736a;

        /* renamed from: b, reason: collision with root package name */
        private final int f12737b;

        b(int i5) {
            int[] iArr = new int[i5];
            this.f12736a = iArr;
            this.f12737b = iArr.length / 2;
        }

        int[] a() {
            return this.f12736a;
        }

        int b(int i5) {
            return this.f12736a[i5 + this.f12737b];
        }

        void c(int i5, int i6) {
            this.f12736a[i5 + this.f12737b] = i6;
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f12738a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12739b;

        /* renamed from: c, reason: collision with root package name */
        public final int f12740c;

        c(int i5, int i6, int i7) {
            this.f12738a = i5;
            this.f12739b = i6;
            this.f12740c = i7;
        }

        int a() {
            return this.f12738a + this.f12740c;
        }

        int b() {
            return this.f12739b + this.f12740c;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final List f12741a;

        /* renamed from: b, reason: collision with root package name */
        private final int[] f12742b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f12743c;

        /* renamed from: d, reason: collision with root package name */
        private final a f12744d;

        /* renamed from: e, reason: collision with root package name */
        private final int f12745e;

        /* renamed from: f, reason: collision with root package name */
        private final int f12746f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f12747g;

        d(a aVar, List list, int[] iArr, int[] iArr2, boolean z5) {
            this.f12741a = list;
            this.f12742b = iArr;
            this.f12743c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f12744d = aVar;
            this.f12745e = aVar.e();
            this.f12746f = aVar.d();
            this.f12747g = z5;
            a();
            e();
        }

        private void a() {
            c cVar = this.f12741a.isEmpty() ? null : (c) this.f12741a.get(0);
            if (cVar == null || cVar.f12738a != 0 || cVar.f12739b != 0) {
                this.f12741a.add(0, new c(0, 0, 0));
            }
            this.f12741a.add(new c(this.f12745e, this.f12746f, 0));
        }

        private void d(int i5) {
            int size = this.f12741a.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                c cVar = (c) this.f12741a.get(i7);
                while (i6 < cVar.f12739b) {
                    if (this.f12743c[i6] == 0 && this.f12744d.b(i5, i6)) {
                        int i8 = this.f12744d.a(i5, i6) ? 8 : 4;
                        this.f12742b[i5] = (i6 << 4) | i8;
                        this.f12743c[i6] = (i5 << 4) | i8;
                        return;
                    }
                    i6++;
                }
                i6 = cVar.b();
            }
        }

        private void e() {
            for (c cVar : this.f12741a) {
                for (int i5 = 0; i5 < cVar.f12740c; i5++) {
                    int i6 = cVar.f12738a + i5;
                    int i7 = cVar.f12739b + i5;
                    int i8 = this.f12744d.a(i6, i7) ? 1 : 2;
                    this.f12742b[i6] = (i7 << 4) | i8;
                    this.f12743c[i7] = (i6 << 4) | i8;
                }
            }
            if (this.f12747g) {
                f();
            }
        }

        private void f() {
            int i5 = 0;
            for (c cVar : this.f12741a) {
                while (i5 < cVar.f12738a) {
                    if (this.f12742b[i5] == 0) {
                        d(i5);
                    }
                    i5++;
                }
                i5 = cVar.a();
            }
        }

        private static f g(Collection collection, int i5, boolean z5) {
            f fVar;
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                fVar = (f) it.next();
                if (fVar.f12748a == i5 && fVar.f12750c == z5) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                f fVar2 = (f) it.next();
                if (z5) {
                    fVar2.f12749b--;
                } else {
                    fVar2.f12749b++;
                }
            }
            return fVar;
        }

        public void b(j jVar) {
            int i5;
            androidx.recyclerview.widget.d dVar = jVar instanceof androidx.recyclerview.widget.d ? (androidx.recyclerview.widget.d) jVar : new androidx.recyclerview.widget.d(jVar);
            int i6 = this.f12745e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i7 = this.f12745e;
            int i8 = this.f12746f;
            for (int size = this.f12741a.size() - 1; size >= 0; size--) {
                c cVar = (c) this.f12741a.get(size);
                int a5 = cVar.a();
                int b5 = cVar.b();
                while (true) {
                    if (i7 <= a5) {
                        break;
                    }
                    i7--;
                    int i9 = this.f12742b[i7];
                    if ((i9 & 12) != 0) {
                        int i10 = i9 >> 4;
                        f g5 = g(arrayDeque, i10, false);
                        if (g5 != null) {
                            int i11 = (i6 - g5.f12749b) - 1;
                            dVar.onMoved(i7, i11);
                            if ((i9 & 4) != 0) {
                                dVar.onChanged(i11, 1, this.f12744d.c(i7, i10));
                            }
                        } else {
                            arrayDeque.add(new f(i7, (i6 - i7) - 1, true));
                        }
                    } else {
                        dVar.onRemoved(i7, 1);
                        i6--;
                    }
                }
                while (i8 > b5) {
                    i8--;
                    int i12 = this.f12743c[i8];
                    if ((i12 & 12) != 0) {
                        int i13 = i12 >> 4;
                        f g6 = g(arrayDeque, i13, true);
                        if (g6 == null) {
                            arrayDeque.add(new f(i8, i6 - i7, false));
                        } else {
                            dVar.onMoved((i6 - g6.f12749b) - 1, i7);
                            if ((i12 & 4) != 0) {
                                dVar.onChanged(i7, 1, this.f12744d.c(i13, i8));
                            }
                        }
                    } else {
                        dVar.onInserted(i7, 1);
                        i6++;
                    }
                }
                int i14 = cVar.f12738a;
                int i15 = cVar.f12739b;
                for (i5 = 0; i5 < cVar.f12740c; i5++) {
                    if ((this.f12742b[i14] & 15) == 2) {
                        dVar.onChanged(i14, 1, this.f12744d.c(i14, i15));
                    }
                    i14++;
                    i15++;
                }
                i7 = cVar.f12738a;
                i8 = cVar.f12739b;
            }
            dVar.a();
        }

        public void c(RecyclerView.Adapter adapter) {
            b(new androidx.recyclerview.widget.b(adapter));
        }
    }

    public static abstract class e {
        public abstract boolean areContentsTheSame(Object obj, Object obj2);

        public abstract boolean areItemsTheSame(Object obj, Object obj2);

        @Nullable
        public Object getChangePayload(@NonNull Object obj, @NonNull Object obj2) {
            return null;
        }
    }

    private static class f {

        /* renamed from: a, reason: collision with root package name */
        int f12748a;

        /* renamed from: b, reason: collision with root package name */
        int f12749b;

        /* renamed from: c, reason: collision with root package name */
        boolean f12750c;

        f(int i5, int i6, boolean z5) {
            this.f12748a = i5;
            this.f12749b = i6;
            this.f12750c = z5;
        }
    }

    static class g {

        /* renamed from: a, reason: collision with root package name */
        int f12751a;

        /* renamed from: b, reason: collision with root package name */
        int f12752b;

        /* renamed from: c, reason: collision with root package name */
        int f12753c;

        /* renamed from: d, reason: collision with root package name */
        int f12754d;

        public g() {
        }

        public g(int i5, int i6, int i7, int i8) {
            this.f12751a = i5;
            this.f12752b = i6;
            this.f12753c = i7;
            this.f12754d = i8;
        }

        int a() {
            return this.f12754d - this.f12753c;
        }

        int b() {
            return this.f12752b - this.f12751a;
        }
    }

    static class h {

        /* renamed from: a, reason: collision with root package name */
        public int f12755a;

        /* renamed from: b, reason: collision with root package name */
        public int f12756b;

        /* renamed from: c, reason: collision with root package name */
        public int f12757c;

        /* renamed from: d, reason: collision with root package name */
        public int f12758d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f12759e;

        h() {
        }

        int a() {
            return Math.min(this.f12757c - this.f12755a, this.f12758d - this.f12756b);
        }

        boolean b() {
            return this.f12758d - this.f12756b != this.f12757c - this.f12755a;
        }

        boolean c() {
            return this.f12758d - this.f12756b > this.f12757c - this.f12755a;
        }

        c d() {
            if (b()) {
                return this.f12759e ? new c(this.f12755a, this.f12756b, a()) : c() ? new c(this.f12755a, this.f12756b + 1, a()) : new c(this.f12755a + 1, this.f12756b, a());
            }
            int i5 = this.f12755a;
            return new c(i5, this.f12756b, this.f12757c - i5);
        }
    }

    private static h a(g gVar, a aVar, b bVar, b bVar2, int i5) {
        int b5;
        int i6;
        int i7;
        boolean z5 = (gVar.b() - gVar.a()) % 2 == 0;
        int b6 = gVar.b() - gVar.a();
        int i8 = -i5;
        for (int i9 = i8; i9 <= i5; i9 += 2) {
            if (i9 == i8 || (i9 != i5 && bVar2.b(i9 + 1) < bVar2.b(i9 - 1))) {
                b5 = bVar2.b(i9 + 1);
                i6 = b5;
            } else {
                b5 = bVar2.b(i9 - 1);
                i6 = b5 - 1;
            }
            int i10 = gVar.f12754d - ((gVar.f12752b - i6) - i9);
            int i11 = (i5 == 0 || i6 != b5) ? i10 : i10 + 1;
            while (i6 > gVar.f12751a && i10 > gVar.f12753c && aVar.b(i6 - 1, i10 - 1)) {
                i6--;
                i10--;
            }
            bVar2.c(i9, i6);
            if (z5 && (i7 = b6 - i9) >= i8 && i7 <= i5 && bVar.b(i7) >= i6) {
                h hVar = new h();
                hVar.f12755a = i6;
                hVar.f12756b = i10;
                hVar.f12757c = b5;
                hVar.f12758d = i11;
                hVar.f12759e = true;
                return hVar;
            }
        }
        return null;
    }

    public static d b(a aVar) {
        return c(aVar, true);
    }

    public static d c(a aVar, boolean z5) {
        int e5 = aVar.e();
        int d5 = aVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new g(0, e5, 0, d5));
        int i5 = ((((e5 + d5) + 1) / 2) * 2) + 1;
        b bVar = new b(i5);
        b bVar2 = new b(i5);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            g gVar = (g) arrayList2.remove(arrayList2.size() - 1);
            h e6 = e(gVar, aVar, bVar, bVar2);
            if (e6 != null) {
                if (e6.a() > 0) {
                    arrayList.add(e6.d());
                }
                g gVar2 = arrayList3.isEmpty() ? new g() : (g) arrayList3.remove(arrayList3.size() - 1);
                gVar2.f12751a = gVar.f12751a;
                gVar2.f12753c = gVar.f12753c;
                gVar2.f12752b = e6.f12755a;
                gVar2.f12754d = e6.f12756b;
                arrayList2.add(gVar2);
                gVar.f12752b = gVar.f12752b;
                gVar.f12754d = gVar.f12754d;
                gVar.f12751a = e6.f12757c;
                gVar.f12753c = e6.f12758d;
                arrayList2.add(gVar);
            } else {
                arrayList3.add(gVar);
            }
        }
        Collections.sort(arrayList, f12735a);
        return new d(aVar, arrayList, bVar.a(), bVar2.a(), z5);
    }

    private static h d(g gVar, a aVar, b bVar, b bVar2, int i5) {
        int b5;
        int i6;
        int i7;
        boolean z5 = Math.abs(gVar.b() - gVar.a()) % 2 == 1;
        int b6 = gVar.b() - gVar.a();
        int i8 = -i5;
        for (int i9 = i8; i9 <= i5; i9 += 2) {
            if (i9 == i8 || (i9 != i5 && bVar.b(i9 + 1) > bVar.b(i9 - 1))) {
                b5 = bVar.b(i9 + 1);
                i6 = b5;
            } else {
                b5 = bVar.b(i9 - 1);
                i6 = b5 + 1;
            }
            int i10 = (gVar.f12753c + (i6 - gVar.f12751a)) - i9;
            int i11 = (i5 == 0 || i6 != b5) ? i10 : i10 - 1;
            while (i6 < gVar.f12752b && i10 < gVar.f12754d && aVar.b(i6, i10)) {
                i6++;
                i10++;
            }
            bVar.c(i9, i6);
            if (z5 && (i7 = b6 - i9) >= i8 + 1 && i7 <= i5 - 1 && bVar2.b(i7) <= i6) {
                h hVar = new h();
                hVar.f12755a = b5;
                hVar.f12756b = i11;
                hVar.f12757c = i6;
                hVar.f12758d = i10;
                hVar.f12759e = false;
                return hVar;
            }
        }
        return null;
    }

    private static h e(g gVar, a aVar, b bVar, b bVar2) {
        if (gVar.b() >= 1 && gVar.a() >= 1) {
            int b5 = ((gVar.b() + gVar.a()) + 1) / 2;
            bVar.c(1, gVar.f12751a);
            bVar2.c(1, gVar.f12752b);
            for (int i5 = 0; i5 < b5; i5++) {
                h d5 = d(gVar, aVar, bVar, bVar2, i5);
                if (d5 != null) {
                    return d5;
                }
                h a5 = a(gVar, aVar, bVar, bVar2, i5);
                if (a5 != null) {
                    return a5;
                }
            }
        }
        return null;
    }
}
