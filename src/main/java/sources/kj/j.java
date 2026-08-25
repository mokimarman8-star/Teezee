package kj;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qi.a;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class j extends Dialog implements qi.a {
    private final Lazy a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, int i) {
        super(context, i);
        Intrinsics.h(context, "context");
        this.a = LazyKt.b(new Function0() { // from class: kj.i
            public final Object invoke() {
                qi.b c;
                c = j.c(j.this);
                return c;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qi.b c(j jVar) {
        return jVar.d();
    }

    public abstract boolean b();

    public qi.b d() {
        return a.C0089a.a(this);
    }

    public final void e() {
    }

    public void f() {
    }

    public final void g(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // qi.a
    public qi.b getLogViewConfig() {
        return (qi.b) this.a.getValue();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            if (isShowing()) {
                return;
            }
            a.a aVar = wf.a.a;
            StringBuilder sb = new StringBuilder();
            sb.append("show dialog hasShownAnyDialogInSession ");
            sb.append(this);
            sb.append(" :");
            k kVar = k.a;
            sb.append(kVar.b());
            a.a.g(aVar, sb.toString(), false, 2, (Object) null);
            if (!kVar.b() || b()) {
                f();
                super.show();
                kVar.c(true);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
