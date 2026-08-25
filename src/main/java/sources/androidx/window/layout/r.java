package androidx.window.layout;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface r extends l {

    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0111a f13821b = new C0111a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final a f13822c = new a("NONE");

        /* renamed from: d, reason: collision with root package name */
        public static final a f13823d = new a("FULL");

        /* renamed from: a, reason: collision with root package name */
        private final String f13824a;

        /* renamed from: androidx.window.layout.r$a$a, reason: collision with other inner class name */
        public static final class C0111a {
            private C0111a() {
            }

            public /* synthetic */ C0111a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private a(String str) {
            this.f13824a = str;
        }

        public String toString() {
            return this.f13824a;
        }
    }

    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final a f13825b = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final b f13826c = new b("VERTICAL");

        /* renamed from: d, reason: collision with root package name */
        public static final b f13827d = new b("HORIZONTAL");

        /* renamed from: a, reason: collision with root package name */
        private final String f13828a;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private b(String str) {
            this.f13828a = str;
        }

        public String toString() {
            return this.f13828a;
        }
    }

    public static final class c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f13829b = new a(null);

        /* renamed from: c, reason: collision with root package name */
        public static final c f13830c = new c("FLAT");

        /* renamed from: d, reason: collision with root package name */
        public static final c f13831d = new c("HALF_OPENED");

        /* renamed from: a, reason: collision with root package name */
        private final String f13832a;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private c(String str) {
            this.f13832a = str;
        }

        public String toString() {
            return this.f13832a;
        }
    }

    b getOrientation();

    boolean isSeparating();
}
