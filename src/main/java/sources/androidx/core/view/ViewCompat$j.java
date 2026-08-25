package androidx.core.view;

import android.content.ClipData;
import android.view.PointerIcon;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewCompat$j {
    static void a(View view) {
        view.cancelDragAndDrop();
    }

    static void b(View view) {
        view.dispatchFinishTemporaryDetach();
    }

    static void c(View view) {
        view.dispatchStartTemporaryDetach();
    }

    static void d(View view, PointerIcon pointerIcon) {
        view.setPointerIcon(pointerIcon);
    }

    static boolean e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i5) {
        return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i5);
    }

    static void f(View view, View.DragShadowBuilder dragShadowBuilder) {
        view.updateDragShadow(dragShadowBuilder);
    }
}
