package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f5166a = new q();

    private q() {
    }

    public final int a(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return r.f5167a.a(context);
        }
        return 0;
    }
}
