package zf;

import android.util.Log;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class b implements xf.a {
    public static final a b = new a(null);
    private static final Lazy c = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: zf.a
        public final Object invoke() {
            b k;
            k = b.k();
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

        public final b a() {
            return (b) b.c.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b k() {
        return new b();
    }

    private final boolean l(String str) {
        return xf.c.a.e() || Log.isLoggable(str, 3);
    }

    @Override // xf.a
    public void a(String str) {
        Intrinsics.h(str, "msg");
        l("DefaultTag");
    }

    @Override // xf.a
    public void b(String str) {
        Intrinsics.h(str, "msg");
        if (l("DefaultTag")) {
            Log.e("DefaultTag", str);
        }
    }

    @Override // xf.a
    public void c(String str) {
        Intrinsics.h(str, "msg");
        l("DefaultTag");
    }

    @Override // xf.a
    public void d(String str, String... strArr) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(strArr, "msg");
        if (l(str)) {
            ArraysKt.m0(strArr, " , ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
    }

    @Override // xf.a
    public void e(String str, String... strArr) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(strArr, "msg");
        if (l(str)) {
            ArraysKt.m0(strArr, " , ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
    }

    @Override // xf.a
    public void f(String str, String... strArr) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(strArr, "msg");
        if (l(str)) {
            Log.w(str, ArraysKt.m0(strArr, " , ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }

    @Override // xf.a
    public void g(String str, String... strArr) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(strArr, "msg");
        if (l(str)) {
            Log.e(str, ArraysKt.m0(strArr, " , ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }

    @Override // xf.a
    public void h(String str, String... strArr) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(strArr, "msg");
        if (l(str)) {
            Log.v(str, ArraysKt.m0(strArr, " , ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }
}
