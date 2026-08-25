package androidx.view;

import android.view.View;
import androidx.lifecycle.runtime.R;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class ViewTreeLifecycleOwner {
    public static final u a(View view) {
        Intrinsics.h(view, "<this>");
        return (u) SequencesKt.t(SequencesKt.z(SequencesKt.h(view, new Function1<View, View>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1
            public final View invoke(View view2) {
                Intrinsics.h(view2, "currentView");
                Object parent = view2.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new Function1<View, u>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2
            public final u invoke(android.view.View view2) {
                Intrinsics.h(view2, "viewParent");
                Object tag = view2.getTag(R.id.view_tree_lifecycle_owner);
                if (tag instanceof u) {
                    return (u) tag;
                }
                return null;
            }
        }));
    }

    public static final void b(View view, u uVar) {
        Intrinsics.h(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, uVar);
    }
}
