package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface d {

    public interface a {
        boolean a();
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f4165a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private static final int f4166b = g(1);

        /* renamed from: c, reason: collision with root package name */
        private static final int f4167c = g(2);

        /* renamed from: d, reason: collision with root package name */
        private static final int f4168d = g(3);

        /* renamed from: e, reason: collision with root package name */
        private static final int f4169e = g(4);

        /* renamed from: f, reason: collision with root package name */
        private static final int f4170f = g(5);

        /* renamed from: g, reason: collision with root package name */
        private static final int f4171g = g(6);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return b.f4170f;
            }

            public final int b() {
                return b.f4167c;
            }

            public final int c() {
                return b.f4166b;
            }

            public final int d() {
                return b.f4171g;
            }

            public final int e() {
                return b.f4168d;
            }

            public final int f() {
                return b.f4169e;
            }
        }

        public static int g(int i5) {
            return i5;
        }

        public static final boolean h(int i5, int i6) {
            return i5 == i6;
        }
    }

    Object a(int i5, Function1 function1);
}
