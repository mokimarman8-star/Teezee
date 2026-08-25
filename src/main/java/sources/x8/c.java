package x8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c {
    private static final c c = new a().a();
    private final String a;
    private final List b;

    public static final class a {
        private String a = "";
        private List b = new ArrayList();

        a() {
        }

        public c a() {
            return new c(this.a, Collections.unmodifiableList(this.b));
        }

        public a b(List list) {
            this.b = list;
            return this;
        }

        public a c(String str) {
            this.a = str;
            return this;
        }
    }

    c(String str, List list) {
        this.a = str;
        this.b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }
}
