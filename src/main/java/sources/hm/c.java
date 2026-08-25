package hm;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Build;
import android.util.AttributeSet;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.h2;
import androidx.compose.runtime.s;
import androidx.compose.runtime.v1;
import androidx.compose.ui.b;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.font.n;
import androidx.compose.ui.text.font.p;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.u;
import androidx.lifecycle.y0;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.blankj.utilcode.util.y;
import com.therouter.TheRouter;
import com.tn.lib.widget.R;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o0.x;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {

    static final class a implements Function2 {
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        a(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        public final void a(androidx.compose.runtime.i iVar, int i) {
            if ((i & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(1875731887, i, -1, "com.transsion.member.task.TaskCompleteTips.showTips.<anonymous>.<anonymous> (TaskCompleteTips.kt:78)");
            }
            c.this.c(this.b, this.c, iVar, 0);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
            return Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d() {
        if (com.transsion.baseui.util.c.a.a(0, 2000L)) {
            return Unit.a;
        }
        ij.k.p(TheRouter.c("/member/MemberActivity").z("extra_member_scroll_bottom", true));
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(c cVar, int i, int i2, int i3, androidx.compose.runtime.i iVar, int i4) {
        cVar.c(i, i2, iVar, v1.a(i3 | 1));
        return Unit.a;
    }

    private final boolean f(Activity activity) {
        return y.d(activity) > 0;
    }

    public final void c(final int i, final int i2, androidx.compose.runtime.i iVar, final int i3) {
        int i4;
        androidx.compose.runtime.i iVar2;
        androidx.compose.runtime.i g = iVar.g(-1799667828);
        if ((i3 & 6) == 0) {
            i4 = (g.c(i) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= g.c(i2) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && g.h()) {
            g.G();
            iVar2 = g;
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-1799667828, i4, -1, "com.transsion.member.task.TaskCompleteTips.TaskCompleteView (TaskCompleteTips.kt:100)");
            }
            Painter c = i0.e.c(R$mipmap.ic_succeed, g, 0);
            b.a aVar = androidx.compose.ui.b.a;
            b.c h = aVar.h();
            f.a aVar2 = androidx.compose.ui.f.a;
            float f = 8;
            androidx.compose.ui.f a2 = BackgroundKt.a(SizeKt.l(aVar2, o0.i.g(i)), i0.b.a(R.color.white_90, g, 0), q.g.c(o0.i.g(f)));
            g.x(693286680);
            t b = a0.b(androidx.compose.foundation.layout.b.a.c(), h, g, 48);
            g.x(-1323940314);
            int a3 = androidx.compose.runtime.g.a(g, 0);
            s n = g.n();
            ComposeUiNode.Companion companion = ComposeUiNode.c1;
            Function0 a4 = companion.a();
            Function3 a5 = LayoutKt.a(a2);
            if (!(g.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            g.C();
            if (g.e()) {
                g.F(a4);
            } else {
                g.o();
            }
            androidx.compose.runtime.i a6 = f3.a(g);
            f3.b(a6, b, companion.c());
            f3.b(a6, n, companion.e());
            Function2 b2 = companion.b();
            if (a6.e() || !Intrinsics.c(a6.y(), Integer.valueOf(a3))) {
                a6.p(Integer.valueOf(a3));
                a6.k(Integer.valueOf(a3), b2);
            }
            a5.invoke(h2.a(h2.b(g)), g, 0);
            g.x(2058660585);
            d0 d0Var = d0.a;
            float f2 = 16;
            e0.a(SizeKt.l(aVar2, o0.i.g(f2)), g, 6);
            iVar2 = g;
            ImageKt.a(c, (String) null, SizeKt.j(aVar2, o0.i.g(32)), (androidx.compose.ui.b) null, (androidx.compose.ui.layout.e) null, 0.0f, (androidx.compose.ui.graphics.v1) null, g, 432, 120);
            e0.a(SizeKt.l(aVar2, o0.i.g(f)), iVar2, 6);
            String b3 = i0.h.b(R$string.member_task_claim_toast, new Object[]{String.valueOf(i2)}, iVar2, 0);
            long a7 = i0.b.a(R.color.gray_light_80, iVar2, 0);
            long c2 = x.c(14);
            h.a aVar3 = androidx.compose.ui.text.font.h.b;
            androidx.compose.ui.text.font.s b4 = aVar3.b();
            p.a aVar4 = p.b;
            TextKt.a(b3, b0.a(d0Var, PaddingKt.i(aVar2, 0.0f, o0.i.g(f2), 0.0f, o0.i.g(f2), 5, (Object) null), 1.0f, false, 2, (Object) null), a7, c2, (n) null, aVar4.c(), b4, 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.d0) null, iVar2, 199680, 0, 130960);
            e0.a(SizeKt.l(aVar2, o0.i.g(f)), iVar2, 6);
            androidx.compose.ui.f a8 = BackgroundKt.a(SizeKt.e(SizeKt.l(aVar2, o0.i.g(64)), o0.i.g(28)), i0.b.a(R.color.yellow_light_50, iVar2, 0), q.g.c(o0.i.g(6)));
            iVar2.P(1849434622);
            Object y = iVar2.y();
            if (y == androidx.compose.runtime.i.a.a()) {
                y = new Function0() { // from class: hm.a
                    public final Object invoke() {
                        Unit d;
                        d = c.d();
                        return d;
                    }
                };
                iVar2.p(y);
            }
            iVar2.K();
            androidx.compose.ui.f d = ClickableKt.d(a8, false, (String) null, (androidx.compose.ui.semantics.f) null, (Function0) y, 7, (Object) null);
            androidx.compose.ui.b d2 = aVar.d();
            iVar2.x(733328855);
            t j = BoxKt.j(d2, false, iVar2, 6);
            iVar2.x(-1323940314);
            int a9 = androidx.compose.runtime.g.a(iVar2, 0);
            s n2 = iVar2.n();
            Function0 a10 = companion.a();
            Function3 a11 = LayoutKt.a(d);
            if (!(iVar2.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVar2.C();
            if (iVar2.e()) {
                iVar2.F(a10);
            } else {
                iVar2.o();
            }
            androidx.compose.runtime.i a12 = f3.a(iVar2);
            f3.b(a12, j, companion.c());
            f3.b(a12, n2, companion.e());
            Function2 b5 = companion.b();
            if (a12.e() || !Intrinsics.c(a12.y(), Integer.valueOf(a9))) {
                a12.p(Integer.valueOf(a9));
                a12.k(Integer.valueOf(a9), b5);
            }
            a11.invoke(h2.a(h2.b(iVar2)), iVar2, 0);
            iVar2.x(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            TextKt.a(i0.h.a(R$string.member_claim, iVar2, 0), (androidx.compose.ui.f) null, i0.b.a(R.color.gray_dark_00, iVar2, 0), x.c(14), (n) null, aVar4.d(), aVar3.b(), 0L, (androidx.compose.ui.text.style.i) null, (androidx.compose.ui.text.style.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.d0) null, iVar2, 199680, 0, 130962);
            iVar2.N();
            iVar2.r();
            iVar2.N();
            iVar2.N();
            e0.a(SizeKt.l(aVar2, o0.i.g(f2)), iVar2, 6);
            iVar2.N();
            iVar2.r();
            iVar2.N();
            iVar2.N();
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j2 = iVar2.j();
        if (j2 != null) {
            j2.a(new Function2() { // from class: hm.b
                public final Object invoke(Object obj, Object obj2) {
                    Unit e;
                    e = c.e(c.this, i, i2, i3, (androidx.compose.runtime.i) obj, ((Integer) obj2).intValue());
                    return e;
                }
            });
        }
    }

    public final void g(int i) {
        boolean z;
        com.transsion.baselib.report.k kVar = com.transsion.baselib.report.k.a;
        Activity o = kVar.o();
        if (Build.VERSION.SDK_INT >= 24 && o != null && le.h.a(o)) {
            try {
                Result.Companion companion = Result.Companion;
                o = kVar.p(kVar.b() - 1);
                Result.constructor-impl(Unit.a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.a(th2));
            }
        }
        if (o == null || o.isDestroyed() || !((z = o instanceof u))) {
            return;
        }
        int i2 = f(o) ? 400 : o.getResources().getConfiguration().screenWidthDp - 32;
        ComposeView composeView = new ComposeView(o, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        ViewTreeLifecycleOwner.b(composeView, z ? (u) o : null);
        ViewTreeViewModelStoreOwner.b(composeView, o instanceof y0 ? (y0) o : null);
        ViewTreeSavedStateRegistryOwner.b(composeView, o instanceof androidx.savedstate.e ? (androidx.savedstate.e) o : null);
        composeView.setContent(androidx.compose.runtime.internal.b.b(1875731887, true, new a(i2, i)));
        composeView.setTag(Integer.valueOf(i2));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(composeView, "translationY", -92.0f, 0.0f);
        ofFloat.setDuration(500L);
        com.tn.lib.widget.toast.core.b bVar = new com.tn.lib.widget.toast.core.b(o);
        bVar.e(composeView);
        bVar.setDuration(1);
        bVar.setGravity(48, 0, 62);
        bVar.show();
        ofFloat.start();
    }
}
