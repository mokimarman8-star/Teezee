package androidx.core.view;

import android.view.View;
import android.view.autofill.AutofillId;
import java.util.Collection;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ViewCompat$k {
    static void a(View view, Collection<View> collection, int i5) {
        view.addKeyboardNavigationClusters(collection, i5);
    }

    public static AutofillId b(View view) {
        return view.getAutofillId();
    }

    static int c(View view) {
        return view.getImportantForAutofill();
    }

    static int d(View view) {
        return view.getNextClusterForwardId();
    }

    static boolean e(View view) {
        return view.hasExplicitFocusable();
    }

    static boolean f(View view) {
        return view.isFocusedByDefault();
    }

    static boolean g(View view) {
        return view.isImportantForAutofill();
    }

    static boolean h(View view) {
        return view.isKeyboardNavigationCluster();
    }

    static View i(View view, View view2, int i5) {
        return view.keyboardNavigationClusterSearch(view2, i5);
    }

    static boolean j(View view) {
        return view.restoreDefaultFocus();
    }

    static void k(View view, String... strArr) {
        view.setAutofillHints(strArr);
    }

    static void l(View view, boolean z5) {
        view.setFocusedByDefault(z5);
    }

    static void m(View view, int i5) {
        view.setImportantForAutofill(i5);
    }

    static void n(View view, boolean z5) {
        view.setKeyboardNavigationCluster(z5);
    }

    static void o(View view, int i5) {
        view.setNextClusterForwardId(i5);
    }

    static void p(View view, CharSequence charSequence) {
        view.setTooltipText(charSequence);
    }
}
