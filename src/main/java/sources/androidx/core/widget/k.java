package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class k {

    static class a {
        static void a(PopupWindow popupWindow, boolean z5) {
            popupWindow.setOverlapAnchor(z5);
        }

        static void b(PopupWindow popupWindow, int i5) {
            popupWindow.setWindowLayoutType(i5);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z5) {
        a.a(popupWindow, z5);
    }

    public static void b(PopupWindow popupWindow, int i5) {
        a.b(popupWindow, i5);
    }

    public static void c(PopupWindow popupWindow, View view, int i5, int i6, int i7) {
        popupWindow.showAsDropDown(view, i5, i6, i7);
    }
}
