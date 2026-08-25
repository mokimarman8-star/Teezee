package androidx.databinding;

import androidx.databinding.c;
import androidx.databinding.j;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class h extends c {

    /* renamed from: f, reason: collision with root package name */
    private static final androidx.core.util.h f7406f = new androidx.core.util.h(10);

    /* renamed from: g, reason: collision with root package name */
    private static final c.a f7407g = new a();

    class a extends c.a {
        a() {
        }

        @Override // androidx.databinding.c.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j.a aVar, j jVar, int i5, b bVar) {
            if (i5 == 1) {
                aVar.b(jVar, bVar.f7408a, bVar.f7409b);
                return;
            }
            if (i5 == 2) {
                aVar.c(jVar, bVar.f7408a, bVar.f7409b);
                return;
            }
            if (i5 == 3) {
                aVar.d(jVar, bVar.f7408a, bVar.f7410c, bVar.f7409b);
            } else if (i5 != 4) {
                aVar.a(jVar);
            } else {
                aVar.e(jVar, bVar.f7408a, bVar.f7409b);
            }
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f7408a;

        /* renamed from: b, reason: collision with root package name */
        public int f7409b;

        /* renamed from: c, reason: collision with root package name */
        public int f7410c;

        b() {
        }
    }

    public h() {
        super(f7407g);
    }

    private static b m(int i5, int i6, int i7) {
        b bVar = (b) f7406f.acquire();
        if (bVar == null) {
            bVar = new b();
        }
        bVar.f7408a = i5;
        bVar.f7410c = i6;
        bVar.f7409b = i7;
        return bVar;
    }

    public synchronized void n(j jVar, int i5, b bVar) {
        super.d(jVar, i5, bVar);
        if (bVar != null) {
            f7406f.release(bVar);
        }
    }

    public void o(j jVar, int i5, int i6) {
        n(jVar, 1, m(i5, 0, i6));
    }

    public void p(j jVar, int i5, int i6) {
        n(jVar, 2, m(i5, 0, i6));
    }

    public void q(j jVar, int i5, int i6) {
        n(jVar, 4, m(i5, 0, i6));
    }
}
