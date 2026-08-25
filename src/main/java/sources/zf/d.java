package zf;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import s7.e;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class d implements xf.a {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: zf.c
        public final Object invoke() {
            d k;
            k = d.k();
            return k;
        }
    });
    private Gson a = new Gson();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return (d) d.c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d k() {
        return new d();
    }

    @Override // xf.a
    public void a(String str) {
        Intrinsics.h(str, "msg");
        e.d(str);
    }

    @Override // xf.a
    public void b(String str) {
        Intrinsics.h(str, "msg");
        e.c(str);
    }

    @Override // xf.a
    public void c(String str) {
        Intrinsics.h(str, "msg");
        e.b(str);
    }

    @Override // xf.a
    public void d(String str, String... strArr) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(strArr, "msg");
        e.g(str).w(strArr);
    }

    @Override // xf.a
    public void e(String str, String... strArr) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(strArr, "msg");
        e.g(str).u(strArr);
    }

    @Override // xf.a
    public void f(String str, String... strArr) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(strArr, "msg");
        e.g(str).z(strArr);
    }

    @Override // xf.a
    public void g(String str, String... strArr) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(strArr, "msg");
        e.g(str).v(strArr);
    }

    @Override // xf.a
    public void h(String str, String... strArr) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(strArr, "msg");
        e.g(str).y(strArr);
    }
}
