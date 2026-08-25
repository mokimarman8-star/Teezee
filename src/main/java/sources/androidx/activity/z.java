package androidx.activity;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class z {
    public static final void a(View view, x xVar) {
        Intrinsics.h(view, "<this>");
        Intrinsics.h(xVar, "onBackPressedDispatcherOwner");
        view.setTag(R$id.view_tree_on_back_pressed_dispatcher_owner, xVar);
    }
}
