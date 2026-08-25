package androidx.activity;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class y {
    public static final void a(View view, t tVar) {
        Intrinsics.h(view, "<this>");
        Intrinsics.h(tVar, "fullyDrawnReporterOwner");
        view.setTag(R$id.report_drawn, tVar);
    }
}
