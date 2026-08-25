package jq;

import io.reactivex.rxjava3.core.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final a b = new a(null);
    private final Lazy a = LazyKt.b(new Function0() { // from class: jq.b
        public final Object invoke() {
            a g;
            g = c.g();
            return g;
        }
    });

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String b() {
        return gg.a.a.a();
    }

    private final jq.a c() {
        return (jq.a) this.a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jq.a g() {
        return (jq.a) kg.c.e.a().h(jq.a.class);
    }

    public final j d(String str) {
        Intrinsics.h(str, "pageFrom");
        return c().d(b(), str);
    }

    public final j e(String str) {
        Intrinsics.h(str, "pageFrom");
        return c().c(b(), str);
    }

    public final j f(String str, int i, String str2) {
        Intrinsics.h(str, "keyword");
        Intrinsics.h(str2, "pageFrom");
        return c().a(b(), str, i, str2);
    }
}
