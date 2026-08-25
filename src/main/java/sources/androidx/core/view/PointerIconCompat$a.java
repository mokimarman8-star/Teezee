package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class PointerIconCompat$a {
    static PointerIcon a(Bitmap bitmap, float f5, float f6) {
        return PointerIcon.create(bitmap, f5, f6);
    }

    static PointerIcon b(Context context, int i5) {
        return PointerIcon.getSystemIcon(context, i5);
    }

    static PointerIcon c(Resources resources, int i5) {
        return PointerIcon.load(resources, i5);
    }
}
