package x8;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b {
    private static final b b = new a().a();
    private final d a;

    public static final class a {
        private d a = null;

        a() {
        }

        public b a() {
            return new b(this.a);
        }

        public a b(d dVar) {
            this.a = dVar;
            return this;
        }
    }

    b(d dVar) {
        this.a = dVar;
    }

    public static a b() {
        return new a();
    }

    public d a() {
        return this.a;
    }
}
