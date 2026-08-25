package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i2 {

    /* renamed from: a, reason: collision with root package name */
    public static final i2 f4819a = new i2();

    private i2() {
    }

    public final void a(ActionMode actionMode) {
        actionMode.invalidateContentRect();
    }

    public final ActionMode b(View view, ActionMode.Callback callback, int i5) {
        return view.startActionMode(callback, i5);
    }
}
