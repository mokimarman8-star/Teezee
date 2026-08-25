package sn;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    private final View a;
    private final View b;
    private boolean c;
    private final Lazy d;

    public c(View view, View view2) {
        Intrinsics.h(view, "startView");
        Intrinsics.h(view2, "endView");
        this.a = view;
        this.b = view2;
        this.d = LazyKt.b(new Function0() { // from class: sn.a
            public final Object invoke() {
                g g;
                g = c.g(c.this);
                return g;
            }
        });
    }

    private final g e() {
        return (g) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g g(final c cVar) {
        Context context = cVar.a.getContext();
        Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
        return new g((Activity) context, new Function1() { // from class: sn.b
            public final Object invoke(Object obj) {
                Unit h;
                h = c.h(c.this, ((Integer) obj).intValue());
                return h;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(c cVar, int i) {
        if (i == 0 || i == 1 || i == 3) {
            cVar.i(cVar.c, i);
        }
        return Unit.a;
    }

    private final void i(boolean z, int i) {
        int c = com.blankj.utilcode.util.d.c();
        int i2 = (z && i == 1) ? c : 0;
        if (!z || i != 3) {
            c = 0;
        }
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.width = i2;
        this.a.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
        layoutParams2.width = c;
        this.b.setLayoutParams(layoutParams2);
    }

    public final void c() {
        g e = e();
        if (e != null) {
            e.disable();
        }
    }

    public final void d() {
        g e = e();
        if (e != null) {
            e.enable();
        }
    }

    public final void f(boolean z) {
        this.c = z;
        i(z, z ? 1 : 0);
    }
}
