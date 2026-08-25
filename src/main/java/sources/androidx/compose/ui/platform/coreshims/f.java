package androidx.compose.ui.platform.coreshims;

import android.os.Bundle;
import android.view.ViewStructure;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Object f4752a;

    private static class a {
        static Bundle a(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }

        static void b(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        static void c(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        static void d(ViewStructure viewStructure, int i5, int i6, int i7, int i8, int i9, int i10) {
            viewStructure.setDimens(i5, i6, i7, i8, i9, i10);
        }

        static void e(ViewStructure viewStructure, int i5, String str, String str2, String str3) {
            viewStructure.setId(i5, str, str2, str3);
        }

        static void f(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }

        static void g(ViewStructure viewStructure, float f5, int i5, int i6, int i7) {
            viewStructure.setTextStyle(f5, i5, i6, i7);
        }
    }

    private f(ViewStructure viewStructure) {
        this.f4752a = viewStructure;
    }

    public static f i(ViewStructure viewStructure) {
        return new f(viewStructure);
    }

    public Bundle a() {
        return a.a((ViewStructure) this.f4752a);
    }

    public void b(String str) {
        a.b((ViewStructure) this.f4752a, str);
    }

    public void c(CharSequence charSequence) {
        a.c((ViewStructure) this.f4752a, charSequence);
    }

    public void d(int i5, int i6, int i7, int i8, int i9, int i10) {
        a.d((ViewStructure) this.f4752a, i5, i6, i7, i8, i9, i10);
    }

    public void e(int i5, String str, String str2, String str3) {
        a.e((ViewStructure) this.f4752a, i5, str, str2, str3);
    }

    public void f(CharSequence charSequence) {
        a.f((ViewStructure) this.f4752a, charSequence);
    }

    public void g(float f5, int i5, int i6, int i7) {
        a.g((ViewStructure) this.f4752a, f5, i5, i6, i7);
    }

    public ViewStructure h() {
        return (ViewStructure) this.f4752a;
    }
}
