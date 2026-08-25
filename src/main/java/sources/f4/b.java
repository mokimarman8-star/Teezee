package f4;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b {
    public static View a(View view, int i5) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View findViewById = viewGroup.getChildAt(i6).findViewById(i5);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }
}
