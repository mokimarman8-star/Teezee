package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ActionBarOverlayLayout$d extends View {
    ActionBarOverlayLayout$d(Context context) {
        super(context);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    public int getWindowSystemUiVisibility() {
        return 0;
    }
}
