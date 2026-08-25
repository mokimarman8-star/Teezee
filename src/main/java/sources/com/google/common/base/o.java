package com.google.common.base;

import com.google.protobuf.h1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class o {
    private final com.google.common.base.b a;
    private final boolean b;
    private final d c;
    private final int d;

    class a implements d {
        final /* synthetic */ com.google.common.base.b a;

        /* renamed from: com.google.common.base.o$a$a, reason: collision with other inner class name */
        class C0005a extends c {
            C0005a(o oVar, CharSequence charSequence) {
                super(oVar, charSequence);
            }

            @Override // com.google.common.base.o.c
            int e(int i) {
                return i + 1;
            }

            @Override // com.google.common.base.o.c
            int f(int i) {
                return a.this.a.e(this.c, i);
            }
        }

        a(com.google.common.base.b bVar) {
            this.a = bVar;
        }

        @Override // com.google.common.base.o.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(o oVar, CharSequence charSequence) {
            return new C0005a(oVar, charSequence);
        }
    }

    class b implements Iterable {
        final /* synthetic */ CharSequence a;
        final /* synthetic */ o b;

        b(o oVar, CharSequence charSequence) {
            this.a = charSequence;
            this.b = oVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.b.j(this.a);
        }

        public String toString() {
            g h = g.h(", ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            StringBuilder b = h.b(sb2, this);
            b.append(']');
            return b.toString();
        }
    }

    private static abstract class c extends AbstractIterator {
        final CharSequence c;
        final com.google.common.base.b d;
        final boolean e;
        int f = 0;
        int g;

        protected c(o oVar, CharSequence charSequence) {
            this.d = oVar.a;
            this.e = oVar.b;
            this.g = oVar.d;
            this.c = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int f;
            int i = this.f;
            while (true) {
                int i2 = this.f;
                if (i2 == -1) {
                    return (String) b();
                }
                f = f(i2);
                if (f == -1) {
                    f = this.c.length();
                    this.f = -1;
                } else {
                    this.f = e(f);
                }
                int i3 = this.f;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    this.f = i4;
                    if (i4 > this.c.length()) {
                        this.f = -1;
                    }
                } else {
                    while (i < f && this.d.g(this.c.charAt(i))) {
                        i++;
                    }
                    while (f > i && this.d.g(this.c.charAt(f - 1))) {
                        f--;
                    }
                    if (!this.e || i != f) {
                        break;
                    }
                    i = this.f;
                }
            }
            int i5 = this.g;
            if (i5 == 1) {
                f = this.c.length();
                this.f = -1;
                while (f > i && this.d.g(this.c.charAt(f - 1))) {
                    f--;
                }
            } else {
                this.g = i5 - 1;
            }
            return this.c.subSequence(i, f).toString();
        }

        abstract int e(int i);

        abstract int f(int i);
    }

    private interface d {
        Iterator a(o oVar, CharSequence charSequence);
    }

    private o(d dVar) {
        this(dVar, false, com.google.common.base.b.i(), h1.READ_DONE);
    }

    private o(d dVar, boolean z, com.google.common.base.b bVar, int i) {
        this.c = dVar;
        this.b = z;
        this.a = bVar;
        this.d = i;
    }

    public static o f(char c2) {
        return g(com.google.common.base.b.f(c2));
    }

    public static o g(com.google.common.base.b bVar) {
        m.o(bVar);
        return new o(new a(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator j(CharSequence charSequence) {
        return this.c.a(this, charSequence);
    }

    public o e() {
        return new o(this.c, true, this.a, this.d);
    }

    public Iterable h(CharSequence charSequence) {
        m.o(charSequence);
        return new b(this, charSequence);
    }

    public List i(CharSequence charSequence) {
        m.o(charSequence);
        Iterator j = j(charSequence);
        ArrayList arrayList = new ArrayList();
        while (j.hasNext()) {
            arrayList.add((String) j.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public o k() {
        return l(com.google.common.base.b.k());
    }

    public o l(com.google.common.base.b bVar) {
        m.o(bVar);
        return new o(this.c, this.b, bVar, this.d);
    }
}
