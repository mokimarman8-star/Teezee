package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewStructure;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f4863a = new v();

    private v() {
    }

    public final void a(ViewStructure viewStructure, View view) {
        viewStructure.setClassName(view.getAccessibilityClassName().toString());
    }
}
