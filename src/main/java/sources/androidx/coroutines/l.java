package androidx.coroutines;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface l {

    /* renamed from: a, reason: collision with root package name */
    public static final b.c f14147a;

    /* renamed from: b, reason: collision with root package name */
    public static final b.C0117b f14148b;

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            private final Throwable f14149a;

            public a(Throwable th) {
                this.f14149a = th;
            }

            public Throwable a() {
                return this.f14149a;
            }

            public String toString() {
                return "FAILURE (" + this.f14149a.getMessage() + ")";
            }
        }

        /* renamed from: androidx.work.l$b$b, reason: collision with other inner class name */
        public static final class C0117b extends b {
            private C0117b() {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class c extends b {
            private c() {
            }

            public String toString() {
                return "SUCCESS";
            }
        }

        b() {
        }
    }

    static {
        f14147a = new b.c();
        f14148b = new b.C0117b();
    }
}
