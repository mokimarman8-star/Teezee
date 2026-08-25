package x8;

import com.google.android.datatransport.runtime.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a {
    private static final a e = new C0070a().b();
    private final e a;
    private final List b;
    private final b c;
    private final String d;

    /* renamed from: x8.a$a, reason: collision with other inner class name */
    public static final class C0070a {
        private e a = null;
        private List b = new ArrayList();
        private b c = null;
        private String d = "";

        C0070a() {
        }

        public C0070a a(c cVar) {
            this.b.add(cVar);
            return this;
        }

        public a b() {
            return new a(this.a, Collections.unmodifiableList(this.b), this.c, this.d);
        }

        public C0070a c(String str) {
            this.d = str;
            return this;
        }

        public C0070a d(b bVar) {
            this.c = bVar;
            return this;
        }

        public C0070a e(e eVar) {
            this.a = eVar;
            return this;
        }
    }

    a(e eVar, List list, b bVar, String str) {
        this.a = eVar;
        this.b = list;
        this.c = bVar;
        this.d = str;
    }

    public static C0070a e() {
        return new C0070a();
    }

    public String a() {
        return this.d;
    }

    public b b() {
        return this.c;
    }

    public List c() {
        return this.b;
    }

    public e d() {
        return this.a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
