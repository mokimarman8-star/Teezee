package pq;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final C0169b f16979e = new C0169b(null);

    /* renamed from: f, reason: collision with root package name */
    private static final b f16980f = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f16981a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f16982b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f16983c;

    /* renamed from: d, reason: collision with root package name */
    private final d f16984d;

    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        private boolean f16987c;

        /* renamed from: a, reason: collision with root package name */
        private boolean f16985a = true;

        /* renamed from: b, reason: collision with root package name */
        private boolean f16986b = true;

        /* renamed from: d, reason: collision with root package name */
        private d f16988d = new c();

        public final b a() {
            return new b(this, null);
        }

        public final boolean b() {
            return this.f16987c;
        }

        public final boolean c() {
            return this.f16985a;
        }

        public final boolean d() {
            return this.f16986b;
        }

        public final d e() {
            return this.f16988d;
        }
    }

    /* renamed from: pq.b$b, reason: collision with other inner class name */
    public static final class C0169b {
        private C0169b() {
        }

        public /* synthetic */ C0169b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            return b.f16980f;
        }
    }

    public static final class c implements d {
        @Override // pq.b.d
        public boolean a() {
            return d.a.c(this);
        }

        @Override // pq.b.d
        public boolean b() {
            return d.a.d(this);
        }

        @Override // pq.b.d
        public boolean c() {
            return d.a.b(this);
        }

        @Override // pq.b.d
        public int d() {
            return d.a.a(this);
        }
    }

    public interface d {

        public static final class a {
            public static int a(d dVar) {
                return 40;
            }

            public static boolean b(d dVar) {
                return false;
            }

            public static boolean c(d dVar) {
                return false;
            }

            public static boolean d(d dVar) {
                return false;
            }
        }

        boolean a();

        boolean b();

        boolean c();

        int d();
    }

    private b(a aVar) {
        this.f16981a = aVar.c();
        this.f16982b = aVar.d();
        this.f16983c = aVar.b();
        this.f16984d = aVar.e();
    }

    public /* synthetic */ b(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public final boolean b() {
        return this.f16983c;
    }

    public final boolean c() {
        return this.f16981a;
    }

    public final d d() {
        return this.f16984d;
    }
}
