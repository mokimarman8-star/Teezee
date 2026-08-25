package androidx.core.view;

import android.view.ViewStructure;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ViewStructureCompat {
    private final Object mWrappedObj;

    private static class a {
        static void a(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        static void b(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        static void c(ViewStructure viewStructure, int i5, int i6, int i7, int i8, int i9, int i10) {
            viewStructure.setDimens(i5, i6, i7, i8, i9, i10);
        }

        static void d(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }
    }

    private ViewStructureCompat(ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }

    public static ViewStructureCompat toViewStructureCompat(ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public void setClassName(String str) {
        a.a((ViewStructure) this.mWrappedObj, str);
    }

    public void setContentDescription(CharSequence charSequence) {
        a.b((ViewStructure) this.mWrappedObj, charSequence);
    }

    public void setDimens(int i5, int i6, int i7, int i8, int i9, int i10) {
        a.c((ViewStructure) this.mWrappedObj, i5, i6, i7, i8, i9, i10);
    }

    public void setText(CharSequence charSequence) {
        a.d((ViewStructure) this.mWrappedObj, charSequence);
    }

    public ViewStructure toViewStructure() {
        return (ViewStructure) this.mWrappedObj;
    }
}
