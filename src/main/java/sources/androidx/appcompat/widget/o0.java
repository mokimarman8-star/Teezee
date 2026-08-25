package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class o0 {

    static class a {
        static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.a(view, charSequence);
        } else {
            r0.h(view, charSequence);
        }
    }
}
