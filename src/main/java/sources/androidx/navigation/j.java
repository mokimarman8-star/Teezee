package androidx.navigation;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.view.u;
import androidx.view.x0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class j extends NavController {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        super(context);
        Intrinsics.h(context, "context");
    }

    public final void d0(u uVar) {
        Intrinsics.h(uVar, "owner");
        super.d0(uVar);
    }

    public final void e0(OnBackPressedDispatcher onBackPressedDispatcher) {
        Intrinsics.h(onBackPressedDispatcher, "dispatcher");
        super.e0(onBackPressedDispatcher);
    }

    public final void f0(x0 x0Var) {
        Intrinsics.h(x0Var, "viewModelStore");
        super.f0(x0Var);
    }

    public final void r(boolean z5) {
        super.r(z5);
    }
}
