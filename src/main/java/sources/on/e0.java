package on;

import android.support.v4.media.session.c;
import com.transsion.player.mediasession.MediaBrowserCompatHelper;
import com.transsion.player.orplayer.f;
import gn.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class e0 {
    private static Function0 c;
    private static Function0 d;
    private static Function0 g;
    private static volatile h0 h;
    private static volatile f i;
    public static final e0 a = new e0();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: on.b0
        public final Object invoke() {
            a0 z;
            z = e0.z();
            return z;
        }
    });
    private static final Lazy e = LazyKt.b(new Function0() { // from class: on.c0
        public final Object invoke() {
            boolean h2;
            h2 = e0.h();
            return Boolean.valueOf(h2);
        }
    });
    private static final Lazy f = LazyKt.b(new Function0() { // from class: on.d0
        public final Object invoke() {
            boolean k2;
            k2 = e0.k();
            return Boolean.valueOf(k2);
        }
    });
    private static final CopyOnWriteArrayList j = new CopyOnWriteArrayList();
    private static final CopyOnWriteArrayList k = new CopyOnWriteArrayList();

    private e0() {
    }

    private final a0 f() {
        return (a0) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h() {
        Function0 function0 = d;
        boolean booleanValue = function0 != null ? ((Boolean) function0.invoke()).booleanValue() : false;
        StringBuilder sb = new StringBuilder();
        sb.append("isASyncPlayer:");
        sb.append(booleanValue);
        return booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k() {
        Function0 function0 = c;
        boolean booleanValue = function0 != null ? ((Boolean) function0.invoke()).booleanValue() : true;
        StringBuilder sb = new StringBuilder();
        sb.append("isMultiplePlayer:");
        sb.append(booleanValue);
        return booleanValue;
    }

    private final void n(f fVar, f fVar2) {
        Iterator it = k.iterator();
        Intrinsics.g(it, "iterator(...)");
        if (it.hasNext()) {
            c.a(it.next());
            throw null;
        }
    }

    private final void q(f fVar) {
        Iterator it = j.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.c(((WeakReference) it.next()).get(), fVar)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            j.remove(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 z() {
        return new a0();
    }

    public final f d(String str) {
        String str2;
        f fVar;
        e currentMediaSource;
        Intrinsics.h(str, "mediaId");
        Iterator it = j.iterator();
        do {
            str2 = null;
            if (!it.hasNext()) {
                return null;
            }
            fVar = (f) ((WeakReference) it.next()).get();
            if (fVar != null && (currentMediaSource = fVar.currentMediaSource()) != null) {
                str2 = currentMediaSource.e();
            }
        } while (!Intrinsics.c(str2, str));
        return fVar;
    }

    public final f e() {
        return i;
    }

    public final boolean g() {
        return ((Boolean) e.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) f.getValue()).booleanValue();
    }

    public final Function0 j() {
        return c;
    }

    public final int l() {
        Function0 function0 = g;
        if (function0 != null) {
            return ((Number) function0.invoke()).intValue();
        }
        return 1;
    }

    public final f m() {
        a0 a0Var = i() ? new a0() : new h0();
        j.add(new WeakReference(a0Var));
        return a0Var;
    }

    public final void o(f fVar, e eVar) {
        Intrinsics.h(fVar, "orPlayer");
    }

    public final void p(f fVar, e eVar) {
        Intrinsics.h(fVar, "orPlayer");
    }

    public final void r(f fVar) {
        Intrinsics.h(fVar, "orPlayer");
        if (Intrinsics.c(i, fVar)) {
            i = null;
            n(null, fVar);
            sn.e.b(sn.e.a, "TnPlayerManager", "releaseFocus  orPlayer:" + fVar, false, 4, (Object) null);
        }
        q(fVar);
    }

    public final void s(String str) {
        Intrinsics.h(str, "mediaId");
        MediaBrowserCompatHelper.h.a().v(str);
    }

    public final void t(f fVar, String str) {
        Intrinsics.h(fVar, "orPlayer");
        Intrinsics.h(str, "reason");
        if (Intrinsics.c(i, fVar)) {
            return;
        }
        f fVar2 = i;
        if (fVar2 != null && fVar2.isPlaying()) {
            fVar2.pause();
        }
        i = fVar;
        n(fVar2, fVar);
        sn.e.b(sn.e.a, "TnPlayerManager", "requestFocus  orPlayer:" + fVar + "  reason:" + str, false, 4, (Object) null);
    }

    public final void u(h0 h0Var) {
        Intrinsics.h(h0Var, "tnPlayer");
        if (i() || Intrinsics.c(h, h0Var)) {
            return;
        }
        synchronized (this) {
            try {
                if (!Intrinsics.c(h, h0Var)) {
                    sn.e.a.a("TnPlayer", "换boss啦:" + h + "  to " + h0Var, true);
                    h0 h0Var2 = h;
                    if (h0Var2 != null) {
                        h0Var2.d(true);
                    }
                    h0Var.d(false);
                    h0 h0Var3 = h;
                    if (h0Var3 != null) {
                        h0Var3.f((f) null);
                    }
                    h0Var.f(a.f());
                    h = h0Var;
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v(f fVar, e eVar) {
        Intrinsics.h(fVar, "orPlayer");
    }

    public final void w(Function0 function0) {
        d = function0;
    }

    public final void x(Function0 function0) {
        c = function0;
    }

    public final void y(Function0 function0) {
        g = function0;
    }
}
