package db;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.d;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a {
    private static final int[] a = {R.attr.theme, com.google.android.material.R.attr.theme};
    private static final int[] b = {com.google.android.material.R.attr.materialThemeOverlay};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int b(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i, int i2) {
        int b2 = b(context, attributeSet, i, i2);
        boolean z = (context instanceof d) && ((d) context).c() == b2;
        if (b2 == 0 || z) {
            return context;
        }
        d dVar = new d(context, b2);
        int a2 = a(context, attributeSet);
        if (a2 != 0) {
            dVar.getTheme().applyStyle(a2, true);
        }
        return dVar;
    }
}
