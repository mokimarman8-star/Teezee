package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    private static class C0053a {
        static void a(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void b(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    public static Drawable a(CheckedTextView checkedTextView) {
        return checkedTextView.getCheckMarkDrawable();
    }

    public static void b(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        C0053a.a(checkedTextView, colorStateList);
    }

    public static void c(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        C0053a.b(checkedTextView, mode);
    }
}
