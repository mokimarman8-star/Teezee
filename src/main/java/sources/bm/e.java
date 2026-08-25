package bm;

import android.os.Build;
import cm.d;
import cm.g;
import io.reactivex.rxjava3.core.j;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import wf.a;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class e {
    private static boolean b;
    private static b c;
    private static boolean d;
    private static Boolean h;
    public static final e a = new e();
    private static final Lazy e = LazyKt.b(new Function0() { // from class: bm.c
        public final Object invoke() {
            a i;
            i = e.i();
            return i;
        }
    });
    private static String f = "";
    private static String g = "wefeed-mobile-bff";

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a i() {
        return (a) kg.c.e.a().h(a.class);
    }

    private final String j() {
        if (f.length() > 0) {
            return f;
        }
        if (Build.VERSION.SDK_INT <= 23) {
            f = "all";
            return "all";
        }
        try {
            ServiceLoader load = ServiceLoader.load(g.class);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = load.iterator();
            Intrinsics.g(it, "iterator(...)");
            while (it.hasNext()) {
                linkedHashSet.addAll(((g) it.next()).providerParams());
            }
            f = CollectionsKt.s0(linkedHashSet, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        } catch (Exception e3) {
            a.a aVar = a.a;
            String message = e3.getMessage();
            if (message == null) {
                message = "";
            }
            a.a.l(aVar, "CombinedRequestParam", message, false, 4, (Object) null);
            e3.printStackTrace();
            f = "all";
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a k() {
        return (a) e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Boolean l() {
        if (h == null) {
            h = Boolean.valueOf(l.a.e());
        }
        return h;
    }

    public static /* synthetic */ void p(e eVar, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gg.a.a.a();
        }
        if ((i & 2) != 0) {
            str2 = "wefeed-mobile-bff";
        }
        eVar.o(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q() {
        return a.j();
    }

    public final void h() {
        if (b) {
            return;
        }
        p(this, null, g, 1, null);
    }

    public final void m() {
        h = Boolean.TRUE;
        h();
    }

    public final void n() {
        h = Boolean.FALSE;
    }

    public final void o(String str, String str2) {
        Intrinsics.h(str, "host");
        Intrinsics.h(str2, "path");
        g = str2;
        if (d) {
            a.a.f(a.a, "RequestConfig", "requestConfig ing...", false, 4, (Object) null);
            return;
        }
        d = true;
        b = false;
        String string = d.a.g().getString("configVersion", "");
        j.r(new d()).E(ey.a.c()).n(new a(str2, str, string != null ? string : "")).f(dg.d.a.e()).y(b.a).subscribe(new c());
    }

    public final void r(b bVar) {
        Intrinsics.h(bVar, "configLoadListener");
        c = bVar;
    }
}
