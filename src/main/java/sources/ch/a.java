package ch;

import android.content.res.Resources;
import android.util.TypedValue;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final int a(float f) {
        return (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }
}
